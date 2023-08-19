package mscLeetcode;
class Solution {

    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {

            char character = columnTitle.charAt(i);
            int value = 26 - ('Z' - character);
            result = 26 * result + value;
        }

        return result;
    }

}
