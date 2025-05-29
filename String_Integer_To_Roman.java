public class String_Integer_To_Roman {
    public static String intToRoman(int num) {
        int val[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < val.length; i++) {
            while (num >= val[i]) {
                roman.append(symbols[i]);
                num -= val[i];

            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 58;
        int num3 = 1994;

        System.out.println("Integer " + num1 + " equals Roman numeral " + intToRoman(num1));
        System.out.println("Integer " + num2 + " equals Roman numeral " + intToRoman(num2));
        System.out.println("Integer " + num3 + " equals Roman numeral " + intToRoman(num3));

    }
}
