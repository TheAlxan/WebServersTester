import java.util.*

object GenPass {
    val base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*"
    fun GenPass(n:Int):String{
        var pass=""
        for(i in 0..n){
            pass=pass + base[Random().nextInt(base.length)]
        }
        return pass
    }
}