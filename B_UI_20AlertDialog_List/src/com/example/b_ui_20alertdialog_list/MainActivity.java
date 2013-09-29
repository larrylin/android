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
		//Ϊ��ť���¼�������
		bn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				//���öԻ����ͼ��
				b.setIcon(R.drawable.tools);
				//���öԻ���ı���
				b.setTitle("���б�Ի���");
				//Ϊ�Ի������ö���б�
				b.setItems(
					new String[] {"��ɫ" , "��ɫ" , "��ɫ"}
					//Ϊ��ť���ü�����
					, new OnClickListener() 
					{
						//�÷�����which���������û��������Ǹ��б���
						@Override
						public void onClick(DialogInterface dialog
							, int which) 
						{
							TextView show = (TextView)findViewById(R.id.show);
							//which�����ĸ��б��������
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
				//����������ʾ�Ի���
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
