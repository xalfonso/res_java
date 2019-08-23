import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Example if news with collections in java 9
 */
public class CollectionsTest {

    @Test
    public void createListTest() {
        List<String> someList = List.of("One", "Two", "Three", "Four", "Five", "Six");
        Assert.assertEquals(someList.size(), 6);
    }

    /**
     * Produce error because the six element is duplicated.
     */
    @Test(expected = IllegalArgumentException.class)
    public void createSetErrorTest() {
        Set<String> someSet = Set.of("One", "Two", "Three", "Four", "Five", "Six", "Six");
    }

    @Test
    public void createMap(){
        Map<Integer, String> integerStringMap = Map.of(1, "One", 2, "Two", 3, "Three");
        Assert.assertEquals(integerStringMap.size(), 3);
    }
}
