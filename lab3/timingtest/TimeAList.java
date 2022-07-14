package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> test01 = new AList<Integer>();
        AList<Integer> Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();
        int i = 1;
        Stopwatch sw = new Stopwatch();
        while (i<=128000){
            test01.addLast(i);
            if (i == 1000 || i== 2000 || i == 4000 || i == 8000 || i == 16000 || i == 32000 || i == 64000 || i == 128000){
                Ns.addLast(i);
                times.addLast(sw.elapsedTime());
                opCounts.addLast(i);
            }
            i = i + 1;
        }
        printTimingTable(Ns,times,opCounts);
    }
}
