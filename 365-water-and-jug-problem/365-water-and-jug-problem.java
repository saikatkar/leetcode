class Solution {
    public boolean canMeasureWater(int m, int n, int target) {
        if (m + n < target) {
            return false;
        }
        if (target % gcd(m, n) != 0) {
            return false;
        }
        return true;
    }
    
    
    private int gcd (int a, int b)
    {
        if (a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
}