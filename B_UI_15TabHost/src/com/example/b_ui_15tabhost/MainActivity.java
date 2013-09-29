package com.example.b_ui_15tabhost;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TabHost tabHost = getTabHost();
		//����ʹ��TabHost����
		LayoutInflater.from(this).inflate(
				R.layout.activity_main, tabHost.getTabContentView(),true);
		//��ӵ�һ����ǩҳ
		tabHost.addTab(tabHost.newTabSpec("tab1")
				.setIndicator("�ѽӵ绰")
				.setContent(R.id.tab01));
		//��ӵڶ�����ǩҳ
		tabHost.addTab(tabHost.newTabSpec("tab2")
				//�ڱ�ǩ�����Ϸ���ͼ��
				.setIndicator("�����绰",getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.tab02));
		//��ӵ�������ǩҳ
		tabHost.addTab(tabHost.newTabSpec("tab3")
				.setIndicator("δ�ӵ绰")
				.setContent(R.id.tab03)
				);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
