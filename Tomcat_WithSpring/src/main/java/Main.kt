import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.*

@EnableAutoConfiguration
@RestController

class Router{
    @RequestMapping(value="/get/{n}",method= arrayOf(RequestMethod.GET))
    fun doGet(@PathVariable("n") n:String):String{
        return GenPass.GenPass(Integer.parseInt(String(Base64.getDecoder().decode(n))))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Router::class.java)
}