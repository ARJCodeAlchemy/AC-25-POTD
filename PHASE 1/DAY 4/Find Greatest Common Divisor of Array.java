class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); //O(n logn)
        return gcd(nums[n-1],nums[0]);
    }
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    } //TC - O(log(min(a,b)))
}
//-------------------------------
// Can be done optimally without the need of sorting
class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return gcd(max, min);
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
//O(n)
