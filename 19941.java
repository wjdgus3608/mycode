

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  static int N,K;
  static int ret=0;
  static char[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N=Integer.parseInt(st.nextToken());
    K=Integer.parseInt(st.nextToken());

    String str = br.readLine();
    int index=0;
    arr = new char[N];
    for(char c:str.toCharArray()){
      arr[index++]=c;
    }

    boolean[] visit = new boolean[N];
    for(int i=0; i<N; i++){
      char c = arr[i];
      if(c=='H'){
        int left=Math.max(0,(i-K));
        while(left<i && (arr[left]!='P' || visit[left])){
          left++;
        }
        if(left>=0 && arr[left]=='P' && !visit[left]){
          visit[left]=true;
          ret++;
          continue;
        }
        int right=i+1;
        while(right<N && (arr[right]!='P' || visit[right])){
          right++;
        }
        if(right<N && (right-i)<=K &&arr[right]=='P' && !visit[right]){
          visit[right]=true;
          ret++;
        }
      }
    }

    System.out.print(ret);
  }

}
