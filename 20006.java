import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int p,m;
	static ArrayList<Room> roomList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		p = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			Player player = new Player(l,name);
			
			int index=-1;
			for(int j=0; j<roomList.size(); j++) {
				Room room = roomList.get(j);
				if(room.state!=1 && room.max>=l && room.min<=l) {
					index=j;
					break;
				}
			}
			if(index!=-1) {
				roomList.get(index).list.add(player);
				if(roomList.get(index).list.size()==m)
					roomList.get(index).state=1;
			}
			else {
				Room room = new Room(l+10,l-10,0,i);
				room.list.add(player);
				if(room.list.size()==m)
					room.state=1;
				roomList.add(room);
			}
		}
		
		for(Room room:roomList) {
			if(room.state==1)
				bw.write("Started!\n");
			else
				bw.write("Waiting!\n");
			Collections.sort(room.list);
			for(Player player:room.list)
				bw.write(player.l+" "+player.name+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
}

class Room{
	int state;
	int max,min;
	ArrayList<Player> list = new ArrayList<>();
	int time;
	
	Room(int max, int min, int state, int time){
		this.max=max;
		this.min=min;
		this.state=state;
		this.time=time;
	}

}

class Player implements Comparable<Player>{
	int l;
	String name;
	Player(int l, String name){
		this.l=l;
		this.name=name;
	}
	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}
	
	
}
