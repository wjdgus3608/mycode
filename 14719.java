import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int H,W;
	static int[] arr;
	static int ret;
	
	public static boolean checkLeft(int y, int x) {
		int left = x-1;
		while(left>=0) {
			if(arr[left]>y) {
				return true;
			}
			left--;
		}
		return false;
	}
	
	public static boolean checkRight(int y, int x) {
		int right = x+1;
		while(right<W) {
			if(arr[right]>y) return true;
			right++;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		for(int j=0; j<W; j++) {
			int cnt=0;
			for(int i=arr[j]; i<H; i++) {
				if(!checkLeft(i,j) || !checkRight(i,j)) {
					break;
				}
				cnt++;
			}
			if(cnt!=0) {
				ret+=cnt;
			}
		}
		
		bw.write(Integer.toString(ret));
		bw.flush();
		bw.close();
		br.close();
	}
}
