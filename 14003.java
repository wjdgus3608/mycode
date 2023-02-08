package com.jung.icon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Test {

	static int N;
	static int[] A;
	static int[] indexArr;
	static int ret;
	static int[] retArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		indexArr=new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		int index=0;
		int[] dp = new int[N];
		dp[index++]=A[0];
		for(int i=1; i<N; i++) {
			if(dp[index-1]<A[i]) {
				dp[index]=A[i];
				indexArr[i]=index++;
			}
			else {
				int at = binSearch(dp,A[i],0,index-1);
				dp[at]=A[i];
				indexArr[i]=at;
			}
		}
		
		ret = index;
		System.out.println(ret);
		retArr = new int[ret];
		
		int count = ret-1;
		for(int i=N-1; i>=0; i--) {
			if(count==indexArr[i]) {
				retArr[count--]=A[i];
				if(count==-1) break;
			}
		}
		
		for(int num:retArr) {
			System.out.print(num+" ");
		}
		
	}
	

	public static int binSearch(int[] dp, int target, int left, int right) {
		int l = left;
		int r = right;
		int mid = (l+r)/2;
		int result = mid;
		
		while(l<=r) {
			mid = (l+r)/2;
			
			if(dp[mid]<target) {
				l = mid +1;
			}
			else {
				r = mid -1;
				result = mid;
			}
		}
		
		return result;
	}
}
