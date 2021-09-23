
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

	
	static int N,M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashMap<String,Integer> strmap = new HashMap<>();
		HashMap<Integer,String> intmap = new HashMap<>();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			strmap.put(str,i+1);
			intmap.put(i+1,str);
		}
		
		for(int i=0; i<M; i++) {
			String key = br.readLine();
			if(Character.isDigit(key.charAt(0))) {
				int num = Integer.parseInt(key);
				sb.append(intmap.get(num)+"\n");
			}
			else {
				sb.append(strmap.get(key)+"\n");
			}
		}
		
		System.out.print(sb.toString());
		
	}
	
}



