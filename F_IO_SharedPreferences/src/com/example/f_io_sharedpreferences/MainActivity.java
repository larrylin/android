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
		//��ȡֻ�ܱ���Ӧ�ó������д��SharedPreferences����
		preferences = getSharedPreferences("larrylin",MODE_PRIVATE);
		editor = preferences.edit();
		Button read = (Button)findViewById(R.id.btn1);
		Button write = (Button)findViewById(R.id.btn2);
		read.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//��ȡ�ַ�������
				String time = preferences.getString("time", null);
				//��ȡint���͵�����
				int randNum = preferences.getInt("random",0);
				String result = time == null ? "��û��д������"
						: "д��ʱ��Ϊ�� " + time
						+ "\n�ϴ����ɵ������Ϊ��" + randNum;
				//ʹ��Toast��ʾ��Ϣ
				Toast.makeText(MainActivity.this, result, 3000).show();
			}
		});
		
		write.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��"+"hh::mm:ss");
				//���뵱ǰʱ��
				editor.putString("time", sdf.format(new Date()));
				//���������
				editor.putInt("randNum", (int)(Math.random() * 100));
				//�ύ���д��������
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
