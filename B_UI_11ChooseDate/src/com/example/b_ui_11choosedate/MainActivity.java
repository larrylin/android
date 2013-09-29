package com.example.b_ui_11choosedate;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.*;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker.OnTimeChangedListener;
public class MainActivity extends Activity {
	//�������¼��ǰʱ��ı���
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker);
		TimePicker timePicker = (TimePicker)findViewById(R.id.timePicker);
		//��ȡϵͳ��ǰ���� �� �� Сʱ ����
		Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		hour = c.get(Calendar.HOUR);
		minute = c.get(Calendar.MINUTE);
		
		//��ʼ��DatePicker�������ʼ��ʱָ��������
		datePicker.init(year, month, day,new OnDateChangedListener(){
			public void onDateChanged(DatePicker arg0,int year,int month,int day) {
				MainActivity.this.year = year;
				MainActivity.this.month = month;
				MainActivity.this.day = day;
				//��ʾ��ǰʱ��
				showDate(year,month,day,hour,minute);
			}
		});
		//Ϊtimepickerָ��������
		timePicker.setOnTimeChangedListener(new OnTimeChangedListener(){

			@Override
			public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
				// TODO Auto-generated method stub
				MainActivity.this.hour = arg1;
				MainActivity.this.minute = arg2;
				showDate(year,month,day,hour,minute);
			}
			
		});
	}
	
	private void showDate(int year,int month,int day,int hour,int minute) {
		EditText show = (EditText)findViewById(R.id.show);
		show.setText("�������ڣ�"+year+"-"+month+"-"+day+" "+hour+":"+minute);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
