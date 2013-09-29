package com.example.b_ui_10spinner;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	//����һ������������
	String[] str = new String[] {
			"��ǿ",
			"������",
			"o finding",
			"lander",
			"�Ϲ���"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		BaseAdapter ba = new BaseAdapter() {
			public int getCount() {
				return 5;
			}
			public Object getItem(int position) {
				return null;
			}
			public long getItemId(int position) {
				return 0;
			}
			/*@SuppressLint("ResourceAsColor")
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView text = new TextView(MainActivity.this);
				text.setText(position + "");
				text.setTextSize(20);
				text.setTextColor(R.color.red);
				return text;
			}*/
			//��д�÷������÷������ص�View����Ϊ�б���ÿ��
			@SuppressLint("ResourceAsColor")
			@Override
			public View getView(int position, View convertView, ViewGroup parent) 
			{
				//����һ��LinearLayout�������������2�����
				LinearLayout line = new LinearLayout(MainActivity.this);
				line.setOrientation(0);
				ImageView image = new ImageView(MainActivity.this);
				image.setImageResource(R.drawable.icon);
				TextView text = new TextView(MainActivity.this);
				text.setText(str[position] + "");
				text.setTextSize(20);
				text.setTextColor(R.color.red);
				line.addView(image);
				line.addView(text);
				//����LinearLayoutʵ��
				return line;
			}	
		};
		
		Spinner sp2 = (Spinner)findViewById(R.id.adspinners);
		sp2.setAdapter(ba);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
