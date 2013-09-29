package com.example.e_intent_tab;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.view.Menu;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TabHost tabHost = getTabHost();
		//使用Intent添加第一个Tab页面
		tabHost.addTab(tabHost.newTabSpec("tab1")
			.setIndicator("已接电话"
				, getResources().getDrawable(R.drawable.ic_launcher))
			.setContent(new Intent(this, BeCalledActivity.class)));
		//使用Intent添加第二个Tab页面
		tabHost.addTab(tabHost.newTabSpec("tab1")
			.setIndicator("呼出电话")
			.setContent(new Intent(this, CalledActivity.class)));
		//使用Intent添加第三个Tab页面
		tabHost.addTab(tabHost.newTabSpec("tab1")
			.setIndicator("未接电话")
			.setContent(new Intent(this, NoCallActivity.class)));		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
