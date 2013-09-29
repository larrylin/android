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
		//设置使用TabHost布局
		LayoutInflater.from(this).inflate(
				R.layout.activity_main, tabHost.getTabContentView(),true);
		//添加第一个标签页
		tabHost.addTab(tabHost.newTabSpec("tab1")
				.setIndicator("已接电话")
				.setContent(R.id.tab01));
		//添加第二个标签页
		tabHost.addTab(tabHost.newTabSpec("tab2")
				//在标签标题上放置图标
				.setIndicator("呼出电话",getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.tab02));
		//添加第三个标签页
		tabHost.addTab(tabHost.newTabSpec("tab3")
				.setIndicator("未接电话")
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
