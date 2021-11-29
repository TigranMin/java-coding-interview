import java.util.Arrays;

public class SortingAndSearch {

    public static void main(String[] args) {

        int[] a = new int[10];
        a[0] = 1;
        a[1] = 5;
        a[2] = 8;
        a[3] = 10;
        a[4] = 15;
        int[] b = new int[]{1, 8, 9, 10, 12};

        mergeSorting(a, b);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSorting(int[] a, int[] b) {
        int indexA = a.length - b.length - 1;
        int indexB = b.length - 1;
        int mergedIndex = indexA + indexB + 1;

        while (indexB >= 0) {
            if(indexA >= 0 && a[indexA] > b[indexB]){
                a[mergedIndex] = a[indexA];
                indexA --;
            }else {
                a[mergedIndex] = b[indexB];
                indexB--;
            }
            mergedIndex--;
        }
    }
}
