import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String in = "";
        while((in = br.readLine()) != null){
            N = Integer.parseInt(in);

            HashSet<Integer> ret = new HashSet<>();
            for(int i=0; i<N; i++){
                String str = br.readLine();
                HashSet<Integer> set = new HashSet<>();
                for(int j=0; j<str.length(); j++){
                    char c = str.charAt(j);
                    set.add(Character.getNumericValue(c));
                }
                int sum = 0;
                for(int num:set){
                    sum += (1<<num);
                }
                ret.add(sum);
            }

            sb.append(ret.size()+"\n");
        }
        System.out.print(sb);
    }
}


