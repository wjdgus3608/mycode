import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static boolean ret = true;
	static String[] arr = {"a","e","i","o","u"};
	public static boolean checkOne(String str) {
		for(String s:arr) {
			if(str.contains(s)) return true;
		}
		return false;
	}
	
	public static boolean checkTwo(String str) {
		int jaCnt=0;
		int moCnt=0;
		for(char c:str.toCharArray()) {
			String s = Character.toString(c);
			if(checkOne(s)) {
				jaCnt=0;
				moCnt++;
			}
			else {
				moCnt=0;
				jaCnt++;
			}
			if(jaCnt==3 || moCnt==3) return false;
		}
		return true;
	}
	
	public static boolean checkThree(String str) {
		String pre="";
		for(char c:str.toCharArray()) {
			String s = Character.toString(c);
			if(pre.equals(s)) {
				if(!s.equals("e")&&!s.equals("o")) {
					return false;
				}
			}
			pre = s;
		}
		return true;
	}
	
	public static boolean checkAll(String str) {
		if(!checkOne(str)) return false;
		if(!checkTwo(str)) return false;
		if(!checkThree(str)) return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String str ="";
		while(!(str=br.readLine()).equals("end")) {
			ret = checkAll(str);
			
			sb.append("<").append(str).append(">").append(" is ");
			if(!ret)
				sb.append("not ");
			sb.append("acceptable.").append("\n");
			ret =true;
		}
	
		System.out.print(sb);
	
	}
}
