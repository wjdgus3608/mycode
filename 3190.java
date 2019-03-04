import java.awt.Point;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Deque;
public class Main {
	static private int[] head=new int[2];
	static private Deque<Point> dq=new ArrayDeque<Point>();
	static private int dir=3;
	public static boolean move(int[][] map, int dir)
	{
		switch(dir)
		{
		case 0:
			if(head[0]-1<0 || map[head[0]-1][head[1]]>=2)
			return false;
			dq.push(new Point(head[0]-1,head[1]));
			if(map[head[0]-1][head[1]]!=1)
			{
				Point p=dq.pollLast();
				map[p.x][p.y]=0;
			}
			head[0]-=1;
			break;
		case 1:
			if(head[0]+1>=map.length || map[head[0]+1][head[1]]>=2)
				return false;
			dq.push(new Point(head[0]+1,head[1]));
			if(map[head[0]+1][head[1]]!=1)
			{
				Point p=dq.pollLast();
				map[p.x][p.y]=0;
			}
			head[0]+=1;
			break;
		case 2:
			if(head[1]-1<0 || map[head[0]][head[1]-1]>=2)
				return false;
			dq.push(new Point(head[0],head[1]-1));
			if(map[head[0]][head[1]-1]!=1)
			{
				Point p=dq.pollLast();
				map[p.x][p.y]=0;
			}
			head[1]-=1;
			break;
		case 3:
			if(head[1]+1>=map.length || map[head[0]][head[1]+1]>=2)
				return false;
			dq.push(new Point(head[0],head[1]+1));
			if(map[head[0]][head[1]+1]!=1)
			{
				Point p=dq.pollLast();
				map[p.x][p.y]=0;
			}
			head[1]+=1;
			break;
		}
		Iterator it=dq.iterator();
		while(it.hasNext())
		{
			Point p=(Point) it.next();
			map[p.x][p.y]=2;
		}
		return true;
	}
	public static void turn(int cur_dir, int target) {
		switch(cur_dir)
		{
		case 0:
			dir=target==0?2:3;
			break;
		case 1:
			dir=target==0?3:2;
			break;
		case 2:
			dir=target==0?1:0;
			break;
		case 3:
			dir=target==0?0:1;
			break;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int size=Integer.parseInt(br.readLine());
		int[][] map=new int[size][size];
		map[0][0]=2;
		dq.push(new Point(0,0));
		int apple_ct=Integer.parseInt(br.readLine());
		for(int i=0; i<apple_ct; i++)
		{
			String[] temp=br.readLine().split(" ");
			map[Integer.parseInt(temp[0])-1][Integer.parseInt(temp[1])-1]=1;
		}
		int move_ct=Integer.parseInt(br.readLine());
		Queue<String[]> dir_que=new LinkedList<String[]>();
		for(int i=0; i<move_ct; i++)
		{
			String[] tm=br.readLine().split(" ");
			dir_que.offer(tm);
		}
		boolean alive=true;
		int sec=0,wait=-1;
		while(alive)
		{
			sec++;
			if(!dir_que.isEmpty())
				wait=Integer.parseInt(dir_que.peek()[0]);
			alive=move(map,dir);
			if(sec==wait) {
				int go=-1;
				go=dir_que.peek()[1].equals("L")?0:1;
				turn(dir,go);
				dir_que.poll();
			}
		}
		System.out.println(sec);
		
	}
}
