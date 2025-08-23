class Solution {
    public boolean isPalindrome(String s) 
    {
        String str=s.toLowerCase();
        String clean = str.replaceAll("[^A-Za-z0-9]", "");  
        System.out.println(clean);

        String reverseString="";
        for(int i=clean.length()-1; i>=0; i--)
        {
            reverseString +=clean.charAt(i);
        }
        if(clean.equals(reverseString))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}