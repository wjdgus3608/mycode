import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. N개의 수로 이루어진 수열 A1, A2, ..., AN이 주어진다. 
2. 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다.
3. 연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다.
4. 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. 
5. 주어진 수의 순서를 바꾸면 안된다.
6. 식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행
7. 나눗셈은 정수 나눗셈으로 몫만 취한다.
8. 음수를 양수로 나눌 때는 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다. 
9. 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.
 */
public class Main {
	static int count;
	static int[] numbers;
	static int[] oper;
	static int opersize = 0;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void findcase(int depth, int result) {
		if (depth == opersize) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		if(oper[0]!=0)
		{
		oper[0]--;
		findcase(depth + 1, result + numbers[depth + 1]);
		oper[0]++;
		}
		if(oper[1]!=0)
		{
		oper[1]--;
		findcase(depth + 1, result - numbers[depth + 1]);
		oper[1]++;
		}
		if(oper[2]!=0)
		{
		oper[2]--;
		findcase(depth + 1, result * numbers[depth + 1]);
		oper[2]++;
		}
		if(oper[3]!=0)
		{
		oper[3]--;
		findcase(depth + 1, result / numbers[depth + 1]);
		oper[3]++;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		count=Integer.valueOf(st.nextToken());
		st=new StringTokenizer(br.readLine()," ");
		numbers=new int[count];
		for(int i=0; i<count; i++)
			numbers[i]=Integer.valueOf(st.nextToken());
		st=new StringTokenizer(br.readLine()," ");
		oper=new int[4];
		for(int i=0; i<4; i++)
		{
			oper[i]=Integer.valueOf(st.nextToken());
			opersize+=oper[i];
		}
		findcase(0,numbers[0]);
		System.out.println(max);
		System.out.println(min);
	}
}