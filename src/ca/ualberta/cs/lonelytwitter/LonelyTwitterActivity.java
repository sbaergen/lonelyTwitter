package ca.ualberta.cs.lonelytwitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<String> tweets;
	private ArrayAdapter<String> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				tweets.add(text);
				adapter.notifyDataSetChanged();
				saveInFile(text, new Date(System.currentTimeMillis()));
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		User u = new Author("joe");
		try {
			u.setName("joe2");
		} catch (IOException e) {
			e.printStackTrace();
		}

		ArrayList<User> x = new ArrayList<User>();
		
		
		super.onStart();
		tweets = loadFromFile();
		adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private ArrayList<String> loadFromFile() {
		Gson gson = new Gson();
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			//https://sites.google.com/site/gson/gson-user-guide 2015-01-21
			Type dataType = new TypeToken<ArrayList<String>>() {}.getType();
			InputStreamReader isr = new InputStreamReader(fis);
			tweets = gson.fromJson(isr, dataType);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (tweets == null){
			tweets = new ArrayList<String>();
			
		}
		return tweets;
	}
	
	private void saveInFile(String text, Date date) {
		Gson gson = new Gson();
		try {
			FileOutputStream fos = openFileOutput(FILENAME,0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(tweets, osw);
			osw.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}