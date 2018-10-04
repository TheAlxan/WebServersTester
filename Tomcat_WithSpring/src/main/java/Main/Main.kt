package Main

import com.google.gson.Gson
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.collections.HashMap

val gson = Gson()

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
open class Main{

}

@RestController
class Router{
    @RequestMapping(value="/get/{n}",method= arrayOf(RequestMethod.GET))
    fun doGet(@PathVariable("n") n:String):String{
        val x = String(Base64.getDecoder().decode(n))
        val n = gson.fromJson<N>(x,N::class.java)
        return GenPass.GenPass(n.n)
    }

    @RequestMapping(value="/post",method= arrayOf(RequestMethod.POST))
    fun doPost(@RequestBody map:HashMap<String,String>):String{
        return GenPass.GenPass(Integer.parseInt(map["n"]))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Main::class.java)
}