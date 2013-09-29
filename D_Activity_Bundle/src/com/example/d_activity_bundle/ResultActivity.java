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
		//��ȡ������Result��Intent
		Intent intent = getIntent();
		//��ȡ��intent��Я��������
		Bundle data = intent.getExtras();
		//��Bundle���ݰ���ȡ������
		Person p = (Person)data.getSerializable("person");
		name.setText("�����û���Ϊ��" + p.getName());
		passwd.setText("��������Ϊ��" + p.getPass());
		gender.setText("�����Ա�Ϊ��" + p.getGender());
	}
}
