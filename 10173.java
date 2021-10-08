
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
	static int n,ret;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		
		Pattern p = Pattern.compile("nemo");
		StringBuilder sb= new StringBuilder();
		while(!(str = br.readLine()).equals("EOI")) {
			str = str.toLowerCase();
			Matcher m = p.matcher(str);
			if(m.find()) {
				sb.append("Found\n");
			}
			else sb.append("Missing\n");
		}
		System.out.print(sb.toString());
	}
	
}




