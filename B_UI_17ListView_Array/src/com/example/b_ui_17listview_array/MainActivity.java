package com.example.b_ui_17listview_array;

import android.os.Bundle;
import android.widget.*;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{   
		super.onCreate(savedInstanceState);   
		setContentView(R.layout.activity_main);   
		ListView list2 = (ListView)findViewById(R.id.list2);
		//定义一个数组
		String[] arr ={"孙悟空" , "猪八戒" , "牛魔王"};
		//将数组包装ArrayAdapter
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
			this , android.R.layout.simple_list_item_1 , arr);
		//为ListView设置Adapter
		list2.setAdapter(arrayAdapter);	
	}  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
