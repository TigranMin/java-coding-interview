public class Recursion {

    public static void main(String[] args) {

        for (int i = 0; i < 15; i++) {
            System.out.println(i + " : " + countWays(i));
        }

    }

    private static int countWays(int n) {
        if(n < 0){
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return countWays(n - 1) + countWays(n - 2) +countWays(n - 3);
    }
}
