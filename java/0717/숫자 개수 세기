/*
import java.util.Arrays;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here
       Scanner sc = new Scanner(System.in);
       
       int n = sc.nextInt();
       int q = sc.nextInt();
       
       int[] numbers = new int[n];
       int[] find = new int[q];
       int[] count = new int[q];
       
       for(int i = 0 ; i < numbers.length; i++){
         numbers[i] = sc.nextInt();
       }
       
       for(int i = 0 ; i < find.length; i++){
         find[i] = sc.nextInt();
       }
       
       Arrays.sort(numbers);
       
//       for(int i = 0 ; i < find.length; i++){
//         for(int j = StartbinarySearch(numbers, find[i]) ; j < numbers.length; j++){
//        	 if(j == -1) {
//        		 count[i]= 0;
//        		 break;
//        	 }
//        	 else {
//        		 if(numbers[j] == find[i] ){
//        			 count[i]++;
//        		 }
//        		 else{
//        			 break;
//        		 }        		 
//        	 }
//         }
//       }
       
       for(int i = 0 ; i < find.length; i++) {
    	   int x = StartbinarySearch(numbers, find[i]);
//    	   System.out.println(x);
    	   
    	   int y = endbinarySearch(numbers, find[i]);
//    	   System.out.println(y);
    	   
    	   count[i] = y - x + 1;
    	   
       }
       
       
       for(int i = 0;  i< count.length; i++){
         System.out.println(count[i]);
       }
       
       
    }
    
  	static int StartbinarySearch(int[] arr,  int value){
  		int start = 0;
  	    int end = arr.length - 1;
  	    int mid;
  	    while (start <= end) {
  	        mid = (start + end) / 2;
  	        if (arr[mid] < value) {
  	            start = mid + 1;
  	        }
  	        else {
  	            end = mid - 1;
  	        }
  	    }
  	 
  	    return start;

   }
	
  	static int endbinarySearch(int[] arr, int value) {
  		int start = 0;
  	    int end = arr.length - 1;
  	    int mid;
  	    while (start <= end) {
  	        mid = (start + end) / 2;
  	        if (arr[mid] <= value) {
  	            start = mid + 1;
  	        }
  	        else {
  	            end = mid - 1;
  	        }
  	    }
  	 
  	    return end;
  	}
}
*/
