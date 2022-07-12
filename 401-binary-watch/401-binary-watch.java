class Solution {
    Set<String> result = new HashSet<>();
    public List<String> readBinaryWatch(int turnedOn) {
        generate(0, 0, 0, 0, turnedOn);
        return new ArrayList<>(result);
    }
    
    private void generate (int h, int m, int i, int j, int count)
    {
        if (count == 0 && h <= 11 && m <= 59) {
            StringBuilder str = new StringBuilder();
            str.append(h);
            String mstr = m <= 9 ? "0" + m : String.valueOf(m);
            str.append(":");
            str.append(mstr);
            result.add(str.toString());
            return;
        }
        for (int k = i; k < 4; k++) {
           generate(h+(int)Math.pow(2, k), m, k+1, j, count-1); 
        }
        for (int l = j; l < 6; l++) {
           generate(h, m+(int)Math.pow(2, l), i, l+1, count-1); 
        }  
    }
}