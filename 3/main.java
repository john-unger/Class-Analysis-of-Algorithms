/**
 * Created by John on 2/16/17.
 */
public class main {
    public static int THREADS = 12;

    public static void main(String [] args)
    {
        for (int j = 1; j < 25; j++)
        {
            System.out.println("\nWith a size of " + 5000 * j * j + " in the array:\n");

            homework3[] longRun = new homework3[THREADS];
            Thread[] t =new Thread[THREADS];

            // A size of 2000000 resulted in a time of 643 seconds

            for (int i = 0; i < THREADS; i++) {
                longRun[i] = new homework3();
                longRun[i].size = 5000 * j * j * (-1);
//                longRun[i].size = 2000000;
                t[i] =new Thread(longRun[i]);

                t[i].start();
            }
            int index = THREADS - 1;

            while (index >= 0) {
                try{
                    t[index].join();
                    System.out.println((longRun[index].time / 1000000000.0) + " ");
                    index--;
                }catch(Exception e){}
            }
        }

    }


}
