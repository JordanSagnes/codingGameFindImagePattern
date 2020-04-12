import java.util.ArrayList;

public class ImagePattern {
    private int imageHeight;
    private int imageWidth;
    private int patternHeight;
    private int patternWidth;
    private String[] image;
    private String[] pattern;


    public ImagePattern(int imageHeight, int imageWidth, String[] image, int patternHeight, int patternWidth, String[] pattern) {
        this.imageHeight = imageHeight;
        this.imageWidth = imageWidth;
        this.image = image;
        this.patternHeight = patternHeight;
        this.patternWidth = patternWidth;
        this.pattern = pattern;
    }


    /**
     * Find first occurrence of pattern in image
     * @return [x,y] if pattern found or [-1,-1]
     */
    public int[] solve() {
        int[] result = {-1,-1}; // x,y
        boolean isFind = false;
        int imageRow = 0;

        while(imageRow < (this.imageHeight - this.patternHeight + 1) && !isFind) {
            // find first occurrence
            int imageColumn = 0;
            ArrayList<Integer> indexOfAllOccurrence = Tools.stringIndexOfAllOccurrence(image[imageRow], pattern[0]);
            isFind = false;

            //if first occurrence found : run through all index found
            for(Integer indexStart : indexOfAllOccurrence) {
                imageColumn = indexStart;

                // run through all pattern's lines
                int rowPattern = 1;
                isFind = true;
                while(rowPattern < this.patternHeight && isFind) {
                    if(!Tools.stringIncludeAtPosition(image[imageRow + rowPattern], pattern[rowPattern], indexStart)) {
                        isFind = false;
                    }
                    rowPattern++;
                }

                if(isFind) {
                    result[0] = imageColumn;
                    result[1] = imageRow;
                    break;
                }
            }
            imageRow++;
        }

        return result;
    }
}
