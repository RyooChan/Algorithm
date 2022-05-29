import java.util.*;

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)
    val x : Int = sc.nextInt()/10
    
    when(x) {
        10 -> println("A")
        9 -> println("A")
        8 -> println("B")
        7 -> println("C")
        6 -> println("D")
        else -> println("F")
    }
}
