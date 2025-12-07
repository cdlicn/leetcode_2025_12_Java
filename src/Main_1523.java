public class Main_1523 {
    public int countOdds(int low, int high) {
        low += low % 2 == 0 ? 1 : 0;
        high -= high % 2 == 0 ? 1 : 0;
        return (high - low) / 2 + 1;
    }
}
