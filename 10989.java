import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[10001];
		
		for(int i=0; i<N; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<10001; i++)
			for(int j=0; j<arr[i]; j++)
			bw.write(i+"\n");
		bw.flush();
		bw.close();
		br.close();
		
	}

}

