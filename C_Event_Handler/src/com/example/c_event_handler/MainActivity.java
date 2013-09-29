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
	//������������ʾ��ͼƬ��ID
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
				//�������Ϣ�Ǳ����������͵�
				if (msg.what == 0x1222)
				{
					//��̬���޸�����ʾ��ͼƬ
					show.setImageResource(imageIds[currentImageId++]);
					if (currentImageId >= 4)
					{
						currentImageId = 0; 
					}
				}
			}
		};
		//����һ����ʱ�����øü�ʱ�������Ե�ִ��ָ������
		new Timer().schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				//���������߳��޷����ʸ�Activity������
				//������Ҫͨ��Handler������Ϣ
				Message msg = new Message();
				msg.what = 0x1222;
				//������Ϣ
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
