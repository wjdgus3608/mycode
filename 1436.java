import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		int num=0, cnt=0;
		while(true) {
			
			if(check(num)) {
				cnt++;
				if(cnt==N) {
					System.out.println(num);
					break;
				}
			}
			num++;
		}
	}
	
	public static boolean check(int num) {
		String str = Integer.toString(num);
		return str.contains("666");
	}
}
