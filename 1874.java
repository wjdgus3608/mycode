
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	static int n;
	static int[] arr;
	static String ret;
	public static void solve(int cnt, int index) {
		StringBuilder sb = new StringBuilder();
		boolean find = true;

		Stack<Integer> st = new Stack<>();
		while(index<n) {
			if(!st.isEmpty() && st.peek()>arr[index] && cnt>arr[index]) {
				find = false;
				break;
			}
			if(!st.isEmpty() && st.peek()==arr[index]) {
				st.pop();
				sb.append("-\n");
				index++;
			}
			else {
				sb.append("+\n");
				st.push(cnt);
				cnt++;
			}
			
			
		}
		
		
		
		if(find) {
			while(!st.isEmpty()) {
				st.pop();
				sb.append("-\n");
			}
				
			ret = sb.toString();
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i]=num;
		}
		
		solve(1,0);
		
		System.out.print(ret==null?"NO":ret);
		
	}
	
}



