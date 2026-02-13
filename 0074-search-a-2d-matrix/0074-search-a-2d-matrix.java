// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int i = 0;
//         int j = n-1;
//         while(i < m && j >= 0){
//             if(matrix[i][j] > target){
//                 j--;

//             }else if(matrix[i][j] < target){
//                 i++;


//             }else{
//                 return true;
//             }
//         }
//         return false;

        
//     }
// }

class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int low = 0;
            int high = m*n-1;
            while(low <= high){
                int mid = low + (high - low)/2;
                int row = mid/n;
                int col = mid%n;
                int value = matrix[row][col];

                if(value  == target){
                    return true;

                }else if(value < target){
                    low = mid+1;

                }else{
                    high  = mid -1;

                }
            }
            return false;




        }
}