import java.util.*;
class Solution {
    ArrayList<char[]> list = new ArrayList<>();
    boolean[] visit = new boolean[3];
    char[] oper = {'+','-','*'};
    public void makePerm(int cnt, char[] arr){
        if(cnt==3){
            char[] temp = new char[3];
            temp = arr.clone();
            list.add(temp);
            return;
        }
        for(int i=0; i<3; i++){
            if(visit[i]) continue;
            visit[i]=true;
            arr[cnt]=oper[i];
            makePerm(cnt+1,arr);
            visit[i]=false;
        }
    }
    public long solution(String expression) {
        long answer = 0;
        //순열 구하기
        makePerm(0,new char[3]);
        //숫자, 연산자 분리
        ArrayList<Long> nums = new ArrayList<>();
        ArrayList<Character> operss = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for(char c:expression.toCharArray()){
            if(!Character.isDigit(c)){
                nums.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
                operss.add(c);
            }
            else sb.append(c);
        }
        nums.add(Long.parseLong(sb.toString()));

        //순열에 따라서 찾아서 계산후 넣기
        
        for(char[] temp:list){
            ArrayList<Long> tempNum = (ArrayList<Long>)nums.clone();
            ArrayList<Character> opers = (ArrayList<Character>) operss.clone();
            for(char c: temp){
                for(int i=0; i<opers.size(); i++){
                    char oper = opers.get(i);
                    if(c!=oper) continue;
                    if(oper=='+'){
                        tempNum.set(i,tempNum.get(i)+tempNum.get(i+1));
                    }
                    else if(oper=='-'){
                        tempNum.set(i,tempNum.get(i)-tempNum.get(i+1));
                    }
                    else{
                        tempNum.set(i,tempNum.get(i)*tempNum.get(i+1));
                    }
                    tempNum.remove(i+1);
                    opers.remove(i);
                    i--;
                }
            }
            answer = Math.max(answer,Math.abs(tempNum.get(0)));
            tempNum.clear();
        }
        //결과출력
        return answer;
    }
    
}
