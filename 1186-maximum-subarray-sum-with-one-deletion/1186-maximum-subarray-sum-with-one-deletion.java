class Solution {
    public int maximumSum(int[] arr) {
        int dp0 = arr[0];
        int dp1 = 0;
        int result = arr[0];

        for(int i = 1; i<arr.length; i++){
            dp1 = Math.max(dp0 , dp1 + arr[i]);
            dp0 = Math.max(arr[i], dp0+arr[i]);

            result = Math.max(result,Math.max(dp0 , dp1));
        }
        return result;

        
    }
}