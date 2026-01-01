package hashAlgorithm;

import java.util.HashMap;

public class hashLv1 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        for (String player : map.keySet()) {
            if (map.get(player) != 0) {
                return player;
            }
        }

        return "";
    }
}
