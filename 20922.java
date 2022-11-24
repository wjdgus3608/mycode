

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {
  static int N,K,ret;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++){
      arr[i]=Integer.parseInt(st.nextToken());
    }

    HashMap<Integer,Integer> map = new HashMap<>();
    int r = 1;
    int left=0;
    int right=0;

    while(right<N && left<N){
      map.put(arr[right],map.getOrDefault(arr[right],0)+1);
      while(map.get(arr[right])>K){
        map.put(arr[left],map.getOrDefault(arr[left],0)-1);
        left++;
        r--;
      }
      ret=Math.max(ret,r);
      r++;
      right++;

    }

    System.out.println(ret);

  }

}


