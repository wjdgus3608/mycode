package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int N,X;
	static int[][] map;
	static int ret;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		T=Integer.valueOf(st.nextToken());
		for(int k=0; k<T; k++) {
			st=new StringTokenizer(br.readLine()," ");
			N=Integer.valueOf(st.nextToken());
			X=Integer.valueOf(st.nextToken());
			map=new int[2*N][N];
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.valueOf(st.nextToken());
				}
			}
			int x=0,y=0;
			for(int i=N; i<2*N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j]=map[y][x];
					y++;
				}
				y=0;
				x++;
			}
			int cnt;
			for(int i=0; i<2*N; i++) {
				cnt=1;
				boolean check=true;
				for(int j=0; j<N-1; j++) {
					if(map[i][j]==map[i][j+1]) {
						cnt++;
						continue;
					}
					if(Math.abs(map[i][j]-map[i][j+1])>1) {
						check=false;
						break;
					}
					if(map[i][j]<map[i][j+1]) {
						if(cnt>=X) cnt=1;
						else {
							check=false;
							break;
						}
					}
					if(map[i][j]>map[i][j+1]) {
						if(cnt>=0)
						cnt=1-X;
						else
						{
							check=false;
							break;
						}
					}
				}
				if(check && cnt>=0) {
					ret++;
				}
			}
			
			System.out.print("#" + (k+1)+" ");
			System.out.println(ret);
			ret=0;
		}
	}
}

