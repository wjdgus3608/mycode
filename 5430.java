
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Main {
	static int T, n;
	public static String solve(Deque<Integer> q, String com, int n, boolean isReverse) {
		try {
			for(int i=0; i<com.length(); i++) {
				char c = com.charAt(i);
				if(c=='D') {
					if(isReverse) {
						q.removeLast();
					}
					else {
						q.removeFirst();
					}
				}
				else {
					isReverse=!isReverse;
				}
			}
		}
		catch(NoSuchElementException e) {
			return "error";
		}
		StringBuilder sb = new StringBuilder();
		if(isReverse) {
			while(!q.isEmpty()) {
				sb.append(q.pollLast()+",");
			}
		}
		else {
			while(!q.isEmpty()) {
				sb.append(q.pollFirst()+",");
			}
		}
		if(sb.length()==0)
			return "[]";
		return "["+sb.substring(0, sb.length()-1)+"]";
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<T; i++) {
			String p = br.readLine();
			n = Integer.parseInt(br.readLine());
			String arrStr = br.readLine();
			if(n!=0)
			arrStr = arrStr.substring(1,arrStr.length()-1);
			int[] arr = new int[n];
			if(n==1) {
				arr[0]=Integer.parseInt(arrStr);
			}
			else if(n>1) {
				String[] temp = arrStr.split(",");
				for(int j=0; j<n; j++) {
					arr[j]=Integer.parseInt(temp[j]);
				}
			}
			Deque<Integer> q = new LinkedList<>();
			for(int j=0; j<n; j++) {
				q.add(arr[j]);
			}
			sb.append(solve(q,p,n,false)+"\n");
		}
		
		System.out.print(sb.toString());
		
	}

}
