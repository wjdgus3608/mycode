
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str="";
		StringBuilder sb = new StringBuilder();
		while(!(str=br.readLine()).equals("0")) {
			int num = Integer.parseInt(str);
			str = Integer.toString(num);
			Stack<Character> temp = new Stack<>();
			for(int i=0; i<Math.ceil(str.length()/2f); i++) {
				temp.add(str.charAt(i));
			}
			boolean isPal = true;
			if(str.length()%2==1) temp.pop();
			for(int i=(int)Math.ceil(str.length()/2f); i<str.length(); i++) {
				if(temp.isEmpty() || str.charAt(i)!=temp.pop()) {
					isPal=false;
					break;
				}
				
			}
			sb.append((isPal?"yes":"no")+"\n");
			
		}
		System.out.print(sb);
	}
	
}



