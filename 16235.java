package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/*1.최근 N×N 크기의 땅을 구매했다. 
2. r은 가장 위에서부터 떨어진 칸의 개수, c는 가장 왼쪽으로부터 떨어진 칸의 개수이다. r과 c는 1부터 시작한다.
3. 놀랍게도 양분은 모든 칸이 5만큼 들어있었다.
4. 상도는 나무 재테크로 더 큰 돈을 벌기 위해 M개의 나무를 구매해 땅에 심었다. 
5. 같은 1×1 크기의 칸에 여러 개의 나무가 심어져 있을 수도 있다.

이 나무는 사계절을 보내며, 아래와 같은 과정을 반복한다.

6. 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다. 
7. 각각의 나무는 나무가 있는 1×1 크기의 칸에 있는 양분만 먹을 수 있다. 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다. 
8. 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
9. 여름에는 봄에 죽은 나무가 양분으로 변하게 된다. 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다. 소수점 아래는 버린다.
10. 가을에는 나무가 번식한다. 번식하는 나무는 나이가 5의 배수이어야 하며, 인접한 8개의 칸에 나이가 1인 나무가 생긴다. 
11. 어떤 칸 (r, c)와 인접한 칸은 8개(대각선포함)
12. 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
13. 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다. 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
14. K년이 지난 후 상도의 땅에 살아있는 나무의 개수를 구하는 프로그램을 작성하시오.

입력


출력
첫째 줄에 K년이 지난 후 살아남은 나무의 수를 출력한다.*/

public class Main {
	static int N, M, K;
	static int[][] map;
	static int[][] add_map;
	static Deque<Tree> tree_list = new ArrayDeque<Tree>();
	static Deque<Tree> live_tree = new ArrayDeque<>();
	static Deque<Tree> dead_list = new ArrayDeque<>();

	// 6. 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
	// 7. 각각의 나무는 나무가 있는 1×1 크기의 칸에 있는 양분만 먹을 수 있다. 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린
	// 나무부터 양분을 먹는다.
	// 8. 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
	public static void spring() {
		while (!tree_list.isEmpty()) {
			Tree cur = tree_list.poll();
			if ((map[cur.y][cur.x] - cur.age) < 0)
				dead_list.add(cur);
			else {
				map[cur.y][cur.x] -= cur.age;
				cur.age++;
				live_tree.add(new Tree(cur.y, cur.x, cur.age));
			}
		}
	}

	// 9. 여름에는 봄에 죽은 나무가 양분으로 변하게 된다. 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로
	// 추가된다.소수점 아래는 버린다.
	public static void summer() {
		while (!dead_list.isEmpty()) {
			Tree cur = dead_list.poll();
			map[cur.y][cur.x] += (int) Math.floor(cur.age / 2);
		}
	}

	// 10. 가을에는 나무가 번식한다. 번식하는 나무는 나이가 5의 배수이어야 하며, 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
	// 11. 어떤 칸 (r, c)와 인접한 칸은 8개(대각선포함)
	// 12. 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void fall() {
		while (!live_tree.isEmpty()) {
			Tree cur = live_tree.poll();
			if (cur.age % 5 == 0) {
				for (int j = 0; j < 8; j++) {
					int nexty = cur.y + dy[j];
					int nextx = cur.x + dx[j];
					if (nexty < 0 || nextx < 0 || nexty >= N || nextx >= N)
						continue;
					tree_list.addFirst(new Tree(nexty, nextx, 1));
				}
			}
			tree_list.addLast(cur);
		}
	}

	// 13. 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다. 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
	public static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += add_map[i][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 첫째 줄에 N, M, K가 주어진다.
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		map = new int[N][N];
		add_map = new int[N][N];
		// 둘째 줄부터 N개의 줄에 A배열의 값이 주어진다. r번째 줄의 c번째 값은 A[r][c]이다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				// 놀랍게도 양분은 모든 칸이 5만큼 들어있었다.
				map[i][j] = 5;
				add_map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		// 다음 M개의 줄에는 상도가 심은 나무의 정보를 나타내는 세 정수 x, y, z가 주어진다.
		// 처음 두 개의 정수는 나무의 위치 (x, y)를 의미하고, 마지막 정수는 그 나무의 나이를 의미한다.
		Tree[] input=new Tree[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			int age = Integer.valueOf(st.nextToken());
			input[i]=new Tree(x-1, y-1, age);
		}
		Arrays.sort(input,(t1,t2)->{
			return Integer.compare(t1.age, t2.age);
		});
		for(Tree temp:input)
		tree_list.add(temp);
		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}

		System.out.print(tree_list.size());
	}
}

class Tree {
	int x, y;
	int age;

	Tree(int y, int x, int age) {
		this.y = y;
		this.x = x;
		this.age = age;
	}

}
