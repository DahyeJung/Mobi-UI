package com.example.mobitest.setting;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mobitest.Network;
import com.example.mobitest.R;

public class ProgramInfo extends Activity{

	TextView title, tv1, tv2, tv3, tv4, tv5 ;
	Typeface typeface;
	ImageButton backBtn;
	Button button1, button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.program_info);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.program_info_title);

		Network nw = new Network();
		typeface = nw.typeface;

		title = (TextView)findViewById(R.id.programinfo);
		tv1 = (TextView)findViewById(R.id.textView1);
		tv2 = (TextView)findViewById(R.id.textView2);
		tv3 = (TextView)findViewById(R.id.textView3);
		tv4 = (TextView)findViewById(R.id.textView4);
		tv5 = (TextView)findViewById(R.id.textView5);
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);

		title.setTypeface(typeface);
		tv1.setTypeface(typeface);
		tv2.setTypeface(typeface);
		tv3.setTypeface(typeface);
		tv4.setTypeface(typeface);
		tv5.setTypeface(typeface);
		button1.setTypeface(typeface);
		button2.setTypeface(typeface);

		button1.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					backBtn.setImageResource(R.drawable.btn_app_info_update_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					backBtn.setImageResource(R.drawable.btn_app_info_update);//버튼을 누르지 않을 때
				}

				return false;
			}
		});

		button2.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					backBtn.setImageResource(R.drawable.btn_app_info_update_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					backBtn.setImageResource(R.drawable.btn_app_info_update);//버튼을 누르지 않을 때
				}

				return false;
			}
		});
	}

}
