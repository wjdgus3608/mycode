import java.util.HashSet;
class Solution {
    public int[] solution(int[] enter, int[] leave) {
        
        int N = enter.length;
        int[] answer = new int[N];
        int index=0;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<N; i++){
            int key = leave[i];
            while(!set.contains(key)){
                int num=enter[index];
                set.add(num);
                index++;
            }
            answer[key-1] += set.size()-1;
            for(int num:set){
                if(num!=key){
                    answer[num-1]++;
                }
            }
            set.remove(key);
            
        }
        
        return answer;
    }
}
