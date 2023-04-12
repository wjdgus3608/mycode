import java.util.*;

class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    public String[] solution(String[] players, String[] callings) {
        int N = callings.length;
        
        for(int i=0; i<players.length; i++)
            map.put(players[i],i);
        
        for(int i=0; i<N; i++){
            String name = callings[i];
            int index = findIndexByName(name);
            moveByIndex(index,players);
        }
        
        
        String[] answer = Arrays.copyOf(players,players.length);
        
        return answer;
    }
    
    public int findIndexByName(String name){
        return map.get(name);
    }
    
    public void moveByIndex(int index, String[] players){
        String temp = players[index-1];
        players[index-1]=players[index];
        players[index]=temp;
        
        map.put(players[index],index);
        map.put(players[index-1],index-1);
        
    }
}
