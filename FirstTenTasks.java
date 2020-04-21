public class FirstTenTasks{
	public static void main(String[] args){
	}

	// Задача 1. 
	public static int remainder(int val1, int val2){
		return val1 % val2;
	}

	// Задача 2. 
	public static int triArea(int osnovanie, int visota){
		return osnovanie*visota/2;
	}

	// Задача 3. 
	public static int animals(int chickens, int cows, int pigs){
		return 2*chickens + 4*cows + 4*pigs;
	}

	// Задача 4. 
	public static boolean profitableGamble(double prob, int prize, int pay){
		if (prob*prize > pay){
			return true;
		}
		else {
			return false;
		}
	}

	// Задача 5.
	public static String operation(int result, int a, int b){
		String oper = "none";

		if (a + b == result){
			oper = "added";
		}
		if (a - b == result ){
			oper = "subtracted";
		}
		if (a / b ==  result){
			oper = "divison";
		}
		if (a * b == result){
			oper = "multiplication";
		}

		return oper;
	}

	// Задача 6.
	public static int ctoa(char bukva){
		return (int)bukva;
	}

	// Задача 7.
	public static int addUpTo(int k){
		int summa = 0;

		for (int i = k; i>= 0; i--){
			summa = summa + i;
		}

		return summa;

	}

	// Задача 8.
	public static int nextEdge(int a, int b){
		return a+b-1;
	}

	// Задача 9.
	public static int sumOfCubes(int[] arr){
		int summ = 0;
		for (int i = 0; i < arr.length; i++){
			summ = summ + (int)Math.pow(arr[i],3);
		}

		return summ;
	}



	// Задача 10.
	public static boolean abcmath(int a, int b, int c){
		double s = a*Math.pow(2,b-1)*2;
		if (s % c == 0){
			return true;
		}
		else return false;
	}
}