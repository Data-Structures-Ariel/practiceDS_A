public class pra_07 {

    //O(n)
    public static int[] MinMax(int[] a) {
        return MinMax(a, 0, a.length - 1);
    }

    private static int[] MinMax(int[] a, int i, int j) {
        if (j == i)
            return new int[]{a[i], a[j]};
        if (j == i + 1) {
            if (a[i] < a[j])
                return new int[]{a[i], a[j]};
            else return new int[]{a[j], a[i]};
        } else {
            int k = (i + j) / 2;
            int a1[] = MinMax(a, i, k);
            int a2[] = MinMax(a, k + 1, j);
            return new int[]{Math.min(a1[0], a2[0]), Math.max(a1[1], a2[1])};
        }
    }
}
