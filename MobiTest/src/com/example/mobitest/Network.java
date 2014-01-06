package com.example.mobitest;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Network extends Activity{
	
	Button cancel, refresh, save;
	TextView top, bottom;
	public Typeface typeface, typeface2;
	
	Login lg = new Login();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.network);
	
		typeface = Typeface.createFromAsset(getAssets(),"fonts/NanumGothicBold.ttf.mp3");
		typeface2 = Typeface.createFromAsset(getAssets(),"fonts/NanumGothic.ttf.mp3");
		
		top = (TextView)findViewById(R.id.textup);
		top.setTypeface(typeface);

		bottom = (TextView)findViewById(R.id.textdown);
		bottom.setTypeface(typeface);
		
		cancel = (Button)findViewById(R.id.cancel);
		refresh = (Button)findViewById(R.id.refresh);
		save = (Button)findViewById(R.id.save);
		
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				lg.ExitProcess();
			}
		});
		
		cancel.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					cancel.setBackgroundResource(R.drawable.network_error_btn_over);
				}
				if(event.getAction()==MotionEvent.ACTION_UP){
					cancel.setBackgroundResource(R.drawable.network_error_btn);//버튼을 누르지 않을 때
				}
				return false;
			}
		});

		refresh.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					cancel.setBackgroundResource(R.drawable.network_error_btn_over);
				}
				if(event.getAction()==MotionEvent.ACTION_UP){
					cancel.setBackgroundResource(R.drawable.network_error_btn);//버튼을 누르지 않을 때
				}
				return false;
			}
		});
		
		save.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					cancel.setBackgroundResource(R.drawable.network_error_btn_over);
				}
				if(event.getAction()==MotionEvent.ACTION_UP){
					cancel.setBackgroundResource(R.drawable.network_error_btn);//버튼을 누르지 않을 때
				}

				
				return false;
			}
		});
		
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//저장웹툰 페이지
			}
		});
	}//onCreate
	
}
