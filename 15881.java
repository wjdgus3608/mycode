
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		
		Pattern pattern = Pattern.compile("pPAp");
		Matcher m = pattern.matcher(str);
		
		while(m.find()) {
			ret++;
		}
		
		System.out.println(ret);
		
	}
	
}




