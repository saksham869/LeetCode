class Solution {

        public int singleNonDuplicate(int[] nums) {

                int l = 0;
                        int h = nums.length - 1;

                                while (l < h) {

                                            int mid = l + (h - l) / 2;

                                                        boolean isRightEven = (h - mid) % 2 == 0;

                                                                    if (nums[mid] == nums[mid + 1]) {

                                                                                    if (isRightEven) {
                                                                                                        l = mid + 2;
                                                                                                                        } else {
                                                                                                                                            h = mid - 1;
                                                                                                                                                            }

                                                                                                                                                                        } else {

                                                                                                                                                                                        if (isRightEven) {
                                                                                                                                                                                                            h = mid;
                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                l = mid + 1;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                            return nums[l];
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                }
