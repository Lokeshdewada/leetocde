class Solution {
  public int longestPalindrome(String[] words) {
    int[][] freq = new int[26][26];//array for all alphabet combinations
    for (String word : words)
      freq[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;//increase the index for every word
    int left = 0;
    boolean odd = false;
    for (int i = 0; i != 26; i++) {
      odd |= (freq[i][i] & 1) == 1;
      left += freq[i][i] / 2;
      for (int j = i + 1; j != 26; j++)
        left += Math.min(freq[i][j], freq[j][i]);//taking min times from both present 
    }
    int res = left * 2 * 2;
    if (odd){
        res+=2;// middle element
    } 
    return res;
  }
}