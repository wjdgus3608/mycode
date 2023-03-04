import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N,K;
	static ArrayList<Nation> list = new ArrayList<>();
	static int ret;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			list.add(new Nation(num,g,s,n));
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			Nation now = list.get(i);
			if(now.num==K) {
				for(int j=i; j>=0; j--) {
					Nation pre = list.get(j);
					if(now.g!=pre.g || now.s!=pre.s || now.n!=pre.n) {
						ret=j+2;
						break;
					}
				}
				if(ret==0) ret=1;
				break;
			}
		}
		
		System.out.println(ret);
	
	}
}

class Nation implements Comparable<Nation>{
	int num,g,s,n;
	Nation(int num, int g, int s, int n){
		this.num=num;
		this.g=g;
		this.s=s;
		this.n=n;
	}
	@Override
	public int compareTo(Nation o) {
		if(this.g==o.g) {
			if(this.s==o.s) {
				if(this.n==o.n)
					return 0;
				return o.n-this.n;
			}
			return o.s-this.s;
		}
		return o.g-this.g;
	}
}
