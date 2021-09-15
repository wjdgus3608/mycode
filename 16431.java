
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	static int by,bx,dy,dx,jy,jx;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		by = Integer.parseInt(st.nextToken());
		bx = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		dy = Integer.parseInt(st.nextToken());
		dx = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		jy = Integer.parseInt(st.nextToken());
		jx = Integer.parseInt(st.nextToken());
		
		int val1 = Math.max(Math.abs(by-jy), Math.abs(bx-jx));
		int val2 = Math.abs(dy-jy)+Math.abs(dx-jx);
		
		if(val1>val2) {
			System.out.println("daisy");
		}
		else if(val1<val2) {
			System.out.println("bessie");
		}
		else {
			System.out.println("tie");
		}
		
	}
	
}



