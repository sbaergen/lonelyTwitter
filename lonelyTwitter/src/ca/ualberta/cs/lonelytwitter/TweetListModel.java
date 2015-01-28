package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Iterator;

public class TweetListModel {

	private int count;
	private ArrayList<LonelyTweetModel> tweetList;
	public TweetListModel() {
		// TODO Auto-generated constructor stub
		count = 0;
		tweetList = new ArrayList<LonelyTweetModel>();
	}
	
	public int getCount(){
		
		return count;
	}

	public ArrayList<LonelyTweetModel> getList() {
		// TODO Auto-generated method stub
		return tweetList;
	}

	public void addTweet(LonelyTweetModel tweet) {
		// TODO Auto-generated method stub
		count++;
		Iterator<LonelyTweetModel> it = tweetList.iterator();
		while (it.hasNext()){
			LonelyTweetModel test = it.next();
			if (test.equals(tweet)){
				throw new IllegalArgumentException();
			}
		}
		tweetList.add(tweet);
	}

}
