package algorithm;
import java.util.Scanner;

public class ex02 {
	//도미노 문제
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("X * 2. X는 무엇인가요?: ");
		int x = sc.nextInt();
		
		System.out.println(f(x));
		sc.close();
	}
	
	static int f(int x) {
		if(x == 1) {
			return 1;
		}
		int f[] = new int[x + 1];
		f[1] = 1;
		f[2] = 2;
		
		
		
		for(int i = 3; i < x + 1; i ++) {
			f[i] = f[i-1] + f[i-2];
		}
		
		
		return f[x];
	}
}
