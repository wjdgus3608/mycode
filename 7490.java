import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int T,N,M;
	static ArrayList<String> list;
	static BufferedWriter bw;
	
	public static boolean check(char[] arr) {
		int pre=1;
		int num=2;
		ArrayList<Integer> temp = new ArrayList<>();
		for(int i=0; i<N-1; i++) {
			if(arr[i]==' ') {
				pre=pre*10+num++;
			}
			else {
				temp.add(pre);
				pre=num++;
			}
		}
		temp.add(pre);
		
		int index=1;
		int sum=temp.get(0);
		for(int i=0; i<N-1; i++) {
			if(arr[i]=='+') {
				sum+=temp.get(index++);
			}
			else if(arr[i]=='-') {
				sum-=temp.get(index++);
			}
		}
		return sum==0;
	}
	
	public static void dfs(int depth, char[] arr) {
		if(depth==N-1) {
			if(check(arr)) {
				StringBuilder sb = new StringBuilder();
				int num=1;
				for(int i=0; i<N-1; i++) {
					sb.append(num++).append(arr[i]);
				}
				sb.append(num);
				list.add(sb.toString());
			}
			return;
		}
		
		arr[depth]='+';
		dfs(depth+1,arr);

		arr[depth]='-';
		dfs(depth+1,arr);

		arr[depth]=' ';
		dfs(depth+1,arr);
		
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(st.nextToken());
		for(int i=0; i<T; i++) {
			N=Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			dfs(0,new char[N-1]);
			Collections.sort(list);
			for(String str:list)
				bw.write(str+"\n");
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
