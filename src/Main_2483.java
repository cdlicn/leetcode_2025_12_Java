public class Main_2483 {
    public int bestClosingTime(String customers) {
        int cntY = 0;
        char[] charArray = customers.toCharArray();
        for (char c : charArray) {
            if (c == 'Y') cntY++;
        }
        int cntN = 0, min = cntY, minIdx = 0;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == 'N') cntN++;
            else cntY--;
            if (cntN + cntY < min) {
                min = cntN + cntY;
                minIdx = i + 1;
            }
        }
        return minIdx;
    }
}
