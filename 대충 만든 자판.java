import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<String,Integer> map = new HashMap<>();
        int[] answer = new int[targets.length];
       
        for(int i=0; i<keymap.length; i++){
            String str = keymap[i];
            for(int j=0; j<str.length(); j++){
                String key = Character.toString(str.charAt(j));
                if(map.containsKey(key)){
                    map.put(key,Math.min(map.get(key),j+1));
                }
                else
                    map.put(key,j+1);
            }
        }
       
        for(int i=0; i<targets.length; i++){
            String str = targets[i];
            int cnt=0;
            for(int j=0; j<str.length(); j++){
                String key = Character.toString(str.charAt(j));
                if(!map.containsKey(key)){
                    cnt=-1;
                    break;
                }
                cnt+=map.get(key);
            }
            answer[i]=cnt;
        }
       
        return answer;
    }
}
