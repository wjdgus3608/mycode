import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	
	static StringBuilder ret = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
		
//		T = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		char[] arr = new char[str.length()];
		int[] cnt = new int[2];
		int idx=0;
		for(char c:str.toCharArray()) {
			arr[idx++]=c;
			if(c=='0') cnt[0]++;
			else cnt[1]++;
		}
		
		cnt[0]/=2;
		cnt[1]/=2;
		
		for(int i=0; i<arr.length; i++) {
			if(cnt[1]==0) break;
			char c = arr[i];
			if(cnt[1]>0 && c=='1') {
				arr[i]='x';
				cnt[1]--;
			}
		}
		
		for(int i=arr.length-1; i>=0; i--) {
			if(cnt[0]==0) break;
			char c = arr[i];
			if(cnt[0]>0 && c=='0') {
				arr[i]='x';
				cnt[0]--;
			}
		}
		
		for(char c:arr) {
			if(c!='x')
				ret.append(c);
		}
		
		
		System.out.print(ret);
	}
}

