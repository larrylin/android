package com.example.f_io_sharedpreferences;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity {

	SharedPreferences preferences;
	SharedPreferences.Editor editor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//获取只能被本应用程序读、写的SharedPreferences对象
		preferences = getSharedPreferences("larrylin",MODE_PRIVATE);
		editor = preferences.edit();
		Button read = (Button)findViewById(R.id.btn1);
		Button write = (Button)findViewById(R.id.btn2);
		read.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//读取字符串数据
				String time = preferences.getString("time", null);
				//读取int类型的数据
				int randNum = preferences.getInt("random",0);
				String result = time == null ? "还没有写入数据"
						: "写入时间为： " + time
						+ "\n上次生成的随机数为：" + randNum;
				//使用Toast提示信息
				Toast.makeText(MainActivity.this, result, 3000).show();
			}
		});
		
		write.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日"+"hh::mm:ss");
				//存入当前时间
				editor.putString("time", sdf.format(new Date()));
				//存入随机数
				editor.putInt("randNum", (int)(Math.random() * 100));
				//提交所有存入的数据
				editor.commit();
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
