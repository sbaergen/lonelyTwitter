package ca.ualberta.cs.lonelytwitter.test;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import ca.ualberta.cs.lonelytwitter.R;

public class IntentReaderActivityTest extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {

	public IntentReaderActivityTest() {
		super(IntentReaderActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testSendText(){
		String text = "Hello World";
		int code = IntentReaderActivity.NORMAL;
		IntentReaderActivity activity = startWithText(text, code);
		assertEquals("Is the text correct?", text, activity.getText());	
	}
	
	public void testDoubleText(){
		String text = "Hello";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.DOUBLE);
		assertEquals("Is the text correct again?", text+text, activity.getText());
	}
	
	public void testReverseText(){
		String text = "Hello";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.REVERSE);
		assertEquals("Is the reverse correct?", "olleH", activity.getText());
	}
	
	public void testDisplayText(){
		String text = "Hello again";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
		assertEquals("correct text?", text, activity.getText());
		TextView view = (TextView) activity.findViewById(R.id.intentText);
		assertEquals("display correct?", text, view.getText().toString());
	}
	
	public void testDefault(){
		String text = "No Message";
		IntentReaderActivity activity = startWithText(null, IntentReaderActivity.NORMAL);
		TextView view = (TextView) activity.findViewById(R.id.intentText);
		assertEquals("Is Default correct?", text, view.getText().toString());
	}
	
	public void textDisplayExists(){
		IntentReaderActivity activity = startWithText(null, IntentReaderActivity.NORMAL);
		TextView view = (TextView) activity.findViewById(R.id.intentText);
		android.test.ViewAsserts.assertOnScreen((View)activity.getWindow().getDecorView(), (View)view);
	}
	
	private IntentReaderActivity startWithText(String text, int code){
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, code);
		setActivityIntent(intent);
		return (IntentReaderActivity) getActivity();
	}
}