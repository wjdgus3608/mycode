import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int T;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			TreeMap<Integer,Integer> q= new TreeMap<>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				q.put(arr[i], q.getOrDefault(arr[i], 0)+1);
			}
			
			long ret = 0;
			for(int num:arr) {
				if(num!=q.firstKey()) {
					ret+=(q.firstKey()-num);
					q.put(num, q.get(num)-1);
					if(q.get(num)==0)
						q.remove(num);
				}
				else {
					q.put(num, q.get(num)-1);
					if(q.get(num)==0)
						q.remove(num);
				}
			}
			
			bw.write(ret+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
}
