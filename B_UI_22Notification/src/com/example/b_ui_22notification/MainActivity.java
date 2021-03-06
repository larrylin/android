package com.example.b_ui_22notification;

import android.view.Menu;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	static final int NOTIFICATION_ID = 0x1123;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//获取应用界面中的Button对象
		Button bn = (Button) findViewById(R.id.bn);
		//为按钮的单击事件绑定事件监听器
		bn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				//创建一个启动其他Activity的Intent
				Intent intent = new Intent(MainActivity.this
					, OtherActivity.class);
				PendingIntent pi = PendingIntent.getActivity(MainActivity.this
					, 0, intent , 0);
				//创建一个Notification
				Notification notify = new Notification();
				//为Notification设置图标，该图标显示在状态栏
				notify.icon = R.drawable.notify;
				//为Notification设置文本内容，该文本会显示在状态栏
				notify.tickerText = "启动其他Activity的通知";
				//为Notification设置发送时间
				notify.when = System.currentTimeMillis();
				//为Notification设置声音
				notify.defaults = Notification.DEFAULT_SOUND;
				//为Notification设置默认声音、默认振动、默认闪光灯
				notify.defaults = Notification.DEFAULT_ALL;
				//设置事件信息
				notify.setLatestEventInfo(MainActivity.this, "普通通知",
					"点击查看", pi);
				//获取系统的NotificationManager服务
				NotificationManager notificationManager = (NotificationManager) 
					getSystemService(NOTIFICATION_SERVICE);
				//发送通知
				notificationManager.notify(NOTIFICATION_ID, notify);
			}
		});
		Button del = (Button)findViewById(R.id.del);
		del.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//获取系统的NotificationManager服务
				NotificationManager notificationManager = (NotificationManager) 
					getSystemService(NOTIFICATION_SERVICE);
				//取消通知
				notificationManager.cancel(NOTIFICATION_ID);
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
