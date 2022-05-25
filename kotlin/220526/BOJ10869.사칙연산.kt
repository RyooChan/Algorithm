import java.util.*;

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`);
    val A : Int = sc.nextInt();
    val B : Int = sc.nextInt();
    var sum : Int = A+B;
    var minus : Int = A-B;
    var mul : Int = A*B;
    var div : Int = A/B;
    var rem : Int = A%B;
    
    println(sum);
    println(minus);
    println(mul);
    println(div);
    println(rem);
}
