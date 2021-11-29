package forkJoinApp;

import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinApp {

    public static void main(String[] args) {

        int[] data = generateArray(100_000_000);
        DemoRecursiveTask task = new DemoRecursiveTask(data);
//        System.out.println(Arrays.toString(data));
        long start1 = System.currentTimeMillis();
        System.out.println(getMax(data));
        long end1 = System.currentTimeMillis();

        System.out.println("getMax duration: " + (end1 - start1));

        long start2 = System.currentTimeMillis();
        Integer result = ForkJoinPool.commonPool().invoke(task);
        System.out.println("fork result - " + result);
        long end2 = System.currentTimeMillis();

        System.out.println("fork duration: " + (end2 - start2));
    }

    private static int[] generateArray(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = new Random()
                    .ints(0, 100_000)
                    .findFirst()
                    .getAsInt();
        }
        return data;
    }

    private static int getMax(int[] data) {
        int temp = 0;
        for (int i : data) {
            if (i > temp) {
                temp = i;
            }
        }
        return temp;
    }
}
