import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N;
	static int ret;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Stick> q= new PriorityQueue<>((a,b)->{
			return -Integer.compare(a.h, b.h);
		});
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			q.add(new Stick(L,H));
		}
		
		Stick start = q.poll();
		ret+=start.h;
		Stick left = null;
		Stick right = null;
		while(!q.isEmpty()) {
			Stick cur = q.poll();
			if(cur.index<start.index) {
				if(left==null) {
					left=cur;
					ret+=(cur.h*(start.index-cur.index));
				}
				else if(left.index>cur.index) {
					ret+=(cur.h*(left.index-cur.index));
					left=cur;
				}
			}
			else if(cur.index>start.index) {
				if(right==null) {
					right=cur;
					ret+=(cur.h*(cur.index-start.index));
				}
				else if(right.index<cur.index) {
					ret+=(cur.h*(cur.index-right.index));
					right=cur;
				}
			}
		}
		bw.write(Integer.toString(ret));
		bw.flush();
		br.close();
		bw.close();
	}
}

class Stick{
	int index, h;
	Stick(int index, int h){
		this.index=index;
		this.h=h;
	}
}
