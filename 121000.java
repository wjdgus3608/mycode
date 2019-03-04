import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static ArrayList<int[]> list = new ArrayList<int[]>();
	private int[] res = new int[5];

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void road(int[] arr, int depth) {
		if (depth == 5) {
			int[] copy = Arrays.copyOf(res, res.length);
			list.add(copy);
			return;
		}
		for (int i = 0; i < 4; i++) {
			swap(arr, depth, i);
			res[depth] = arr[depth];
			road(arr, depth + 1);
			swap(arr, depth, i);
		}
	}

	static public void move(int[][] arr, int dir) {
		switch (dir) {
		case 0:

			for (int j = 0; j < arr.length; j++) {
				boolean trans = false;
				for (int i = 0; i < arr.length; i++) {
					if (arr[i][j] == 0)
						continue;
					int index = i;
					int memo = arr[i][j];
					arr[i][j] = 0;
					while (i - 1 >= 0 && arr[i - 1][j] == 0) {
						i--;
					}
					if (i - 1 >= 0 && arr[i - 1][j] == memo && !trans) {
						arr[i - 1][j] += memo;
						arr[i][j] = 0;
						trans = true;
					} else {
						arr[i][j] = memo;
						trans = false;
					}
					i = index;
				}
			}

			break;
		case 1:

			for (int j = 0; j < arr.length; j++) {
				boolean trans = false;
				for (int i = arr.length - 1; i >= 0; i--) {
					if (arr[i][j] == 0)
						continue;
					int index = i;
					int memo = arr[i][j];
					arr[i][j] = 0;
					while (i + 1 < arr.length && arr[i + 1][j] == 0) {
						i++;
					}
					if (i + 1 < arr.length && arr[i + 1][j] == memo && !trans) {
						arr[i + 1][j] += memo;
						arr[i][j] = 0;
						trans = true;
					} else {
						arr[i][j] = memo;
						trans = false;
					}
					i = index;
				}
			}

			break;
		case 2:
			for (int i = 0; i < arr.length; i++) {
				boolean trans = false;
				for (int j = 0; j < arr.length; j++) {
					if (arr[i][j] == 0)
						continue;
					int index = j;
					int memo = arr[i][j];
					arr[i][j] = 0;
					while (j - 1 >= 0 && arr[i][j - 1] == 0) {
						j--;
					}
					if (j - 1 >= 0 && arr[i][j - 1] == memo && !trans) {
						arr[i][j - 1] += memo;
						arr[i][j] = 0;
						trans = true;
					} else {
						arr[i][j] = memo;
						trans = false;
					}
					j = index;
				}
			}
			break;
		case 3:
			for (int i = 0; i < arr.length; i++) {
				boolean trans = false;
				for (int j = arr.length - 1; j >= 0; j--) {
					if (arr[i][j] == 0)
						continue;
					int index = j;
					int memo = arr[i][j];
					arr[i][j] = 0;
					while (j + 1 < arr.length && arr[i][j + 1] == 0) {
						j++;
					}
					if (j + 1 < arr.length && arr[i][j + 1] == memo && !trans) {
						arr[i][j + 1] += memo;
						arr[i][j] = 0;
						trans = true;
					} else {
						arr[i][j] = memo;
						trans = false;
					}
					j = index;
				}
			}
			break;
		}

	}

	public static void main(String[] args) throws IOException {

		Main b1 = new Main();
		int[] dir = new int[20];
		for (int i = 0; i < 20; i++)
			dir[i] = i % 4;
		b1.road(dir, 0);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] arr = new int[num][num];

		for (int i = 0; i < num; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < temp.length; j++)
				arr[i][j] = Integer.parseInt(temp[j]);
		}

		int max = -1;
		for (int[] temp : list) {
			int[][] copy=new int[arr.length][arr.length];
			for(int i=0; i<arr.length; i++)
			{
				for(int j=0; j<arr.length; j++)
				{
					copy[i][j]=arr[i][j];
				}
			}
			for (int a : temp) {
				move(copy, a);
			}
			for (int i = 0; i < copy.length; i++) {
				for (int j = 0; j < copy.length; j++) {
					if (max < copy[i][j])
						max = copy[i][j];
				}
			}
		}
		 System.out.println(max);
	}
}
