package com.example.b_ui_12processbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.widget.*;
public class MainActivity extends Activity {
	//该程序模拟填充长度为100的数组
	private int[] data = new int[100];
	int hasData = 0;
	//记录progress的完成进度
	int mProgressStatus = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ProgressBar bar = (ProgressBar)findViewById(R.id.bar);
		final ProgressBar bar2 = (ProgressBar)findViewById(R.id.bar2);
		//创建一个负责更新进度的Handler
		final Handler mHandler = new Handler() {
			public void handleMessage(Message msg) {
				if(msg.what == 1) {
					bar.setProgress(mProgressStatus);
					bar2.setProgress(mProgressStatus);
				}
			}
		};
		//启动线和来执行任务
		new Thread(){
			public void run() {
				while(mProgressStatus < 100 ) {
					//获取耗时操作的完成百分比
					mProgressStatus = doWork();
					//发送消息到Handler
					Message m = new Message();
					m.what = 1;
					mHandler.sendMessage(m);
				}
			}
		}.start();
	}
	
	//模拟一个耗时操作
	public int doWork() {
		data[hasData++] = (int)(Math.random() * 100);
		try{
			Thread.sleep(100);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return hasData;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
