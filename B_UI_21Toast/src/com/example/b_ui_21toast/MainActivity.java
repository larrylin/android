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
		//为按钮的单击事件绑定事件监听器
		simple.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				//创建一个Toast提示信息
				Toast toast = Toast.makeText(MainActivity.this
					, "简单的提示信息"
					// 设置该Toast提示信息的持续时间
					, Toast.LENGTH_SHORT);
				toast.show();
			}
		});
		Button bn = (Button)findViewById(R.id.bn);
		//为按钮的单击事件绑定事件监听器
		bn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				//创建一个Toast提示信息
				Toast toast = Toast.makeText(MainActivity.this
					, "带图片的的提示信息"
					// 设置该Toast提示信息的持续时间
					, Toast.LENGTH_LONG);				
				toast.setGravity(Gravity.CENTER, 0, 0);
				//获取Toast提示里原有的View
				View toastView = toast.getView();
				//创建一个ImageView
				ImageView image = new ImageView(MainActivity.this);
				image.setImageResource(R.drawable.tools);
				//创建一个LinearLayout容器
				LinearLayout ll = new LinearLayout(MainActivity.this);
				//向LinearLayout中添加图片、原有的View
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
