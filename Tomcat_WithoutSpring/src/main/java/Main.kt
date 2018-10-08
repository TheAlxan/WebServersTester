import org.apache.catalina.core.StandardContext
import org.apache.catalina.startup.Tomcat
import org.apache.catalina.webresources.DirResourceSet
import org.apache.catalina.webresources.StandardRoot
import java.io.File
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class Server {
    fun startUp(){
        val contextPath = "/benchmark"
        val appBase = "."
        val tomcat = Tomcat().apply {
            setPort(8080)
            host.appBase = appBase
            addWebapp(contextPath, appBase)
            start()
            server.await()
        }
    }
}

fun main(args: Array<String>) {
    Server().startUp()
}