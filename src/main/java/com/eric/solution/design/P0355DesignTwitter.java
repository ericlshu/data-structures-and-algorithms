package com.eric.solution.design;

import java.util.*;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-03-12 17:31:45
 * <p>
 * Description : 设计推特
 * <p>设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近 10 条推文。
 * <p>
 * <p>实现 Twitter 类：
 * <p>Twitter() 初始化简易版推特对象
 * <p>void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId 创建一条新推文。每次调用此函数都会使用一个不同的 tweetId 。
 * <p>List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近  10 条推文的 ID 。新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。
 * <p>void follow(int followerId, int followeeId) ID 为 followerId 的用户开始关注 ID 为 followeeId 的用户。
 * <p>void unfollow(int followerId, int followeeId) ID 为 followerId 的用户不再关注 ID 为 followeeId 的用户。
 * <p>
 * <p>示例：
 * <p>输入
 * <p>["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
 * <p>[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
 * <p>输出
 * <p>[null, null, [5], null, null, [6, 5], null, [5]]
 * <p>解释
 * <p>Twitter twitter = new Twitter();
 * <p>twitter.postTweet(1, 5); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
 * <p>twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
 * <p>twitter.follow(1, 2);    // 用户 1 关注了用户 2
 * <p>twitter.postTweet(2, 6); // 用户 2 发送了一个新推文 (推文 id = 6)
 * <p>twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
 * <p>twitter.unfollow(1, 2);  // 用户 1 取消关注了用户 2
 * <p>twitter.getNewsFeed(1);  // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用户 2
 * <p>
 * <p>提示：
 * <p>1 <= userId, followerId, followeeId <= 500
 * <p>0 <= tweetId <= 104
 * <p>所有推特的 ID 都互不相同
 * <p>postTweet、getNewsFeed、follow 和 unfollow 方法最多调用 3 * 104 次
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0355DesignTwitter
{
    public static class Twitter
    {
        private final Map<Integer, User> userMap = new HashMap<>();
        private static int time;

        public Twitter()
        {
        }

        public void postTweet(int userId, int tweetId)
        {
            User user = userMap.computeIfAbsent(userId, User::new);
            user.head.next = new Tweet(tweetId, time++, user.head.next);
        }

        public List<Integer> getNewsFeed(int userId)
        {
            User user = userMap.get(userId);
            if (user == null)
                return List.of();

            PriorityQueue<Tweet> queue = new PriorityQueue<>(Comparator.comparingInt(Tweet::getTime).reversed());
            if (user.head.next != null)
                queue.offer(user.head.next);

            for (Integer id : user.followees)
            {
                User followee = userMap.get(id);
                if (followee.head.next != null)
                    queue.offer(followee.head.next);
            }

            List<Integer> res = new ArrayList<>();
            int cnt = 0;
            while (cnt < 10 && !queue.isEmpty())
            {
                Tweet tweet = queue.poll();
                res.add(tweet.id);

                if (tweet.next != null)
                    queue.offer(tweet.next);
                cnt++;

            }

            return res;
        }

        public void follow(int followerId, int followeeId)
        {
            User follower = userMap.computeIfAbsent(followerId, User::new);
            User followee = userMap.computeIfAbsent(followeeId, User::new);
            follower.followees.add(followee.id);
        }

        public void unfollow(int followerId, int followeeId)
        {
            User user = userMap.get(followerId);
            if (user != null)
                user.followees.remove(followeeId);
        }

        static class Tweet
        {
            int id;
            int time;
            Tweet next;

            public Tweet(int id, int time, Tweet next)
            {
                this.id = id;
                this.time = time;
                this.next = next;
            }

            public int getId()
            {
                return id;
            }

            public int getTime()
            {
                return time;
            }
        }

        static class User
        {
            int id;

            public User(int id)
            {
                this.id = id;
            }

            Set<Integer> followees = new HashSet<>();
            Tweet head = new Tweet(-1, -1, null);
        }
    }
}
