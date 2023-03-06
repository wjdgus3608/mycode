import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N,M;
	static ArrayList<Naming> list = new ArrayList<>();
	static ArrayList<Person> nums = new ArrayList<>();
	static TreeMap<Integer,String> retMap = new TreeMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			String name = st.nextToken();
			long num = Long.parseLong(st.nextToken());
			
			list.add(new Naming(name,num));
		}
		
		for(int i=0; i<M; i++) {
			long num = Long.parseLong(br.readLine());
			
			nums.add(new Person(i,num));
		}
		Collections.sort(nums,(a,b)->{
			return Long.compare(a.num, b.num);
		});
		
		int index=0;
		for(Naming cur:list) {
			while(cur.num>=nums.get(index).num) {
				retMap.put(nums.get(index).idx, cur.name);
				index++;
				if(index>=nums.size()) break;
			}
			if(index>=nums.size()) break;
		}
		
		for(int key:retMap.keySet())
			sb.append(retMap.get(key)).append("\n");
		
		System.out.print(sb);
	}
}

class Naming{
	String name;
	long num;
	Naming(String name, long num){
		this.name=name;
		this.num=num;
	}
}

class Person{
	int idx;
	long num;
	Person(int idx, long num){
		this.idx=idx;
		this.num=num;
	}
}
