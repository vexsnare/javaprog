/**
 * Created by vinaysaini on 11/17/16.
 */

public final  class Test {

    private boolean [] visited = new boolean[10];
    private int[] fact = new int[10];
    private int N;
    private int K;
    StringBuilder sb = new StringBuilder();

    void findChar(int pos) {
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                if(fact[N - pos] >= K) {
                    sb.append(i);
                    visited[i] = true;
                    break;
                } else {
                    K -= fact[N - pos];
                }
            }
        }
    }

    public String getPermutation(int n, int k){
        fact[0] = 1;
        this.N = n;
        this.K = k;
        for(int i = 1; i < n+1; i++) {
            fact[i] = i * fact[i-1];
        }

        for(int i = 1; i <= N; i++) {
            findChar(i);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.getPermutation(3, 3));

    }

}
