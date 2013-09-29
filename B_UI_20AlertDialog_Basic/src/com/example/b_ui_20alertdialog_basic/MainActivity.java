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
		//定义一个AlertDialog.Builder对象
		final Builder builder = new AlertDialog.Builder(this);
		//为按钮绑定事件监听器
		bn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				// 设置对话框的图标
				builder.setIcon(R.drawable.tools);
				// 设置对话框的标题
				builder.setTitle("自定义普通对话框");
				// 设置对话框显示的内容
				builder.setMessage("一个简单的提示对话框");
				// 为对话框设置一个“确定”按钮
				builder.setPositiveButton("确定"
					//为列表项的单击事件设置监听器
					, new OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog, int which)
						{
							EditText show = (EditText) findViewById(R.id.show);
							// 设置EditText内容
							show.setText("用户单击了“确定”按钮！");
						}
					});
				// 为对话框设置一个“取消”按钮
				builder.setNegativeButton("取消"
					,  new OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog, int which)
						{
							EditText show = (EditText) findViewById(R.id.show);
							// 设置EditText内容
							show.setText("用户单击了“取消”按钮！");
						}
					});
				//创建、并显示对话框
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
