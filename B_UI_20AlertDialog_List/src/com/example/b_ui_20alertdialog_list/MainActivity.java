package com.example.b_ui_20alertdialog_list;

import android.view.Menu;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bn = (Button)findViewById(R.id.bn);
		final Builder b = new AlertDialog.Builder(this);
		//为按钮绑定事件监听器
		bn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				//设置对话框的图标
				b.setIcon(R.drawable.tools);
				//设置对话框的标题
				b.setTitle("简单列表对话框");
				//为对话框设置多个列表
				b.setItems(
					new String[] {"红色" , "绿色" , "蓝色"}
					//为按钮设置监听器
					, new OnClickListener() 
					{
						//该方法的which参数代表用户单击了那个列表项
						@Override
						public void onClick(DialogInterface dialog
							, int which) 
						{
							TextView show = (TextView)findViewById(R.id.show);
							//which代表哪个列表项被单击了
							switch(which)
							{
								case 0:
									show.setBackgroundColor(Color.RED);
									break;
								case 1:
									show.setBackgroundColor(Color.GREEN);
									break;
								case 2:
									show.setBackgroundColor(Color.BLUE);
									break;								
							}					
						}
					});
				//创建、并显示对话框
				b.create().show();	
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
