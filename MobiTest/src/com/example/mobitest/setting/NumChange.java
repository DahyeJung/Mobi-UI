package com.example.mobitest.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mobitest.Network;
import com.example.mobitest.R;

public class NumChange extends Activity{

	Typeface typeface;
	TextView tv1, tv2, title;
	Button ok;
	ImageButton backBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.num_change);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.num_change_title);

		Network nw = new Network();

		typeface = nw.typeface;

		title = (TextView)findViewById(R.id.changenum);
		tv1 = (TextView)findViewById(R.id.textView1);
		tv2 = (TextView)findViewById(R.id.textView2);
		ok = (Button)findViewById(R.id.ok);
		backBtn = (ImageButton)findViewById(R.id.backBtn);
		
		
		tv1.setTypeface(typeface);
		tv2.setTypeface(typeface);
		ok.setTypeface(typeface);
		title.setTypeface(typeface);


		//완료 버튼
		ok.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					ok.setBackgroundResource(R.drawable.login_btn_bg_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					ok.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
				}

				return false;
			}
		});
		ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(NumChange.this,MyInform.class);
				startActivity(intent);
			}
		});

		//이전 버튼
		backBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(NumChange.this,MyInform.class);
				startActivity(intent);
			}
		});

	}

}
