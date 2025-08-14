class Solution {
    public String largestGoodInteger(String num) {
       int m=-1,ind=0;
        for(int i=2;i<num.length();i++){
                if((num.charAt(i)==num.charAt(i-1))&&(num.charAt(i-1)==num.charAt(i-2))){
                    m=Math.max(m,num.charAt(i)-'0');
                
                }
        }
        if(m==-1){
            return "";
        }else{
            String a=Integer.toString(m);
            return a.repeat(3);
        }
    }
}