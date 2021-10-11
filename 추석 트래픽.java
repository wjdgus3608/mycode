class Solution {
    public double getTime(String str){
        String[] temp = str.split(":");
        double sum = 0;
        sum+=Double.parseDouble(temp[0])*3600;
        sum+=Double.parseDouble(temp[1])*60;
        sum+=Double.parseDouble(temp[2]);
        
        return sum;
    }
  public int solution(String[] lines) {
      int answer = 1;
      for(int i=0; i<lines.length-1; i++){
          String[] str = lines[i].split(" ");
          double time = getTime(str[1]);
          int cnt = 1;
          for(int j=i+1; j<lines.length; j++){
              String[] str2 = lines[j].split(" ");
              double time2 = getTime(str2[1]);
              double s = Double.parseDouble(str2[2].substring(0,str2[2].length()-1));
              if(time+0.999f>=(time2-s+0.001f)){
                cnt++;
              } 
          }
          answer = Math.max(cnt, answer);
      }
      return answer;
  }
}
