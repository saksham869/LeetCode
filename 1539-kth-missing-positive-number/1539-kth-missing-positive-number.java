class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        int l = 0;
        int h =n-1;
        int mid = -1;
        while(l <= h){
            mid = l + (h-l)/2;
            int missing_tillTheEnd = arr[mid] - (mid+1);
            if(missing_tillTheEnd < k){
                l = mid + 1;

            }else{
                h = mid-1;
            }
        }
        return l+k; 
        
    }
}