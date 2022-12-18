import java.util.*;
class Solution {
    final String END_TIME = "23:59";
    public int[] solution(int[] fees, String[] records) {
        
        TreeMap<String, Integer> retMap = new TreeMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<records.length; i++){
            String[] parsed = records[i].split(" ");
            int time = strToLong(parsed[0]);
            String carNum = parsed[1];
            String type = parsed[2];
            
            if(type.equals("IN")){
                map.put(carNum,time);
            }
            else{
                int startTime = map.get(carNum);
                map.remove(carNum);
                retMap.put(carNum,
                           retMap.getOrDefault(carNum,0)
                           +(time-startTime));
            }
        }
        
        for(String key: map.keySet()){
            int value = strToLong(END_TIME)-map.get(key);
            retMap.put(key,retMap.getOrDefault(key,0)+value);
        }
                           
        for(String key: retMap.keySet()){
            int time = retMap.get(key);
            int fee = calculateFee(time,fees);
            retMap.put(key,fee);
        }
        
        int[] answer = new int[retMap.size()];
        int index=0;
        for(String key: retMap.keySet()){
            int num = (int)retMap.get(key);
            answer[index++]=num;
        }
        
        return answer;
    }
    
    public int calculateFee(int time, int[] fees){
        int diff = time;
        int sum = 0;
        
        if(diff<=fees[0]){
            return fees[1];
        }
        else{
            sum+=fees[1];
            diff-=fees[0];
            sum+=(Math.ceil((float)diff/fees[2])*fees[3]);
        }
        return sum;
        
    }
    public int strToLong(String str){
        String[] parsed = str.split(":");
        return Integer.parseInt(parsed[0])*60
            +Integer.parseInt(parsed[1]);
    }

}
