
import java.util.*;

public class TransposeMatrix {
    public void run() {
        List<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        matrix.add(new ArrayList<>(Arrays.asList(2, 4, -1)));
        matrix.add(new ArrayList<>(Arrays.asList(-10, 5, 11)));
        matrix.add(new ArrayList<>(Arrays.asList(18, -7, 6)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        matrix.add(new ArrayList<>(Arrays.asList(4, 5, 6)));

        List<ArrayList<Integer>> result = transpose(matrix);
        for (int x = 0; x < result.size(); x++) {
            for (int y = 0; y < result.get(0).size(); y++) {
                System.out.print(result.get(x).get(y) + " , ");
            }
            System.out.println("");
        }
    }

    public List<ArrayList<Integer>> transpose(List<ArrayList<Integer>> matrix) {
        // check if there is a need to resize the array first
        if (matrix.size() != matrix.get(0).size()) {
            resetSizeOfArray(matrix);
        }
        // iterate 2d array -> swap x,y
        HashSet<Pair> seenPair = new HashSet<>();
        for (int x = 0; x < matrix.size(); x++) {
            for (int y = 0; y < matrix.get(0).size(); y++) {
                if (x == y) continue;
                Pair xyPair = new Pair(x, y);
                if (seenPair.contains(xyPair)) continue;
                // swap x,y and y,x
                int temp = matrix.get(x).get(y);
                matrix.get(x).set(y, matrix.get(y).get(x));
                matrix.get(y).set(x, temp);
                seenPair.add(xyPair);
            }
        }
        return matrix;
    }

    public void resetSizeOfArray(List<ArrayList<Integer>> matrix) {
        // col > row, add row
        if (matrix.get(0).size() > matrix.size()) {
            for (int i = matrix.size(); i < matrix.get(0).size(); i++) {
                matrix.add(new ArrayList() {
                    {
                        for (int z = 0; z < matrix.get(0).size(); z++) {
                            add(null);
                        }
                    }
                });
            }
        } else {
            // row > col , add null col
            for (int i = 0; i < matrix.size(); i++) {
                for (int j = matrix.get(i).size(); j < matrix.size(); j++) {
                    try {
                        matrix.get(i).add(-1);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }
        }
    }

    public final class Pair {
        private final Object a;
        private final Object b;

        public Pair(Object a, Object b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || !(o instanceof Pair))
                return false;

            Pair that = (Pair) o;
            return this.a.equals(that.a) && this.b.equals(that.b)
                    || this.a.equals(that.b) && this.b.equals(that.a);
        }

        @Override
        public int hashCode() {
            return a.hashCode() ^ b.hashCode();
        }
    }
}
