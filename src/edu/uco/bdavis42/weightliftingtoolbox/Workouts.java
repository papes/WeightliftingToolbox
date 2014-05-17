package edu.uco.bdavis42.weightliftingtoolbox;

import edu.uco.bdavis42.finalproject.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Workouts extends Activity {
	User user;
	TextView week;
	TextView squat1RepMax;
	TextView bench1RepMax;
	TextView deadlift1RepMax;
	TextView row1RepMax;
	TextView incline1RepMax;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workouts);
		user = User.getInstance();

		week = (TextView) findViewById(R.id.Week);
		week.setText("Week " + Integer.toString(user.week));
		squat1RepMax = (TextView) findViewById(R.id.squatStats);
		squat1RepMax.setText(Integer.toString(user.squatMax));
		bench1RepMax = (TextView) findViewById(R.id.benchStats);
		bench1RepMax.setText(Integer.toString(user.benchMax));
		deadlift1RepMax = (TextView) findViewById(R.id.deadliftStats);
		deadlift1RepMax.setText(Integer.toString(user.deadliftMax));
		row1RepMax = (TextView) findViewById(R.id.rowStats);
		row1RepMax.setText(Integer.toString(user.rowMax));
		incline1RepMax = (TextView) findViewById(R.id.inclineStats);
		incline1RepMax.setText(Integer.toString(user.inclineMax));

		Button monday = (Button) findViewById(R.id.Monday);
		Button wednesday = (Button) findViewById(R.id.Wednesday);
		Button friday = (Button) findViewById(R.id.Friday);

		monday.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				final Dialog monday = new Dialog(Workouts.this);
				monday.setContentView(R.layout.monday);
				monday.setTitle("Today's workout");

				// set the custom dialog components - text, image and button
				TextView squat1 = (TextView) monday
						.findViewById(R.id.mondaySquat1);
				squat1.setText(roundTo5((user.squatMax * 0.925 * .925 * .925
						* .925 * .925)));
				TextView squat2 = (TextView) monday
						.findViewById(R.id.mondaySquat2);
				squat2.setText(roundTo5((user.squatMax * 0.925 * .925 * .925 * .925)));
				TextView squat3 = (TextView) monday
						.findViewById(R.id.mondaySquat3);
				squat3.setText(roundTo5((user.squatMax * 0.925 * .925 * .925)));
				TextView squat4 = (TextView) monday
						.findViewById(R.id.mondaySquat4);
				squat4.setText(roundTo5((user.squatMax * 0.925 * .925)));
				TextView squat5 = (TextView) monday
						.findViewById(R.id.mondaySquat5);
				squat5.setText(roundTo5((user.squatMax * 0.925)));

				// fill in bench weights

				TextView bench1 = (TextView) monday
						.findViewById(R.id.mondayBench1);
				bench1.setText(roundTo5((user.benchMax * 0.925 * 0.925 * 0.925
						* 0.925 * 0.925)));
				TextView bench2 = (TextView) monday
						.findViewById(R.id.mondayBench2);
				bench2.setText(roundTo5((user.benchMax * 0.925 * 0.925 * 0.925 * 0.925)));
				TextView bench3 = (TextView) monday
						.findViewById(R.id.mondayBench3);
				bench3.setText(roundTo5((user.benchMax * 0.925 * 0.925 * 0.925)));
				TextView bench4 = (TextView) monday
						.findViewById(R.id.mondayBench4);
				bench4.setText(roundTo5((user.benchMax * 0.925 * 0.925)));
				TextView bench5 = (TextView) monday
						.findViewById(R.id.mondayBench5);
				bench5.setText(roundTo5((user.benchMax * 0.925)));

				// fill in row weights

				TextView row1 = (TextView) monday.findViewById(R.id.mondayRow1);
				row1.setText(roundTo5((user.rowMax * 0.925 * 0.925 * 0.925
						* 0.925 * 0.925)));
				TextView row2 = (TextView) monday.findViewById(R.id.mondayRow2);
				row2.setText(roundTo5((user.rowMax * 0.925 * 0.925 * 0.925 * 0.925)));
				TextView row3 = (TextView) monday.findViewById(R.id.mondayRow3);
				row3.setText(roundTo5((user.rowMax * 0.925 * 0.925 * 0.925)));
				TextView row4 = (TextView) monday.findViewById(R.id.mondayRow4);
				row4.setText(roundTo5((user.rowMax * 0.925 * 0.925)));
				TextView row5 = (TextView) monday.findViewById(R.id.mondayRow5);
				row5.setText(roundTo5((user.rowMax * 0.925)));

				monday.show();

			}
		});

		wednesday.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				final Dialog wednesday = new Dialog(Workouts.this);
				wednesday.setContentView(R.layout.wednesday);
				wednesday.setTitle("Today's workout");

				// set the custom dialog components - text, image and button
				TextView squat1 = (TextView) wednesday
						.findViewById(R.id.wednesdaySquat1);
				squat1.setText(roundTo5((user.squatMax * 0.925 * 0.925 * 0.925 * 0.925)));
				TextView squat2 = (TextView) wednesday
						.findViewById(R.id.wednesdaySquat2);
				squat2.setText(roundTo5((user.squatMax * 0.925 * 0.925 * 0.925)));
				TextView squat3 = (TextView) wednesday
						.findViewById(R.id.wednesdaySquat3);
				squat3.setText(roundTo5((user.squatMax * 0.925 * 0.925)));
				TextView squat4 = (TextView) wednesday
						.findViewById(R.id.wednesdaySquat4);
				squat4.setText(roundTo5((user.squatMax * 0.925)));

				// fill in bench weights

				TextView incline1 = (TextView) wednesday
						.findViewById(R.id.wednesdayIncline1);
				incline1.setText(roundTo5((user.inclineMax * 0.925 * 0.925 * 0.925 * 0.925)));
				TextView incline2 = (TextView) wednesday
						.findViewById(R.id.wednesdayIncline2);
				incline2.setText(roundTo5((user.inclineMax * 0.925 * 0.925 * 0.925)));
				TextView incline3 = (TextView) wednesday
						.findViewById(R.id.wednesdayIncline3);
				incline3.setText(roundTo5((user.inclineMax * 0.925 * 0.925)));
				TextView incline4 = (TextView) wednesday
						.findViewById(R.id.wednesdayIncline4);
				incline4.setText(roundTo5((user.inclineMax * 0.925)));

				// fill in row weights

				TextView deadlift1 = (TextView) wednesday
						.findViewById(R.id.wednesdayDeadlift1);
				deadlift1
						.setText(roundTo5((user.deadliftMax * 0.925 * 0.925 * 0.925 * 0.925)));
				TextView deadlift2 = (TextView) wednesday
						.findViewById(R.id.wednesdayDeadlift2);
				deadlift2
						.setText(roundTo5((user.deadliftMax * 0.925 * 0.925 * 0.925)));
				TextView deadlift3 = (TextView) wednesday
						.findViewById(R.id.wednesdayDeadlift3);
				deadlift3.setText(roundTo5((user.deadliftMax * 0.925 * 0.925)));
				TextView deadlift4 = (TextView) wednesday
						.findViewById(R.id.wednesdayDeadlift4);
				deadlift4.setText(roundTo5((user.deadliftMax * 0.925)));

				wednesday.show();

			}
		});

		friday.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				final Dialog friday = new Dialog(Workouts.this);
				friday.setContentView(R.layout.friday);
				friday.setTitle("Today's workout");
				TextView squat1 = (TextView) friday
						.findViewById(R.id.fridaySquat1);
				squat1.setText(roundTo5((user.squatMax * 0.925 * 0.925 * 0.925
						* 0.925 * 0.925)));
				TextView squat2 = (TextView) friday
						.findViewById(R.id.fridaySquat2);
				squat2.setText(roundTo5((user.squatMax * 0.925 * 0.925 * 0.925 * 0.925)));
				TextView squat3 = (TextView) friday
						.findViewById(R.id.fridaySquat3);
				squat3.setText(roundTo5((user.squatMax * 0.925 * 0.925 * 0.925)));
				TextView squat4 = (TextView) friday
						.findViewById(R.id.fridaySquat4);
				squat4.setText(roundTo5((user.squatMax * 0.925 * 0.925)));
				TextView squat5 = (TextView) friday
						.findViewById(R.id.fridaySquat5);
				squat5.setText(roundTo5((user.squatMax * 0.925)));

				TextView squat6 = (TextView) friday
						.findViewById(R.id.fridaySquat6);

				squat6.setText(roundTo5((user.squatMax * 0.80)));

				// fill in bench weights

				TextView bench1 = (TextView) friday
						.findViewById(R.id.fridayIncline1);
				bench1.setText(roundTo5((user.benchMax * 0.925 * 0.925 * 0.925
						* 0.925 * 0.925)));
				TextView bench2 = (TextView) friday
						.findViewById(R.id.fridayIncline2);
				bench2.setText(roundTo5((user.benchMax * 0.925 * 0.925 * 0.925 * 0.925)));
				TextView bench3 = (TextView) friday
						.findViewById(R.id.fridayIncline3);
				bench3.setText(roundTo5((user.benchMax * 0.925 * 0.925 * 0.925)));
				TextView bench4 = (TextView) friday
						.findViewById(R.id.fridayBench4);
				bench4.setText(roundTo5((user.benchMax * 0.925 * 0.925)));
				TextView bench5 = (TextView) friday
						.findViewById(R.id.fridayBench5);
				bench5.setText(roundTo5((user.benchMax * 0.925)));
				TextView bench6 = (TextView) friday
						.findViewById(R.id.fridayBench6);
				bench6.setText(roundTo5((user.benchMax * 0.80)));

				// fill in row weights

				TextView row1 = (TextView) friday.findViewById(R.id.fridayRow1);
				row1.setText(roundTo5((user.benchMax * 0.925 * 0.925 * 0.925 * 0.925) * 0.925));
				TextView row2 = (TextView) friday.findViewById(R.id.fridayRow2);
				row2.setText(roundTo5((user.benchMax * 0.925 * 0.925 * 0.925 * 0.925)));
				TextView row3 = (TextView) friday.findViewById(R.id.fridayRow3);
				row3.setText(roundTo5((user.benchMax * 0.925 * 0.925 * 0.925)));
				TextView row4 = (TextView) friday.findViewById(R.id.fridayRow4);
				row4.setText(roundTo5((user.benchMax * 0.925 * 0.925)));
				TextView row5 = (TextView) friday.findViewById(R.id.fridayRow5);
				row5.setText(roundTo5((user.benchMax * 0.925)));
				TextView row6 = (TextView) friday.findViewById(R.id.fridayRow6);
				row6.setText(roundTo5((user.benchMax * 0.80)));

				friday.show();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.workouts, menu);
		return true;
	}

	public String roundTo5(Double y) {
		int x = y.intValue();

		while (x % 5 != 0) {
			x++;
		}
		return Integer.toString(x);

	}

	public void update() {

		week.setText("Week " + Integer.toString(user.week));
		squat1RepMax.setText(Integer.toString(user.squatMax));
		bench1RepMax.setText(Integer.toString(user.benchMax));
		deadlift1RepMax.setText(Integer.toString(user.deadliftMax));
		row1RepMax.setText(Integer.toString(user.rowMax));
		incline1RepMax.setText(Integer.toString(user.inclineMax));

	}

	public boolean onOptionsItemSelected(MenuItem item) {
		SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
		switch (item.getItemId()) {
		case R.id.menu_item_advance_week:
			user.increaseWeight();
			editor.putInt("squat", user.squatMax);
			editor.putInt("bench", user.benchMax);
			editor.putInt("deadlift", user.deadliftMax);
			editor.putInt("row", user.rowMax);
			editor.putInt("incline", user.inclineMax);
			editor.putInt("week", user.week);
			editor.commit();
			update();
			return true;
		case R.id.menu_item_previous_week:
			user.decreaseWeight();
			editor.putInt("squat", user.squatMax);
			editor.putInt("bench", user.benchMax);
			editor.putInt("deadlift", user.deadliftMax);
			editor.putInt("row", user.rowMax);
			editor.putInt("incline", user.inclineMax);
			editor.putInt("week", user.week);
			editor.commit();
			update();
			return true;
		case R.id.menu_item_delete:
			
			
			user.squatMax = 0;
			user.benchMax = 0;
			user.deadliftMax = 0;
			user.rowMax = 0;
			user.inclineMax = 0;
			user.week = 1;
			editor.putInt("squat", user.squatMax);
			editor.putInt("bench", user.benchMax);
			editor.putInt("deadlift", user.deadliftMax);
			editor.putInt("row", user.rowMax);
			editor.putInt("incline", user.inclineMax);
			editor.putInt("week", user.week);
			editor.commit();
			update();
			finish();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
