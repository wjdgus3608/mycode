package algo;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
	static int n, m, min = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<cctv> cctv_list = new ArrayList<>();
	static final int[] cctv_range = { 4, 2, 4, 4, 1 };
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	static void copy(int[][] arr,int[][] copy)
	{
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr[i].length; j++)
				copy[i][j]=arr[i][j];
		}
	}
	
	static void spread(int dir, int y, int x)
	{
		int nextY,nextX;
		dir=dir%4;
		switch(dir)
		{
		case 0:
			for(int i=0; i<n; i++)
			{
				nextY=y-(1*(i+1));
				if(nextY<0 || map[nextY][x]==6)
					break;
				if(map[nextY][x]==0)
				map[nextY][x]=-1;
			}
			break;
		case 1:
			for(int i=0; i<m; i++)
			{
				nextX=x+(1*(i+1));
				if(nextX>=m || map[y][nextX]==6)
					break;
				if(map[y][nextX]==0)
				map[y][nextX]=-1;
			}
			break;
		case 2:
			for(int i=0; i<n; i++)
			{
				nextY=y+(1*(i+1));
				if(nextY>=n || map[nextY][x]==6)
					break;
				if(map[nextY][x]==0)
				map[nextY][x]=-1;
			}
			break;
		case 3:
			for(int i=0; i<m; i++)
			{
				nextX=x-(1*(i+1));
				if(nextX<0 || map[y][nextX]==6)
					break;
				if(map[y][nextX]==0)
				map[y][nextX]=-1;
			}
			break;
		}
	}
	
	public static void dfs(int index) {
		if (index == cctv_list.size()) {
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 0)
						count++;
				}
			}
			min = Math.min(min, count);
			return;
		}

		cctv temp = cctv_list.get(index);
		for (int i = 0; i < cctv_range[temp.type-1]; i++) {
			int[][] backup=new int[n][m];
			copy(map,backup);
			if (temp.type == 1) {
				spread(i, temp.y, temp.x);
			}
			if (temp.type == 2) {
				spread(i, temp.y, temp.x);
				spread(i+2, temp.y, temp.x);
			}
			if (temp.type == 3) {
				spread(i, temp.y, temp.x);
				spread(i+1, temp.y, temp.x);
			}
			if (temp.type == 4) {
				spread(i, temp.y, temp.x);
				spread(i+1, temp.y, temp.x);
				spread(i+2, temp.y, temp.x);
			}
			if (temp.type == 5) {
				spread(i, temp.y, temp.x);
				spread(i+1, temp.y, temp.x);
				spread(i+2, temp.y, temp.x);
				spread(i+3, temp.y, temp.x);
			}
			dfs(index + 1);
			copy(backup,map);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		map=new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6)
				{
					cctv temp=new cctv(i,j ,map[i][j]);
					cctv_list.add(temp);
				}	
			}
		}
		dfs(0);
		System.out.print(min);
	}
}

class cctv {
	int x, y;
	int type;

	cctv(int y, int x, int type) {
		this.y = y;
		this.x = x;
		this.type = type;
	}
}

