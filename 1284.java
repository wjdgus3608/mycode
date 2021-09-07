
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = "";
		StringBuilder sb = new StringBuilder();
		while(!(in = br.readLine()).equals("0")) {
			int sum = 0;
			for(int i=0; i<in.length(); i++) {
				char c = in.charAt(i);
				if(c=='1') {
					sum+=2;
				}
				else if(c=='0') {
					sum+=4;
				}
				else sum+=3;
			}
			sb.append(sum+1+in.length()+"\n");
		}
		System.out.print(sb);
	}

}

