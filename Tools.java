import java.util.ArrayList;

public class Tools {
    /**
     * @param haystack : String where we are looking for a pattern
     * @param needle : String which represent pattern
     * @param position : int which represent the index where we start the research
     * @return true if haystack contains needle at the index position
     */
    public static Boolean stringIncludeAtPosition(String haystack, String needle, int position) {
        int endIndex = position + needle.length();
        if( endIndex > haystack.length()) {
            return false;
        }

        for(int index = position; index < endIndex; index++) {
            if(haystack.charAt(index) != needle.charAt(index - position)) {
                return false;
            }
        }

        return true;
    }

    /**
     * @param haystack : String where we are looking for a pattern
     * @param needle : String which represent pattern
     * @return List of index
     */
    public static ArrayList<Integer> stringIndexOfAllOccurrence(String haystack, String needle) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int charPos = 0; charPos < haystack.length(); charPos++) {
            if(Tools.stringIncludeAtPosition(haystack, needle, charPos)) {
                result.add(charPos);
            }
        }

        return result;
    }
}
