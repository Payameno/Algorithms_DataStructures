class Solution {

  /*
   * Two bucket solution
   */

    public String frequencySort(String s) {
        
      //Map chat to frequency
      HashMap<Character, Integer> bucket1 = new HashMap<>();
      int n = s.length();

      for (Character chr : s.toCharArray()) {
        bucket1.put(chr, bucket1.getOrDefault(chr, 0)+1);
      }

      //Map Frequency to array of character with that frequency
      HashMap<Integer, List<Character>> bucket2 = new HashMap<>();

      for (Character chr : bucket1.keySet()) {
        int freq = bucket1.get(chr);

        //Create the key value in memory - if does not exists
        if (!bucket2.containsKey(freq)) {
          bucket2.put(freq, new ArrayList<>());
        }

        bucket2.get(freq).add(chr);
      }

      StringBuilder sb = new StringBuilder();
      
      //Loop down from top possible frequency
      for (int i = n; i > 0; i--) {

          if (bucket2.containsKey(i)) {

            for (Character chr : bucket2.get(i)) {
                for (int j = i; j > 0; j--) {
                    sb.append(chr);
                }
            }

          }

      }

      return sb.toString();
        
    }

}