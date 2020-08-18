package leetcode;

class WithoutConsecutiveOnes {

    public int findIntegers(int num) {

        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;

        String bit = Integer.toBinaryString(num);

        for(int i = 2; i < bit.length(); i++) {
            f[i] = f[i-1] + f[i-2];
        }

        int msb = 0;
        int temp = num;
        while(temp > 0) {
            temp >>= 1;
            msb++;
        }
        int prevChar = 0;
        int n = bit.length();
        int ans = 0;
        for(int i = n - msb; i < n; i++) {
            if(bit.charAt(i) == '1') {
                if(prevChar == 0) {
                    System.out.println(n-i-1);
                    if(n-i-1>=0)  ans += f[n-i-1];
                    prevChar = 1;
                } else {
                    prevChar = 0;
                }
            } else {
                if(prevChar == 0) {
                    System.out.println(n-i);
                    if(n-i>=0)  ans += f[n-i];
                    prevChar = 1;
                }
                else prevChar = 0;
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        WithoutConsecutiveOnes solution = new WithoutConsecutiveOnes();
        solution.findIntegers(120);
    }
}