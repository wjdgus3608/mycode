import java.util.Stack;
class Solution {
    public String solution(String new_id) {
        return transfer(new_id);
    }
    
    public String transfer(String str){
        StringBuilder sb = new StringBuilder();
        //1,2단계
        for(char c:str.toCharArray()){
            if(Character.isLetter(c))
            sb.append(Character.toLowerCase(c));
            else if(Character.isDigit(c)||c=='-'||c=='_'||c=='.')
                sb.append(c);
        }
        
        //3단계
        str = sb.toString();
        sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c=='.' && !st.isEmpty() && st.peek()!='.'){
                st.add(c);
            }
            else if(c!='.'){
                st.add(c);
            }
        }
        
        //4단계
        int index = 0;
        int size = st.size();
        while(!st.isEmpty()){
            char c = st.pop();
            if(c!='.' || (index!=0 &&index!=size-1))
            sb.append(c);
            index++;
        }
        sb = sb.reverse();
        System.out.println(sb);
        //5단계
        if(sb.length()==0){
            sb.append("a");
        }
        //6단계
        str = sb.toString();
        sb = new StringBuilder();
        if(str.length()>=16){
            for(int i=0; i<14; i++){
                sb.append(str.charAt(i));
            }
            if(str.charAt(14)!='.'){
                sb.append(str.charAt(14));
            }
        }
        else if(str.length()<=2){
            char last=' ';
            for(char c:str.toCharArray()){
                sb.append(c);
                last = c;
            }
            while(sb.length()!=3){
                sb.append(last);
            }
        }
        else{
            sb.append(str);
        }
        return sb.toString();
    }
    
    
}
