class Solution {

        public long minimumTime(int[] time, int totalTrips) {
                long left = 1;

                        // Find minimum time manually (instead of using stream)
                                int minTime = Integer.MAX_VALUE;
                                        for (int t : time) {
                                                    if (t < minTime) {
                                                                    minTime = t;
                                                                                }
                                                                                        }

                                                                                                long right = (long) minTime * totalTrips;

                                                                                                        while (left < right) {
                                                                                                                    long mid = left + (right - left) / 2;

                                                                                                                                if (possible(time, mid, totalTrips)) {
                                                                                                                                                right = mid;       // try smaller time
                                                                                                                                                            } else {
                                                                                                                                                                            left = mid + 1;    // need more time
                                                                                                                                                                                        }
                                                                                                                                                                                                }

                                                                                                                                                                                                        return left;
                                                                                                                                                                                                            }

                                                                                                                                                                                                                private boolean possible(int[] time, long givenTime, int totalTrips) {
                                                                                                                                                                                                                        long trips = 0;

                                                                                                                                                                                                                                for (int t : time) {
                                                                                                                                                                                                                                            trips += givenTime / t;

                                                                                                                                                                                                                                                        // Early stopping to avoid overflow and extra work
                                                                                                                                                                                                                                                                    if (trips >= totalTrips) {
                                                                                                                                                                                                                                                                                    return true;
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                return false;
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                    }
