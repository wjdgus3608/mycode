import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N;
	static int[] arr;
	static HashSet<Integer> set = new HashSet<>();
	static int ret;
	
	public static int check(int a) {
		int pre=0;
		int b=0;
		for(int i=0; i<N-1; i++) {
			b = arr[i+1]-arr[i]*a;
			if(i!=0 && pre!=b) return 999;
			pre = b;
		}
		return b;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		if(N==1) {
			System.out.println("A");
			return;
		}
		
		int a=0;
		int b=0;
		while(a<201) {
			b = check(a);
			if(b!=999) {
				set.add(arr[arr.length-1]*a+b);
			}
			b=check(-a);
			if(b!=999) {
				set.add(arr[arr.length-1]*-a+b);
			}
			a++;
		}
		for(int num:set)
			ret=num;
		System.out.println((set.size()==0)?"B":(set.size()>1)?"A":ret);
	}
}
