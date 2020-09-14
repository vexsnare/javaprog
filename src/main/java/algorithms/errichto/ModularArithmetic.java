package algorithms.errichto;

/**
 * @author vinay.saini
 * @created 14/09/2020 - 9:46 PM
 */
public class ModularArithmetic {
    final int mod = 13;

    // Mod is generally slower below technique is 3 times faster
    public int myMod(int x, int mod) {
        return x > mod ? x - mod : x;
    }

    private int add(int x, int y) {
        return (x%mod + y%mod)%mod;
    }

    private int substract(int x, int y) {
        return ((x - y)%mod + mod)%mod;
    }

    private int prod(int x, int y) {
        return (int)((long) (x % mod) * (y % mod))%mod;
    }

    private int div(int x, int y) {
        //x * (1/y)
        //(int)((a%mod) * (long)(Math.pow(b, mod - 2)))%mod;
        int inverseOfY = ((int)Math.pow(y, mod-2))%mod;
        return prod(x, inverseOfY);
    }

    public static void main(String[] args) {
        ModularArithmetic ma = new ModularArithmetic();
//        assert ma.add(100, 40) == 4 : "Add Failed";
//        assert ma.prod(7, 4) == 11 : "Product Failed";
//        assert ma.substract(84, 4) == 12 : "Sub Failed";
//        assert ma.div(84, 4) == 4 : "div Failed";

        assert ma.add(100, 40) == 10 : "Add Failed";
        assert ma.prod(7, 4) == 2 : "Product Failed";
        assert ma.substract(84, 4) == 2 : "Sub Failed";
        assert ma.div(84, 4) == 8 : "div Failed";
    }
}
