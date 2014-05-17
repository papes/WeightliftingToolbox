package edu.uco.bdavis42.weightliftingtoolbox;

import edu.uco.bdavis42.finalproject.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;
import android.util.Log;

public class GatherMaxes extends Activity {

	int squatWeight = 225, squatReps = 5, squatSets = 1;
	int benchWeight = 185, benchReps = 5, benchSets = 1;
	int deadliftWeight = 315, deadliftReps = 5, deadliftSets = 1;
	int rowWeight = 135, rowReps = 5, rowSets = 1;
	int inclineWeight = 95, inclineReps = 5, inclineSets = 1;
	EditText squatW, squatR, squatS;
	EditText benchW, benchR, benchS;
	EditText deadliftW, deadliftR, deadliftS;
	EditText rowW, rowR, rowS;
	EditText inclineW, inclineR, inclineS;
	User user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gather_maxes);
		user = User.getInstance();

		Button submit = (Button) findViewById(R.id.calculateMaxes);

		submit.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				testSquat();

				final Dialog dialog = new Dialog(GatherMaxes.this);
				dialog.setContentView(R.layout.custom);
				//dialog.setTitle(");

				// set the custom dialog components - text, image and button
				TextView squat1RepMax = (TextView) dialog
						.findViewById(R.id.squat1RepMax);
				squat1RepMax
						.setText(Integer.toString(calc1RM(squatWeight, squatReps, squatSets)));
				TextView squat5RepMax = (TextView) dialog
						.findViewById(R.id.squat5RepMax);
				squat5RepMax
						.setText(Integer.toString(calc5RM(calc1RM(squatWeight, squatReps, squatSets))));
				
				TextView bench1RepMax = (TextView) dialog
						.findViewById(R.id.bench1RepMax);
				bench1RepMax
						.setText(Integer.toString(calc1RM(benchWeight, benchReps, benchSets)));
				TextView bench5RepMax = (TextView) dialog
						.findViewById(R.id.bench5RepMax);
				bench5RepMax
						.setText(Integer.toString(calc5RM(calc1RM(benchWeight, benchReps, benchSets))));
				
				TextView deadlift1RepMax = (TextView) dialog
						.findViewById(R.id.deadlift1RepMax);
				deadlift1RepMax
						.setText(Integer.toString(calc1RM(deadliftWeight, deadliftReps, deadliftSets)));
				TextView deadlift5RepMax = (TextView) dialog
						.findViewById(R.id.deadlift5RepMax);
				deadlift5RepMax
						.setText(Integer.toString(calc5RM(calc1RM(deadliftWeight, deadliftReps, deadliftSets))));
				
				TextView row1RepMax = (TextView) dialog
						.findViewById(R.id.row1RepMax);
				row1RepMax
						.setText(Integer.toString(calc1RM(rowWeight, rowReps, rowSets)));
				TextView row5RepMax = (TextView) dialog
						.findViewById(R.id.row5RepMax);
				row5RepMax
						.setText(Integer.toString(calc5RM(calc1RM(rowWeight, rowReps, rowSets))));
				
				
				TextView incline1RepMax = (TextView) dialog
						.findViewById(R.id.incline1RepMax);
				incline1RepMax
						.setText(Integer.toString(calc1RM(inclineWeight, inclineReps, inclineSets)));
				TextView incline5RepMax = (TextView) dialog
						.findViewById(R.id.incline5RepMax);
				incline5RepMax
						.setText(Integer.toString(calc5RM(calc1RM(inclineWeight, inclineReps, inclineSets))));
				

				Button dialogButton = (Button) dialog
						.findViewById(R.id.ConfirmMaxes);
				Button cancelButton = (Button) dialog
						.findViewById(R.id.CancelMaxes);
				// if button is clicked, close the custom dialog
				dialogButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						user.setBenchMax(calc1RM(benchWeight, benchReps, benchSets));
						user.setDeadliftMax(calc1RM(deadliftWeight, deadliftReps, deadliftSets));
						user.setInclineMax(calc1RM(inclineWeight, inclineReps, inclineSets));
						user.setRowMax(calc1RM(rowWeight, rowReps, rowSets));
						user.setSquatMax(calc1RM(squatWeight, squatReps, squatSets));
						
						SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
						 editor.putInt("squat", user.squatMax);
						 editor.putInt("bench", user.benchMax);
						 editor.putInt("deadlift", user.deadliftMax);
						 editor.putInt("row", user.rowMax);
						 editor.putInt("incline", user.inclineMax);
						 editor.commit();
						 
						 finish();
						
						
					//	Log.d("benchmax", " " + user.getBenchMax());
						
					}
				});
				cancelButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						user.setBenchMax(calc1RM(benchWeight, benchReps, benchSets));
						user.setDeadliftMax(calc1RM(deadliftWeight, deadliftReps, deadliftSets));
						user.setInclineMax(calc1RM(inclineWeight, inclineReps, inclineSets));
						user.setRowMax(calc1RM(rowWeight, rowReps, rowSets));
						user.setSquatMax(calc1RM(squatWeight, squatReps, squatSets));
						
						SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
						 editor.putInt("squat", user.squatMax);
						 editor.putInt("bench", user.benchMax);
						 editor.putInt("deadlift", user.deadliftMax);
						 editor.putInt("row", user.rowMax);
						 editor.putInt("incline", user.inclineMax);
						 editor.commit();
						 
						 finish();
						
						
					//	Log.d("benchmax", " " + user.getBenchMax());
						
					}
				});

				dialog.show();

			}
		});

		squatW = (EditText) findViewById(R.id.squatWeight);
		squatW.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				
				if(c.length() > 0){
					squatWeight = Integer.parseInt(c.toString());
					}
				
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}
		});

		squatR = (EditText) findViewById(R.id.squatReps);
		squatR.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				if(c.length() > 0){
					squatReps = Integer.parseInt(c.toString());
					}
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}
		});

		squatS = (EditText) findViewById(R.id.squatSets);
		squatS.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				if(c.length() > 0){
					squatSets = Integer.parseInt(c.toString());
					}
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}
		});

		benchW = (EditText) findViewById(R.id.benchWeight);
		benchW.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				if(c.length() > 0){
					benchWeight = Integer.parseInt(c.toString());
					}
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}
		});

		benchS = (EditText) findViewById(R.id.benchSets);
		benchS.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				if(c.length() > 0){
					benchSets = Integer.parseInt(c.toString());
					}
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}
		});

		benchR = (EditText) findViewById(R.id.benchReps);
		benchR.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				if(c.length() > 0){
					benchReps = Integer.parseInt(c.toString());
					}
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}
		});

		deadliftW = (EditText) findViewById(R.id.deadliftWeight);
		deadliftW.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				if(c.length() > 0){
					deadliftWeight = Integer.parseInt(c.toString());
					}
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}
		});

		deadliftR = (EditText) findViewById(R.id.deadliftReps);
		deadliftR.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				if(c.length() > 0){
					deadliftReps = Integer.parseInt(c.toString());
					}
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}
		});

		deadliftS = (EditText) findViewById(R.id.deadliftSets);
		deadliftS.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				if(c.length() > 0){
					deadliftSets = Integer.parseInt(c.toString());
					}
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}
		});

		rowW = (EditText) findViewById(R.id.rowWeight);
		rowW.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				if(c.length() > 0){
					rowWeight = Integer.parseInt(c.toString());
					}
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}
		});

		rowR = (EditText) findViewById(R.id.rowReps);
		rowR.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				if(c.length() > 0){
					rowReps = Integer.parseInt(c.toString());
					}
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}
		});

		rowS = (EditText) findViewById(R.id.rowSets);
		rowS.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				if(c.length() > 0){
					rowSets = Integer.parseInt(c.toString());
					}
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}

		});

		inclineW = (EditText) findViewById(R.id.inclineWeight);
		inclineW.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				if(c.length() > 0){
					inclineWeight = Integer.parseInt(c.toString());
					}
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}
		});

		inclineR = (EditText) findViewById(R.id.inclineReps);
		inclineR.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				if(c.length() > 0){
					inclineReps = Integer.parseInt(c.toString());
					}
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}
		});

		inclineS = (EditText) findViewById(R.id.inclineSets);
		inclineS.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				if(c.length() > 0){
					inclineSets = Integer.parseInt(c.toString());
					}
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// this space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// this one too
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gather_maxes, menu);
		return true;
	}

	public void testSquat() {
		Log.w("myApp", "Squat weight is: " + squatWeight);
	}

	public int calc1RM(int w, int r, int s) {
		double x;
		int y;
		x = w / (1.0278 - (0.0278 * r));
		x = x * (1 + ((s - 1) * 0.0235));
		y = (int) x;

		return y;
	}

	public int calc5RM(int oneRepMax) {
		int fiveRepMax = (int) (oneRepMax * .89);

		return fiveRepMax;

	}

}
