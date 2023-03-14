import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N,K;
	static int[] arr;
	static boolean fin = true;
	static int start;
	static int ret;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void one() {
		start--;
		if(start==-1) start=2*N-1;
	}
	
	public static void two() {
		for(int i=0; i<list.size(); i++) {
			int r = list.get(i);
			if(r==((start+N-1)%(2*N))) {
				list.remove(i);
				i--;
				continue;
			}
			
			int next = r+1;
			if(next==(2*N)) next=0;
			
			if(arr[next]>0 && !list.contains(next)) {
				list.set(i, next);
				arr[next]--;
				if(next==(start+N-1)%(2*N)) {
					list.remove(i);
					i--;
				}
			}
		}
	}
	
	
	public static void three() {
		if(arr[start]>0) {
			list.add(start);
			arr[start]--;
		}
	}
	
	public static void four() {
		int cnt=0;
		for(int num:arr) {
			if(num==0) cnt++;
		}
		if(cnt>=K)
			fin=false;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[2*N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2*N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			one();
			two();
			three();
			four();
			ret++;
			if(!fin) break;
		}
		
		bw.write(Integer.toString(ret));
		bw.flush();
		bw.close();
		br.close();
	}
}
