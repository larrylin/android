package com.example.c_event_configuration_change;

import android.view.Menu;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bn = (Button)findViewById(R.id.bn);
		//Ϊ��ť���¼�������
		bn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				Configuration config = getResources().getConfiguration();
				//�����ǰ�Ǻ���
				if (config.orientation 
					== Configuration.ORIENTATION_LANDSCAPE)
				{
					//��Ϊ����
					MainActivity.this.setRequestedOrientation(
						ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
				}
				//�����ǰ������
				if (config.orientation 
					== Configuration.ORIENTATION_PORTRAIT)
				{
					//��Ϊ����
					MainActivity.this.setRequestedOrientation(
						ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );
				}			
			}
		});		
	}
	
	//��д�÷��������ڼ���ϵͳ���õĸ��ģ���Ҫ�Ǽ����Ļ����ĸ���
	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		String screen = newConfig.orientation == 
			Configuration.ORIENTATION_LANDSCAPE ? "������Ļ": "������Ļ";
		Toast.makeText(this, "ϵͳ����Ļ�������ı�"
			+ "\n�޸ĺ����Ļ����Ϊ��" + screen
			, Toast.LENGTH_LONG)
			.show();		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
