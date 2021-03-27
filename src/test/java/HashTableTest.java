import org.junit.Test;
import solution.hash_table.P0381_InsertDeleteAndGetRandom;

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
        P0381_InsertDeleteAndGetRandom obj = new P0381_InsertDeleteAndGetRandom();
        P0381_InsertDeleteAndGetRandom.RandomizedCollection randomizedCollection = obj.new RandomizedCollection();
        System.out.println("result = " + randomizedCollection.insert(21));
    }

}
