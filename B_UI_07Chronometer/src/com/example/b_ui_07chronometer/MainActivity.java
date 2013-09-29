package com.example.b_ui_07chronometer;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button start = (Button)findViewById(R.id.start);
		Button stop  = (Button)findViewById(R.id.stop);
		final Chronometer ch = (Chronometer)findViewById(R.id.chronometer);
		
		start.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				ch.setBase(SystemClock.elapsedRealtime());
				ch.start();
			}
		});
		
		stop.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				ch.stop();
			}
		});
		
		ch.setOnChronometerTickListener(new OnChronometerTickListener(){

			@Override
			public void onChronometerTick(Chronometer arg0) {
				// TODO Auto-generated method stub
				//´óÓÚ20SÔòÍ£Ö¹
				if(SystemClock.elapsedRealtime() - ch.getBase() > 20 * 1000) {
					ch.stop();
				}
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
