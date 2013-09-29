package com.example.a_layout_framelayout;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private int currentColor = 0; //定义一个变量来控制当前颜色
	//所有颜色
	final int[] colors = new int[] {
			R.color.color1,
			R.color.color2,
			R.color.color3,
			R.color.color4,
			R.color.color5,
			R.color.color6,
			R.color.color7
	};
	//组件
	final int[] names = new int[] {
			R.id.view01,
			R.id.view02,
			R.id.view03,
			R.id.view04,
			R.id.view05,
			R.id.view06,
			R.id.view07
	};
	TextView[] views = new TextView[7];
	@SuppressLint("HandlerLeak")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		for(int i=0; i<7; i++) {
			views[i] = (TextView)findViewById(names[i]);
		}
		
		final Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				if(msg.what == 0x1122) {
					//依次改变7个TextView的背景色
					for(int i=0; i<7-currentColor; i++) {
						views[i].setBackgroundResource(colors[i]+currentColor);
					}
					for(int i=7-currentColor,j=0; i<7; i++ , j++){
						views[i].setBackgroundResource(colors[j]);
					}
				}
				super.handleMessage(msg);
			}
		};
		
		//定义一个线程周期性的改变currentColor变量值
		new Timer().schedule(new TimerTask() {
			public void run() {
				currentColor++;
				if(currentColor >= 6) {
					currentColor = 0;
				}
				//发送一条消息通知系统改变7个TextView组件的背景色
				Message m = new Message();
				//给消息一个标识
				m.what = 0x1122;
				handler.sendMessage(m);
			}
		},0,100);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
