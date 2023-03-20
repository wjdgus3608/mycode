import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N;
	static Building[] arr;
	static int ret;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new Building[N];
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken());
			
			arr[i]=new Building(x,y);
		}
		
		for(Building cur:arr) {
			if(s.isEmpty()) {
				s.add(cur.y);
			}
			else {
				if(s.peek()<=cur.y) {
					s.add(cur.y);
				}
				else {
					int pre = -1;
					while(!s.isEmpty() && s.peek()>cur.y) {
						if(pre!=s.peek() && s.peek()!=0)
							ret++;
						pre=s.pop();
					}
					s.add(cur.y);
				}
			}
		}
		
		int pre = -1;
		while(!s.isEmpty()) {
			if(pre!=s.peek() && s.peek()!=0)
				ret++;
			pre=s.pop();
		}
		
		bw.write(Integer.toString(ret));
		bw.flush();
		bw.close();
		br.close();
	}
}

class Building{
	int x,y;
	Building(int x, int y){
		this.x=x;
		this.y=y;
	}
}
