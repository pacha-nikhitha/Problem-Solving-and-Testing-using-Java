class Solution {
    public boolean halvesAreAlike(String s) {
     String vowels = "aeiouAEIOU";
        int n = s.length();
        int half = n / 2;
        
        int countA = 0, countB = 0;
        
        for (int i = 0; i < half; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                countA++;
            }
            if (vowels.indexOf(s.charAt(i + half)) != -1) {
                countB++;
            }
        }
        
        return countA == countB;
    }
}
