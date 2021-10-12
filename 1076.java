
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
	static long ret;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<>();
		list.add("black");
		list.add("brown");
		list.add("red");
		list.add("orange");
		list.add("yellow");
		list.add("green");
		list.add("blue");
		list.add("violet");
		list.add("grey");
		list.add("white");
		
		for(int i=0; i<3; i++) {
			String str = br.readLine();
			if(i==2) 
				ret*=Math.pow(10,list.indexOf(str));
			else
			ret+=list.indexOf(str)*(Math.pow(10, 1-i));
		}
		
		System.out.println(ret);
		
		br.close();
	}
	
}




