package com.example.mobitest.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobitest.Network;
import com.example.mobitest.R;

public class IdSearch extends Activity{

	//public static Activity aActivity;

	RelativeLayout page1, page2, page3, page4;
	TextView title, p1_tv1, p1_tv2, p2_tv1, p2_tv2, p2_tv3, p3_tv1, p3_tv2, p3_tv3, p4_tv1, p4_tv2;
	EditText p1_email, p2_email;
	Button p1_ok, p2_ok, p2_signup, p3_ok, p4_ok;
	ImageButton backBtn;
	Typeface typeface;

	Network nw = new Network();
	Login lg = new Login();


	private boolean BackButtonTouched = false;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.id_search);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.id_search_title);

		//aActivity = IdSearch.this;


		typeface = nw.typeface;

		page1 = (RelativeLayout)findViewById(R.id.page1);
		page2 = (RelativeLayout)findViewById(R.id.page2);
		page3 = (RelativeLayout)findViewById(R.id.page3);
		page4 = (RelativeLayout)findViewById(R.id.page4);
		title = (TextView)findViewById(R.id.id_search);
		p1_tv1 = (TextView)findViewById(R.id.p1_tv1);
		p1_tv2 = (TextView)findViewById(R.id.p1_tv2);
		p2_tv1 = (TextView)findViewById(R.id.p2_tv1);
		p2_tv2 = (TextView)findViewById(R.id.p2_tv2);
		p2_tv3 = (TextView)findViewById(R.id.p2_tv3);
		p3_tv1 = (TextView)findViewById(R.id.p3_tv1);
		p3_tv2 = (TextView)findViewById(R.id.p3_tv2);
		p3_tv3 = (TextView)findViewById(R.id.p3_tv3);
		p4_tv1 = (TextView)findViewById(R.id.p4_tv1);
		p4_tv2 = (TextView)findViewById(R.id.p4_tv2);
		p1_email = (EditText)findViewById(R.id.p1_email);
		p2_email = (EditText)findViewById(R.id.p2_email);
		p1_ok = (Button)findViewById(R.id.p1_OK);
		p2_ok = (Button)findViewById(R.id.p2_OK);
		p2_signup = (Button)findViewById(R.id.p2_signup);
		p3_ok = (Button)findViewById(R.id.p3_ok);
		p4_ok = (Button)findViewById(R.id.p4_ok);
		backBtn = (ImageButton)findViewById(R.id.backBtn);

		title.setTypeface(typeface);
		p1_tv1.setTypeface(typeface);
		p1_tv2.setTypeface(typeface);
		p2_tv1.setTypeface(typeface);
		p2_tv2.setTypeface(typeface);
		p2_tv3.setTypeface(typeface);
		p3_tv1.setTypeface(typeface);
		p3_tv2.setTypeface(typeface);
		p3_tv3.setTypeface(typeface);
		p4_tv1.setTypeface(typeface);
		p4_tv2.setTypeface(typeface);
		p1_email.setTypeface(typeface);
		p2_email.setTypeface(typeface);
		p1_ok.setTypeface(typeface);
		p2_ok.setTypeface(typeface);
		p2_signup.setTypeface(typeface);
		p3_ok.setTypeface(typeface);
		p4_ok.setTypeface(typeface);

		page1.setVisibility(View.VISIBLE);//첫번째 화면
		page2.setVisibility(View.INVISIBLE);//확인
		page3.setVisibility(View.INVISIBLE);//오류
		page4.setVisibility(View.INVISIBLE);//아이디 전체보기


		//뒤로가기버튼
		backBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(IdSearch.this, Login.class);
				startActivity(intent);
			}
		});

		//아이디 찾기 첫번째 창
		p1_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(p1_email.getText().toString().equals("huray@huray.net")){
					page1.setVisibility(View.GONE);
					page3.setVisibility(View.VISIBLE);
				}else if(p1_email.getText().toString().equals("")){
					Toast toast = Toast.makeText(IdSearch.this, "이메일을 입력해주세요.", Toast.LENGTH_LONG);
					toast.show();
				}else{
					page1.setVisibility(View.GONE);
					page2.setVisibility(View.VISIBLE);
				}
			}
		});
		p1_ok.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					p1_ok.setBackgroundResource(R.drawable.login_btn_bg_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					p1_ok.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
				}
				
				return false;
			}
		});

		//확인 버튼
		p2_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(p2_email.getText().toString().equals("huray@huray.net")){
					page2.setVisibility(View.GONE);
					page3.setVisibility(View.VISIBLE);
				}else{
					p2_email.setText("");
					Toast toast = Toast.makeText(IdSearch.this, "다시 입력해주세요.", Toast.LENGTH_LONG);
					toast.show();
				}
			}
		});
		p2_ok.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					p2_ok.setBackgroundResource(R.drawable.login_btn_bg_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					p2_ok.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
				}
				
				return false;
			}
		});
		
		//회원가입 하러가기
		p2_signup.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(IdSearch.this,Signup.class);
				startActivity(intent);

			}
		});
		p2_signup.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					p2_signup.setBackgroundResource(R.drawable.login_btn_bg_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					p2_signup.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
				}
				return false;
			}
		});
		//아이디 전체 보기
		p3_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				page3.setVisibility(View.GONE);
				page4.setVisibility(View.VISIBLE);
			}
		});

		//로그인 화면으로 버튼
		p4_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(IdSearch.this, Login.class);
				startActivity(intent);
			}
		});

		//첫번째 화면 이메일
		p1_email.setOnFocusChangeListener(new View.OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus == false){
					p1_email.setBackgroundResource(R.drawable.login_input);
				}if(hasFocus == true){
					p1_email.setBackgroundResource(R.drawable.login_input_over);

				}
			}
		});

		p2_email.setOnFocusChangeListener(new View.OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus == false){
					p2_email.setBackgroundResource(R.drawable.login_input);
				}if(hasFocus == true){
					p2_email.setBackgroundResource(R.drawable.login_input_over);
				}
			}
		});
	}//onCreate

	@Override
	public void onBackPressed() {
		if(BackButtonTouched == false){
			BackButtonTouched = true;
			Toast toast = Toast.makeText(IdSearch.this, "한번 더 누르시면 로그인화면으로 돌아갑니다.", Toast.LENGTH_LONG);
			toast.show();
		}else if(BackButtonTouched == true){
			Intent intent = new Intent(IdSearch.this,Login.class);
			startActivity(intent);
		}


	}

}
