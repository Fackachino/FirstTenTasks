public class ThirdTenTasks{
	public static void main(String[] args){
		System.out.println(rightTriangle(70,130,110));

	}

	// Задача 1.
	public static int solutions(int a, int b, int c){
		int D = b*b - 4*a*c;

		if (D > 0) return 2;
		else if (D == 0) return 1;
		else return 0;
  
	}	

	// Задача 3.
	public static boolean checkPerfect(int n){
		int summa = 0;

		for (int i = 1; i < n; i++){
			if(n % i == 0) summa = summa + i;
			if( i == n) summa = summa - i;
		}

		if (summa == n) return true;
		else return false;

	}

	// Задача 10.
	public static boolean rightTriangle(int a, int b, int c){
		if (a*a + b*b == c*c) return true;
			else if (a*a == b*b + c*c) return true;
			else if (b*b == a*a + c*c) return true;
			else return false;





	}

	








}