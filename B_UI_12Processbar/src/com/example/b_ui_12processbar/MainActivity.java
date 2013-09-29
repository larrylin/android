package com.example.b_ui_12processbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.widget.*;
public class MainActivity extends Activity {
	//�ó���ģ����䳤��Ϊ100������
	private int[] data = new int[100];
	int hasData = 0;
	//��¼progress����ɽ���
	int mProgressStatus = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ProgressBar bar = (ProgressBar)findViewById(R.id.bar);
		final ProgressBar bar2 = (ProgressBar)findViewById(R.id.bar2);
		//����һ��������½��ȵ�Handler
		final Handler mHandler = new Handler() {
			public void handleMessage(Message msg) {
				if(msg.what == 1) {
					bar.setProgress(mProgressStatus);
					bar2.setProgress(mProgressStatus);
				}
			}
		};
		//�����ߺ���ִ������
		new Thread(){
			public void run() {
				while(mProgressStatus < 100 ) {
					//��ȡ��ʱ��������ɰٷֱ�
					mProgressStatus = doWork();
					//������Ϣ��Handler
					Message m = new Message();
					m.what = 1;
					mHandler.sendMessage(m);
				}
			}
		}.start();
	}
	
	//ģ��һ����ʱ����
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
