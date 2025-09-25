class Solution {
    public int longestConsecutive(int[] arr) {

        Set<Integer> s=new HashSet<>();
        for(int x:arr)s.add(x);
        int max=0;

        for(int n:s){ //hum set m check karenge arr m repeat element p bhi faltu m check hoga

            int a=n;int current=1;
            if(!s.contains(a-1)){

                while(s.contains(a+1)){

                    a=a+1;
                    current+=1;

                }
                max=Math.max(max,current);

                
                
            }
        }
        return max;
        
    }
}