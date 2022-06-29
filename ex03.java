package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex03 {
	//LCS 길이, 최장 공통 부분 순서 출력 문제
	static int B[][] = new int[100][100];
	static char str1[] = new char[100];
	static char str2[] = new char[100];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("비교 할 문장: ");
		str1 = br.readLine().toCharArray();
		System.out.print("비교 할 문장: ");
		str2 = br.readLine().toCharArray();
		int n = str1.length;
		int nn = str2.length;

		System.out.println("길이: " + LCSLength(n, nn));
		System.out.println("문장: " + LCSStr(n, nn));
	}

	
	public static int LCSLength(int n, int nn) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= nn; j++) {
				if (str1[i - 1] == str2[j - 1])
					B[i][j] = B[i - 1][j - 1] + 1;
				else
					B[i][j] = Math.max(B[i][j - 1], B[i - 1][j]);
			}
		}
		
		
		return B[n][nn];
	}
	
	public static String LCSStr(int n, int nn) {
		if(n == 0 || nn == 0) {
			return "";
		} else if(str1[n-1] == str2[nn-1]) {
			return LCSStr(n-1, nn-1) + str1[n-1];
		} else {
			if(B[n][nn-1] > B[n-1][nn])
				return LCSStr(n, nn-1);
			else
				return LCSStr(n-1, nn);
		}
	}
}