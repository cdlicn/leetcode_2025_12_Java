import java.util.*;

public class Main_3606 {

    private final Map<String, Integer> BUSINESS_LINE_TO_CATEGORY = Map.of(
            "electronics", 0,
            "grocery", 1,
            "pharmacy", 2,
            "restaurant", 3
    );

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String>[] groups = new ArrayList[BUSINESS_LINE_TO_CATEGORY.size()];
        Arrays.setAll(groups, a -> new ArrayList<>());
        for (int i = 0; i < code.length; i++) {
            String s = code[i];
            Integer category = BUSINESS_LINE_TO_CATEGORY.get(businessLine[i]);
            if (category != null && isActive[i] && isValid(s)) {
                groups[category].add(s);
            }
        }

        List<String> ans = new ArrayList<>();
        for (List<String> g : groups) {
            Collections.sort(g);
            ans.addAll(g);
        }
        return ans;
    }

    private boolean isValid(String s) {
        for (char c : s.toCharArray()) {
            if (c != '_' && !Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return !s.isEmpty();
    }
}
