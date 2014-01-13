package com.example.mobitest.view;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mobitest.R;
import com.example.mobitest.main.Main;

public class View extends ListActivity{

	String [] title = {
			"81화 충돌",
			"80화 전야"
	};
	
	String [] date = {
			"2013.07.12",
			"2013.06.27"
	};
	
	String [] num = {
			"9.6",
			"9,5"
	};
	
	TextView title_tv, date_tv;
	Button tag1, tag2, tag3;
	ImageButton backBtn, favorBtn, alarmBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.view);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.view_title);
		
		title_tv = (TextView)findViewById(R.id.textView1);
		date_tv = (TextView)findViewById(R.id.textView2);
		tag1 = (Button)findViewById(R.id.button1);
		tag2 = (Button)findViewById(R.id.button2);
		tag3 = (Button)findViewById(R.id.button3);
		backBtn = (ImageButton)findViewById(R.id.backBtn);
		favorBtn = (ImageButton)findViewById(R.id.favorBtn);
		alarmBtn = (ImageButton)findViewById(R.id.alarmBtn);
		
		backBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(android.view.View v) {

				Intent intent = new Intent(View.this, Main.class);
				startActivity(intent);
				
			}
		});
		
		favorBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(android.view.View v) {
				// TODO Auto-generated method stub
				
			}
		});
		ViewArray adapter = new ViewArray(this, title, date);
		setListAdapter(adapter);
		
	}
}
