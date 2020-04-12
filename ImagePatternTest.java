import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ImagePatternTest {

    @Test
    public void example1() {
        String[] image = {"10toto00toto0", "20tati00tati0"};
        String[] pattern = {"toto", "tati"};
        ImagePattern imagePattern = new ImagePattern(image.length, 13, image, pattern.length, 4, pattern);
        Assert.assertArrayEquals(new int[] {2,0}, imagePattern.solve());
    }

    @Test
    public void example2() {
        String[] image = {"10toto00toto0", "20tata00tati0"};
        String[] pattern = {"toto", "tati"};
        ImagePattern imagePattern = new ImagePattern(image.length, 13, image, pattern.length, 4, pattern);
        Assert.assertArrayEquals(new int[] {8,0}, imagePattern.solve());
    }

    @Test
    public void example3() {
        String[] image = {"1000000000000", "20toto000toto", "20toto000tati"};
        String[] pattern = {"toto", "tati"};
        ImagePattern imagePattern = new ImagePattern(image.length, 13, image, pattern.length, 4, pattern);
        Assert.assertArrayEquals(new int[] {9,1}, imagePattern.solve());
    }

    @Test
    public void example4() {
        String[] image = {"10tati00tati0", "20tata000toto"};
        String[] pattern = {"toto"};
        ImagePattern imagePattern = new ImagePattern(image.length, 13, image, pattern.length, 4, pattern);
        Assert.assertArrayEquals(new int[] {9,1}, imagePattern.solve());
    }

    @Test
    public void exampleFail() {
        String[] image = {"1000000000000", "200000000toto"};
        String[] pattern = {"toto", "tata"};
        ImagePattern imagePattern = new ImagePattern(image.length, 13, image, pattern.length, 4, pattern);
        Assert.assertArrayEquals(new int[] {-1,-1}, imagePattern.solve());
    }

    @Test
    public void tools() {
        String haystack = "tototo00000toto";
        String needle = "toto";
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(2);
        result.add(11);
        Assert.assertEquals(result, Tools.stringIndexOfAllOccurrence(haystack, needle));
    }
}