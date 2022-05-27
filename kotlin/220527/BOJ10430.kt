import java.util.*;

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)
    
    val A : Int = sc.nextInt()
    val B : Int = sc.nextInt()
    val C : Int = sc.nextInt()

	println((A+B)%C)
	println(((A%C)+(B%C))%C)
	println((A*B)%C)
	println(((A%C) * (B%C))%C)
}
