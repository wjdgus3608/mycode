import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 1. 루빅스 큐브가 모두 풀린 상태에서 시작한다. 윗 면은 흰색, 아랫 면은 노란색, 앞 면은 빨간색, 뒷 면은 오렌지색, 왼쪽 면은 초록색, 오른쪽 면은 파란색이다.
2. 루빅스 큐브를 돌린 방법이 순서대로 주어진다. 이때, 모두 돌린 다음에 가장 윗 면의 색상을 구하는 프로그램을 작성하시오.
3. 첫째 줄에 테스트 케이스의 개수가 주어진다. 테스트 케이스는 최대 100개이다.
4. 첫째 줄에 큐브를 돌린 횟수 n이 주어진다.
5. 둘째 줄에는 큐브를 돌린 방법이 주어진다. 각 방법은 공백으로 구분되어져 있으며, 첫 번째 문자는 돌린 면이다.
6. U: 윗 면, D: 아랫 면, F: 앞 면, B: 뒷 면, L: 왼쪽 면, R: 오른쪽 면이다. 
7. 두 번째 문자는 돌린 방향이다. +인 경우에는 시계 방향 (그 면을 바라봤을 때가 기준), -인 경우에는 반시계 방향이다.
 */

public class Main {
	static int K;
	static ArrayList<char[][]> cube = new ArrayList<>();

	public static void turn(int target, int dir) {
		int n = cube.get(target).length;
		char[][] a = cube.get(target);
		int times;
		if(target==2)
		times = dir == -1 ? 2 : 0;
		else
			times = dir == 1 ? 2 : 0;
		for (int k = 0; k < 1 + times; k++) {
			for (int i = 0; i < n / 2; i++) {
				for (int j = i; j < n - i - 1; j++) {
					char temp = a[i][j];
					a[i][j] = a[n - j - 1][i];
					a[n - j - 1][i] = a[n - 1 - i][n - 1 - j];
					a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
					a[j][n - 1 - i] = temp;
				}
			}
		}
	}

	public static void turn_round(int target, int dir) {
		switch (target) {
		case 0:
			if (dir == 1) {
				for(int i=0; i<3; i++) {
					char[] temp=new char[3];
					temp[i]=cube.get(1)[0][i];
				cube.get(1)[0][i]=cube.get(5)[2][i];
				cube.get(5)[2][i]=cube.get(3)[0][i];
				cube.get(3)[0][i]=cube.get(2)[0][i];
				cube.get(2)[0][i]=temp[i];
				}
			} else {
				for(int i=0; i<3; i++) {
					char[] temp=new char[3];
					temp[i]=cube.get(1)[0][i];
				cube.get(1)[0][i]=cube.get(2)[0][i];
				cube.get(2)[0][i]=cube.get(3)[0][i];
				cube.get(3)[0][i]=cube.get(5)[2][i];
				cube.get(5)[2][i]=temp[i];
				}
			}
			break;
		case 1:
			if (dir == 1) {
				for(int i=0; i<3; i++) {
					char[] temp=new char[3];
					temp[i]=cube.get(0)[i][0];
				cube.get(0)[i][0]=cube.get(2)[i][0];
				cube.get(2)[i][0]=cube.get(4)[i][0];
				cube.get(4)[i][0]=cube.get(5)[i][0];
				cube.get(5)[i][0]=temp[i];
				}
			} else {
				for(int i=0; i<3; i++) {
					char[] temp=new char[3];
					temp[i]=cube.get(0)[i][0];
				cube.get(0)[i][0]=cube.get(5)[i][0];
				cube.get(5)[i][0]=cube.get(4)[i][0];
				cube.get(4)[i][0]=cube.get(2)[i][0];
				cube.get(2)[i][0]=temp[i];
				}
			}
			break;
		case 2:
			if (dir == 1) {
				for(int i=0; i<3; i++) {
					char[] temp=new char[3];
					temp[i]=cube.get(0)[2][i];
				cube.get(0)[2][i]=cube.get(3)[i][0];
				cube.get(3)[i][0]=cube.get(4)[0][i];
				cube.get(4)[0][i]=cube.get(1)[i][2];
				cube.get(1)[i][2]=temp[i];
				}
			} else {
				for(int i=0; i<3; i++) {
					char[] temp=new char[3];
					temp[i]=cube.get(0)[2][i];
				cube.get(0)[2][i]=cube.get(1)[i][2];
				cube.get(1)[i][2]=cube.get(4)[0][i];
				cube.get(4)[0][i]=cube.get(3)[i][0];
				cube.get(3)[i][0]=temp[i];
				}
			}
			break;
		case 3:
			if (dir == 1) {
				for(int i=0; i<3; i++) {
					char[] temp=new char[3];
					temp[i]=cube.get(0)[i][2];
				cube.get(0)[i][2]=cube.get(5)[i][2];
				cube.get(5)[i][2]=cube.get(4)[i][2];
				cube.get(4)[i][2]=cube.get(2)[i][2];
				cube.get(2)[i][2]=temp[i];
				}
			} else {
				for(int i=0; i<3; i++) {
					char[] temp=new char[3];
					temp[i]=cube.get(0)[i][2];
				cube.get(0)[i][2]=cube.get(2)[i][2];
				cube.get(2)[i][2]=cube.get(4)[i][2];
				cube.get(4)[i][2]=cube.get(5)[i][2];
				cube.get(5)[i][2]=temp[i];
				}
			}
			break;
		case 4:
			if (dir == 1) {
				for(int i=0; i<3; i++) {
					char[] temp=new char[3];
					temp[i]=cube.get(1)[2][i];
				cube.get(1)[2][i]=cube.get(2)[2][i];
				cube.get(2)[2][i]=cube.get(3)[2][i];
				cube.get(3)[2][i]=cube.get(5)[0][i];
				cube.get(5)[0][i]=temp[i];
				}
			} else {
				for(int i=0; i<3; i++) {
					char[] temp=new char[3];
					temp[i]=cube.get(1)[2][i];
				cube.get(1)[2][i]=cube.get(5)[0][i];
				cube.get(5)[0][i]=cube.get(3)[2][i];
				cube.get(3)[2][i]=cube.get(2)[2][i];
				cube.get(2)[2][i]=temp[i];
				}
			}
			break;
		case 5:
			if (dir == 1) {
				for(int i=0; i<3; i++) {
					char[] temp=new char[3];
					temp[i]=cube.get(0)[0][i];
				cube.get(0)[0][i]=cube.get(1)[i][0];
				cube.get(1)[i][0]=cube.get(4)[2][i];
				cube.get(4)[2][i]=cube.get(3)[i][2];
				cube.get(3)[i][2]=temp[i];
				}
			} else {
				for(int i=0; i<3; i++) {
					char[] temp=new char[3];
					temp[i]=cube.get(0)[0][i];
				cube.get(0)[0][i]=cube.get(3)[i][2];
				cube.get(3)[i][2]=cube.get(4)[2][i];
				cube.get(4)[2][i]=cube.get(1)[i][0];
				cube.get(1)[i][0]=temp[i];
				}
			}
			break;
		}
	}
	public static void reset() {
		for (int i = 0; i < 6; i++) {
			char[][] temp = new char[3][3];
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					switch (i) {
					case 0:
						temp[j][k] = 'o';
						break;
					case 1:
						temp[j][k] = 'g';
						break;
					case 2:
						temp[j][k] = 'y';
						break;
					case 3:
						temp[j][k] = 'b';
						break;
					case 4:
						temp[j][k] = 'r';
						break;
					case 5:
						temp[j][k] = 'w';
						break;
					}
				}
			}
			cube.add(temp);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		reset();
		K = Integer.valueOf(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				String how = (st.nextToken());
				char temp = how.charAt(0);
				char temp2 = how.charAt(1);
				int target = -1, dir = -1;
				switch (temp) {
				case 'U':
					target = 5;
					break;
				case 'D':
					target = 2;
					break;
				case 'B':
					target = 0;
					break;
				case 'L':
					target = 1;
					break;
				case 'R':
					target = 3;
					break;
				case 'F':
					target = 4;
					break;
				}
				dir = temp2 == '+' ? 1 : -1;
				turn(target, dir);
				turn_round(target, dir);
			}
			for (int a = 2; a >=0; a--) {
				for (int b = 0; b < 3; b++) {
					System.out.print(cube.get(5)[a][b]);
				}
				System.out.println();
			}
			cube.clear();
			reset();
		}
		
	}
}
