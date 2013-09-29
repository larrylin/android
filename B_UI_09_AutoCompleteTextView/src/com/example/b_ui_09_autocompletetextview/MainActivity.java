package com.example.b_ui_09_autocompletetextview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {

	//�����ַ������飬��Ϊ��ʾ���ı�
	String[] books = new String[] {
		"java���˼��",
		"python�����̳�",
		"phpȨ�����",
		"mysqlȨ�����"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		//����һ��ArrayAdapter,��װ����
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line,books);
		AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.auto);
		//����adapter
		actv.setAdapter(aa);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
