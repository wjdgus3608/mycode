import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N;
	static int[] arr;
	static int[] ret;

	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		ret = new int[N];
		st = new StringTokenizer(br.readLine());
		
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			s1.add(i);
		}
		
		while(!s1.isEmpty()) {
			int cur = s1.pop();
			while(!s2.isEmpty() && arr[s2.peek()]<=arr[cur]) {
				ret[s2.pop()]=cur+1;
			}
			s2.add(cur);
		}
		
		while(!s2.isEmpty()) {
			int index = s2.pop();
			ret[index]=0;
		}
		
		for(int num:ret)
			bw.write(num+" ");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
