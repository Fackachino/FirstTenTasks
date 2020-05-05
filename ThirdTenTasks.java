import java.util.ArrayList;

public class ThirdTenTasks{
	public static void main(String[] args){
		int[] a = {9,8,7,6};
		int[] b = {4,4,3,1};

		System.out.println(same(a,b));
	}		

	// Задача 1.
	public static int solutions(int a, int b, int c){
		int D = b*b - 4*a*c;

		if (D > 0) return 2;
		else if (D == 0) return 1;
		else return 0;
  
	}	


	// Задача 2.
	public static int findZip(String input){
		String newStr = input.replaceFirst("zip", "");

		if (newStr.indexOf("zip") != -1){
		int n = newStr.indexOf("zip") + 3;
		return n;
		}
		else return -1;

	}


	// Задача 3.
	public static boolean checkPerfect(int n){
		int summa = 0;

		for (int i = 1; i < n; i++){
			if(n % i == 0) summa = summa + i;
		}

		if (summa == n) return true;
		else return false;	

	}


	// Задача 4.
	public static String flipEndChars(String str){
		if (str.length() < 2) return "Incompatible";

		char[] arr = str.toCharArray();
		char k = arr[0];

		if (arr[0] == arr[str.length()-1]) return "Two's a pair";

		arr[0] = arr[str.length()-1];
		arr[str.length()-1] = k;

		String result = new String(arr);

		return result;
 	}

 	// Задача 5.
 	public static boolean isValidHexCode(String code){
 		int check = 1;

 		if (code.charAt(0) != '#') return false;
 		if (code.length() != 7) return false;

 	/*	97 -a 
 		102 - f
 		57 - 9
 		48 - 0
 		A - 65
 		F - 70
 	*/

 		for (int i = 1; i < code.length(); i++){
 			char k = code.charAt(i);
 			if (((int)k >= 97 && (int)k <= 102) || ((int)k >= 48 && (int)k  <= 57) 
 			||  ((int)k >= 65 && (int)k  <= 70) ) check++;
		}

 		if (check == code.length()) return true;
 		else return false;
 	}

 	// Задача 6.
 	public static boolean same(int[] array1, int[] array2) {
        String strArr1 = new String();
        String strArr2 = new String();

         for (int i = 0; i < array1.length; i++) {
            if (strArr1.contains(String.valueOf(array1[i])) == false) {
                strArr1 += (String.valueOf(array1[i]));
            }
        }

        for (int i = 0; i < array2.length; i++) {
            if (strArr2.contains(String.valueOf(array2[i])) == false) {
                strArr2 += (String.valueOf(array2[i]));
            }
        }
        
        if (strArr1.length() == strArr2.length()) return true;
        else return false;
    }



 	// Задача 7.
 	public static boolean isKaprekar(int n){
 		if (n == 0 || n == 1) return true;

		boolean checkKap = false;
 		int nSqr = n * n;
 		String str = String.valueOf(nSqr);
 		String strLeft = new String();
 		String strRight = new String();

 		if (str.length() % 2 == 0){
 			strLeft = str.substring(0, str.length()/2);
 			strRight = str.substring(str.length()/2);

 			if (Integer.valueOf(strLeft) + Integer.valueOf(strRight) == n) return true;
 			else return false;

 		}

 		else if (str.length() > 1);
  			for (int i = 0; i <= str.length()/2; i++){

 			strLeft = str.substring(0, i+1);
 			strRight = str.substring(i+1);

 			if (Integer.valueOf(strLeft) + Integer.valueOf(strRight) == n) return true;
 
 			}
 		return false;
 	}


 	
 	// Задача 8.
 	public static String longestZero(String str){
 		String longestStr = new String();
 		String strVar = new String();

 		for(int i = 0; i < str.length(); i++){
 			if (str.charAt(i) == '0'){
 				strVar += str.charAt(i);
 			} 

 			else { 
 				if (strVar.length() > longestStr.length()){
 					longestStr = strVar;
 				}
 				strVar = "";

 			}

 		}
 		return longestStr;
 	}
 	


 	// Задача 9.
 	public static boolean checkPrime(int number){
 		for (int i = 2; i < number; i++){
 			if (number % i == 0) return false;
 		}
 		return true;
 	}
 
 	public static int nextPrime(int n){
 		if (checkPrime(n)) return n;

 		else while(checkPrime(n) == false){
 			n++;
 		}

 		return n;
 	}
 	

	// Задача 10.
	public static boolean rightTriangle(int a, int b, int c){
		if (a*a + b*b == c*c) return true;
			else if (a*a == b*b + c*c) return true;
			else if (b*b == a*a + c*c) return true;
			else return false;

	}


}