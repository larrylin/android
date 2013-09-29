package com.example.e_intent_actionattr;

import android.app.Activity;
import android.content.Intent;
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
		//Ϊbn��ť���¼�������
		bn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				//����Intent����
				Intent intent = new Intent();
				//ΪIntent����Action���ԣ�����ֵ����һ����ͨ�ַ�����
				//intent.setAction(ActionAttr.CRAZYIT_ACTION);
				intent.setAction("helloWorld");
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
