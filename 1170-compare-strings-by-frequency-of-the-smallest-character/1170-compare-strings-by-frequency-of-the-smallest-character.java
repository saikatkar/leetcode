class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int qf [] = new int[queries.length];
        int wf [] = new int[words.length];
        for (int i = 0; i < qf.length; i++) {
            qf[i] = freqSmallest(queries[i]);
        }
        for (int i = 0; i< wf.length; i++) {
            wf[i] = freqSmallest(words[i]);
        }
        Arrays.sort(wf);
        int[] result = new int[queries.length];
         System.out.println(Arrays.toString(qf));
         System.out.println(Arrays.toString(wf));
        for (int i = 0; i < qf.length; i++) {
            
            int idx = search(wf, qf[i]);
            //System.out.println(idx);
            result[i] = wf.length-idx;
        }
        return result;
    }
    
    private int search (int [] wf, int target) {
        //System.out.println(target);
        int low = 0;
        int high = wf.length;
        while (low < high) {
            int mid = low + (high - low)/2;
            //System.out.println(mid);
            if (wf[mid] <= target) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return high;
    }
    private int freqSmallest (String str) {
        int [] freq = new int[26];
        for (char ch : str.toCharArray()) {
            freq[ch-'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                return freq[i];
            }
        }
        return -1;
    }
    
}