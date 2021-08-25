
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
    static int T,K;
    static String W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            W = br.readLine();
            K = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int max = 0;

            HashMap<Character,Integer> map2 = new HashMap<>();
            for(int x=0; x<W.length(); x++){
                char ch = W.charAt(x);
                map2.put(ch,map2.getOrDefault(ch,0)+1);
            }

            for(int j=0; j<W.length(); j++){
                char c = W.charAt(j);
                if(map2.get(c)<K) continue;
                int cnt = 0;
                for(int k=j; k<W.length(); k++){
                    if(W.charAt(k) == c){
                        cnt++;
                        if(cnt==K){
                            min = Math.min(min,k-j+1);
                            max = Math.max(max,k-j+1);
                            break;
                        }
                    }
                }
            }

            if(min!=Integer.MAX_VALUE)
            sb.append(min+" "+max+"\n");
            else
                sb.append(-1+"\n");
        }
        System.out.print(sb);

    }

}


