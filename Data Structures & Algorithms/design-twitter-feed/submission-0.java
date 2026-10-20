class Twitter {
    List<Tweet> tweets;
    Map<Integer, Set<Integer>> followers;
    public Twitter() {
        tweets = new ArrayList<Tweet>();
        followers = new HashMap();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(tweetId, userId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList();
        Set<Integer> f = followers.get(userId);
        int count = 0;
        for (int i = tweets.size() - 1; i > -1; i--) {
            Tweet t = tweets.get(i);
            if (t.userId == userId || (f != null && f.contains(t.userId))) {
                feed.add(t.tweetId);
                count++;
                if (count == 10) {
                    break;
                }
            }
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).add(followeeId);
        } else {
            Set<Integer> follow = new HashSet();
            follow.add(followeeId);
            followers.put(followerId, follow);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }

    record Tweet(int tweetId, int userId) {}
}
