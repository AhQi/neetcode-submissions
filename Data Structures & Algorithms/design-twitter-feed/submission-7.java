class Twitter {
    private class Feed {
        int seq;
        int feedId;
        int userId;
        Feed(int seq, int feedId, int userId) {
            this.seq = seq;
            this.feedId = feedId;
            this.userId = userId;
        }
    }
    private class User {
        List<Feed> feeds;
        int id;
        User(int id) {
            this.id = id;
            this.feeds = new ArrayList<>();
        }
    }

    int globalSeq;
    Map<Integer, User> users;
    Map<Integer, Set<Integer>> following;
    public Twitter() {
        this.users = new HashMap<>();
        this.following = new HashMap<>();
        this.globalSeq = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        User newUser = users.get(userId);
        if (newUser == null) {
            newUser = new User(userId);
            users.put(userId, newUser);
            following.put(userId, new HashSet<>());
        }
        newUser.feeds.add(new Feed(globalSeq, tweetId, userId));
        globalSeq++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        Set<Integer> followees = new HashSet<>(Set.of(userId));
        followees.addAll((following.get(userId)));

        for (Integer cur : followees) {
            User user = users.get(cur);
            if (user != null && !user.feeds.isEmpty()) {
                int topIdx = user.feeds.size() - 1;
                minHeap.add(new int[]{user.feeds.get(user.feeds.size() - 1).seq, topIdx, user.id});
            }
        }

        List<Integer> res = new ArrayList<>();
        int n = 0;
        while (n < 10 && !minHeap.isEmpty()) {
            int[] feed = minHeap.poll();
            
            final List<Feed> feeds = users.get(feed[2]).feeds;

            res.add(feeds.get(feed[1]).feedId);
            n++;
            if (feed[1] > 0) {
                minHeap.add(new int[]{feeds.get(feed[1]-1).seq, feed[1]-1, users.get(feed[2]).id});
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!following.containsKey(followerId)) {
            following.put(followerId, new HashSet<>(Set.of(followeeId)));
        } else {
            following.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!following.containsKey(followerId)) {
            return;
        } else {
            following.get(followerId).remove(followeeId);
        }
    }
}
