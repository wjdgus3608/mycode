import java.util.*;
class Solution {
    ArrayList<String> ret = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        
        for(int i=0; i<orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i]=String.valueOf(arr);
        }
        
        for(int i=0; i<course.length; i++){
            int C = course[i];
            HashMap<String,Integer> map = new HashMap<>();
            for(int j=0; j<orders.length; j++){
                String str = orders[j];
                int N = str.length();
                for(int k=0; k<(1<<N); k++){
                    if(Integer.bitCount(k)==C){
                        StringBuilder sb = new StringBuilder();
                        for(int x=0; x<N; x++){
                            if((k&(1<<x))!=0){
                                sb.append(str.charAt(x)+"");
                            }
                        }
                        String key = sb.toString();
                        map.put(key,map.getOrDefault(key,0)+1);
                    }
                }
            }
            
            ArrayList<String> list = new ArrayList<>(map.keySet());
            Collections.sort(list,(a,b)->{
                return -Integer.compare(map.get(a),map.get(b));
            });
            if(list.size()!=0){
                int max = map.get(list.get(0));
                if(max<2) continue;
                ret.add(list.get(0));
                for(int l=1; l<list.size(); l++){
                    if(max>map.get(list.get(l))) break;
                    ret.add(list.get(l));
                }
            }
        }
        
        
        
        Collections.sort(ret);
        
        String[] answer = new String[ret.size()];
        for(int i=0; i<answer.length; i++){
            answer[i]=ret.get(i);
        }
        return answer;
    }
}
