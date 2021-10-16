
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
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i]=num;
			set.add(num);
		}
		
		ArrayList<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<list.size(); i++) {
			map.put(list.get(i),i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			sb.append(map.get(arr[i]));
			if(i!=arr.length-1)
				sb.append(" ");
		}
		System.out.print(sb.toString());
		
		br.close();
	}
	
}




