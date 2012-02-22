package com.sst.school;

import android.app.Activity;
import android.os.Bundle;

public class wifi_Teacher_Attendence extends Activity {
	/** Called when the activity is first created. */
	protected boolean _active = true;
	protected int _splashTime = 1000; // time to display the splash screen in ms

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wifi_teacher_attendance);
	}
}