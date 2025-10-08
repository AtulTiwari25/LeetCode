class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> f=new ArrayList<>();
        List<List<String>> result=new ArrayList<>();
        List<String> list=new ArrayList<>();
        comb(s,0,list,result);
        for(List<String> combi:result)
        {
            if(combi.size()==4)
            {
                int c=0;
                StringBuilder sb=new StringBuilder();
                for(String i:combi)
                {
                    if(Integer.parseInt(i)>=0 && Integer.parseInt(i)<=255 && !(i.length()>1 && i.charAt(0)=='0'))
                    {
                        c++;
                        sb.append(i).append(".");
                    }
                }
                if(c==4)
                {
                    String v=sb.toString();
                    f.add(v.substring(0,v.length()-1));
                }
            }
        }
        return f;
    }
    public static void comb(String s,int index,List<String> list,List<List<String>> result)
    {
        if(index==s.length())
        {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=1;i<=3 && index+i<=s.length();i++)
        {
            String p=s.substring(index,index+i);
            list.add(p);
            comb(s,index+i,list,result);
            list.remove(list.size()-1);
        }
    }
}