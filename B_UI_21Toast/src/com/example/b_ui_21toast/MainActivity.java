package com.example.b_ui_21toast;

import android.view.Menu;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button simple = (Button)findViewById(R.id.simple);
		//Ϊ��ť�ĵ����¼����¼�������
		simple.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				//����һ��Toast��ʾ��Ϣ
				Toast toast = Toast.makeText(MainActivity.this
					, "�򵥵���ʾ��Ϣ"
					// ���ø�Toast��ʾ��Ϣ�ĳ���ʱ��
					, Toast.LENGTH_SHORT);
				toast.show();
			}
		});
		Button bn = (Button)findViewById(R.id.bn);
		//Ϊ��ť�ĵ����¼����¼�������
		bn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				//����һ��Toast��ʾ��Ϣ
				Toast toast = Toast.makeText(MainActivity.this
					, "��ͼƬ�ĵ���ʾ��Ϣ"
					// ���ø�Toast��ʾ��Ϣ�ĳ���ʱ��
					, Toast.LENGTH_LONG);				
				toast.setGravity(Gravity.CENTER, 0, 0);
				//��ȡToast��ʾ��ԭ�е�View
				View toastView = toast.getView();
				//����һ��ImageView
				ImageView image = new ImageView(MainActivity.this);
				image.setImageResource(R.drawable.tools);
				//����һ��LinearLayout����
				LinearLayout ll = new LinearLayout(MainActivity.this);
				//��LinearLayout�����ͼƬ��ԭ�е�View
				ll.addView(image);
				ll.addView(toastView);
				toast.setView(ll);
				toast.show();				
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
