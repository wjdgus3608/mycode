
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
	static int ret;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(L+(5+L)*i);
		}
		
		int ring=0;
		boolean flag = false;
		while(!flag) {
			if(ring>list.get(list.size()-1)) {
				ret = ring;
				break;
			}
			
			for(int i=0; i<list.size(); i++) {
				int num = list.get(i);
				if(num<=ring && num+5>ring) {
					ret = ring;
					flag=true;
					break;
				}
				
			}
			ring+=D;
		}
		
		System.out.println(ret);
		
		br.close();
	}
	
}




