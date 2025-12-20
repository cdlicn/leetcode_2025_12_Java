public class Main_944 {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            char bef = 'a';
            for (String str : strs) {
                char c = str.charAt(i);
                if (c < bef) {
                    res++;
                    break;
                } else {
                    bef = c;
                }
            }
        }
        return res;
    }
}
