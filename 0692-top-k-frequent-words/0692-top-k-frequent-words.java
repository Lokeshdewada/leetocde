class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> frequency = new LinkedHashMap<>();
        for( String s : words) {
            frequency.put(s, 1 + (frequency.containsKey(s) ? frequency.get(s) : 0 ));
        }
        return frequency.entrySet()
                        .stream()
                        .sorted( (i,j) -> 
                                j.getValue().compareTo(i.getValue()) == 0 ?
                                i.getKey().compareTo(j.getKey()) 
                                : j.getValue().compareTo(i.getValue()))
                        .limit(k)
                        .map(i -> i.getKey())
                        .collect(Collectors.toList());
    }
}