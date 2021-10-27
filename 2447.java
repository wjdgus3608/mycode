
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void spread(int n, int y, int x) {
		if(n==3) {
			draw(y,x);
			return;
		}
		for(int i=0; i<n; i+=(n/3)) {
			for(int j=0; j<n; j+=(n/3)) {
				if(i==n/3 && j==n/3) continue;
				spread(n/3,y+i,x+j);
			}
		}
	}
	public static void draw(int y, int x) {
		for(int i=y; i<y+3; i++) {
			for(int j=x; j<x+3; j++) {
				if(i==y+1 && j==x+1) continue;
				map[i][j]='*';
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				map[i][j]=' ';
		spread(N,0,0);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				sb.append(map[i][j]);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

}
