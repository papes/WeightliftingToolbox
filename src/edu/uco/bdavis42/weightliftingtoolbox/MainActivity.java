package edu.uco.bdavis42.weightliftingtoolbox;

import edu.uco.bdavis42.finalproject.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	User user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		user = User.getInstance();
		Button programButton = (Button) findViewById(R.id.programButton);
		Button visualWeights = (Button) findViewById(R.id.visualWeightsButton);
		Button myVideos = (Button) findViewById(R.id.myVideosButton);
		
		SharedPreferences prefs = getPreferences(MODE_PRIVATE); 
		String restoredText = prefs.getString("text", null);
		if (restoredText != null) 
		{
		  //mSaved.setText(restoredText, TextView.BufferType.EDITABLE);
		  int squat = prefs.getInt("squat", 0);
		  int bench = prefs.getInt("bench", 0);
		  int deadlift = prefs.getInt("deadlift", 0);
		  int row = prefs.getInt("row", 0);
		  int incline = prefs.getInt("incline", 0);
		  int week = prefs.getInt("week", 0);
		  
		  user.squatMax = squat;
		  user.benchMax = bench;
		  user.deadliftMax = deadlift;
		  user.rowMax = row;
		  user.inclineMax = incline;
		  user.week = week;
		  /*if (selectionStart != -1 && selectionEnd != -1)
		  {
		     mSaved.setSelection(selectionStart, selectionEnd);
		  }*/
		}
		

		programButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent;
				if (user.getBenchMax() == 0) {
					intent = new Intent(MainActivity.this, GatherMaxes.class);
					startActivity(intent);
				}

				else {
					intent = new Intent(MainActivity.this, Workouts.class);
					startActivity(intent);
				}
			}
		});

		visualWeights.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						VisualWeights.class);
				startActivity(intent);
			}
		});

		myVideos.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, MyVideos.class);
				startActivity(intent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
