package mscLeetcode;
class Solution2 {
    public String addBinary(String a, String b) {

      //Define parameters
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        int i = arr1.length - 1;
        int j = arr2.length -1 ;

        //loop through strings
        while ( i >= 0 || j >= 0 || carry > 0) {

            int num1 = i >= 0? Integer.parseInt(String.valueOf(arr1[i])) : 0;
            int num2 = j >= 0? Integer.parseInt(String.valueOf(arr2[j])) : 0;

            //function
            int sum = num1 + num2 + carry;
            sb.insert(0,sum%2);
            carry = sum/2;
            i--;
            j--;
        }
        return sb.toString();
    }
}