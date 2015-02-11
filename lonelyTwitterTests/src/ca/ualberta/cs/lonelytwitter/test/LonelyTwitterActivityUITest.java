package ca.ualberta.cs.lonelytwitter.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.R;

/*
 * generate this class with new.. JUnit Test Case
 * set superclass to ActivityInstrumentationTestCase2
 */
public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	Activity activity;
	EditText textInput;
	
	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();

		textInput = ((EditText) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.body));
	}
	
	public void testSetText(){
		String text = "NeatO!!";
		instrumentation.runOnMainSync(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String text = "NeatO!!";
				textInput.setText(text);
				
			
			}
		});
		instrumentation.waitForIdleSync();
		assertEquals("DOES THIS WORK????", text, textInput.getText().toString());
		}
	
	
	public void testAddTweet(){
		ListView list = (ListView) activity.findViewById(R.id.oldTweetsList);
		ListAdapter adapter = list.getAdapter();
		int length = adapter.getCount();
		NormalTweetModel tweet = new NormalTweetModel();
		tweet.setText("Tweet");
		instrumentation.runOnMainSync(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String text = "Tweet";
				makeTweet(text);
			}
		});
		instrumentation.waitForIdleSync();
		assertEquals("Adapter", length+1, adapter.getCount());
		assertEquals("Type", tweet.getClass(), adapter.getItem(adapter.getCount()-1).getClass());
		assertEquals("Text", "Tweet", ((NormalTweetModel) adapter.getItem(adapter.getCount()-1)).getText());
	}
	/*
	 * fills in the input text field and clicks the 'save'
	 * button for the activity under test
	 */
	private void makeTweet(String text) {
		assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
	}
}
