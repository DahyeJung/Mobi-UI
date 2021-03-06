package com.example.mobitest.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mobitest.Network;
import com.example.mobitest.R;
import com.example.mobitest.account.Account;
import com.example.mobitest.faq.FAQ;
import com.example.mobitest.main.Main;
import com.example.mobitest.notice.Notice;

public class Setting extends Activity{
	TextView title, tv1, myinformtv, myinformtv2, tv2, rotation, tv3, usetv, usetv2, viewtv, viewtv2, updatetv1, updatetv2, tv4, noticetv, faqtv, proposaltv, tv5, proinfotv, tv6;
	Typeface typeface;
	ImageButton backBtn;
	ImageView myinform, notice, FAQ, propersal, proinform, chk1, chk2, chk3, chk4;
	LinearLayout layout1, layout2, layout3, layout4, layout5, layout6, layout7, layout8, layout9;


	private boolean ImageTouched = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.setting);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.setting_title);

		Network nw = new Network();
		typeface = nw.typeface;
		
		title = (TextView)findViewById(R.id.setting_title);
		title.setTypeface(typeface);
		tv1 = (TextView)findViewById(R.id.textView1);
		tv1.setTypeface(typeface);
		myinformtv = (TextView)findViewById(R.id.textView2);
		myinformtv.setTypeface(typeface);
		myinformtv2 = (TextView)findViewById(R.id.textView3);
		myinformtv2.setTypeface(typeface);
		tv2 = (TextView)findViewById(R.id.textView4);
		tv2.setTypeface(typeface);
		rotation = (TextView)findViewById(R.id.textView5);
		rotation.setTypeface(typeface);
		tv3 = (TextView)findViewById(R.id.textView6);
		tv3.setTypeface(typeface);
		usetv = (TextView)findViewById(R.id.textView7);
		usetv.setTypeface(typeface);
		usetv2 = (TextView)findViewById(R.id.textView8);
		usetv2.setTypeface(typeface);
		viewtv = (TextView)findViewById(R.id.textView9);
		viewtv.setTypeface(typeface);
		viewtv2 = (TextView)findViewById(R.id.textView10);
		viewtv2.setTypeface(typeface);
		updatetv1 = (TextView)findViewById(R.id.textView11);
		updatetv1.setTypeface(typeface);
		updatetv2 = (TextView)findViewById(R.id.textView12);
		updatetv2.setTypeface(typeface);
		tv4 = (TextView)findViewById(R.id.textView13);
		tv4.setTypeface(typeface);
		noticetv = (TextView)findViewById(R.id.textView15);
		noticetv.setTypeface(typeface);
		faqtv = (TextView)findViewById(R.id.textView14);
		faqtv.setTypeface(typeface);
		proposaltv = (TextView)findViewById(R.id.textView16);
		proposaltv.setTypeface(typeface);
		tv5 = (TextView)findViewById(R.id.textView17);
		tv5.setTypeface(typeface);
		proinfotv = (TextView)findViewById(R.id.textView18);
		proinfotv.setTypeface(typeface);
		tv6 = (TextView)findViewById(R.id.textView19);
		tv6.setTypeface(typeface);
		
		
		
		backBtn = (ImageButton)findViewById(R.id.backBtn);
		myinform = (ImageButton)findViewById(R.id.imageView1);
		notice = (ImageButton)findViewById(R.id.imageView6);
		FAQ = (ImageButton)findViewById(R.id.imageView8);
		propersal = (ImageButton)findViewById(R.id.imageView10);
		proinform = (ImageButton)findViewById(R.id.imageView11);
		chk1 = (ImageView)findViewById(R.id.checkbox1);
		chk2 = (ImageView)findViewById(R.id.checkbox2);
		chk3 = (ImageView)findViewById(R.id.checkbox3);
		chk4 = (ImageView)findViewById(R.id.checkbox4);
		layout1 = (LinearLayout)findViewById(R.id.Linear1);
		layout2 = (LinearLayout)findViewById(R.id.Linear2);
		layout3 = (LinearLayout)findViewById(R.id.Linear3);
		layout4 = (LinearLayout)findViewById(R.id.Linear4);
		layout5 = (LinearLayout)findViewById(R.id.Linear5);
		layout6 = (LinearLayout)findViewById(R.id.Linear6);
		layout7 = (LinearLayout)findViewById(R.id.Linear7);
		layout8 = (LinearLayout)findViewById(R.id.Linear8);
		layout9 = (LinearLayout)findViewById(R.id.Linear9);

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
				Intent intent = new Intent(Setting.this,Account.class);
				startActivity(intent);
			}
		});
		//내 정보
		layout1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Setting.this,MyInform.class);
				startActivity(intent);

			}
		});
		layout1.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					myinform.setBackgroundResource(R.drawable.menu_arrow_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					myinform.setBackgroundResource(R.drawable.menu_arrow);//버튼을 누르지 않을 때
				}

				return false;
			}
		});

		//자동회전
		layout2.setOnClickListener(new OnClickListener() {

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
		layout2.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					chk1.setBackgroundResource(R.drawable.set_chkbox_active);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					chk1.setBackgroundResource(R.drawable.set_chkbox);//버튼을 누르지 않을 때
				}

				return false;
			}
		});

		//이동통신망 사용 알림
		layout3.setOnClickListener(new OnClickListener() {

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
		layout3.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					chk2.setBackgroundResource(R.drawable.set_chkbox_active);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					chk2.setBackgroundResource(R.drawable.set_chkbox);//버튼을 누르지 않을 때
				}

				return false;
			}
		});

		//Tour guide 다시 보기
		layout4.setOnClickListener(new OnClickListener() {

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
		layout4.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					chk3.setBackgroundResource(R.drawable.set_chkbox_active);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					chk3.setBackgroundResource(R.drawable.set_chkbox);//버튼을 누르지 않을 때
				}

				return false;
			}
		});
		
		//관심웹툰 업데이트 알림
		layout5.setOnClickListener(new OnClickListener() {

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
		layout5.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					chk4.setBackgroundResource(R.drawable.set_chkbox_active);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					chk4.setBackgroundResource(R.drawable.set_chkbox);//버튼을 누르지 않을 때
				}

				return false;
			}
		});
		//공지사항
		layout6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Setting.this,Notice.class);
				startActivity(intent);
			}
		});
		layout6.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					notice.setBackgroundResource(R.drawable.menu_arrow_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					notice.setBackgroundResource(R.drawable.menu_arrow);//버튼을 누르지 않을 때
				}
				return false;
			}
		});

		//FAQ
		layout7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Setting.this, FAQ.class);
				startActivity(intent);
			}
		});
		layout7.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					FAQ.setBackgroundResource(R.drawable.menu_arrow_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					FAQ.setBackgroundResource(R.drawable.menu_arrow);//버튼을 누르지 않을 때
				}

				return false;
			}
		});

		//건의/문의하기
		layout8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Setting.this,Proposal.class);
				startActivity(intent);
			}
		});
		layout8.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					propersal.setBackgroundResource(R.drawable.menu_arrow_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					propersal.setBackgroundResource(R.drawable.menu_arrow);//버튼을 누르지 않을 때
				}

				return false;
			}
		});

		//프로그램 정보
		layout9.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Setting.this,ProgramInfo.class);
				startActivity(intent);
			}
		});
		layout9.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					proinform.setBackgroundResource(R.drawable.menu_arrow_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					proinform.setBackgroundResource(R.drawable.menu_arrow);//버튼을 누르지 않을 때
				}
				return false;
			}
		});
	}

}