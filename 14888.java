import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. N���� ���� �̷���� ���� A1, A2, ..., AN�� �־�����. 
2. ���� �� ���̿� �������� �� �ִ� N-1���� �����ڰ� �־�����.
3. �����ڴ� ����(+), ����(-), ����(��), ������(��)���θ� �̷���� �ִ�.
4. ���� �� ���̿� �����ڸ� �ϳ��� �־, ������ �ϳ� ���� �� �ִ�. 
5. �־��� ���� ������ �ٲٸ� �ȵȴ�.
6. ���� ����� ������ �켱 ������ �����ϰ� �տ������� ����
7. �������� ���� ���������� �� ���Ѵ�.
8. ������ ����� ���� ���� ����� �ٲ� �� ���� ���ϰ�, �� ���� ������ �ٲ� �Ͱ� ����. 
9. ���� ����� �ִ��� �Ͱ� �ּ��� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
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