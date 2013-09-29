package com.example.d_activity_forresult;

import android.os.Bundle;
import android.widget.*;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	EditText city;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//获取界面上的组件
		Button bn = (Button)findViewById(R.id.bn);
		city = (EditText)findViewById(R.id.city);
		//为按钮绑定事件监听器
		bn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//创建需要对应于目标的activity的intent
				Intent intent = new Intent(MainActivity.this,
						SelectCityActivity.class);
				//启动指定的activity并等待返回的结果，其中0是请求码，用于标识该请求
				startActivityForResult(intent, 0);
			}
			
		});
	}
	
	//重写该方法，该方法以回调的方式来获取指定activity返回的结果
	@Override
	public void onActivityResult(int requestCode,int resultCode, Intent intent) {
		//当reqeustCode、resultCode同时为0时，也就是处理特定的结果
		if(requestCode==0 && resultCode == 0) {
			//取出Intent里的Extras数据
			Bundle data = intent.getExtras();
			//取出Bundle中的数据
			String resultCity = data.getString("city");
			//修改city文本框的内容
			city.setText(resultCity);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
