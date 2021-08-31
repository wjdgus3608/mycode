
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M,T,K,ret;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		List<Pair> list = new ArrayList<>();
		
		for(int k=0; k<T; k++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Pair(y,x));
		}
		int retX = list.get(0).x, retY = list.get(0).y;
		for(int i=0; i<T; i++) {
			for(int j=0; j<T; j++) {
				int cnt = 0;
				int X = list.get(i).x;
				int Y = list.get(j).y;
				int XX = X+K;
				int YY = Y+K;
				if(XX>N) {
					if(X-(XX-N)>=0) {
						X -= (XX-N);
						XX = N;
					}
					else {
						continue;
					}
				}
				if(YY>M) {
					if(Y-(YY-M)>=0) {
						Y -= (YY-M);
						YY = M;
					}
					else {
						continue;
					}
				}
				
				for(int k=0; k<T; k++) {
					int x = list.get(k).x;
					int y = list.get(k).y;
					if(X<=x && x<=XX && Y<=y && y<=YY) {
						cnt++;
					}
				}
				if(ret<cnt) {
					ret = cnt;
					retY = YY;
					retX = X;
					
				}
			}
		}
		System.out.println(retX+" "+retY);
		System.out.println(ret);
	}

}


class Pair{
	int y,x;
	Pair(int y, int x){
		this.y=y;
		this.x=x;
	}
}
