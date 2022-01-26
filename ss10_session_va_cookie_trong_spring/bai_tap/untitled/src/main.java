import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        int A[] = new int[] (1, 2, 3);
        int B[] =[1, 2, 3];
        ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                ids.add(i);
            }
        }
        if (ids.size() == 0) {
            return true;
        }
        if (ids.size() != 2) {
            return false;
        }
        int id1 = ids.get(0);
        int id2 = ids.get(1);
        if (A[id1] == B[id2] && A[id2] == B[id1]) {
            return true;
        }
        return false;
    }
}
