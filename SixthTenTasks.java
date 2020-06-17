import java.util.*;

public class SixthTenTasks{
	public static void main(String[] args){
	}

	// Задача 1
	private static int factorial(int n){
        if (n == 0) return 1;
        else{
            int result = 1;
            for(int i = 2; i <= n; i++){
                result *= i;
            }
            return result;
        }
    }

    private static int C(int n, int k)
    {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }


    public static int Bell(int n){
        if (n == 0) return 1;
        else{
            int sum = 0;
            for (int k = 0; k < n; k++){
                sum += C(n-1, k) * Bell(n - k - 1);
            }
            return sum;
        }
    }

	// Задача 2
	public static String translateWord(String str) {
        String vowels = "aeiouAEIOU";
        boolean flag = true;
        int count = 0;
        char[] word = str.toCharArray();
        String res = "";

        if (str.equals("")) return "";
        if (vowels.contains(Character.toString(word[0]))) res = str + "yay";
        else {
        while (flag) {
            if (vowels.contains(Character.toString(word[count]))) flag=false;
            else count++;
        }
        res = str.substring(count) + str.substring(0,count) + "ay";
        }

        return res;
    }

	// Задача 3
	 public static boolean validColor(String str) {
        String[] wp = str.substring(str.indexOf('(')+1, str.indexOf(')')).split(",");

        if (str.contains("rgba") && wp.length != 4 || (str.contains(",,"))) return false;

        for (int i = 0; i < wp.length ; i++) {
            double num = Double.parseDouble(wp[i]);
            if (i==3) {
                if (!(num >= 0 && num <= 1.0)) return false;
            }
            else if (!(num >= 0 && num <= 255)) return false;
        }
        return true;
    }

	// Задача 4
	public static String stripUrlParams(String url, String ...param) {
       	String res = "", args = "";
        Map<String, String> map=new HashMap<>();
        String[] wp = url.split("\\?");
        res += wp[0];

        if (wp.length!=1) {
            wp = wp[1].split("&");
            for (int i = 0; i<wp.length; i++) {
                String[] pair = wp[i].split("=");
                if (map.containsKey(pair[0])) {
                    map.replace(pair[0], pair[1]);
                } else map.put(pair[0], pair[1]);
            }
            res+="?";
        }

        for (String pam : param) {
            if (map.containsKey(pam)) map.remove(pam);
        }

        for (String key : map.keySet()) {
            res += key + "=" + map.get(key) + "&";
        }

        return res.substring(0,res.length()-1);
    }

	// Задача 5
	 public static String[] getHashTags (String str) {
        String[] wp = str.split(" ");
        String[] res = { "", "", ""};
        String max = "", maxes = "";
        int count = 0;

        while (count < 3) {
        for (String word : wp) {
            if (!Character.isLetter(word.charAt(word.length() - 1)))
                word = word.substring(0, word.length() - 1);
            if (max.length() < word.length() && !maxes.contains(word)) max=word;
        }
        if (max != "")
        res[count] = "#" + max.toLowerCase();
        maxes += max;
        max = "";
        count++;}

        return res;
    }

	// Задача 6
	 public static int ulam(int n) {
        Vector<Integer> ulamNumbers = new Vector<>();
        ulamNumbers.add(1);
        ulamNumbers.add(2);

        for (int i = 3; i < 2500; i++) {
            int count = 0;
            for (int j = 0; j < ulamNumbers.size() - 1; j++) {
                for (int k = j + 1; k < ulamNumbers.size(); k++) {
                    if (ulamNumbers.get(j) + ulamNumbers.get(k) == i) count++;
                    if (count > 1) break;
                }
                if (count > 1) break;
            }
            if (count == 1) ulamNumbers.add(i);
        }

        return ulamNumbers.get(n - 1);
    }

	// Задача 7
	 public static String longestNonrepeatingSubstring(String str) {
        String res = "", decoy = "", max = "";

        for (int i = 0; i < str.length(); i++) {
            String wc = Character.toString(str.charAt(i));
            if (!decoy.contains(wc)) decoy+=wc;
            else {
                if (max.length()<decoy.length()) max=decoy;
                decoy = wc;
            }
            if (max.length()<decoy.length()) max=decoy;
        }

        return max;
    }

	// Задача 8
	public static String convertToRoman(int num) {
        String res = "";
        while (num >= 1000) {
            res += "M";
            num -= 1000;        }
        while (num >= 900) {
            res += "CM";
            num -= 900;
        }
        while (num >= 500) {
            res += "D";
            num -= 500;
        }
        while (num >= 400) {
            res += "CD";
            num -= 400;
        }
        while (num >= 100) {
            res += "C";
            num -= 100;
        }
        while (num >= 90) {
            res += "XC";
            num -= 90;
        }
        while (num >= 50) {
            res += "L";
            num -= 50;
        }
        while (num >= 40) {
            res += "XL";
            num -= 40;
        }
        while (num >= 10) {
            res += "X";
            num -= 10;
        }
        while (num >= 9) {
            res += "IX";
            num -= 9;
        }
        while (num >= 5) {
            res += "V";
            num -= 5;
        }
        while (num >= 4) {
            res += "IV";
            num -= 4;
        }
        while (num >= 1) {
            res += "I";
            num -= 1;
        }
        return res;
    }

	// Задача 9
	public static boolean formula (String str) {
        String[] full = str.split("=");
        int[] reslts = new int[full.length];

        for (int j =0; j < full.length; j++) {
            if (full[j].length()==1) reslts[j] = Integer.parseInt(full[j]);
            else {
            String[] wp = full[j].split(" ");

        for (int i = 0; i < wp.length; i++) {
            switch (wp[i]) {
                case "*":
                    wp[i+1] = String.valueOf(Integer.parseInt(wp[i-1])*Integer.parseInt(wp[i+1]));
                    break;
                case "/":
                    wp[i+1] = String.valueOf(Integer.parseInt(wp[i-1])/Integer.parseInt(wp[i+1]));
                    break;
                case "+":
                    wp[i+1] = String.valueOf(Integer.parseInt(wp[i-1])+Integer.parseInt(wp[i+1]));
                    break;
                case "-":
                    wp[i+1] = String.valueOf(Integer.parseInt(wp[i-1])-Integer.parseInt(wp[i+1]));
                    break;
                default:
                    break;
                }
            }
        reslts[j] = Integer.parseInt(wp[wp.length-1]);
            }
        }
        int check = reslts[0];

        for (int i = 1; i < reslts.length; i++) {
            if (reslts[i]!=check) return false;
        }

        return true;
    }

	// Задача 10
	public static boolean palindromedescendant(long n){
        String number = Long.toString(n);
        String reverseNumber = new StringBuffer(number).reverse().toString();
        if (number.equals(reverseNumber)) return true;
        else {
            while (number.length() >= 2) {
                int[] nums = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
                number = "";
                for (int i = 0; i < nums.length - 1; i += 2){
                    nums[i] += nums[i + 1];
                    number += Integer.toString(nums[i]);
                }
                reverseNumber = new StringBuffer(number).reverse().toString();
                if (number.equals(reverseNumber) && number.length() >= 2) return true;
            }
        }
        return false;
    }
}