

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  static int N;
  static String[] arr;
  static int ret;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    arr = new String[N];
    for(int i=0; i<N; i++){
      arr[i]=br.readLine();
    }

    HashMap<Character,Integer> map = new HashMap<>();
    for(char c:arr[0].toCharArray())
      map.put(c,map.getOrDefault(c,0)+1);


    for(int i=1; i<N; i++){
      String str = arr[i];
      HashMap<Character,Integer> temp = new HashMap<>();
      for(char c:str.toCharArray())
        temp.put(c,temp.getOrDefault(c,0)+1);

      for(char key: map.keySet()){
        if(temp.containsKey(key)){
          temp.put(key,temp.get(key)-map.get(key));
          if(temp.get(key)==0)
            temp.remove(key);
        }
        else
          temp.put(key,-map.get(key));
      }

      if(temp.size()==0) ret++;
      else{
        if(temp.size()>2) continue;
          boolean isPlus = false;
          boolean isMinus = false;
          boolean bigValue = false;
          for (char key : temp.keySet()) {
            if (Math.abs(temp.get(key)) > 1) {
              bigValue = true;
              break;
            }
            if(temp.get(key)>0) isPlus=true;
            else isMinus=true;
          }
          if(temp.size()==2 && isPlus && isMinus && !bigValue) ret++;
          else if(temp.size()==1 && !bigValue) ret++;

      }

    }


    System.out.println(ret);
  }

}
