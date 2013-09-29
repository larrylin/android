package com.example.d_activity_bundle;

import com.example.d_activity_bundle.bean.Person;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bn = (Button)findViewById(R.id.bn);
		//为注册按钮绑定监听事件
		bn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText name = (EditText)findViewById(R.id.name);
				EditText passwd = (EditText)findViewById(R.id.passwd);
				RadioButton male = (RadioButton)findViewById(R.id.male);
				String gender = male.isChecked() ? "男" : "女";
				Person p = new Person(name.getText().toString(),
						passwd.getText().toString(),gender);
				//创建一个Bundle对象
				Bundle data = new Bundle();
				data.putSerializable("person",p);
				//创建一个intent
				Intent intent = new Intent(MainActivity.this,
						ResultActivity.class);
				intent.putExtras(data);
				//启动intent对应的activity
				startActivity(intent);
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
