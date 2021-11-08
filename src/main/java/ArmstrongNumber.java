//check Armstrong number.
//        Armstrong number is the number which is the sum of the cubes of all its unit,
//        tens and a hundred digits for three-digit numbers.
//        153 = 1*1*1 + 5*5*5 + 3*3*3 = 1 + 125 + 27 = 153
//        If you have a four-digit number lets say
//        1634 = 1*1*1*1 + 6*6*6*6 + 3*3*3*3 + 4*4*4*4 = 1 + 1296 + 81 + 256 = 1634

public class ArmstrongNumber {

    public static void main(String[] args) {

        System.out.println(isArmstrongNumber(1634));
        System.out.println(isArmstrongNumber(153));

    }

    private static boolean isArmstrongNumber(int num) {
        int res = 0;
        int numToCheck;
        numToCheck = num;
        while (num > 0) {
            res += (int) (Math.pow(num % 10, countDigits(numToCheck)));
            num /= 10;
        }
        return numToCheck == res;
    }

    private static int countDigits(int number){
        return (int) (Math.log10(number) + 1);
    }
}
