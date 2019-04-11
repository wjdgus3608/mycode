import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N;
	static int[][] map;
	static ArrayList<Person> p_list=new ArrayList<>();
	static Stair[] stair;
	static int ret=Integer.MAX_VALUE;
	public static void dfs(int cnt,int index,int r) {
		if(cnt==r) {
			check();
			return;
		}
		for(int i=index+1; i<p_list.size(); i++) {
			p_list.get(i).dir=1;
			dfs(cnt+1,i,r);
			p_list.get(i).dir=0;
		}
	}
	public static void check() {
		ArrayList<Person> temp_list=new ArrayList<>();
		for(Person temp:p_list) {
			temp_list.add(temp);
		}
		Collections.sort(temp_list,(t1,t2)->{
			int dis1=Math.abs(t1.y-stair[t1.dir].y)+Math.abs(t1.x-stair[t1.dir].x);
			int dis2=Math.abs(t2.y-stair[t2.dir].y)+Math.abs(t2.x-stair[t2.dir].x);
			return Integer.compare(dis1,dis2);
		});
		Queue<Person> q=new LinkedList<>();
		ArrayList<Integer> l1=new ArrayList<>();
		ArrayList<Integer> l2=new ArrayList<>();
		for(Person temp:temp_list)
			q.add(temp);
		int time=0;
		int cnt=0;
		while(!q.isEmpty()) {
			Person cur=q.peek();
			int dis=Math.abs(cur.y-stair[cur.dir].y)+Math.abs(cur.x-stair[cur.dir].x);
			while(time<dis+cnt) {
				for(int i=0; i<l1.size(); i++) {
					if(l1.get(i)!=0)
					l1.set(i,l1.get(i)-1);
					else {
						l1.remove(i);
						i--;
					}
				}
				for(int i=0; i<l2.size(); i++) {
					if(l2.get(i)!=0)
						l2.set(i,l2.get(i)-1);
						else {
							l2.remove(i);
							i--;
						}
				}
				time++;
			}
			if(cur.dir==0) {
				if(l1.size()<3) {
					if(cnt!=0)
					l1.add(stair[0].length-1);
					else
					l1.add(stair[0].length);
					cnt=0;
					q.poll();
				}
				else cnt++;
			}
			else if(cur.dir==1) {
				if(l2.size()<3) {
					if(cnt!=0)
						l1.add(stair[0].length-1);
					else
						l2.add(stair[1].length);
					cnt=0;
					q.poll();
				}
				else cnt++;
			}
		}
		while(l1.size()!=0 || l2.size()!=0) {
			for(int i=0; i<l1.size(); i++) {
				if(l1.get(i)!=0)
				l1.set(i,l1.get(i)-1);
				else {
					l1.remove(i);
					i--;
				}
			}
			for(int i=0; i<l2.size(); i++) {
				if(l2.get(i)!=0)
					l2.set(i,l2.get(i)-1);
					else {
						l2.remove(i);
						i--;
					}
			}
			time++;
		}
		ret=Math.min(ret,time);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb;
		T=Integer.valueOf(st.nextToken());
		for(int k=0; k<T; k++) {
			N=Integer.valueOf(br.readLine());
			map=new int[N][N];
			stair=new Stair[2];
			int index=0;
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.valueOf(st.nextToken());
					if(map[i][j]==1) {
						p_list.add(new Person(i,j));
					}
					else if(map[i][j]>1) {
						stair[index]=new Stair(i,j,map[i][j]);
						index++;
					}
				}
			}
			for(int i=0; i<=p_list.size(); i++)
			dfs(0,-1,i);
			System.out.print("#"+(k+1)+" ");
			System.out.println(ret);
			ret=Integer.MAX_VALUE;
			p_list.clear();
		}
	}
}

class Stair{
	int x,y;
	int length;
	Stair(int y, int x,int length){
		this.y=y;
		this.x=x;
		this.length=length;
	}
}
class Person{
	int x,y;
	int dir=0;
	Person(int y,int x){
		this.y=y;
		this.x=x;
	}
}

