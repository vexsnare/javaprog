import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static int m, n;
    static int matched = 0;
    static Set<String> words;
    static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};
    static int[] dy = {1, 0, -1, 0, -1, 1, 1, -1};
    static boolean[][] visited = new boolean[11][11];
    static String[][] mat = new String[11][11];

    static boolean inRange(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    static void init(){
        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                visited[i][j] = false;
            }
        }
    }
    static void dfs(int i, int j, String s) {
        if(words.contains(s)) {
            System.out.println("s = " + s);
            matched++;
        }
        for(int k = 0; k < 8; k++) {
            int nextI = i + dx[k];
            int nextj = j + dy[k];
            if(inRange(nextI, nextj) && visited[nextI][nextj] == false) {
                visited[nextI][nextj] = true;
                dfs(nextI, nextj, s + mat[nextI][nextj]);
                visited[nextI][nextj] = false;
            }
        }
    }
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        init();
        int z;
        z = sc.nextInt();
        sc.nextLine();
        words = new HashSet<>();
        String wordsLine = sc.nextLine();
        String[] splitWords = wordsLine.split(" ");
        for (int i = 0; i < splitWords.length; i++) {
            words.add(splitWords[i]);
        }
        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();
        String[] chars = sc.nextLine().split(" ");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //System.out.println("x = " + chars[i * n + j]);
                mat[i][j] = chars[i*n + j];
            }
        }
        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                matched = 0;
                dfs(i, j, "" + mat[i][j]);
                ans += matched;
            }
        }
        System.out.println(ans);

        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    }
}

