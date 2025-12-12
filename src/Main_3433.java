import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main_3433 {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((o1, o2) -> {
            int t1 = Integer.parseInt(o1.get(1));
            int t2 = Integer.parseInt(o2.get(1));
            return t1 != t2 ? t1 - t2 : o2.get(0).charAt(0) - o1.get(0).charAt(0);
        });
        int[] res = new int[numberOfUsers];
        int[] status = new int[numberOfUsers];
        for (List<String> event : events) {
            String e = event.get(0);
            int time = Integer.parseInt(event.get(1));
            if (e.equals("MESSAGE")) {
                String mentions = event.get(2);
                if (mentions.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        res[i]++;
                    }
                } else if (mentions.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (status[i] <= time) {
                            res[i]++;
                        }
                    }
                } else {
                    for (String uid : mentions.split(" ")) {
                        int id = Integer.parseInt(uid.substring(2));
                        res[id]++;
                    }
                }
            } else {
                int uid = Integer.parseInt(event.get(2));
                status[uid] = time + 60;
            }
        }
        return res;
    }
}
