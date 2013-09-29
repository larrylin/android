package com.example.b_ui_20alertdialog_basic;

import android.view.Menu;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bn = (Button)findViewById(R.id.btn1);
		//����һ��AlertDialog.Builder����
		final Builder builder = new AlertDialog.Builder(this);
		//Ϊ��ť���¼�������
		bn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				// ���öԻ����ͼ��
				builder.setIcon(R.drawable.tools);
				// ���öԻ���ı���
				builder.setTitle("�Զ�����ͨ�Ի���");
				// ���öԻ�����ʾ������
				builder.setMessage("һ���򵥵���ʾ�Ի���");
				// Ϊ�Ի�������һ����ȷ������ť
				builder.setPositiveButton("ȷ��"
					//Ϊ�б���ĵ����¼����ü�����
					, new OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog, int which)
						{
							EditText show = (EditText) findViewById(R.id.show);
							// ����EditText����
							show.setText("�û������ˡ�ȷ������ť��");
						}
					});
				// Ϊ�Ի�������һ����ȡ������ť
				builder.setNegativeButton("ȡ��"
					,  new OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog, int which)
						{
							EditText show = (EditText) findViewById(R.id.show);
							// ����EditText����
							show.setText("�û������ˡ�ȡ������ť��");
						}
					});
				//����������ʾ�Ի���
				builder.create().show();
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
