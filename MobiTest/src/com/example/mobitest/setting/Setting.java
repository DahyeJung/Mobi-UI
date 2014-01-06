package com.example.mobitest.setting;

import com.example.mobitest.Network;
import com.example.mobitest.R;
import com.example.mobitest.R.drawable;
import com.example.mobitest.R.id;
import com.example.mobitest.R.layout;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class Setting extends Activity{
	TextView setting;
	Typeface typeface;
	ImageButton backBtn;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.setting);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.setting_title);

		Network nw = new Network();
		typeface = nw.typeface;
		
		setting = (TextView)findViewById(R.id.setting);
		setting.setTypeface(typeface);

		backBtn = (ImageButton)findViewById(R.id.backBtn);
		backBtn.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					backBtn.setImageResource(R.drawable.back_arrow_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					backBtn.setImageResource(R.drawable.back_arrow);//버튼을 누르지 않을 때
				}
				
				return false;
			}
		});
		
	
	}
	
}