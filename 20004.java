
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	static int A;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());

		ArrayList<Integer> ret = new ArrayList<>();
		for(int i=1; i<=A; i++) {
			if(30%(i+1)==0) ret.add(i);
		}
		
		Collections.sort(ret);
		StringBuilder sb = new StringBuilder();
		for(int num:ret)
			sb.append(num+"\n");
		System.out.print(sb.toString());
	}
	
}




