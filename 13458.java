import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long answer=0;
		int place_cnt=Integer.parseInt(br.readLine());
		int[] number=new int[place_cnt];
			String[] str=br.readLine().split(" ");
		for(int i=0; i<str.length; i++)
			number[i]=Integer.parseInt(str[i]);
		String[] str2=br.readLine().split(" ");
		int second=Integer.parseInt(str2[1]);
		answer+=place_cnt;
		for(int i=0; i<str.length; i++)
		{
			number[i]-=Integer.parseInt(str2[0]);
			if(number[i]<=0)
				continue;
			if(number[i]%second==0)
				answer+=number[i]/second;
			else
			answer+=number[i]/second+1;
		}
		System.out.print(answer);
		br.close();
	}
}
