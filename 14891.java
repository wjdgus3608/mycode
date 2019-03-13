package study;

/*
1. �� 8���� ��ϸ� ������ �ִ� ��Ϲ��� 4���� �Ʒ� �׸��� ���� �Ϸķ� ������ �ִ�.
2. ��ϴ� N�� �Ǵ� S�� �� �ϳ��� ��Ÿ���� �ִ�. 
3. ��Ϲ������� ��ȣ�� �Ű��� �ִµ�, ���� ���� ��Ϲ����� 1��, �� �������� 2��, �� �������� 3��, ���� ������ ��Ϲ����� 4���̴�.
4. ��ϰ� �´��� ���� �ٸ��� ȸ����Ų��.
5. �� K�� ȸ����Ų ���Ŀ� �� ��Ϲ����� ������ ���� ����Ѵ�. ������ ������ ���� ����Ѵ�.
1�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 1��
2�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 2��
3�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 4��
4�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 8��
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Deque<Integer>> wheels=new ArrayList<>();
	static Deque<Pair> q=new LinkedList<>();
	public static boolean checkR(int target)//������ ��� üũ
	{
		Iterator it=wheels.get(target-1).iterator();
		Iterator it2=wheels.get(target).iterator();
		for(int i=0; i<2; i++)
			it.next();
		for(int i=0; i<6; i++)
			it2.next();
		int t1=(int)it.next();
		int t2=(int)it2.next();
		//System.out.println("t1= "+t1 +"t2 ="+t2);
		return Integer.compare(t1,t2)==0?true:false;
	}
	public static boolean checkL(int target)//������� üũ
	{
		Iterator it=wheels.get(target-1).iterator();
		Iterator it2=wheels.get(target-2).iterator();
		for(int i=0; i<6; i++)
			it.next();
		for(int i=0; i<2; i++)
			it2.next();
		return Integer.compare((int)it.next(),(int)it2.next())==0?true:false;
	}
	public static void move() {
		while(!q.isEmpty())
		{
			Pair temp=q.removeFirst();
			switch(temp.target)
			{
			case 1:
				for(int i=0; i<3; i++)
				{
					if(checkR(1+i))
					{
						turn(i+1,temp.dir*(int)Math.pow(-1, i));
						break;
					}
					turn(i+1,temp.dir*(int)Math.pow(-1, i));
					if(i==2)
						turn(4,temp.dir*-1);
				}
				
				break;
			case 2:
				if(!checkL(2))
					turn(1,temp.dir*-1);
				for(int i=0; i<2; i++)
				{
					if(checkR(2+i))
					{
						turn(2+i,temp.dir*(int)Math.pow(-1,i));
						break;
					}
					turn(2+i,temp.dir*(int)Math.pow(-1,i));
					if(i==1)
						turn(4,temp.dir);
				}
				break;
			case 3:
				if(!checkR(3))
					turn(4,temp.dir*-1);
				for(int i=0; i<2; i++)
				{
					if(checkL(3-i))
					{
						turn(3-i,temp.dir*(int)Math.pow(-1,i));
						break;
					}
					turn(3-i,temp.dir*(int)Math.pow(-1,i));
					if(i==1)
						turn(1,temp.dir);
				}
				
				break;
			case 4:
				for(int i=0; i<3; i++)
				{
					if(checkL(4-i))
					{
						turn(4-i,temp.dir*(int)Math.pow(-1, i));
						break;
					}
					turn(4-i,temp.dir*(int)Math.pow(-1, i));
					if(i==2)
						turn(1,temp.dir*-1);
				}
				break;
			}
		}
	}
	public static void turn(int target,int dir) {
		switch(dir)
		{
		case -1://�ݽð� ����
			wheels.get(target-1).addLast(wheels.get(target-1).removeFirst());
			break;
		case 1://�ð� ����
			wheels.get(target-1).addFirst(wheels.get(target-1).removeLast());
			break;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0; i<4; i++)
		{
			String str=br.readLine();
			Deque<Integer> temp=new ArrayDeque<>();
			for(int j=0; j<8; j++)
				temp.add(Character.getNumericValue(str.charAt(j)));
			wheels.add(temp);
		}
		st=new StringTokenizer(br.readLine());
		int times=Integer.valueOf(st.nextToken());
		for(int i=0; i<times; i++)
		{
			st=new StringTokenizer(br.readLine()," ");
			int tar=Integer.valueOf(st.nextToken());
			int dir=Integer.valueOf(st.nextToken());
			Pair temp=new Pair(tar,dir);
			q.add(temp);
		}
		move();
		int sum=0;
		for(int i=0; i<4; i++)
		{
			sum+=(wheels.get(i).getFirst()*(Math.pow(2, i)));
		}
		System.out.print(sum);
	}
}

class Pair{
	int target;
	int dir;
	Pair(int target,int dir)
	{
		this.target=target;
		this.dir=dir;
	}
}