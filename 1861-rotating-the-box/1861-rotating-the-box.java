class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char [][] rotatedBox = new char[box[0].length][box.length];
        
        for (int i = 0; i < box.length; i++) {
            int fallTo = box[0].length-1;
            for (int j = box[0].length-1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][fallTo--] = '#';
                }
                if (box[i][j] == '*') {
                    fallTo = j-1;
                }
            }
        }
        for (int i = 0; i < box[0].length; i++) {
            for (int j = 0; j < box.length; j++) {
                rotatedBox[i][j] = box[box.length-1-j][i];
            }
        }
        return rotatedBox;
    }
}