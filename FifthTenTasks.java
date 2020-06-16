import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;

public class FifthTenTasks{
	public static void main(String[] args){
		
	}

	// Задача 1.
	public static int[]	encrypt(String str){
		int[] arr = new int[str.length() - 1];
		arr[0] = str.charAt(0);

		for (int i = 1; i < str.length() - 1; i++){
			arr[i] = str.charAt(i - 1) - str.charAt(i);
		}

		return arr;
	}

	public static String decrypt(int[] arr){
		String result = new String();
		result = result + (char)arr[0];

		for (int i = 1; i < arr.length; i++){
			result += (char)(arr[i] - arr[i-1]);
		}

		return result;
	}

	// Задача 2.
	public static boolean canMove(String name, String start, String finish){
		boolean result = false;
		int first = Math.abs(start.charAt(0) - finish.charAt(0));
		int second = Math.abs(start.charAt(1) - finish.charAt(1));

		switch (name){
			case "Kon":
            	if((first == 2 && second == 1) || (first == 1 && second == 2)) result = true;
                break;

			case "Ferz":
                if((first == 0 && second != 0) ||(first != 0 && second == 0)|| first == second) result = true;
                break;  
            
            case "Slon":
          		if(first == second) result = true;
            	break;
                 
            case "Peshka":
                if((first == 1 && second <= 1) || (first == 2 && second == 0)) result = true;
                break;

            case "King":
                if(first <= 1 && second <= 1) result = true;
                break;

            case "Lad'ya":
           		if((first == 0 && second != 0) || (first != 0 && second == 0)) result = true;
             	break;

          	default:
          		break;
        }

        return result;
	}

	// Задача 3.
	public static boolean canComplete(String first, String second){
		int k = 0;

        for (int i = 0; i < second.length(); i++){
            if (second.charAt(i) == first.charAt(k)) k++;
        }

        if (k == first.length()) return true;
        else return false;
	}
	
	// Задача 4.
	public static int sumDigProd(int[] arr){
		int summa = 0;

        for (int i = 0; i < arr.length; i++) summa += arr[i];

        String result = String.valueOf(summa);

        while (result.length() > 1) {
            int ss = Character.getNumericValue(result.charAt(0)) * Character.getNumericValue(result.charAt(1));
            result = String.valueOf(ss);
        }

        return Integer.valueOf(result);
    }

	// Задача 5.
	public static String sameVowelGroup(String[] arr){
		String vowels = "aeiouy";
        String[] checker = new String[arr.length];
        String result = new String();
        

        for (int i = 0; i < arr.length; i++){
            checker[i] = "";

            for (int j = 0; j < arr[i].length(); j++) {
                if (vowels.indexOf(arr[i].charAt(j)) != -1 
                && arr[i].indexOf(arr[i].charAt(j)) == -1) checker[i] += arr[i].charAt(j);
            }
        }

        for (int i = 0; i < checker.length; i++){
            int k = 0;

            for (int j = 0; j < checker[i].length(); j++){
               if (checker[0].indexOf(checker[i].charAt(j)) != -1) k++;
               if (k == checker[0].length()) {
               	result = result + String.valueOf(arr[i]);
               } 
            }
        }

        return result;
    }

	// Задача 6.
    public static boolean validateCard(String n){
    	if (n.length() < 14 || n.length() > 19)return false;

    	int summa = 0;
        int checker = Integer.valueOf(String.valueOf(n.charAt(n.length() - 1)));

        for (int i = 0; i < n.length() - 1; i++){
            int multi = Integer.valueOf(String.valueOf(n.charAt(n.length() - 1 - i)));
            if (i % 2 != 0) multi = multi * 2;
            if (multi > 10){
                summa += multi % 10;
                multi = multi / 10;
                summa += multi % 10;
            }
            else summa += multi;
        }

        if (10 - (summa % 10) == checker)return true;
        return false;
    }

	// Задача 7.
	public static String numToEng(int n){
		String result = "";
		String[] arr1 = {"one", "two", "three", "four", "five", "six", "seven", "eight","nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
        "seventeen", "eighteen", "nineteen", ""};
        String[] arr2 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy","eighty", "ninety"};

        if (n== 0) return "zero";
        if (n % 100 <= 19) result += arr1[n % 100 - 1];
        else result += arr2[n % 100 / 10 - 2] + " " + arr1[n % 10 - 1];

        if (n % 100 == 0) return arr1[n / 100 - 1] + " hundred ";
        if (n % 10 == 0 && n > 19) return arr2[n / 10 - 2];

        if (n / 100 != 0 && n % 100 == 0) result = arr1[n / 100 - 1] + " hundred and ";
        else if (n / 100 != 0) result = arr1[n / 100 - 1] + " hundred ";
        else result = "";
   
        return result;

	}
	// Задача 8.
	public static String getSha256(String str){
		 try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        }
        catch(Exception ex){
            throw new RuntimeException(ex);
        }
	}
	// Задача 9.
	public static String correctTitle(String str){
		String[] result = str.split(" ");
		str = "";

		for (int i = 0; i < str.length(); i++){
			if (i == 0 || i == 1|| i == 2 || i == result.length - 1){
			 result[i] = result[i].substring(0, 1).toUpperCase() + result[i].substring(1).toLowerCase();
             str += result[i] + " ";
            }
            else str += result[i].toLowerCase() + " ";
        }
        return str;
    }

	// Задача 10.
	public static String hexLattice(int num){
		double n = (3 + Math.sqrt(12 * num - 3)) / 6;
        int max = (int) Math.floor(num / n);
        if (max % 2 == 0) max--;
        String result = "";
        boolean check = false;
        if (n % 1 == 0) {
            int MAX = max;
            int MIN = (int) n;
            for (int j = 0; j < MAX; j++) {
                for (int i = 0; i < MAX - MIN; i++) result += " ";
                for (int i = 0; i < MIN; i++) result += "o ";
                result += "\n";
                if (MIN == MAX) check = true;
                if (check) MIN--;
                else MIN++;
            }
        }
        else result += "Invalid";
        return result;
    }

}



