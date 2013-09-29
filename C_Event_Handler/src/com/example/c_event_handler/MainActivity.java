package com.example.c_event_handler;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.view.Menu;

public class MainActivity extends Activity {
	//定义周期性显示的图片的ID
	int[] imageIds = new int[]
	{ 
		R.drawable.java,
		R.drawable.ee,
		R.drawable.ajax,
		R.drawable.xml,
		R.drawable.classic		
	};
	int currentImageId = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ImageView show = (ImageView)findViewById(R.id.show);		
		final Handler myHandler = new Handler()
		{
			@Override
			public void handleMessage(Message msg)
			{
				//如果该消息是本程序所发送的
				if (msg.what == 0x1222)
				{
					//动态地修改所显示的图片
					show.setImageResource(imageIds[currentImageId++]);
					if (currentImageId >= 4)
					{
						currentImageId = 0; 
					}
				}
			}
		};
		//定义一个计时器，让该计时器周期性地执行指定任务
		new Timer().schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				//新启动的线程无法访问该Activity里的组件
				//所以需要通过Handler发送信息
				Message msg = new Message();
				msg.what = 0x1222;
				//发送消息
				myHandler.sendMessage(msg);
			}
		}, 0 , 2*1000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
