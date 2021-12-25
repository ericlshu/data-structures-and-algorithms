package solution.hash_table;

import java.util.*;

/**
 * Description : O(1) 时间插入、删除和获取随机元素 - 允许重复
 * <p>
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 * 注意: 允许出现重复元素。
 * <p>
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * <p>
 * 示例:
 * <p>
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 * <p>
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 * <p>
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 * <p>
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 * <p>
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 * <p>
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 * <p>
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 *
 * @author Eric L SHU
 * @date 2020-10-31 16:21
 * @since JDK 1.8
 */
public class P0381InsertDeleteAndGetRandom
{
    public static class RandomizedCollection
    {
        Map<Integer, Set<Integer>> index;
        List<Integer> nums;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection()
        {
            index = new HashMap<>();
            nums = new ArrayList<>();
        }

        /**
         * Inserts a value to the collection.
         * Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val)
        {
            nums.add(val);
            Set<Integer> set = index.getOrDefault(val, new HashSet<>());
            set.add(nums.size() - 1);
            index.put(val, set);
            return set.size() == 1;
        }

        /**
         * Removes a value from the collection.
         * Returns true if the collection contained the specified element.
         */
        public boolean remove(int val)
        {
            if (!index.containsKey(val))
            {
                return false;
            }
            Iterator<Integer> it = index.get(val).iterator();
            int i = it.next();
            int lastNum = nums.get(nums.size() - 1);
            nums.set(i, lastNum);
            index.get(val).remove(i);
            index.get(lastNum).remove(nums.size() - 1);
            if (i < nums.size() - 1)
            {
                index.get(lastNum).add(i);
            }
            if (index.get(val).size() == 0)
            {
                index.remove(val);
            }
            nums.remove(nums.size() - 1);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom()
        {
            return nums.get((int) (Math.random() * nums.size()));
        }
    }
}
