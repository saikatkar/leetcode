class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a2, a1) -> Integer.compare(a1[1], a2[1]));
        //System.out.println(Arrays.deepToString(boxTypes));
        int result = 0;
        for (int [] box : boxTypes) {
            if (truckSize == 0) {
                break;
            }
            if (truckSize >= box[0]) {
                result += box[1] * box[0];
                truckSize -= box[0];
            } else {
                result += box[1] * truckSize;
                truckSize = 0;
            }
        }
        return result;
    }
}