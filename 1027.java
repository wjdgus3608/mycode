import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N;
	static long[] arr;
	static int ret;
	
	public static int getLeft(int start) {
		int index=start-1;
		int cnt=0;
		while(index>=0) {
			double a1 = arr[index]-arr[start];
			double a2 = index-start;
			double b = getB(start,a1,a2);
			boolean flag = true;
			
			for(int i=start-1; i>index; i--) {
				if((a1/a2*i+b)<=(double)arr[i]) {
					flag=false;
					break;
				}
			}
			if(flag)
				cnt++;
			index--;
		}
		return cnt;
	}
	
	public static int getRight(int start) {
		int index=start+1;
		int cnt=0;
		while(index<N) {
			double a1 = arr[start]-arr[index];
			double a2 = start-index;
			double b = getB(start,a1,a2);
			boolean flag = true;
		
			for(int i=start+1; i<index; i++) {
				if((a1/a2*i+b)<=(double)arr[i]) {
					flag=false;
					break;
				}
			}
			if(flag)
				cnt++;
			index++;
		}
		return cnt;
	}
	
	
	public static double getB(int start, double a1, double a2) {
		return (arr[start]-start*a1/a2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum+=getLeft(i);
			sum+=getRight(i);
			ret=Math.max(ret, sum);
			sum=0;
		}
		
		bw.write(Integer.toString(ret));
		bw.flush();
		bw.close();
		br.close();
		
	}
}
