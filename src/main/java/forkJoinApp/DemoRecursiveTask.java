package forkJoinApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DemoRecursiveTask extends RecursiveTask<Integer> {

    private int[] data;

    public DemoRecursiveTask(int[] data) {
        this.data = data;
    }

    @Override
    protected Integer compute() {
        if (this.data.length > 2) {
            List<DemoRecursiveTask> subtasks = createSubtasks();
            for (DemoRecursiveTask subtask : subtasks) {
                subtask.fork(); // running subtasks
            }
            int result = 0;
            for (DemoRecursiveTask subtask : subtasks) {
                Integer joinRes = subtask.join();
                result = joinRes > result ? joinRes : result; // getting result of subtasks
            }
            return result;
        } else {
//            System.out.println("Calculation for: " + Arrays.toString(data) +
//                    " in thread " + Thread.currentThread().getName());
            return getMax(data);
        }
    }

    private List<DemoRecursiveTask> createSubtasks() {
        return new ArrayList<>(Arrays.asList(
                new DemoRecursiveTask(Arrays.copyOfRange(data,
                        0, data.length / 2)),
                new DemoRecursiveTask(Arrays.copyOfRange(data,
                        data.length / 2, data.length))
        ));
    }

    private static int getMax(int[] data) {
        int temp = data[0];
        for (int i : data) {
            if (i > temp) {
                temp = i;
            }
        }
        return temp;
    }

}
