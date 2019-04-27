package hashmapTest;

import java.util.HashMap;

public class stringrepeter {
    HashMap<String, String> hashMaps = new HashMap<>();
    String newWords;

    public void printPermutations(String s, String s1) {
        permutationHelper(prepareHashMap(s), "", s.length());
        boolean test = false;
        for (String ss : hashMaps.values()) {
            if (ss.contains(newWords)) System.out.println("pass");

        }
    }


    private HashMap<Character, Integer> prepareHashMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);

            }
        }
        return map;
    }

    private void permutationHelper(HashMap<Character, Integer> map, String permutation, int remainingChars) {

        if (remainingChars == 0) {
            hashMaps.put(permutation, permutation);
            System.out.println(permutation);
        } else {
            for (char c : map.keySet()) {

                if (map.get(c) > 0) {
                    //choose
                    String nextPermutation = permutation +
                            c;

                    map.put(c, map.get(c) - 1);

                    //explore
                    permutationHelper(map, nextPermutation, remainingChars - 1);

                    //un chose
                    map.put(c, map.get(c) + 1);
                }
            }
        }
    }
}
