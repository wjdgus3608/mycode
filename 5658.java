import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int N,K;
	static int side;
	static ArrayList<Character> first=new ArrayList<>();
	static HashSet<String> set=new HashSet<>();
	static ArrayList<String> second=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb;
		T=Integer.valueOf(st.nextToken());
		for(int k=0; k<T; k++) {
			st=new StringTokenizer(br.readLine()," ");
			N=Integer.valueOf(st.nextToken());
			K=Integer.valueOf(st.nextToken());
			side=N/4;
			String temp=br.readLine();
			for(int i=0; i<temp.length(); i++) {
				first.add(temp.charAt(i));
			}
			int index=0;
			for(int i=0; i<side; i++) {
				for(int a=0; a<N; a+=side) {
				sb=new StringBuilder();
				for(int j=0; j<side; j++) {
					sb.append(first.get(index));
					index++;
					index%=N;
				}
				set.add(sb.toString());
				}
				index++;
				index%=N;
			}
			Iterator it=set.iterator();
			while(it.hasNext()) {
				second.add((String)it.next());
			}
			Collections.sort(second,(s1,s2)->{
				long v1=Long.parseLong(s1,16);
				long v2=Long.parseLong(s2,16);
				return -Long.compare(v1, v2);
			});
			System.out.print("#"+(k+1)+" ");
			System.out.println(Long.parseLong(second.get(K-1),16));
			first.clear();
			second.clear();
			set.clear();
		}
	}
}
