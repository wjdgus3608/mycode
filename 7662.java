import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T,Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        StringBuilder sb =new StringBuilder();
        for(int i=0; i<T; i++){
            Q = Integer.parseInt(br.readLine());
            TreeMap<Integer,Integer> map = new TreeMap<>();
            for(int j=0; j<Q; j++){
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(str.equals("I")){
                    map.put(num,map.getOrDefault(num,0)+1);
                }
                else if(map.size()!=0 && str.equals("D")){
                    if(num==1){
                        map.put(map.lastKey(),map.get(map.lastKey())-1);
                        if(map.get(map.lastKey())==0){
                            map.remove(map.lastKey());
                        }
                    }
                    else{
                        map.put(map.firstKey(),map.get(map.firstKey())-1);
                        if(map.get(map.firstKey())==0){
                            map.remove(map.firstKey());
                        }
                    }
                }
            }
            if(map.size()==0){
                sb.append("EMPTY\n");
            }
            else{
                sb.append(map.lastKey()+" "+map.firstKey()+"\n");
            }
        }
        System.out.print(sb);

    }
}
