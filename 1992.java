
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

	
	static int N;
	static int[][] map;
	
	public static String solve(int y, int x, int size) {
		if(size==1) {
			return Integer.toString(map[y][x]);
		}
		else if(check(y,x,size)) {
			return Integer.toString(map[y][x]);
		}
		int nextSize = size/2;
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(solve(y,x,nextSize));
		sb.append(solve(y,x+nextSize,nextSize));
		sb.append(solve(y+nextSize,x,nextSize));
		sb.append(solve(y+nextSize,x+nextSize,nextSize));
		sb.append(")");
		
		return sb.toString();
	}
	
	public static boolean check(int y, int x, int size) {
		int start = map[y][x];
		for(int i=y; i<y+size; i++) {
			for(int j=x; j<x+size; j++) {
				if(map[i][j]!=start) return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map =new int[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j]=Character.getNumericValue(str.charAt(j));
			}
		}
	
		System.out.println(solve(0,0,N));
	}
	
}




