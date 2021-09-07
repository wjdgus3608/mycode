import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		String number = st.nextToken();
		
		int[] arr = new int[number.length()];
		for(int i=0; i<number.length(); i++) {
			arr[i] = Character.getNumericValue(number.charAt(i));
			String str="";
			if(i==0) {
				str =Integer.toBinaryString(arr[i]);
			}
			else
				str = String.format("%3s", Integer.toBinaryString(arr[i])).replace(" ", "0");
			sb.append(str);
		}
		
		System.out.print(sb);		
		
	}

}

