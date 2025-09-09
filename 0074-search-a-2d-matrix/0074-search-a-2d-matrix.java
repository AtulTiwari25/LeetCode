class Solution {
    public boolean searchMatrix(int[][] arr, int target) {


        int a=-1;
        int l=0;
        int r=arr.length-1;

        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid][0]<=target && arr[mid][arr[0].length-1]>=target){
                a=mid; l=r+1;//khtm kr di condition;
            }
            else if(arr[mid][0]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        if(a==-1){return false;}

        int low=0;
        int high=arr[0].length-1;

        while(low<=high){
            int m=(low+high)/2;

            if(arr[a][m]==target){return true;}
            if(arr[a][m]<target){low=m+1;}
            else{high=m-1;}
        }

        if(arr[a][low]==target){return true;}

        return false;
    }
}