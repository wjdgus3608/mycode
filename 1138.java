import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i]=num;
		}
		
		int[] ret = new int[N];
		int[] cnt = new int[N];
		for(int i=0; i<N; i++)
			cnt[i]=i;
		Arrays.fill(ret, -1);
		for(int i=0; i<N; i++) {
			int index = arr[i];
			for(int j=0; j<N; j++) {
				if(cnt[j]==index && ret[j]==-1) {
					ret[j]=i+1;
					cnt[j]=-1;
					for(int k=j+1; k<N; k++)
						cnt[k]--;
					break;
				}
			}
		}
		
		
		for(int i=0; i<N; i++) {
			bw.write(Integer.toString(ret[i]));
			if(i!=N-1)
				bw.write(" ");
		}
		
		
		bw.flush();
		br.close();
		bw.close();
	}
}
