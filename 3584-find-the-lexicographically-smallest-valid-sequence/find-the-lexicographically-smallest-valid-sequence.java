class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // exact[j] = latest starting index in word1
        // from which word2[j...] can be matched exactly.
        int[] exact = new int[m + 1];

        // almost[j] = latest starting index in word1
        // from which word2[j...] can be matched with <= 1 mismatch.
        int[] almost = new int[m + 1];

        // Empty suffix can always be matched.
        exact[m] = n;
        almost[m] = n;

        /*
         * Build exact[] from right to left.
         */
        int p = n - 1;

        for (int j = m - 1; j >= 0; j--) {

            while (p >= 0 && word1.charAt(p) != word2.charAt(j)) {
                p--;
            }

            if (p >= 0) {
                exact[j] = p;
                p--;
            } else {
                exact[j] = -1;
            }
        }

        /*
         * Build almost[] from right to left.
         *
         * For word2[j...], there are two possibilities:
         *
         * 1. word1[i] != word2[j]
         *    -> use the one mismatch here
         *    -> remainder must match EXACTLY
         *
         * 2. word1[i] == word2[j]
         *    -> don't use mismatch here
         *    -> remainder may have <= 1 mismatch
         */
        for (int j = m - 1; j >= 0; j--) {

            int best = -1;

            // Case 1: mismatch at current character.
            // Need exact[j + 1] after i.
            if (exact[j + 1] != -1) {
                best = exact[j + 1] - 1;
            }

            // Case 2: current character matches.
            // Need almost[j + 1] after i.
            if (almost[j + 1] != -1) {

                int i = almost[j + 1] - 1;

                while (i >= 0 && word1.charAt(i) != word2.charAt(j)) {
                    i--;
                }

                best = Math.max(best, i);
            }

            almost[j] = best;
        }

        // No valid sequence exists.
        if (almost[0] == -1) {
            return new int[0];
        }

        int[] ans = new int[m];

        int prev = -1;
        boolean usedMismatch = false;

        /*
         * Greedily choose the smallest possible index.
         */
        for (int j = 0; j < m; j++) {

            for (int i = prev + 1; i < n; i++) {

                boolean same = word1.charAt(i) == word2.charAt(j);

                if (same) {

                    // If mismatch already used,
                    // remainder must be EXACT.
                    if (usedMismatch) {
                        if (exact[j + 1] > i) {
                            ans[j] = i;
                            prev = i;
                            break;
                        }
                    }

                    // If mismatch not used,
                    // remainder can have <= 1 mismatch.
                    else {
                        if (almost[j + 1] > i) {
                            ans[j] = i;
                            prev = i;
                            break;
                        }
                    }

                } else {

                    // We can use our one mismatch here.
                    if (!usedMismatch && exact[j + 1] > i) {

                        ans[j] = i;
                        prev = i;
                        usedMismatch = true;
                        break;
                    }
                }
            }

            // We failed to find an index.
            if (prev != ans[j]) {
                return new int[0];
            }
        }

        return ans;
    }
}