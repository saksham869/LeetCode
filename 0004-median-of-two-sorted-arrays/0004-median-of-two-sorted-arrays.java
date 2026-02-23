class Solution {

        public double findMedianSortedArrays(int[] arr1, int[] arr2) {

                        if (arr1.length > arr2.length) {
                                    return findMedianSortedArrays(arr2, arr1);
                                            }

                                                    int n1 = arr1.length;
                                                            int n2 = arr2.length;

                                                                    int l = 0;
                                                                            int h = n1;

                                                                                    while (l <= h) {

                                                                                                int m1 = (l + h) / 2;
                                                                                                            int m2 = (n1 + n2 + 1) / 2 - m1;

                                                                                                                        int left1  = (m1 == 0) ? Integer.MIN_VALUE : arr1[m1 - 1];
                                                                                                                                    int right1 = (m1 == n1) ? Integer.MAX_VALUE : arr1[m1];

                                                                                                                                                int left2  = (m2 == 0) ? Integer.MIN_VALUE : arr2[m2 - 1];
                                                                                                                                                            int right2 = (m2 == n2) ? Integer.MAX_VALUE : arr2[m2];

                                                                                                                                                                                    if (left1 <= right2 && left2 <= right1) {

                                                                                                                                                                                                    if ((n1 + n2) % 2 == 0) {
                                                                                                                                                                                                                        return (Math.max(left1, left2) +
                                                                                                                                                                                                                                                    Math.min(right1, right2)) / 2.0;
                                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                                                        return Math.max(left1, left2);
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                                            else if (left1 > right2) {
                                                                                                                                                                                                                                                                                                                                                            h = m1 - 1;
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                else {
                                                                                                                                                                                                                                                                                                                                                                                                                l = m1 + 1;
                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                                                                                                                                            return 0.0; // never reached
                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                }
