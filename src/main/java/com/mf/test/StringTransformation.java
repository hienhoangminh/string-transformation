package com.mf.test;

public class StringTransformation {

    public static String appendAndDelete(String s, String t, int k) {
        // Check if k is non-negative. If yes then throw exception
        if (k < 0) {
            throw new IllegalArgumentException("Number of operations should not be negative or be equal to 0");
        } else {
            // Preliminary check:
            // Check if s and t are 2 strings of lowercase English letter. If not, then convert it to lowercase letter first.
            // We also check if length of 2 strings are over the upper limit of integer.
            s = convertToLowercaseString(s);
            t = convertToLowercaseString(t);
            verifyIfStringOverBoundary(s);
            verifyIfStringOverBoundary(t);

            // Step 1 : Find the longest common prefix
            int longestCommonPrefix = findLongestCommonPrefix(s, t);

            // Step 2 : Calculate the total operations number
            int totalOperations = calculateTotalOperations(s, t, longestCommonPrefix);

            // Step 3: Compare the k number of operations allowed with total number of opearations required
            // If totalOperations is bigger then k then we return No
            if (totalOperations > k) {
                return "No";
            }

            // Step 4: Check if the difference between k and totalOperations is even or the k number
            // is bigger than the sum of length of 2 strings. If true then we perform multiple deletion then append characters
            if ((k - totalOperations) % 2 == 0 || (k >= s.length() + t.length())) {
                return "Yes";
            }
            return "No";
        }
    }

    /**
     * Validate if string length is not over the boundary limit
     *
     * @param s: the string
     */
    private static void verifyIfStringOverBoundary(String s) {
        if (s.length() > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("The current string are too long!");
        }
    }

    /**
     * Convert the string to lower case
     *
     * @param s: the string
     */
    private static String convertToLowercaseString(String s) {
        return s.toLowerCase();
    }

    /**
     * Find the longest common prefix between 2 characters
     *
     * @param s : the first string
     * @param t : the second string
     * @return the longest common prefix between 2 characters
     */
    private static int findLongestCommonPrefix(String s, String t) {
        int commonLength = 0;
        while (commonLength < s.length() && commonLength < t.length() && s.charAt(commonLength) == t.charAt(commonLength)) {
            commonLength++;
        }
        return commonLength;
    }

    /**
     * Calculate the number of total operations
     *
     * @param s                   : the first string
     * @param t                   : the second string
     * @param longestCommonPrefix : the length of longest comm prefix
     * @return number of total operations that we need to convert s to t
     */
    private static int calculateTotalOperations(String s, String t, int longestCommonPrefix) {
        return (s.length() - longestCommonPrefix) + (t.length() - longestCommonPrefix);
    }

}
