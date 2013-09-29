package com.example.b_ui_09_autocompletetextview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {

	//定义字符串数组，作为提示的文本
	String[] books = new String[] {
		"java编程思想",
		"python基础教程",
		"php权威编程",
		"mysql权威编程"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		//创建一个ArrayAdapter,封装数组
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line,books);
		AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.auto);
		//设置adapter
		actv.setAdapter(aa);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
