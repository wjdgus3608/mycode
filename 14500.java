import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.valueOf(st.nextToken());
		}
		int[] shape = { 0, 1, 2, 3 };
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < shape.length; i++) {
			switch (shape[i]) {
			case 0:// mmmm case
				for (int k = 0; k < map.length; k++) {

					for (int j = 0; j < map[k].length - 3; j++)
						max = Math.max(max, map[k][j] + map[k][j + 1] + map[k][j + 2] + map[k][j + 3]);

				}
				for (int k = 0; k < map.length - 3; k++) {

					for (int j = 0; j < map[k].length; j++)
						max = Math.max(max, map[k][j] + map[k + 1][j] + map[k + 2][j] + map[k + 3][j]);

				}
				break;
			case 1:// yellow case
				for (int k = 0; k < map.length - 1; k++) {

					for (int j = 0; j < map[k].length - 1; j++) {
						max = Math.max(max, map[k][j] + map[k + 1][j] + map[k][j + 1] + map[k + 1][j + 1]);
					}

				}
				break;
			case 2:// ga
				int[][] donot1 = { { 1, 4 }, { 2, 4 }, { 1, 3 }, { 0, 4 }, { 1, 5 }, { 0, 3 }, { 2, 5 } };
				for (int k = 0; k < map.length - 1; k++) {
					for (int j = 0; j < map[k].length - 2; j++) {
						int sum = map[k][j] + map[k][j + 1] + map[k][j + 2] + map[k + 1][j] + map[k + 1][j + 1]
								+ map[k + 1][j + 2];
						for (int a = 0; a < 5; a++) {
							for (int b = a + 1; b < 6; b++) {
								boolean check = true;
								for (int c = 0; c < donot1.length; c++) {
									if (donot1[c][0] == a && donot1[c][1] == b) {
										check = false;
										break;
									}
								}
								if (check)
									max = Math.max(max, sum - map[a / 3 + k][a % 3 + j] - map[b / 3 + k][b % 3 + j]);
							}
						}
					}
				}
				break;
			case 3:// sae
				int[][] donot2 = { { 0, 3 }, { 1, 2 }, { 2, 3 }, { 2, 5 }, { 3, 4 }, { 0, 1 }, { 4, 5 } };
				for (int k = 0; k < map.length - 2; k++) {
					for (int j = 0; j < map[k].length - 1; j++) {
						int sum = map[k][j] + map[k][j + 1] + map[k + 1][j] + map[k + 1][j + 1] + map[k + 2][j]
								+ map[k + 2][j + 1];
						for (int a = 0; a < 5; a++) {
							for (int b = a + 1; b < 6; b++) {
								boolean check = true;
								for (int c = 0; c < donot2.length; c++) {
									if (donot2[c][0] == a && donot2[c][1] == b) {
										check = false;
										break;
									}
								}
								if (check)
									max = Math.max(max, sum - map[a / 2 + k][a % 2 + j] - map[b / 2 + k][b % 2 + j]);
							}
						}
					}
				}
				break;
			}
		}
		System.out.print(max);
	}
}
