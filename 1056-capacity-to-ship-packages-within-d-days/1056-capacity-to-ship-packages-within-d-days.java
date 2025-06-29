class Solution {
    public int shipWithinDays(int[] weights, int days) {
       
        int low = getMax(weights);     
        int high = getSum(weights);  

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
             
                high = mid;
            } else {
             
                low = mid + 1;
            }
        }

      
        return low;
    }

    
    private boolean canShip(int[] weights, int days, int capacity) {
        int currentLoad = 0;
        int dayCount = 1;

        for (int weight : weights) {
            if (currentLoad + weight <= capacity) {
                currentLoad += weight;
            } else {
                dayCount++;
                currentLoad = weight;

                if (dayCount > days) return false;
            }
        }

        return true;
    }

    private int getMax(int[] weights) {
        int max = weights[0];
        for (int w : weights) {
            max = Math.max(max, w);
        }
        return max;
    }
    private int getSum(int[] weights) {
        int sum = 0;
        for (int w : weights) {
            sum += w;
        }
        return sum;
    }
}
