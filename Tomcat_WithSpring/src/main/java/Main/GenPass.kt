package Main

import java.util.*

object GenPass {
    val base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*"
    fun GenPass(n:Int):String{
        var pass=""
        for(i in 0..n){
            pass=pass + GenPass.base[Random().nextInt(GenPass.base.length)]
        }
        return pass
    }
}