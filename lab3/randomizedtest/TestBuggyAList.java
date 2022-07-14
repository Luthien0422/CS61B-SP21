package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> alist = new AListNoResizing<>();
        BuggyAList<Integer> blist = new BuggyAList<>();
        alist.addLast(4);
        alist.addLast(5);
        alist.addLast(6);
        blist.addLast(4);
        blist.addLast(5);
        blist.addLast(6);
        Assert.assertEquals(alist.removeLast(),blist.removeLast());
        Assert.assertEquals(alist.removeLast(),blist.removeLast());
        Assert.assertEquals(alist.removeLast(),blist.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int sizeOfL = L.size();
                int sizeOfB = B.size();
                assertEquals(sizeOfL,sizeOfB);
            }else if (operationNumber == 2 && L.size()>0){
                // getLast
                int lastElementL = L.getLast();
                int lastElementB = B.getLast();
                assertEquals(lastElementL,lastElementB);
            }else if (operationNumber == 3 && L.size()>0){
                // removeLast
                int removeLastL = L.removeLast();
                int removeLastB = B.removeLast();
                assertEquals(removeLastL,removeLastB);
            }
        }
    }
}
