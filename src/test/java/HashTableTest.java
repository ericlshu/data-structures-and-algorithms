import org.junit.Test;
import solution.hash_table.P0381InsertDeleteAndGetRandom;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2021-03-27 14:20
 * @since JDK 1.8
 */
public class HashTableTest
{
    @Test
    public void testP0381()
    {
        P0381InsertDeleteAndGetRandom obj = new P0381InsertDeleteAndGetRandom();
        P0381InsertDeleteAndGetRandom.RandomizedCollection randomizedCollection = new P0381InsertDeleteAndGetRandom.RandomizedCollection();
        System.out.println("result = " + randomizedCollection.insert(21));
    }

}
