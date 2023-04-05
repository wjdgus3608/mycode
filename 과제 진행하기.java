import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        ArrayList<String> ret = new ArrayList<>();
        Stack<Work> st = new Stack<>();
        Work cur = null;
        Arrays.sort(plans,(a,b)->{
            return convertToMin(a[1])-convertToMin(b[1]);
        });
        for(int i=0; i<plans.length; i++){
            Work work = new Work(plans[i][0],convertToMin(plans[i][1]),Integer.parseInt(plans[i][2]));
            if(cur!=null){
                if(cur.start+cur.time>work.start){
                    cur.time=cur.start+cur.time-work.start;
                    st.add(cur);
                }
                else{
                    ret.add(cur.name);
                    int remainTime = work.start-(cur.start+cur.time);
                    
                    while(!st.isEmpty() && remainTime-st.peek().time>=0){
                        remainTime-=st.peek().time;
                        ret.add(st.pop().name);       
                    }
                    if(!st.isEmpty()){
                        st.peek().time-=remainTime;
                    }
                }
                    
            }
            cur=work;
        }
        
        ret.add(cur.name);
        while(!st.isEmpty()){
            ret.add(st.pop().name);
        }
        
        answer = new String[ret.size()];
        for(int i=0; i<ret.size(); i++)
            answer[i]=ret.get(i);
        
        return answer;
    }
    
    public int convertToMin(String str){
        String[] parsed = str.split(":");
        int minute=Integer.parseInt(parsed[0])*60+Integer.parseInt(parsed[1]);
        
        return minute;
    }
}

class Work{
    String name;
    int start, time;
    Work(String name, int start, int time){
        this.name=name;
        this.start=start;
        this.time=time;
    }
}
