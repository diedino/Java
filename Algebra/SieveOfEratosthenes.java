public final class SieveOfEratosthenes {

    public static int[] find(int n) {
        int count = 0;
        boolean[] arr = new boolean[n+1];
        // all elements are true
        for(int i=0; i<arr.length; i++) {
            arr[i] = true;
        }
        for(int i=2; i*i<=n; i++) {
            if (arr[i]) {
                for (int j=i*i; j<=n; j+=i) {
                    arr[j]=false;
                }
            }
        }
        for (int i=2; i<arr.length; i++) {
            if (arr[i])
                count++;
        }
        int[] ret = new int[count];
        int j=0;
        for (int i=2; i<arr.length; i++) {
            if (arr[i]) {
                ret[j] = i;
                j++;
            }
        }
        return ret;
    }
}
