import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        
        
        int m = languages.length;
        List<Set<Integer>> langSets = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int lang : languages[i]) {
                set.add(lang);
            }
            langSets.add(set);
        }

        // Step 2: Identify users in friendships who cannot communicate
        Set<Integer> needTeach = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1, v = f[1] - 1;
            Set<Integer> uLangs = langSets.get(u), vLangs = langSets.get(v);

            boolean canComm = false;
            // Check for at least one common language
            for (int lang : uLangs) {
                if (vLangs.contains(lang)) {
                    canComm = true;
                    break;
                }
            }
            if (!canComm) {
                needTeach.add(u);
                needTeach.add(v);
            }
        }

        // If everyone can already communicate, no one needs teaching
        if (needTeach.isEmpty()) {
            return 0;
        }

        // Step 3: For each language, count how many of the problematic users already know it
        int[] langCount = new int[n + 1];
        for (int user : needTeach) {
            for (int lang : languages[user]) {
                langCount[lang]++;
            }
        }

        // Step 4: Choose the best language to teach
        int maxKnown = 0;
        for (int lang = 1; lang <= n; lang++) {
            maxKnown = Math.max(maxKnown, langCount[lang]);
        }

        // The minimum people to teach = total problematic users - those who already know the best language
        return needTeach.size() - maxKnown;
    }
}
