package com.example.c_event_configuration;

import android.view.Menu;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText ori;
	EditText navigation;
	EditText touch;
	EditText mnc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//��ȡӦ�ý����еĽ������
		ori = (EditText)findViewById(R.id.ori);
		navigation = (EditText)findViewById(R.id.navigation);
		touch = (EditText)findViewById(R.id.touch);
		mnc = (EditText)findViewById(R.id.mnc);
		Button bn = (Button)findViewById(R.id.bn);
		bn.setOnClickListener(new OnClickListener()
		{
			//Ϊ��ť���¼�������
			@Override
			public void onClick(View source)
			{
				//��ȡϵͳ��Configuration����
				Configuration cfg = getResources().getConfiguration();
				String screen = cfg.orientation == 
					Configuration.ORIENTATION_LANDSCAPE ? "������Ļ": "������Ļ";
				String mncCode = cfg.mnc + "";
				String naviName = cfg.orientation == 
					Configuration.NAVIGATION_NONAV 
					? "û�з������" :
					cfg.orientation == Configuration.NAVIGATION_WHEEL 
					? "���ֿ��Ʒ���" :
					cfg.orientation == Configuration.NAVIGATION_DPAD
					? "��������Ʒ���" : "�켣����Ʒ���";
				navigation.setText(naviName);
				String touchName = cfg.touchscreen == Configuration.TOUCHSCREEN_NOTOUCH
					? "�޴�����" :
					cfg.touchscreen == Configuration.TOUCHSCREEN_STYLUS
					? "������ʽ������" : "������ָ�Ĵ�����";
				ori.setText(screen);
				mnc.setText(mncCode);
				touch.setText(touchName);
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
