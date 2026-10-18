class Solution {
    static final long MOD = 1_000_000_007L;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        long[][] C = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);
        return (int) ((count(list, C) - 1 + MOD) % MOD);
    }

    private long count(List<Integer> nums, long[][] C) {
        int n = nums.size();
        if (n <= 2) return 1;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int root = nums.get(0);
        for (int i = 1; i < n; i++) {
            if (nums.get(i) < root) left.add(nums.get(i));
            else right.add(nums.get(i));
        }
        long res = C[n - 1][left.size()];
        res = res * count(left, C) % MOD;
        res = res * count(right, C) % MOD;
        return res;
    }
}