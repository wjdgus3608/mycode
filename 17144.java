import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, T;
	static int[][] map;
	static ArrayList<Point> clear = new ArrayList<>();
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int ret;

	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					q.add(new Point(i, j));
			}
		}
		int[][] temp = new int[R][C];
		while (!q.isEmpty()) {
			Point cur = q.poll();
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nexty = cur.y + dy[i];
				int nextx = cur.x + dx[i];
				if (nexty < 0 || nextx < 0 || nexty >= R || nextx >= C)
					continue;
				if (map[nexty][nextx] != -1) {
					temp[nexty][nextx] += map[cur.y][cur.x] / 5;
					cnt++;
				}
			}
			temp[cur.y][cur.x] += -(map[cur.y][cur.x] / 5 * cnt);
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += temp[i][j];
			}
		}
	}

	public static void air() {
		Point cur = clear.get(0);
		int nexty = cur.y - 1;
		int nextx = cur.x;
		while (nexty > 0) {
			map[nexty][nextx] = map[nexty - 1][nextx];
			nexty--;
		}
		while (nextx < C - 1) {
			map[nexty][nextx] = map[nexty][nextx + 1];
			nextx++;
		}
		while (nexty < cur.y) {
			map[nexty][nextx] = map[nexty + 1][nextx];
			nexty++;
		}
		while (nextx > cur.x) {
			if (map[nexty][nextx-1] != -1)
				map[nexty][nextx] = map[nexty][nextx - 1];
			else
				map[nexty][nextx] = 0;
			nextx--;
		}
		Point down = clear.get(1);
		int nexty2 = down.y + 1;
		int nextx2 = down.x;
		while (nexty2 < R - 1) {
			map[nexty2][nextx2] = map[nexty2 + 1][nextx2];
			nexty2++;
		}
		while (nextx2 < C - 1) {
			map[nexty2][nextx2] = map[nexty2][nextx2 + 1];
			nextx2++;
		}
		while (nexty2 > down.y) {
			map[nexty2][nextx2] = map[nexty2 - 1][nextx2];
			nexty2--;
		} 
		while (nextx2 > down.x) {
			if (map[nexty2][nextx2-1] != -1)
				map[nexty2][nextx2] = map[nexty2][nextx2 - 1];
			else
				map[nexty2][nextx2] = 0;
			nextx2--;
		} 
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());
		T = Integer.valueOf(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
				if (map[i][j] == -1)
					clear.add(new Point(i, j));
			}
		}
		for (int k = 0; k < T; k++) {
			bfs();
			air();
		}
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					sum += map[i][j];
			}
		}
		ret = sum;
		System.out.println(ret);
	}
}

class Point {
	int x, y;

	Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
