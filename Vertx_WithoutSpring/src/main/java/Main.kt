package Main

import com.google.gson.Gson
import io.vertx.core.Vertx
import io.vertx.core.json.Json
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.BodyHandler
import java.util.*
import io.vertx.groovy.ext.web.RoutingContext_GroovyExtension.getBodyAsJson
import io.vertx.groovy.ext.web.RoutingContext_GroovyExtension.getBodyAsJson





class Server {
    val gson = Gson()
    fun startUp(){
        val vertx = Vertx.vertx()
        val router = Router.router(vertx)
        router.route().handler(BodyHandler.create())
        router.get("/get/:n").handler(this::doGet)
        router.post("/post").handler(this::doPost)
        vertx.createHttpServer().requestHandler(router::accept).listen(8080)
    }

    fun doGet(rc:RoutingContext){
        val x = String(Base64.getDecoder().decode(rc.request().getParam("n")))
        val n = gson.fromJson<N>(x,N::class.java)
        rc.response().end(GenPass.GenPass(n.n))
    }
    fun doPost(rc:RoutingContext){
        val json = rc.bodyAsJson
        rc.response().end(GenPass.GenPass(Integer.parseInt(json.getString("n"))))
    }
}

fun main(args: Array<String>) {
    Server().startUp()
}
