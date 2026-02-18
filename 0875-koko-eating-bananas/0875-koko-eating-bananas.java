// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         int maxPile = 0;
//         for (int pile : piles){
//             maxPile = Math.max(maxPile, pile);

        
//     }
//     int low = 1, high = maxPile;

//             while (low < high) {

//                 int mid = low + (high - low) / 2;

//                 if (canEatAll(piles, h, mid)) {

//                     high = mid;
//                 } else {
//                     low = mid + 1;

//                 }
//             }


//             return low;

//             }

//              private boolean canEatAll(int[] piles, int h, int k) {

//                 int hours = 0;
//                 for (int pile : piles) {

//                      hours += (pile + k - 1) / k;

//                      }

//                      return hours <= h;

                    
//                                                                                             }
//                                                                                                     }
// }
// }
class Solution{
    public int minEatingSpeed(int[] piles, int h){
        int l = 1;
        int high = 0;
        //find high
        for(int pile : piles){
            high = Math.max(high, pile); 
        }
        while(l <= high){
            int mid = l + (high-l)/2;
            long totalHours = 0;
            for(int pile : piles){
                totalHours +=(pile + mid-1)/mid;
            }
            if(totalHours <=  h ){
                high = mid-1;
            }else{
                l = mid+1;

            }
        }
        return l;
    }

}
