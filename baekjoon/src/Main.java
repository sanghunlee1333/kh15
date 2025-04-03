import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		int n = 1234;
		int num1 = 1;
		int num2 = 3;
		int[] numbers = {1, 2, 3, 4, 5}; 
		int[] answer = {};
	    int size = num2 - num1 + 1;
	    answer = new int[size];
	    
	    
	    for (int i = 0; i < size; num1++) {
	       answer[i] = numbers[num1];
	    }
	    for(int i = 0; i < answer.length; i++) {
	    	System.out.println(answer[0]);
	    }
	}

}