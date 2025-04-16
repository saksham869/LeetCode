class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;

        int[] count = new int[2]; // count[0] for type 0, count[1] for type 1

        for (int student : students) {
            count[student]++;
        }

        for (int i = 0; i < n; i++) {
            int type = sandwiches[i];

            if (count[type] == 0) {
                return n - i; // No student wants this sandwich
            }

            count[type]--; // Give sandwich to someone
        }

        return 0; // All students served
    }
}
