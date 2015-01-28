package ca.ualberta.cs.lonelytwitter.test;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;

public class LonelyTweetModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public LonelyTweetModelTest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testSampleCode(){
		assertTrue("This is not true", isGreater(7,6));
		assertEquals("NOT EQUAL", 5, 6);
		fail("This is a failing test");
	}
	
	private boolean isGreater (int i, int j){
		if (i<j)
			return false;
		return true;
	}

}
