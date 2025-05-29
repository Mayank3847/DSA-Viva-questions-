public class String_Integer_To_String_ATOI {
    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        int i = 0, sign = 1;
        int n = s.length();
        long result = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = s.charAt(i);
            if (sign == '-') {
                sign = -1;
            } else {
                sign = 1;
            }
            i++;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)(result*sign);
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));              // Output: 42
        System.out.println(myAtoi("   -42"));          // Output: -42
        System.out.println(myAtoi("4193 with words")); // Output: 4193
        System.out.println(myAtoi("words and 987"));   // Output: 0
        System.out.println(myAtoi("-91283472332"));
    }

}
