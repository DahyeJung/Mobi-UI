package com.example.mobitest.setting;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mobitest.Network;
import com.example.mobitest.R;

public class webtoon_update extends Activity{
	
	
	TextView title, tv1, tv2, tv3;
	Typeface typeface, typeface2;
	ImageButton backBtn, check;
	
	private boolean ImageTouched = false;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.webtoon_update_more);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.webtoon_update_title);
		
		Network nw = new Network();
		typeface = nw.typeface;
		typeface2 = nw.typeface2;
		
		title = (TextView)findViewById(R.id.webtoon_update);
		tv1 = (TextView)findViewById(R.id.textView1);
		tv2 = (TextView)findViewById(R.id.textView2);
		tv3 = (TextView)findViewById(R.id.textView3);
		backBtn = (ImageButton)findViewById(R.id.backBtn);
		check = (ImageButton)findViewById(R.id.imageButton);
		
		title.setTypeface(typeface);
		tv1.setTypeface(typeface);
		tv2.setTypeface(typeface2);
		tv3.setTypeface(typeface2);
		
		check.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(ImageTouched == false){
					ImageTouched = true;
					check.setImageResource(R.drawable.set_chkbox_active);
				}else if(ImageTouched==true){
					check.setImageResource(R.drawable.set_chkbox);
					ImageTouched = false;
				}
				
			}
		});
	
		
		
	}
}
