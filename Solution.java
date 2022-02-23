class Solution {
    public List<Integer> partitionLabels(String s) {
        // same as count sort algorithm but the differance is that we get the last index of each char.
        int[] last = new int[26];
        for (int i = 0; i < s.length(); ++i)
            last[s.charAt(i) - 'a'] = i;
        
        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i <s.length(); ++i) {
            j = Math.max(j, last[s.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
