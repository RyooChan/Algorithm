import java.util.*;

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)
    var h : Int = sc.nextInt()
    var m : Int = sc.nextInt()
    
    m -= 45
    if(m<0){
        m += 60
        h -= 1
    }
    
    if(h<0){
        h += 24
    }
    
    println(h)
    println(m)
        
}
