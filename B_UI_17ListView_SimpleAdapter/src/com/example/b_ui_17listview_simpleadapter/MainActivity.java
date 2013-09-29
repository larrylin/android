package com.example.b_ui_17listview_simpleadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	private String[] names = new String[] {
			"��ͷ","Ū��","������","����"
	};
	private int[] imageIds = new int[]{
			R.drawable.tiger,
			R.drawable.nongyu,
			R.drawable.qingzhao,
			R.drawable.libai
	};
	private String[] titles = new String[] {
			"��ǣ���ӳ�","��ǣ���ӳ�ˣ��ǹ","һֱ��һֱ��һֱ��","��������Ҫ��0"
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//����һ��list���ϣ����ϵ�Ԫ����MAP
		List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
		for(int i=0; i<names.length; i++) {
			Map<String,Object> listItem = new HashMap<String,Object>();
			listItem.put("header", imageIds[i]);
			listItem.put("personName", names[i]);
			listItem.put("title", titles[i]);
			listItems.add(listItem);
		}
		//����һ��SimpleAdapter
		SimpleAdapter simpleAdapter = new SimpleAdapter(this
				,listItems
				,R.layout.activity_main
				,new String[]{"personName","header","title"}
				,new int[]{R.id.name,R.id.header,R.id.title}
		);
		ListView list = (ListView)findViewById(R.id.mylist);
		list.setAdapter(simpleAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
