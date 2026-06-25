class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // If both strings are made from the same repeating pattern,
        // concatenating them in either order should give the same result.
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Length of the largest common divisor string
        int len = gcd(str1.length(), str2.length());

        // The common divisor string must be the prefix of length gcd(len1, len2)
        return str1.substring(0, len);
    }

    public int gcd(int a, int b) {
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);

        // Euclidean Algorithm
        // while (b != 0) {
        //     int temp = a % b;
        //     a = b;
        //     b = temp;
        // }
        // return a;
    }
}