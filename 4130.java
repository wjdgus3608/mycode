import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int K;
	static ArrayList<int[][]> list=new ArrayList<>();
	static Queue<Pair> q=new LinkedList<>();
	static int ret;
	public static void turn(int target, int dir) {
		int[][] temp=list.get(target-1);
		int save=temp[0][0];
		if(dir==-1) {
			temp[0][0]=temp[0][1];
			temp[0][1]=temp[0][2];
			temp[0][2]=temp[1][2];
			temp[1][2]=temp[2][2];
			temp[2][2]=temp[2][1];
			temp[2][1]=temp[2][0];
			temp[2][0]=temp[1][0];
			temp[1][0]=save;
		}
		else if(dir==1) {
			temp[0][0]=temp[1][0];
			temp[1][0]=temp[2][0];
			temp[2][0]=temp[2][1];
			temp[2][1]=temp[2][2];
			temp[2][2]=temp[1][2];
			temp[1][2]=temp[0][2];
			temp[0][2]=temp[0][1];
			temp[0][1]=save;
		}
		list.set(target-1,temp);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		T=Integer.valueOf(st.nextToken());
		for(int a=0; a<T; a++) {
			st=new StringTokenizer(br.readLine());
			K=Integer.valueOf(st.nextToken());
			for(int i=0; i<4; i++) {
				st=new StringTokenizer(br.readLine()," ");
				int[][] temp=new int[3][3];
				temp[0][1]=Integer.valueOf(st.nextToken());
				temp[0][2]=Integer.valueOf(st.nextToken());
				temp[1][2]=Integer.valueOf(st.nextToken());
				temp[2][2]=Integer.valueOf(st.nextToken());
				temp[2][1]=Integer.valueOf(st.nextToken());
				temp[2][0]=Integer.valueOf(st.nextToken());
				temp[1][0]=Integer.valueOf(st.nextToken());
				temp[0][0]=Integer.valueOf(st.nextToken());
				list.add(temp);
			}
			for(int i=0; i<K; i++) {
				st=new StringTokenizer(br.readLine()," ");
				int target=Integer.valueOf(st.nextToken());
				int dir=Integer.valueOf(st.nextToken());
				q.add(new Pair(target,dir));
			}
			while(!q.isEmpty()) {
				Pair cur=q.poll();
				switch(cur.target) {
				case 1:
					if(list.get(0)[1][2]==list.get(1)[1][0]) {
						turn(1,cur.dir);
					}
					else {
						turn(1,cur.dir);
						if(list.get(1)[1][2]==list.get(2)[1][0]) {
							turn(2,cur.dir*-1);
						}
						else {
							turn(2,cur.dir*-1);
							if(list.get(2)[1][2]==list.get(3)[1][0]) {
								turn(3,cur.dir);
							}
							else {
								turn(3,cur.dir);
								turn(4,cur.dir*-1);
							}
						}
					}
					break;
				case 2:
					if(list.get(0)[1][2]!=list.get(1)[1][0]) {
						turn(1,cur.dir*-1);
					}
					if(list.get(1)[1][2]==list.get(2)[1][0]) {
						turn(2,cur.dir);
					}
					else {
						turn(2,cur.dir);
						if(list.get(2)[1][2]==list.get(3)[1][0]) {
							turn(3,cur.dir*-1);
						}
						else {
							turn(3,cur.dir*-1);
							turn(4,cur.dir);
						}
					}
					break;
				case 3:
					if(list.get(2)[1][2]!=list.get(3)[1][0]) {
						turn(4,cur.dir*-1);
					}
					if(list.get(2)[1][0]==list.get(1)[1][2]) {
						turn(3,cur.dir);
					}
					else {
						turn(3,cur.dir);
						if(list.get(1)[1][0]==list.get(0)[1][2]) {
							turn(2,cur.dir*-1);
						}
						else {
							turn(2,cur.dir*-1);
							turn(1,cur.dir);
						}
					}
					break;
				case 4:
					if(list.get(2)[1][2]==list.get(3)[1][0]) {
						turn(4,cur.dir);
					}
					else {
						turn(4,cur.dir);
						if(list.get(1)[1][2]==list.get(2)[1][0]) {
							turn(3,cur.dir*-1);
						}
						else {
							turn(3,cur.dir*-1);
							if(list.get(0)[1][2]==list.get(1)[1][0]) {
								turn(2,cur.dir);
							}
							else {
								turn(2,cur.dir);
								turn(1,cur.dir*-1);
							}
						}
					}
					break;
				}
			}
			int point=1;
			for(int k=0; k<4; k++) {
				ret+=list.get(k)[0][1]*point;
				point*=2;
			}
			System.out.print("#"+(a+1)+" ");
			System.out.println(ret);
			ret=0;
			list.clear();
		}
	}
}
class Pair{
	int target, dir;
	Pair(int target, int dir){
		this.target=target;
		this.dir=dir;
	}
}
