package com.example.d_activity_lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.Menu;

public class MainActivity extends Activity {

	final String TAG = "--CrazyIt--";
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//�����־
		Log.d(TAG , "-------onCreate------");		
		Button bn = (Button)findViewById(R.id.bn);
		//Ϊbn��ť���¼�������
		bn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				//������Activity
				MainActivity.this.finish();
			}			
		});
	}
	@Override
	public void onStart() 
	{
		super.onStart();
		//�����־
		Log.d(TAG , "-------onStart------");
	}
	@Override
	public void onRestart() 
	{
		super.onRestart();
		//�����־
		Log.d(TAG , "-------onRestart------");		
	}
	@Override
	public void onResume() 
	{
		super.onResume();
		//�����־
		Log.d(TAG , "-------onResume------");		
	}
	@Override
	public void onPause() 
	{
		super.onPause();
		//�����־
		Log.d(TAG , "-------onPause------");		
	}
	@Override
	public void onStop() 
	{
		super.onStop();
		//�����־
		Log.d(TAG , "-------onStop------");		
	}
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		//�����־
		Log.d(TAG , "-------onDestroy------");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
