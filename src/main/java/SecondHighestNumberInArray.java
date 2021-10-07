public class SecondHighestNumberInArray {

    public static void main(String[] args) {

        int[] arr = {14, 46, 47, 94, 94, 52, 86, 36, 94, 89, 100};
        System.out.println(secondHighestNumberInArray(arr));

    }

    public static int secondHighestNumberInArray(int[] arr) {
        int largest = 0;
        int secondLargest = 0;
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }
}
