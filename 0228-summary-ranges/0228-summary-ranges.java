class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        
        while (i < n) {
            int start = nums[i];
            // Extend the range while the next element is consecutive
            while (i < n - 1 && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            // Determine if it's a single number or a range
            if (start == nums[i]) {
                ans.add(String.valueOf(start));
            } else {
                ans.add(start + "->" + nums[i]);
            }
            i++;
        }
        return ans;
    }
}
