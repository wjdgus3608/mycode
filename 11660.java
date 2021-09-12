
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
		
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] sum = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i-1>=0) sum[i][j]+=sum[i-1][j];
				if(j-1>=0) sum[i][j]+=sum[i][j-1];
				if(i-1>=0 && j-1>=0) {
					sum[i][j]-=sum[i-1][j-1];
				}
				sum[i][j]+=map[i][j];
			}
		}
		
		StringBuilder sb =new StringBuilder();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int y1= Integer.parseInt(st.nextToken())-1;
			int x1= Integer.parseInt(st.nextToken())-1;
			int y2= Integer.parseInt(st.nextToken())-1;
			int x2= Integer.parseInt(st.nextToken())-1;
			int val = sum[y2][x2];
			if(x1-1>=0)
				val-=sum[y2][x1-1];
			if(y1-1>=0)
				val-=sum[y1-1][x2];
			if(x1-1>=0&&y1-1>=0)
				val+=sum[y1-1][x1-1];
			sb.append(val+"\n");
		}
		
		System.out.print(sb);
		
	}
	
}



