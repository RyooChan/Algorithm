import java.util.*;

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)
    val x : Int = sc.nextInt()
    
    var check : Boolean = false
    if(x%100 == 0){
        if(x%400 == 0){
            check = true
        }
    }else if(x%4 == 0){
        check = true
    }
    
    if(check) println("1")
    else println("0")
    
}
