package com.example.d_activity_otheractivity;

import android.os.Bundle;
import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class MainActivity extends LauncherActivity {
	//��������Activity������
	String[] names = {"���ó������","�鿴�Ǽʱ���"};
	//��������Activity��Ӧ��ʵ����
	Class<?>[] clazzs = {PreferenceActivityTest.class,
			ExpandableListActivityTest.class};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,names);
		//���øô�����ʾ���б������Adapter
		setListAdapter(adapter);
	}
	
	//�����б����ָ��Activity��Ӧ��Intent
	public Intent intentForPosition(int position) {
		return new Intent(MainActivity.this,clazzs[position]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
