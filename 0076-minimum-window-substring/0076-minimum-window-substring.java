class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        int r = 0;
        int st = 0;
        int e = 0;
        boolean solutionExists = false;

        HashMap<Character, Integer> hashmap = new HashMap();
        int minLen = Integer.MAX_VALUE;
        for (Character c : t.toCharArray()) {
            hashmap.put(c, hashmap.getOrDefault(c, 0) + 1);
        }
        int count = hashmap.size();

        while (r < s.length()) {
            if (!hashmap.containsKey(s.charAt(r))) {
                r++;
                continue;
            }
            Character sc = s.charAt(r);
            hashmap.put(sc, hashmap.get(sc) - 1);
            if (hashmap.get(sc) == 0)
                count--;
            r++;
            if (count > 0)
                continue;

            while (count == 0) {
                Character lat = s.charAt(l);
                if (!hashmap.containsKey(lat)) {
                    l++;
                    continue;
                }
                l++;
                hashmap.put(lat, hashmap.get(lat) + 1);
                if (hashmap.get(lat) > 0)
                    count++;
            }

            if (minLen > r - l) {
                minLen = r - l;
                st = l - 1;
                e = r;
                solutionExists = true;
            }
        }
        return solutionExists ? s.substring(st, e) : "";

    }
}
