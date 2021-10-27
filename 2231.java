
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N,ret;
	public static int solve(int num) {
		int sum = num;
		while(num/10!=0) {
			sum+=(num%10);
			num/=10;
		}
		sum+=(num%10);
		return sum;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int num = 1;
		while(num<=N) {
			int temp = solve(num);
			if(temp==N) {
				ret=num;
				break;
			}
			num++;
		}
		System.out.println(ret);
	}

}
