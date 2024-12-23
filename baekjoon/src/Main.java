import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
//		int[] a = new int[28];
//		int[] b = new int[30];
//		
//		for (int i = 0; i < b.length; i++) {
//			b[i] = i;
//		} 
//		
//		for (int i = 0; i < a.length; i++) {
//			a[i] = sc.nextInt();
//		}
//		boolean[] c = new boolean[b.length];
//		
//		for (int j = 0; j < b.length; j++) {
//			for (int i = 0; i < a.length; i++) {
//				if (b[j] == a[i]) {
//					c[j] = true;
//				}
//				else {
//					c[j] = false;
//				}
//			}
//				
//		}
//		
//		for(int j = 0; j < b.length; j++) {
//			if(c[j] == false) {
//				System.out.println(j);
//			}
//		}

//		Scanner sc = new Scanner(System.in);
//		
//		String answer = "";
//		
//		int testCase = sc.nextInt();
//		int[] num = new int[testCase];
//		String[] s = new String[testCase];
//		for (int i = 0; i < testCase; i++) {
//			num[i] = sc.nextInt();
//			s[i] = sc.next();
//		}
//		for (int i = 0; i < s[i].length(); i++) {
//			for (int k = 0; k < num[i]; k++ )
//				
//				System.out.print(answer + s[i].charAt(i));
//		}

//		String answer = "";
//		String my_string = 	  "hahahahahahahahha";
//        String overwrite_string = "youretoslow";
//        int s = 4;
//        
//        for(int i = 0; i < s; i++){
//            answer = answer + my_string.charAt(i);   
//        }    
//        
//        for(int i = 0; i < overwrite_string.length(); i++){
//            answer += overwrite_string.charAt(i);
//        }
//        
//        
//        for(int i = my_string.length(); i < my_string.length() - answer.length(); i++){
//            answer += my_string.charAt(i - (my_string.length() - answer.length()));
//            System.out.println(answer);
//        }
//        System.out.println(answer);
//        //return answer;
//		}

		Scanner sc = new Scanner(System.in);

		String sentense = sc.nextLine();
		int count = 1;

		for (int i = 0; i < sentense.length(); i++) {
			if (sentense.charAt(0) != ' ') {
				if (sentense.charAt(i) == ' ') {
					count++;
					if (sentense.charAt(sentense.length() - 1) != ' ')
						count--;
				}
			}
			
		}
		System.out.println(count);

	}

}