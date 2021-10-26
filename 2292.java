
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int ret = 1;
		int num = 6;
		int cur = 1;
		while(cur<N) {
			cur+=num;
			num+=6;
			ret++;
		}
		System.out.println(ret);
		
		br.close();
	}
	
}






