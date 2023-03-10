import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N, d, k, c;
	static int[] arr;
	static HashMap<Integer,Integer> map = new HashMap<>();
	static int ret;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr= new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		map.put(c, 1);
		for(int i=0; i<k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		ret = map.size();
		
		for(int i=k; i<N+k; i++) {
			int now = i%N;
			int pre = (i-k)%N;
			map.put(arr[now], map.getOrDefault(arr[now], 0)+1);
			map.put(arr[pre], map.get(arr[pre])-1);
			if(map.get(arr[pre])==0)
				map.remove(arr[pre]);
			ret=Math.max(ret, map.size());
		}
		
		bw.write(Integer.toString(ret));
		bw.flush();
		bw.close();
		br.close();
	}
}
