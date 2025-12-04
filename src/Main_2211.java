public class Main_2211 {

    public int countCollisions(String s) {
        int n = s.length();
        int l = 0;
        while (l < n && s.charAt(l) == 'L') {
            l++;
        }
        int r = n;
        while (r > l && s.charAt(r - 1) == 'R') {
            r--;
        }
        int cnt = 0;
        for (int i = l; i < r; i++) {
            if (s.charAt(i) != 'S') {
                cnt++;
            }
        }
        return cnt;
    }

}
