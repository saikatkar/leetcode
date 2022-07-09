class Solution {
    List<String> resultList = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4) {
            return resultList;
        }
        generate(s, new ArrayList<>(), 3);
        return resultList;
    }
    
    private void generate (String s, List<String> result, int k)
    {
        if (s.equals("") && k < 0) {
            StringBuilder sb = new StringBuilder();
            for (String str : result) {
                sb.append(str);
                sb.append(".");
            }
            sb.setLength(sb.length() - 1);
            resultList.add(sb.toString());
            return;
        }
        if (k < 0) {
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i+1);
            long subInt = Long.parseLong(sub);
            //System.out.println(sub);
            if (sub.charAt(0) == '0' && sub.length() > 1) {
                continue;
            }
            if (!(subInt >= 0 && subInt <= 255)) {
                continue;
            }
            result.add(sub);
            generate(s.substring(i+1), result, k-1);
            result.remove(result.size() - 1);
        }
        
    }
}