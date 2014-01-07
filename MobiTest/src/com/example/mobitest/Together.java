package com.example.mobitest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mobitest.main.Main;

public class Together extends Activity{

	ImageButton backBtn;
	RelativeLayout page1, page2, page3;
	Button p1_btn, p2_cancel, p2_next, p3_btn1, p3_btn2;
	ImageButton p1_textdelete;
	EditText p1_searchId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.togetherview);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.togetherview_title);
		backBtn = (ImageButton)findViewById(R.id.backBtn);
		page1 = (RelativeLayout)findViewById(R.id.page1);
		page2 = (RelativeLayout)findViewById(R.id.page2);
		page3 = (RelativeLayout)findViewById(R.id.page3);
		p1_btn = (Button)findViewById(R.id.btn1);
		p1_textdelete = (ImageButton)findViewById(R.id.delete);
		p2_cancel = (Button)findViewById(R.id.cancel);
		p2_next = (Button)findViewById(R.id.next);
		p3_btn1 = (Button)findViewById(R.id.p3_btn1);
		p3_btn2 = (Button)findViewById(R.id.p3_btn2);
		p1_searchId = (EditText)findViewById(R.id.p1_searchId);
		
		p1_textdelete.setVisibility(View.INVISIBLE);
		page2.setVisibility(View.INVISIBLE);
		page3.setVisibility(View.INVISIBLE);

		p1_textdelete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				p1_searchId.setText("");
			}
		});
		
		p1_searchId.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(s.length()==0){
					p1_textdelete.setVisibility(View.INVISIBLE);
				}else{				
					p1_textdelete.setVisibility(View.VISIBLE);
				}
			}
			
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});

		backBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Together.this,Main.class);
				startActivity(intent);
			}
		});

		p1_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				page1.setVisibility(View.INVISIBLE);
				page2.setVisibility(View.VISIBLE);
			}
		});
		p1_btn.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					p1_btn.setBackgroundResource(R.drawable.sign_up_code_btn_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					p1_btn.setBackgroundResource(R.drawable.sign_up_code_btn);//버튼을 누르지 않을 때
				}

				return false;
			}
		});

		p2_cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Together.this,Main.class);
				startActivity(intent);
			}
		});
		p2_cancel.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					p2_cancel.setBackgroundResource(R.drawable.login_btn_bg_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					p2_cancel.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
				}
				return false;
			}
		});

		p2_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				page2.setVisibility(View.INVISIBLE);
				page3.setVisibility(View.VISIBLE);

			}
		});
		p2_next.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					p2_next.setBackgroundResource(R.drawable.login_btn_bg_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					p2_next.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
				}
				return false;
			}
		});

		p3_btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(Together.this, "계속 감상", Toast.LENGTH_LONG);
				toast.show();
			}
		});
		p3_btn1.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					p3_btn1.setBackgroundResource(R.drawable.login_btn_bg_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					p3_btn1.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
				}
				return false;
			}
		});

		p3_btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Together.this,Main.class);
				startActivity(intent);
			}
		});
		p3_btn2.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					p3_btn2.setBackgroundResource(R.drawable.login_btn_bg_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					p3_btn2.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
				}

				return false;
			}
		});
	}
}
