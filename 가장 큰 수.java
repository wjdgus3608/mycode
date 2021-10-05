import java.util.Collections;
import java.util.ArrayList;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<Long> list = new ArrayList<>();
        boolean isZero=true;
        for(long num:numbers){
            list.add(num);
            if(num!=0) isZero=false;
        }
        if(isZero) return "0";
        Collections.sort(list,(a,b)->{
            String num1 = Long.toString(a);
            String num2 = Long.toString(b);
            Character c1 = num1.charAt(0);
            Character c2 = num2.charAt(0);
            if(c1==c2){
                int s1 = num1.length();
                int s2 = num2.length();
                char l1;
                if(s1==s2){
                    return (int)(b-a);
                }
                else if(s1>s2){
                    l1 = num2.charAt(s2-1);
                    for(int i=0; i<s1-s2; i++)
                        num2+=c2;
                    
                }
                else{
                    l1 = num1.charAt(s1-1);
                    for(int i=0; i<s2-s1; i++)
                        num1+=c1;
                }
                if(num2.equals(num1)){
                    if(s1>s2){
                        return l1-c1;
                    }
                    else{
                        return c1-l1;
                    }
                    
                }
                return (int)(Long.parseLong(num2)-Long.parseLong(num1));
            }
           return c2-c1;
        });
        for(long num:list)
            answer+=Long.toString(num);
        
        return answer;
    }
}
