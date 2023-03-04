

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  static int ret=1;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String str = st.nextToken();
    Queue<Character> q = new LinkedList<>();
    for(char c:str.toCharArray())
      q.add(c);

    while(!q.isEmpty()){
      char c = q.peek();
      String key = Integer.toString(ret);

      while(key.contains(Character.toString(c))){
        q.poll();
        int idx=key.indexOf(c);
        if(idx+1<key.length())
          key=key.substring(idx+1);
        else
          key="";
        if(!q.isEmpty())
        c = q.peek();
        else
          break;
      }
      ret++;
    }

    System.out.print(ret-1);
  }

}
