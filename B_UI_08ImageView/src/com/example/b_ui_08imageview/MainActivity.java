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

	//定义一个访问图片的数组
	int[] images = new int[]{
		R.drawable.lijiang,
		R.drawable.qiao,
		R.drawable.shuangta,
		R.drawable.shui,
		R.drawable.xiangbi
	};
	//定义默认显示的图片
	int currentImg = 2;
	//定义图片的初始透明度
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
		//定义查看下一张图片的监听器
		next.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(currentImg >= 4) {
					currentImg = -1;
				}
				BitmapDrawable bitmapDrawable = (BitmapDrawable) img1.getDrawable();
				//如果图片还未回收，先强制回收该图片
				if(!bitmapDrawable.getBitmap().isRecycled()) {
					bitmapDrawable.getBitmap().recycle();
				}
				//改变imageView显示的图片
				img1.setImageBitmap(BitmapFactory.decodeResource(getResources(),images[++currentImg]));
			}
		});
		//定义查看上一张图片的监听器
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
		//定义改变图片透明度的方法
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
		//为两个按钮添加监听
		plus.setOnClickListener(listener);
		minus.setOnClickListener(listener);
		
		img1.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				BitmapDrawable bitmapDrawable = (BitmapDrawable) img1.getDrawable();
				//获取第一张图片显示框中的位图
				Bitmap bitmap = bitmapDrawable.getBitmap();
				//bitmap 图片实际大小与第一个imageView的缩放比例
				double scale = bitmap.getWidth() / 320.0;
				//获取需要显示的图片的开始点
				int x = (int) (arg1.getX() * scale);
				int y = (int) (arg1.getY() * scale);
				if(x + 120 > bitmap.getWidth()) {
					x = bitmap.getWidth() - 120;
				}
				if(y + 120 > bitmap.getHeight()) {
					y = bitmap.getHeight() - 120;
				}
				//显示图片的指定区域
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
