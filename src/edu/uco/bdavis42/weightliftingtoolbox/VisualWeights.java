package edu.uco.bdavis42.weightliftingtoolbox;

import java.util.ArrayList;
import java.util.List;

import edu.uco.bdavis42.finalproject.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class VisualWeights extends Activity {

	int weight;
	int temp;
	int plates;
	boolean metric;
	String system;
	List<ImageView> list = new ArrayList<ImageView>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_visual_weights);
		plates = 0;
		weight = 45;
		system = "lbs";
		metric = false;
		final TextView weightLabel = (TextView) findViewById(R.id.weightLabel);
		final Button add100 = (Button) findViewById(R.id.add100);
		final Button add45 = (Button) findViewById(R.id.add45);
		final Button add35 = (Button) findViewById(R.id.add35);
		final Button add25 = (Button) findViewById(R.id.add25);
		final Button add10 = (Button) findViewById(R.id.add10);
		final Button add5 = (Button) findViewById(R.id.add5);
		final Button add2_5 = (Button) findViewById(R.id.add2_5);
		final Button clear = (Button) findViewById(R.id.clear);
		final Button pounds = (Button) findViewById(R.id.displayPounds);
		final Button kilograms = (Button) findViewById(R.id.displayKilos);
		final ImageView left1 = (ImageView) findViewById(R.id.left_plate1);
		final ImageView left2 = (ImageView) findViewById(R.id.left_plate2);
		final ImageView left3 = (ImageView) findViewById(R.id.left_plate3);
		final ImageView left4 = (ImageView) findViewById(R.id.left_plate4);
		final ImageView left5 = (ImageView) findViewById(R.id.left_plate5);
		final ImageView left6 = (ImageView) findViewById(R.id.left_plate6);
		final ImageView left7 = (ImageView) findViewById(R.id.left_plate7);
		final ImageView left8 = (ImageView) findViewById(R.id.left_plate8);
		final ImageView left9 = (ImageView) findViewById(R.id.left_plate9);
		final ImageView left10 = (ImageView) findViewById(R.id.left_plate10);
		final ImageView right1 = (ImageView) findViewById(R.id.right_plate1);
		final ImageView right2 = (ImageView) findViewById(R.id.right_plate2);
		final ImageView right3 = (ImageView) findViewById(R.id.right_plate3);
		final ImageView right4 = (ImageView) findViewById(R.id.right_plate4);
		final ImageView right5 = (ImageView) findViewById(R.id.right_plate5);
		final ImageView right6 = (ImageView) findViewById(R.id.right_plate6);
		final ImageView right7 = (ImageView) findViewById(R.id.right_plate7);
		final ImageView right8 = (ImageView) findViewById(R.id.right_plate8);
		final ImageView right9 = (ImageView) findViewById(R.id.right_plate9);
		final ImageView right10 = (ImageView) findViewById(R.id.right_plate10);

		list.add(left1);
		list.add(left2);
		list.add(left3);
		list.add(left4);
		list.add(left5);
		list.add(left6);
		list.add(left7);
		list.add(left8);
		list.add(left9);
		list.add(left10);
		list.add(right1);
		list.add(right2);
		list.add(right3);
		list.add(right4);
		list.add(right5);
		list.add(right6);
		list.add(right7);
		list.add(right8);
		list.add(right9);
		list.add(right10);

		add100.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				if (plates < 10) {
					weight += 200;
					weightLabel.setText(Integer.toString(weight) + system);
					list.get(plates).setImageResource(R.drawable.plate_black);
					list.get(plates + 10).setImageResource(
							R.drawable.plate_black);
					list.get(plates).setVisibility(View.VISIBLE);
					list.get(plates + 10).setVisibility(View.VISIBLE);
				}
				plates++;
			}
		});
		add45.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				if (plates < 10) {
					weight += 90;
					weightLabel.setText(Integer.toString(weight) + system);
					list.get(plates).setImageResource(R.drawable.plate_red);
					list.get(plates + 10)
							.setImageResource(R.drawable.plate_red);
					list.get(plates).setVisibility(View.VISIBLE);
					list.get(plates + 10).setVisibility(View.VISIBLE);
				}
				plates++;
			}
		});
		add35.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				if (plates < 10) {
					weight += 70;
					weightLabel.setText(Integer.toString(weight) + system);
					list.get(plates).setImageResource(R.drawable.plate_blue);
					list.get(plates + 10).setImageResource(
							R.drawable.plate_blue);
					list.get(plates).setVisibility(View.VISIBLE);
					list.get(plates + 10).setVisibility(View.VISIBLE);
				}
				plates++;
			}
		});
		add25.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				if (plates < 10) {
					weight += 50;
					weightLabel.setText(Integer.toString(weight) + system);
					list.get(plates).setImageResource(R.drawable.plate_green);
					list.get(plates + 10).setImageResource(
							R.drawable.plate_green);
					list.get(plates).setVisibility(View.VISIBLE);
					list.get(plates + 10).setVisibility(View.VISIBLE);
				}
				plates++;
			}
		});
		add10.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				if (plates < 10) {
					weight += 20;
					weightLabel.setText(Integer.toString(weight) + system);
					list.get(plates).setImageResource(R.drawable.plate_yellow);
					list.get(plates + 10).setImageResource(
							R.drawable.plate_yellow);
					list.get(plates).setVisibility(View.VISIBLE);
					list.get(plates + 10).setVisibility(View.VISIBLE);
				}
				plates++;
			}
		});
		add5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				if (plates < 10) {
					weight += 10;
					weightLabel.setText(Integer.toString(weight) + system);
					list.get(plates).setImageResource(R.drawable.plate_pink);
					list.get(plates + 10).setImageResource(
							R.drawable.plate_pink);
					list.get(plates).setVisibility(View.VISIBLE);
					list.get(plates + 10).setVisibility(View.VISIBLE);
				}
				plates++;
			}
		});
		add2_5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				if (plates < 10) {
					weight += 5;
					weightLabel.setText(Integer.toString(weight) + system);
					list.get(plates).setImageResource(R.drawable.plate_orange);
					list.get(plates + 10).setImageResource(
							R.drawable.plate_orange);
					list.get(plates).setVisibility(View.VISIBLE);
					list.get(plates + 10).setVisibility(View.VISIBLE);
				}
				plates++;
			}
		});
		clear.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (metric == true) {
					weight = 20;
					weightLabel.setText(Integer.toString(weight) + system);
				} else {
					weight = 45;
					weightLabel.setText(Integer.toString(weight) + system);
				}

				for (int x = 0; x < list.size(); x++) {
					list.get(x).setVisibility(View.INVISIBLE);

				}
				plates = 0;
			}

		});

		pounds.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				if (metric == false) {

				} else {

					weight = ((int) (weight * 2.20462)) + 1;
					system = " lbs";
					weightLabel.setText(Integer.toString(weight) + system);
					add100.setText("100");
					add45.setText("45");
					add35.setText("35");
					add25.setText("25");
					add10.setText("10");
					add5.setText(" 5");
					add2_5.setText("2.5");
					metric = false;

				}

			}
		});

		kilograms.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				if (metric == true) {

				} else {
					weight = (int) (weight * .453592);
					system = " kgs";
					weightLabel.setText(Integer.toString(weight) + system);
					add100.setText("45");
					add45.setText("20");
					add35.setText("15");
					add25.setText("10");
					add10.setText("5");
					add5.setText("2.5");
					add2_5.setText("1.25");
					metric = true;

				}
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.visual_weights, menu);
		return true;
	}

}
