class Solution {
    public int maximalRectangle(char[][] matrix) {
        long area=0;
        int[] arr=new int[matrix[0].length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j]=='1') arr[j]+=1;
                else arr[j]=0;
                while(!st.empty() && arr[st.peek()]>arr[j]) {
                    int temp=st.pop();
                    int pse=(st.empty()) ? -1:st.peek();
                    area=Math.max(area,(long)(arr[temp]*(j-pse-1)));
                }
                st.push(j);
            }
            while(!st.empty()) {
                int temp=st.pop();
                int pse=(st.empty()) ? -1:st.peek();
                area=Math.max(area,(long)(arr[temp]*(matrix[0].length-pse-1)));
            }
        }
        return (int)area;
    }
}