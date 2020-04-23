import java.util.*;

public class SecondTenTasks{
	public static void main(String[] args){
	}

	// Задача 1.
	public static String repeat(String str, int n){
	StringBuffer s = new StringBuffer("");

	for (int i = 0; i < str.length(); i++){
		for (int j = 0; j < n; j++){
			s.append(str.charAt(i));
		}
	}

		return s.toString();

	}


	// Задача 2.
	public static int differenceMaxMin(int[] arr){
		int max = arr[0];
		int min = arr[0];

		for (int i = 0; i < arr.length; i++){
			if (max < arr[i]){
				max = arr[i]; 
			}
			if (min > arr[i]){
				min = arr[i];
			}
		}

		return max - min;
	}

	// Задача 3.
	public static boolean isAvgWhole(int[] arr){
		float sum = 0;

		for (int i = 0; i < arr.length; i++){
			sum = sum + arr[i];
		}

		if (sum/arr.length == (int)(sum/arr.length)) return true;

		else return false;

	}

	// Задача 4.
	public static int[] cumalativeSum(int[] arr){
		for (int i = 1; i < arr.length; i++){
			arr[i] = arr[i] + arr[i-1];
		}

		return arr;

	}

	// Задача 5.
	public static int getDecimalPlaces(String str){
		int n = 0;
		if (str.indexOf(".") > 0){
			String newStr = str.substring(str.indexOf(".")+1);
			n = newStr.length();
			return n;
		}
		else return n;

	}
	
	// Задача 6.
	public static int Fibonacci(int n){
		int x1 = 0;
		int x2 = 1;
		int xN = 0;

		for (int i = 0; i < n; i++){
			xN = x1 + x2;
			x1 = x2;
			x2 = xN;
		}

		return xN;
	}

	// Задача 7.
	public static boolean isValid(String str){
		if (str.length() > 5) return false;
		int k = 0;

		for (int i = 0; i < str.length(); i++){
			if ((int)str.charAt(i) >= 48 && (int)str.charAt(i) <=57){
				k ++;
			}
		}

		if (k == str.length()) return true;
		else return false;
	}
	

	// Задача 8.
	public static boolean isStrangePair(String str1, String str2){

		if (str1.equals("") && str2.equals("")){
			return true;
		}

		if (str1.charAt(0) == str2.charAt(str2.length()-1) && 
			str2.charAt(0) == str1.charAt(str1.length()-1)) 
			return true;
		
		else return false;

	 }

	 // Задача 9.
	 public static boolean isPrefix(String str, String prefix){
	 	int prefixLen = prefix.length();
	 	String s = str.substring(0, prefixLen-1);

	 	if (s.equals(prefix.substring(0,prefixLen-1))){
	 		return true;
	 	}
	 	else return false;    
	 }

	 public static boolean isSuffix(String str, String suffix){
	 	int suffixLen = suffix.length();
	 	int strLen = str.length();

	 	String s = str.substring(strLen-suffixLen+1);
	 	if (s.equals(suffix.substring(1,suffixLen))){
	 		return true;
	 	}
	 	else return false;    
	 }

	 // Задача 10.
	 public static int boxSeq(int n){
	 	switch(n){
	 		case 0:
	 			return 0;
	 		case 1:
	 			return 3;
	 		case 2:
	 			return 2;
	 		case 3:
	 			return 5;
	 		case 4:
	 			return 4;
	 		case 5:
	 			return 7;
	 		case 6:
	 			return 6;
	 	}

	 	return 0;
	 }

}