class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) return "";
        StringBuilder sb = new StringBuilder();
        while (sum > 0 && num > 0) {
            int digit = Math.min(9, sum);
            sb.append(digit);
            sum -= digit;
            num--;
        }
        while (num-- > 0) {
            sb.append('0');
        }
        return sb.toString();
    }
}