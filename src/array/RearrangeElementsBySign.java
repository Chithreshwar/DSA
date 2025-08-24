package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class RearrangeElementsBySign {

    private static final Logger logger = Logger.getLogger(RearrangeElementsBySign.class.getName());

    public static void main(String[] args) {
        int q[] = {1, 2, -4, -5};
        logger.info("Rearranged array" + Arrays.toString(rearrangeBrute(q)));
        logger.info("BruteForce"+rearrangeOptimal(q));

    }

    private static List<Integer> rearrangeOptimal(int A[]) {
        int n = A.length;
        //below line creates prefilled arraylist of size n filled with 0.
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
        //This is done because in beforehand itself we don't know where will the position of positive and negative number be
        //or else we could have just used the new arraylist and start adding the element. for example u cant ad arr.add(0,2)
        //arr.add(3,6) missing out position 1,2 unfilled.


        // positive elements start from 0 and negative from 1.
        int posIndex = 0, negIndex = 1;
        for (int i = 0; i < n; i++) {

            // Fill negative elements in odd indices and inc by 2.
            if (A[i] < 0) {
                ans.set(negIndex, A[i]);
                negIndex += 2;
            }

            // Fill positive elements in even indices and inc by 2.
            else {
                ans.set(posIndex, A[i]);
                posIndex += 2;
            }
        }

        return ans;
    }

    private static int[] rearrangeBrute(int A[]) {
        int n = A.length;
        // Define 2 vectors, one for storing positive
        // and other for negative elements of the array.
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Segregate the array into positives and negatives.
        for (int i = 0; i < n; i++) {

            if (A[i] > 0) pos.add(A[i]);
            else neg.add(A[i]);
        }

        // Positives on even indices, negatives on odd.
        for (int i = 0; i < n / 2; i++) {

            A[2 * i] = pos.get(i);
            A[2 * i + 1] = neg.get(i);
        }


        return A;
    }
}


