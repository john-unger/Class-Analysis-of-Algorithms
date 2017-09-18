/**
 * Created by John on 2/14/17.
 */

import java.lang.management.*;
import java.util.Random;
import java.util.Scanner;

public class homework3 implements Runnable{
    public long time;
    public int size = 1;

    public homework3() {
        time = 0;
    }


    private void printNumbers(int[] input) {

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
    }

    public void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
//            printNumbers(array);
        }
    }

    private void randomFill(int[] ary) {
        if (size > 0) {

            Random rand = new Random();
            for (int i = 0; i < ary.length; i++) {
                ary[i] = (rand.nextInt() % (ary.length * 2)); // To keep values in a reasonable range
            }
        }
        else{
            // THIS IS WORST CASE (sorted array that is reversed)
            for (int i = 0; i < ary.length; i++) {
                ary[i] = ary.length - i;
            }
        }
    }

    @Override
    public void run() {

        // Fill array
        int[] ary;
        if ( size > 0)
            ary = new int[size];
        else
            ary = new int[(-1 * size)];

        randomFill(ary);
        //test.printNumbers(ary);

        // Start timer and sorting
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        time = threadMXBean.getCurrentThreadCpuTime();

        insertionSort(ary);
        time = threadMXBean.getCurrentThreadCpuTime() - time;
    }
}
