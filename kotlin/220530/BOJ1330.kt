import java.util.*;

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)
    val x : Int = sc.nextInt()
    val y : Int = sc.nextInt()
    
    if(x>y){
        println(">")
    }else if(x<y){
        println("<")
    }else{
        println("==")
    }
}
