
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,T,K,ret;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static HashSet<Integer> set = new HashSet<>();
    public static void solve(ArrayList<Integer> temp){
        for(int i=0; i<temp.size(); i++){
            int num = temp.get(i);
            if(set.contains(num)) continue;
            set.add(num);
            solve(list.get(num));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            int num = Integer.parseInt(st.nextToken())-1;
            set.add(num);
        }

        int[][] ps = new int[M][];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            int[] pp = new int[K];
            for(int j=0; j<K; j++){
                int p = Integer.parseInt(st.nextToken())-1;
                pp[j]=p;
            }
            ps[i]=pp;
        }

        //연결

        for(int i=0; i<N; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<M; i++){
            int[] arr = ps[i];
            for(int j=0; j<arr.length-1; j++){
                for(int k=j+1; k<arr.length; k++){
                    int p1 = arr[j];
                    int p2 = arr[k];
                    list.get(p1).add(p2);
                    list.get(p2).add(p1);
                }
            }
        }
        //진실자 연결
        ArrayList<Integer> truth = new ArrayList<>(set);
        for(int key:truth){
            ArrayList<Integer> temp = list.get(key);
            solve(temp);
        }
        //검사
        for(int i=0; i<M; i++){
            int[] arr = ps[i];
            boolean flag = true;
            for(int j=0; j<arr.length; j++){
                if(set.contains(arr[j])){
                    flag = false;
                    break;
                }
            }
            if(flag) ret++;
        }

        System.out.println(ret);

    }
}
