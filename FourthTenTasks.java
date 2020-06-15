import java.util.*;

public class FourthTenTasks{

	public static void main(String[] args){
	}
	//Задача 1.
	public static String bessyText(int n, int k, String str){
		String[] arr = str.split(" ");
		String result = new String();
		int len = 0;

		for (int i = 0; i < arr.length; i++){

			if (len + arr[i].length() <= k){
				result += arr[i] + " ";
				len += arr[i].length();
			}

			else {
					result += "\n" + arr[i] + " ";
					len = arr[i].length();
			}
		}

		return result;
	}


	//Задача 2.
	public static String split(String x){
		int k = 0;
		String result = new String();

		for (int i = 0; i < x.length(); i++){

			if (x.charAt(i) == '('){
				k++;
				result += x.charAt(i);
			}
			else if (x.charAt(i) == ')'){
				k--;
				result += x.charAt(i);
			}

			if (k == 0) result += ", ";
		}

		return result;

	}
		

	//Задача 3.
	public static String toCamelCase(String x){
		String result = new String();

		for (int i = 0; i < x.length(); i++){

			if (x.charAt(i) == '_'){
				result += (String.valueOf(x.charAt(i+1))).toUpperCase();
				i += 2;
			}
			result += x.charAt(i);
		}

		return result;

	}

	public static String to_snake_case(String x){
		String result = new String();

		for (int i = 0; i < x.length(); i++){

			if (Character.isUpperCase(x.charAt(i))){
				result += '_' + (String.valueOf(x.charAt(i))).toLowerCase();
				i++;
			}

			result += x.charAt(i);

		}

		return result;

	}

	//Задача 4.
	public static String overTime(double[] arr){
		String result = "$";
		double money = 0;
		double over_money = 0;

		if (arr[1] > 17){
			money = (17 - arr[0]) * arr[2];
			over_money = (arr[1] - 17) * arr[2] * arr[3];
		}
		else money = (arr[1] - arr[0]) * arr[2];

		return result + String.format("%.2f", money + over_money);
	}

	// Задача 5.
	// 1 фунт = 0.453 кг
	// 1 дюйм = 0.0254 метр
	public static String BMI(String w, String h){
		String[] wW = w.split(" ");
		String[] hH = h.split(" ");
		double ves = Double.valueOf(wW[0]);
		double rost = Double.valueOf(hH[0]);

		if (wW[1].equals("pounds")) ves *= 0.453;
        if (hH[1].equals("inches")) rost *= 0.0254;

        double result = ves/(rost*rost);

        if (result < 18.5) return String.format("%.1f", ves/(rost*rost)) + " Underweight";
        if (result >= 18.5 && result <= 24.9) {
       		return String.format("%.1f", ves/(rost*rost)) + " Normal weight";
       	}
        else return String.format("%.1f", ves/(rost*rost)) + "  Overweight";

	}

	//Задача 6.
	 public static int bugger(int n){
        int k = 0;
        String number = Integer.toString(n);
        int j = number.length();

        while (j != 1){
            int num = 1;

            for (int i = 0; i < j; i++){
                num *= Integer.parseInt(Character.toString(number.charAt(i)));
            }
            number = Integer.toString(num);
            k++;
        }
        return k;
    }

    //Задача 7.
  	public static String toStarShorthand(String x){
  		if (x.isEmpty()) return "";

  		String result = new String();
  		int k = 1;
  		char letter = x.charAt(0);

  		for (int i = 1; i < x.length(); i++){
  			if (x.charAt(i) == letter)	k++;

  			else {

  				if (k != 1) result += letter + "*" + String.valueOf(k);
  				else result += letter;
  				letter = x.charAt(i);
  				k = 1;

  			}	
  			
  		}

  		if (k != 1) result += letter + "*" + String.valueOf(k);
        	else result += letter;

        return result;

    }
 
    //Задача 8.
    public static boolean doesRhyme(String x, String y){
    	char char1 = x.charAt(x.length() - 1);
        char char2 = y.charAt(y.length() - 1);

        if (!Character.isAlphabetic(x.charAt(x.length() - 1))) char1 = x.charAt(x.length() - 2);
        if (!Character.isAlphabetic(y.charAt(y.length() - 1))) char2 = y.charAt(y.length() - 2);

        return char1 == char2;
    }

    //Задача 9.
    public static boolean trouble(long a, long b){
    	String str1 = Long.toString(a);
        String str2 = Long.toString(b);
        String str = new String();

        for (int i = 2; i < str1.length(); i++){
            if (str1.charAt(i) == str1.charAt(i - 1) && str1.charAt(i) == str1.charAt(i - 2)) str += str1.charAt(i);
        }

        for (int i = 0; i < str.length(); i++){
            for (int j = 1; j < str2.length(); j++){
                if (str2.charAt(j) == str2.charAt(j - 1) && str2.charAt(j) == str.charAt(i)) return true;
            }
        }

        return false;
    }


    //Задача 10.
    public static int countUniqueBooks(String a, String b){
    	int k = 0;
    	boolean check = false;
    	String str = "";

    	for (int i = 0; i < a.length(); i += 1) {
      		if (a.substring(i, i + 1).equals(b)) {
        		check = !check;
        		if (!check)	str = "";
       			continue;
      		}

     		if (check) {
       			if (!str.contains(a.substring(i, i + 1))) {
          		k += 1;
          		str += a.substring(i, i + 1);
       	 		}
      		}
  		}

  		return k;
    }
    
}





















