import java.util.*;

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)
    val X : Int = sc.nextInt()
    val Y : Int = sc.nextInt()
    
	if(X > 0) {
		if(Y > 0) {
			println(1);
		} 
		else {
			println(4);
		}
	} 
	
	else {
		if(Y > 0) {
			println(2);
		} 
		else {
			println(3);
		}
	}
    
}
