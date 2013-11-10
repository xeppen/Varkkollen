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
	Button timerButton;
	
	// Define running boolean for Chronometer
	static boolean isChronometerRunning = false;
	
	// Define list of Contractions
	List<Contraction> conts = new ArrayList<Contraction>();
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        
        // Assign elements
        contractionStartTime = (TextView) v.findViewById(R.id.contractionStartTime);
    	contractionStopTime = (TextView) v.findViewById(R.id.contractionStopTime);
    	timeSinceLastContraction = (TextView) v.findViewById(R.id.timeSinceLastContraction);
    	durationLastContraction = (TextView) v.findViewById(R.id.durationLastContraction);
    	timerButton = (Button) v.findViewById(R.id.timerButton);
    	contractionTimeChronometer = (Chronometer) v.findViewById(R.id.contractionTimeChronometer);
    	
    	addListeners();
    	
        return v;
    }

	private void addListeners() {
		
		// Button listener
		timerButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// OM chronometern inte körs så vill jag
				// Ändra utseende på knapp
				// Ändra text på knapp
				// Sätta boolean
				// Starta chronometern
				
				// OM chronometern körs så vill jag
				// Ändra utseendet på knapp
				// Ändra text på knapp
				// Ändra boolean
				// SToppa chronometern
				// Spara undan tiden i ett Contraction object
				
				if(isChronometerRunning){
					// Change text on button
					timerButton.setText(getResources().getString(R.string.timerStart));
					
					// Change appearance of button
					
					// Start the timer and reset
					contractionTimeChronometer.stop();
					
					// Set stop time
					String curTime = getCurrentTime();
					contractionStopTime.setText(curTime);
					
					// Set boolean
					isChronometerRunning = false;
				} else{
					// Change text on button
					timerButton.setText(getResources().getString(R.string.timerStop));
					
					// Change appearance of button
					
					// Set start time
					String curTime = getCurrentTime();
					contractionStartTime.setText(curTime);
					
					// Start the timer
					contractionTimeChronometer.setBase(SystemClock.elapsedRealtime());
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
	private void alert(String s){
		Toast.makeText(getActivity(),s, Toast.LENGTH_SHORT).show();
	}
}

