class Solution {
    public int hIndex(int[] citations) {
        // sort it in descending order  
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;
        // start from end , largest citation first
        for ( int i =0; i < n; i++){
            int paperwithatleast = i +1;
            int citationCount = citations[n-1-i];//When i=0 →citations[n-1-0]=citations[4]=6
            if ( citationCount >= paperwithatleast){
                h = paperwithatleast;
            }else {
                break;
            }
        }
        return h;
    }
}