
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		Person[] arr = new Person[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			arr[i]=new Person(num1,num2);
		}
		
		int[] ret = new int[N];
		for(int i=0; i<N; i++) {
			int cnt = 0;
			Person p1 = arr[i];
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				Person p2 = arr[j];
				if(p1.num1<p2.num1 && p1.num2 <p2.num2) cnt++;
			}
			ret[i]=cnt+1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(ret[i]);
			if(i!=N-1) sb.append(" ");
		}
		System.out.print(sb.toString());
	}

}

class Person{
	int num1, num2;
	Person(int num1, int num2){
		this.num1=num1;
		this.num2=num2;
	}
}
