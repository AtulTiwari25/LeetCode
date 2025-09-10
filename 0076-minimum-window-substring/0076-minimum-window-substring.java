class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        
        int freqs[] = new int[256];
        int freqt[] = new int[256];
        int dchars = 0; int start = 0; int end = 0;
        for(int i = 0;i<t.length();i++){
            if(freqt[t.charAt(i)]==0){dchars++;}
            freqt[t.charAt(i)]++;
        }
        int count = 0;
        for(int i = 0;i<s.length();i++){
             freqs[s.charAt(i)]++;
            if(freqs[s.charAt(i)]==freqt[s.charAt(i)]){ count++;}
            if(count==dchars){ end = i; break;}
        }
        if(count<dchars){return "";}
        int anss=start;int anse = end; int minm = end-start+1;

        
        while(end<s.length()){
            while(freqs[s.charAt(start)]>freqt[s.charAt(start)]){
                freqs[s.charAt(start)]--;
                start++;
            }
            int length = end-start+1;
            if(length<minm){
                anss = start; anse = end; minm = length;
            }
            end++; if(end<s.length()){freqs[s.charAt(end)]++;}
        }
        return s.substring(anss,anse+1);
    }
}