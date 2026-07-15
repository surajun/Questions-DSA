class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxlength = 0;
        for ( int right = 0; right < s.length(); right ++){
            char currentchar = s.charAt(right);
            // shrink
            while ( window.contains(currentchar)){
                window.remove(s.charAt(left));
                left ++;
            }
            window.add(currentchar);
            int currentwindowSize = right - left + 1;
            maxlength = Math.max(maxlength, currentwindowSize); 
        }
        return maxlength;
    }
}