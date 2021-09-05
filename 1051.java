import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	static int N,M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		
		int min = Math.min(N, M);
		
		for(int k=min; k>=1; k--) {
			for(int i=0; i<N-k+1; i++) {
				for(int j=0; j<M-k+1; j++) {
					if(arr[i][j]==arr[i][j+k-1] && arr[i][j]==arr[i+k-1][j] && arr[i][j]==arr[i+k-1][j+k-1]) {
						System.out.println(k*k);
						return;
					}
				}
			}
		}
		
	}
	
}



