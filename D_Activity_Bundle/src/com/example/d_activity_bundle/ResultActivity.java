/**
 * 
 */
package com.example.d_activity_bundle;

import com.example.d_activity_bundle.bean.Person;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		TextView name = (TextView)findViewById(R.id.name);
		TextView passwd = (TextView)findViewById(R.id.passwd);
		TextView gender = (TextView)findViewById(R.id.gender);
		//获取启动该Result的Intent
		Intent intent = getIntent();
		//获取该intent所携带的数据
		Bundle data = intent.getExtras();
		//从Bundle数据包中取出数据
		Person p = (Person)data.getSerializable("person");
		name.setText("您的用户名为：" + p.getName());
		passwd.setText("您的密码为：" + p.getPass());
		gender.setText("您的性别为：" + p.getGender());
	}
}
