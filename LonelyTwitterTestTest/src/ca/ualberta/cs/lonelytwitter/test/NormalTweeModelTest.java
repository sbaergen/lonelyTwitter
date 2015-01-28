package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

public class NormalTweeModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public NormalTweeModelTest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testEquals(){
		Date date = new Date();
		NormalTweetModel tweet1 = new NormalTweetModel("Hi", date);
		NormalTweetModel tweet2 = new NormalTweetModel("Hi", date);
		ImportantTweetModel tweet3 = new ImportantTweetModel("Hi", date);
		ImportantTweetModel tweet4 = new ImportantTweetModel("Hi there", date);
		NormalTweetModel tweet5 = new NormalTweetModel("Hi there", date);
		assertTrue("These should be same", tweet1.equals(tweet2));
		assertFalse("Same tweets are same", tweet3.equals(tweet2));
		assertFalse("Should be different", tweet2.equals(tweet5));
		assertFalse("These should be different", tweet3.equals(tweet4));
	}

}
