

import java.io.*;
import java.util.*;

class Main {

  static int T;
  static int n;
  static ArrayList[] list;
  static boolean[] visit;
  static boolean[] done;
  static int ret;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());


    T = Integer.parseInt(st.nextToken());
    for(int i=0; i<T; i++){
       n = Integer.parseInt(br.readLine());
       list = new ArrayList[n];
       for(int k=0; k<n; k++)
         list[k]=new ArrayList<Integer>();
       visit = new boolean[n];
       done = new boolean[n];
       st = new StringTokenizer(br.readLine());
       for(int j=0; j<n; j++){
         int end = Integer.parseInt(st.nextToken())-1;
         list[j].add(end);
       }

       for(int j=0; j<n; j++){
         if(done[j]) continue;
          dfs(j);
       }

        bw.write((n-ret)+"\n");
       ret=0;
    }



    br.close();
    bw.flush();
    bw.close();

  }

  public static void dfs(int cur){
      if(done[cur]) return;
      if(visit[cur]) {
          done[cur]=true;
          ret++;
      }
      visit[cur]=true;



    for(int i=0; i<list[cur].size(); i++){
      int next = (int)list[cur].get(i);
      dfs(next);

    }
    visit[cur]=false;
    done[cur]=true;
  }



}

