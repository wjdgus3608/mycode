
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
	static int N,m,M,T,R,ret;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		int X=m;
		if(m+T>M) {
			System.out.println(-1);
			return;
		}
		while(N>0) {
			if(X+T<=M) {
				X+=T;
				N--;
			}
			else {
				X-=R;
				if(X<m) X=m;
			}
			ret++;
		}
		
		System.out.println(ret);
		br.close();
	}
	
}




