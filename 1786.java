
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static String T,P;
    static ArrayList<Integer> ret = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = br.readLine();
        P = br.readLine();

        int[] pi = getPi(P);

        int j=0;

        for(int i=0; i<T.length(); i++){
            while(j>0 && T.charAt(i) != P.charAt(j))
                j=pi[j-1];
            if(T.charAt(i)==P.charAt(j)){
                if(j==P.length()-1){
                    ret.add(i-P.length()+2);
                    j=pi[j];
                }
                else{
                    j++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();

        sb.append(ret.size()+"\n");
        for(int i=0; i<ret.size(); i++){
            sb.append(ret.get(i));
            if(i!=ret.size()-1)
                sb.append(" ");
        }
        System.out.print(sb);

    }

    public static int[] getPi(String p){
        int[] pi = new int[p.length()];
        int j=0;
        for(int i=1; i<p.length(); i++){
            while(j>0 && p.charAt(i) != p.charAt(j))
                j = pi[j-1];
            if(p.charAt(i)==p.charAt(j))
                pi[i]=++j;
        }

        return pi;
    }
}


