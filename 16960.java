
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][];
		HashMap<Integer,Integer> map =new HashMap<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			arr[i] = new int[K];
			for(int j=0; j<K; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				map.put(arr[i][j],map.getOrDefault(arr[i][j], 0)+1);
			}
		}
		
		boolean find = false;
		for(int i=0; i<arr.length; i++) {
			boolean flag = true;
			for(int j=0; j<arr[i].length; j++) {
				if(map.get(arr[i][j])<=1) {
					flag = false;
					break;
				}
			}
			if(flag) {
				find=true;
				break;
			}
		}
		System.out.println(find ? 1:0);
		
		
		br.close();
	}
	
}






