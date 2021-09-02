import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		List<String> list = new ArrayList<>(set);
		
		Collections.sort(list,(str1, str2)->{
			int size1 = str1.length();
			int size2 = str2.length();
			
			if(size1 == size2) {
				return str1.compareTo(str2);
			}
			return Integer.compare(size1, size2);
		});
		
		for(String str:list) {
			sb.append(str+"\n");
		}
		
		System.out.print(sb);
	}
}

