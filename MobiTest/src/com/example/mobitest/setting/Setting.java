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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobitest.Network;
import com.example.mobitest.R;
import com.example.mobitest.faq.FAQ;
import com.example.mobitest.main.Main;
import com.example.mobitest.notice.Notice;

public class Setting extends Activity{
	TextView setting;
	Typeface typeface;
	ImageButton backBtn;
	ImageView myinform, notice, FAQ, propersal, proinform, chk1, chk2, chk3, chk4;

	private boolean ImageTouched = false;

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
		myinform = (ImageButton)findViewById(R.id.imageView1);
		notice = (ImageButton)findViewById(R.id.imageView6);
		FAQ = (ImageButton)findViewById(R.id.imageView8);
		propersal = (ImageButton)findViewById(R.id.imageView10);
		proinform = (ImageButton)findViewById(R.id.imageView11);
		chk1 = (ImageButton)findViewById(R.id.checkbox1);
		chk2 = (ImageButton)findViewById(R.id.checkbox2);
		chk3 = (ImageButton)findViewById(R.id.checkbox3);
		chk4 = (ImageButton)findViewById(R.id.checkbox4);


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
		backBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Setting.this,Main.class);
				startActivity(intent);
			}
		});
		//내 정보
		myinform.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Setting.this,MyInform.class);
				startActivity(intent);

			}
		});
		//자동회전
		chk1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(ImageTouched == false){
					ImageTouched = true;
					chk1.setImageResource(R.drawable.set_chkbox_active);
				}else if(ImageTouched==true){
					chk1.setImageResource(R.drawable.set_chkbox);
					ImageTouched = false;
				}
			}
		});
		//이동통신망 사용 알림
		chk2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(ImageTouched == false){
					ImageTouched = true;
					chk2.setImageResource(R.drawable.set_chkbox_active);
				}else if(ImageTouched==true){
					chk2.setImageResource(R.drawable.set_chkbox);
					ImageTouched = false;
				}
			}
		});
		//Tour guide 다시 보기
		chk3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(ImageTouched == false){
					ImageTouched = true;
					chk3.setImageResource(R.drawable.set_chkbox_active);
				}else if(ImageTouched==true){
					chk3.setImageResource(R.drawable.set_chkbox);
					ImageTouched = false;
				}
			}
		});
		//관심웹툰 업데이트 알림
		chk4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(ImageTouched == false){
					ImageTouched = true;
					chk4.setImageResource(R.drawable.set_chkbox_active);
				}else if(ImageTouched==true){
					chk4.setImageResource(R.drawable.set_chkbox);
					ImageTouched = false;
				}
			}
		});

		notice.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Setting.this,Notice.class);
				startActivity(intent);
			}
		});

		FAQ.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Setting.this, FAQ.class);
				startActivity(intent);
			}
		});

		propersal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Setting.this,Proposal.class);
				startActivity(intent);
			}
		});

		proinform.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Setting.this,ProgramInfo.class);
				startActivity(intent);
			}
		});

	}

}