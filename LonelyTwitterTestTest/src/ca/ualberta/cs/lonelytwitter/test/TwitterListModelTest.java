package ca.ualberta.cs.lonelytwitter.test;

import java.util.ArrayList;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetListModel;

public class TwitterListModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
	
	TweetListModel tweets;
	public TwitterListModelTest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		tweets = new TweetListModel();
	}

	public void testCounts(){
		NormalTweetModel normalTweet = new NormalTweetModel("Hello");
		tweets.addTweet(normalTweet);
		assertEquals("Count should be zero", tweets.getCount(), 1);
	}
	
	public void testAddTweets(){
		NormalTweetModel normalTweet = new NormalTweetModel("hi");
		NormalTweetModel normalTweet1 = new NormalTweetModel("hi");
		tweets.addTweet(normalTweet);
		tweets.addTweet(normalTweet1);
		assertEquals("There should be a tweet in the list", 1, tweets.getList().size());
		assertNotNull("The tweets list is not initialised", tweets.getList());
	}
	
	public void testGetTweets(){
		NormalTweetModel tweet1 = new NormalTweetModel("Number1");
		NormalTweetModel tweet2 = new NormalTweetModel("Number2");
		tweets.addTweet(tweet1);
		tweets.addTweet(tweet2);
		ArrayList<LonelyTweetModel> test = new ArrayList<LonelyTweetModel>();
		tweets.getTweets();
	}
	
}
