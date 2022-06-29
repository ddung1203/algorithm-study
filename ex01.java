package algorithm;
import java.util.Scanner;

public class ex01 {
	//행렬 경로 변경 문제
	static int row;
	static int col;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇행인가요?: ");
		row = sc.nextInt();
		
		System.out.print("몇열인가요?: ");
		col = sc.nextInt();
		

		System.out.println(matrixPath(row + 1, col + 1));
		sc.close();
	}

	static int matrixPath(int n, int nn) {
		Scanner sc = new Scanner(System.in);
		
		int m[][] = new int [n][nn];
		
		for(int i = 0; i < n-1; i ++) {
			System.out.println("행을 입력해주세요: ");
			for(int j = 0; j < nn-1; j++) {
				m[i][j] =sc.nextInt(); 
			} 
		}
		
		
		int c[][] = new int[n][nn];
		
		
		for(int i = 0; i < n; i++) {
			c[i][0] = 0;
		}
		
		for(int j = 1; j < nn; j++) {
			c[0][j] = 0;
		}
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < nn; j++) {
				c[i][j] = m[i-1][j-1] + Math.max(c[i-1][j], Math.max(c[i][j-1], c[i-1][j-1]));
				
			}
		}
		sc.close();
		return c[n-1][nn-1];
	}
}

