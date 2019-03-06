//1.크기가 N * M 지도 -
//2. 지도의 좌표는 (r,c) r=i, c=j -
//3. 처음 주사위는 윗면 1 동쪽을 바라보는 방향이 3인 상태 놓인 좌표는 (x,y) ?
//4. 가장 처음 주사위는 모든면이 0 -
//5. 굴려서 그면이 0이면 주사위->지도 복사 아니면 지도->주사위 복사하고 지도는 0으로 -
//6. 주사위 좌표와 이동명령 주어졌을때 이동마다 주사위 상단값 출력
//7. 주사위가 바깥으로 이동하려하면 명령 무시, 출력도 안함 -

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		StringBuilder sb=new StringBuilder();
		int N=Integer.valueOf(st.nextToken());
		int M=Integer.valueOf(st.nextToken());
		int y=Integer.valueOf(st.nextToken());
		int x=Integer.valueOf(st.nextToken());
		int count=Integer.valueOf(st.nextToken());
		//1.크기가 N * M 지도
		int[][] map=new int[N][M];
		LinkedList<Integer> dice=new LinkedList<>();
		//4. 가장 처음 주사위는 모든면이 0
		for(int i=0; i<6; i++)
			dice.add(0);
		for(int i=0; i<N; i++)
		{
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++)
				map[i][j]=Integer.valueOf(st.nextToken());
		}
		st=new StringTokenizer(br.readLine()," ");
		Queue<Integer> q=new LinkedList<>();
		for(int i=0; i<count; i++)
			q.offer(Integer.valueOf(st.nextToken()));
		for(int i=0; i<count; i++)
		{
			switch(q.poll())
			{
			case 1://right
				//7. 주사위가 바깥으로 이동하려하면 명령 무시, 출력도 안함
				if(x+1>=M)continue;
				x++;
				dice.add(4,dice.get(5));
				dice.remove(dice.size()-1);
				dice.add(dice.get(1));
				dice.remove(1);
				break;
			case 2://left
				if(x-1<0)continue;
				x--;
				dice.add(1,dice.get(5));
				dice.remove(dice.size()-1);
				dice.add(dice.get(4));
				dice.remove(4);
				break;
			case 3://up
				if(y-1<0)continue;
				y--;
				dice.add(0,dice.get(5));
				dice.remove(dice.size()-1);
				dice.add(3,dice.get(1));
				dice.remove(1);
				dice.add(3,dice.get(4));
				dice.remove(5);
				break;
			case 4://down
				if(y+1>=N)continue;
				y++;
				dice.add(dice.get(0));
				dice.set(0,dice.get(2));
				dice.set(2,dice.get(4));
				dice.remove(4);
				break;
			}
			sb.append(dice.get(5)).append("\n");
			//5. 굴려서 그면이 0이면 주사위->지도 복사 아니면 지도->주사위 복사하고 지도는 0으로
			if(map[y][x]==0)
				map[y][x]=dice.get(2);
			else {
				dice.set(2,map[y][x]);
				map[y][x]=0;
			}
		}
		System.out.print(sb);
		br.close();
	}
}
