import java.util.Arrays;

public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null) {
            return false;
        }

        if (b.length == 0 && a.length == 0) {
            return true;
        }

        if (b.length == 0 || a.length == 0) {
            return false;
        }

        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                a[i] = -a[i];
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] <= b[i]) {
                if (a[i] * a[i] != b[i]) {
                    return false;
                }
            }
            if (b[i] < a[i]) {
                if (b[i] * b[i] != a[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, -14, 191, 161, 19, 144, 195, 1};
        int[] b = {1, 0, 14 * 14, 191 * 191, 161 * 161, 19 * 19, 144 * 144, 195 * 195};
        System.out.println(comp(a, b));
    }

}

