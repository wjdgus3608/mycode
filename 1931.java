
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N;
	static Meet[] M;
	static long ret;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = new Meet[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			long start = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());
			
			M[i]=new Meet(start,end);
		}
		
		Arrays.sort(M);
		long pre=-1;
		for(int i=0; i<N; i++) {
			Meet m = M[i];
			if(pre<=m.start) {
				ret++;
				pre=m.end;
			}
		}
		
		System.out.println(ret);
	}
}

class Meet implements Comparable<Meet>{
	long start,end;
	Meet(long start, long end){
		this.start=start;
		this.end=end;
	}
	
	@Override
	public int compareTo(Meet m1) {
		if(this.end>m1.end) {
			return 1;
		}
		else if(this.end<m1.end) {
			return -1;
		}
		else if(this.end==m1.end) {
			if(this.start>m1.start)
				return 1;
			else if(this.start<m1.start)
				return -1;
			return 0;
		}
		return 0;
	}
}
