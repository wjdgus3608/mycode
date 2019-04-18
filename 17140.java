import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int r,c,k;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		r=Integer.valueOf(st.nextToken());
		c=Integer.valueOf(st.nextToken());
		k=Integer.valueOf(st.nextToken());
		list=new ArrayList<>();
		for(int i=0; i<3; i++) {
			st=new StringTokenizer(br.readLine()," ");
			ArrayList<Integer> temp=new ArrayList<>();
			for(int j=0; j<3; j++) {
				temp.add(Integer.valueOf(st.nextToken()));
			}
			list.add(temp);
		}
		int time=0;
		while(r-1>=list.size() || c-1>=list.get(r-1).size() || list.get(r-1).get(c-1)!=k) {
			if(list.size()>=list.get(0).size()) {
				int max=Integer.MIN_VALUE;
				for(int i=0; i<list.size(); i++) {
					HashMap<Integer,Integer> map=new HashMap<>();
					for(int j=0; j<list.get(i).size(); j++) {
						if(list.get(i).get(j)==0) continue;
						map.put(list.get(i).get(j),map.getOrDefault(list.get(i).get(j),0)+1);
					}
					ArrayList<Integer> result=new ArrayList<>(map.keySet());
					Collections.sort(result,(a,b)->{
						if(map.get(a)>map.get(b)) return 1;
						else if(map.get(a)<map.get(b)) return -1;
						else {
							return Integer.compare(a, b);
						}
					});
					ArrayList<Integer> index=new ArrayList<>(map.values());
					Collections.sort(index);
					ArrayList<Integer> last=new ArrayList<>();
					for(int temp:result) last.add(temp);
					for(int temp:index) last.add(temp);
					max=Math.max(max, last.size());
					for(int a=0; a<max-last.size(); a++) {
						last.add(0);
					}
					list.set(i, last);
				}
			}
			else {
			}
			time++;
		}
		System.out.println(time);
	}
}
