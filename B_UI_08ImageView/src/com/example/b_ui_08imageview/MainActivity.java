package com.example.b_ui_08imageview;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	//����һ������ͼƬ������
	int[] images = new int[]{
		R.drawable.lijiang,
		R.drawable.qiao,
		R.drawable.shuangta,
		R.drawable.shui,
		R.drawable.xiangbi
	};
	//����Ĭ����ʾ��ͼƬ
	int currentImg = 2;
	//����ͼƬ�ĳ�ʼ͸����
	private int alpha = 255;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button plus = (Button)findViewById(R.id.plus);
		final Button minus = (Button)findViewById(R.id.minus);
		final ImageView img1  = (ImageView)findViewById(R.id.image1);
		final ImageView img2 = (ImageView)findViewById(R.id.image2);
		final Button prev = (Button)findViewById(R.id.prev);
		final Button next = (Button)findViewById(R.id.next);
		//����鿴��һ��ͼƬ�ļ�����
		next.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(currentImg >= 4) {
					currentImg = -1;
				}
				BitmapDrawable bitmapDrawable = (BitmapDrawable) img1.getDrawable();
				//���ͼƬ��δ���գ���ǿ�ƻ��ո�ͼƬ
				if(!bitmapDrawable.getBitmap().isRecycled()) {
					bitmapDrawable.getBitmap().recycle();
				}
				//�ı�imageView��ʾ��ͼƬ
				img1.setImageBitmap(BitmapFactory.decodeResource(getResources(),images[++currentImg]));
			}
		});
		//����鿴��һ��ͼƬ�ļ�����
		prev.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(currentImg <= 0) {
					currentImg = 4;
				}
				BitmapDrawable bd = (BitmapDrawable)img1.getDrawable();
				if(!bd.getBitmap().isRecycled()) {
					bd.getBitmap().recycle();
				}
				img1.setImageBitmap(BitmapFactory.decodeResource(getResources(), images[--currentImg]));
			}
		});
		//����ı�ͼƬ͸���ȵķ���
		OnClickListener listener = new OnClickListener() {
			public void onClick(View v) {
				if(v == plus) {
					alpha += 20;
				}
				if(v == minus) {
					alpha -= 20;
				}
				if(alpha >= 255) {
					alpha = 255;
				}
				if(alpha <= 0) {
					alpha = 0;
				}
				img1.setAlpha(alpha);
			}
		};
		//Ϊ������ť��Ӽ���
		plus.setOnClickListener(listener);
		minus.setOnClickListener(listener);
		
		img1.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				BitmapDrawable bitmapDrawable = (BitmapDrawable) img1.getDrawable();
				//��ȡ��һ��ͼƬ��ʾ���е�λͼ
				Bitmap bitmap = bitmapDrawable.getBitmap();
				//bitmap ͼƬʵ�ʴ�С���һ��imageView�����ű���
				double scale = bitmap.getWidth() / 320.0;
				//��ȡ��Ҫ��ʾ��ͼƬ�Ŀ�ʼ��
				int x = (int) (arg1.getX() * scale);
				int y = (int) (arg1.getY() * scale);
				if(x + 120 > bitmap.getWidth()) {
					x = bitmap.getWidth() - 120;
				}
				if(y + 120 > bitmap.getHeight()) {
					y = bitmap.getHeight() - 120;
				}
				//��ʾͼƬ��ָ������
				img2.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
				img2.setAlpha(alpha);
				return false;
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
