package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        SLList<Integer> test01 = new SLList<Integer>();
        AList<Integer> Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();
        int numberOfItems = 1000;
        int i = 1;
        int numberOfPerform = 10000;
        while (true){
            Ns.addLast(numberOfItems);
            opCounts.addLast(numberOfPerform);
            while(i <= numberOfItems){
                test01.addLast(i);
                i = i + 1;
            }
            int m = 0;
            Stopwatch sw = new Stopwatch();
            while(m < numberOfPerform){
                int lastNumber = test01.getLast();
                m = m + 1;
            }
            times.addLast(sw.elapsedTime());
            numberOfItems *= 2;
            if(numberOfItems > 128000){
                break;
            }
        }
        printTimingTable(Ns,times,opCounts);
    }

}
