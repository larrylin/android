package com.example.e_intent_dataattr;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bn = (Button)findViewById(R.id.bn);
		//Ϊbn��ť���һ��������
		bn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//����Intent
				Intent intent = new Intent();
				String data = "http://www.qq.org";
				//����ָ���ַ���������Uri����
				Uri uri = Uri.parse(data);
				//ΪIntent����Action����
				intent.setAction(Intent.ACTION_VIEW);
				//����Data����
				intent.setData(uri);
				startActivity(intent);
			}
		});
		
		Button edit = (Button)findViewById(R.id.edit);
		//Ϊedit��ť���һ��������
		edit.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//����Intent
				Intent intent = new Intent();
				//ΪIntent����Action���ԣ�����Ϊ���༭��
				intent.setAction(Intent.ACTION_EDIT);
				String data = "content://com.android.contacts/contacts/1";
				//����ָ���ַ���������Uri����
				Uri uri = Uri.parse(data);				
				//����Data����
				intent.setData(uri);
				startActivity(intent);
			}
		});	
		Button call = (Button)findViewById(R.id.call);
		//Ϊedit��ť���һ��������
		call.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//����Intent
				Intent intent = new Intent();
				//ΪIntent����Action���ԣ�����Ϊ�����ţ�
				intent.setAction(Intent.ACTION_DIAL);
				String data = "tel:13800138000";
				//����ָ���ַ���������Uri����
				Uri uri = Uri.parse(data);				
				//����Data����
				intent.setData(uri);
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
