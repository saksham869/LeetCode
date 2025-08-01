class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequency
        for (int num : arr1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: Add elements from arr2
        for (int num : arr2) {
            int count = freq.get(num);
            for (int i = 0; i < count; i++) {
                result.add(num);
            }
            freq.remove(num);
        }

        // Step 3: Add remaining elements
        List<Integer> remaining = new ArrayList<>();
        for (int key : freq.keySet()) {
            int count = freq.get(key);
            for (int i = 0; i < count; i++) {
                remaining.add(key);
            }
        }

        Collections.sort(remaining);
        result.addAll(remaining);

        // Convert to array
        int[] finalResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }

        return finalResult;
    }
}
