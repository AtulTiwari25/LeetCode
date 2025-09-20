class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x=0;
        for(int i=nums1.length-1;i>=1;i--)
        {
            if(nums1[i]==0 && nums1[i-1]!=0)
            {
                x=i;
                break;
            }
            
        }
        for(int i=0;i<nums2.length;i++)
        {
            nums1[x++]=nums2[i];
        }
        Arrays.sort(nums1);
    }
}