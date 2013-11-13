package com.varkkollen;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.androidbegin.absfragmenttabs.R;

public class HomeFragment extends SherlockFragment {

	// Define Chronometer
	Chronometer contractionTimeChronometer;

	// Define TextViews
	TextView contractionStartTime;
	TextView contractionStopTime;
	TextView timeSinceLastContraction;
	TextView durationLastContraction;

	// Define Button
	Button timerStartButton;
	Button timerStopButton;

	// Define running boolean for Chronometer
	static boolean isChronometerRunning = false;

	// Define list of Contractions
	List<Contraction> conts = new ArrayList<Contraction>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_home, container, false);

		// Assign elements
		contractionStartTime = (TextView) v
				.findViewById(R.id.contractionStartTime);
		contractionStopTime = (TextView) v
				.findViewById(R.id.contractionStopTime);
		timeSinceLastContraction = (TextView) v
				.findViewById(R.id.timeSinceLastContraction);
		durationLastContraction = (TextView) v
				.findViewById(R.id.durationLastContraction);
		timerStartButton = (Button) v.findViewById(R.id.timerStartButton);
		timerStopButton = (Button) v.findViewById(R.id.timerStopButton);
		contractionTimeChronometer = (Chronometer) v
				.findViewById(R.id.contractionTimeChronometer);

		addListeners();

		return v;
	}

	private void addListeners() {

		// Start Button listener
		timerStartButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (!isChronometerRunning) {
					// Set start time
					String curTime = getCurrentTime();
					contractionStartTime.setText(curTime);

					// Start the timer
					contractionTimeChronometer.setBase(SystemClock
							.elapsedRealtime());
					contractionTimeChronometer.start();

					// Set boolean
					isChronometerRunning = true;
				}

			}

			private String getCurrentTime() {
				Time now = new Time(Time.getCurrentTimezone());
				now.setToNow();
				String time = now.format("%k:%M:%S");
				return time;
			}
		});

		// Start Button listener
		timerStopButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (!isChronometerRunning) {
					// Set start time
					String curTime = getCurrentTime();
					contractionStartTime.setText(curTime);

					// Start the timer
					contractionTimeChronometer.setBase(SystemClock
							.elapsedRealtime());
					contractionTimeChronometer.start();

					// Set boolean
					isChronometerRunning = true;
				}

			}

			private String getCurrentTime() {
				Time now = new Time(Time.getCurrentTimezone());
				now.setToNow();
				String time = now.format("%k:%M:%S");
				return time;
			}
		});

	}

	private void alert(String s) {
		Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
	}
}
