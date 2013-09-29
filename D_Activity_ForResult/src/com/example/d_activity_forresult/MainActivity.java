package com.example.d_activity_forresult;

import android.os.Bundle;
import android.widget.*;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	EditText city;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//��ȡ�����ϵ����
		Button bn = (Button)findViewById(R.id.bn);
		city = (EditText)findViewById(R.id.city);
		//Ϊ��ť���¼�������
		bn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//������Ҫ��Ӧ��Ŀ���activity��intent
				Intent intent = new Intent(MainActivity.this,
						SelectCityActivity.class);
				//����ָ����activity���ȴ����صĽ��������0�������룬���ڱ�ʶ������
				startActivityForResult(intent, 0);
			}
			
		});
	}
	
	//��д�÷������÷����Իص��ķ�ʽ����ȡָ��activity���صĽ��
	@Override
	public void onActivityResult(int requestCode,int resultCode, Intent intent) {
		//��reqeustCode��resultCodeͬʱΪ0ʱ��Ҳ���Ǵ����ض��Ľ��
		if(requestCode==0 && resultCode == 0) {
			//ȡ��Intent���Extras����
			Bundle data = intent.getExtras();
			//ȡ��Bundle�е�����
			String resultCity = data.getString("city");
			//�޸�city�ı��������
			city.setText(resultCity);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
