package com.example.mobitest.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
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

public class Signup extends Activity implements OnClickListener{

	Typeface typeface;
	RelativeLayout page1, page2, page3;
	EditText p1_id, p1_pw, p1_email, p1_nickname, p3_code_input;
	TextView p1_tv1, p2_tv1, p2_tv2, p2_birth, p2_country, p2_country2, p2_skip, p3_tv1, p3_tv2, p3_tv3, p3_tv4,
	p3_tv5, p3_tv6, p3_tv7, p3_tv8, p4_tv1, p4_tv2;
	Button  p1_ok, p2_Button1, p2_boy, p2_girl, p2_boygirl, p2_ok, p3_codeBtn, p3_login, p3_mail, p4_login;
	ImageButton backBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.signup);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.signup_title);

		Network nw = new Network();
		typeface = nw.typeface;

		page1 = (RelativeLayout)findViewById(R.id.page1);
		page2 = (RelativeLayout)findViewById(R.id.page2);
		page3 = (RelativeLayout)findViewById(R.id.page3);
		p1_id = (EditText)findViewById(R.id.p1_id);
		p1_pw = (EditText)findViewById(R.id.p1_pw);
		p1_email = (EditText)findViewById(R.id.p1_email);
		p1_nickname = (EditText)findViewById(R.id.p1_nickname);
		p3_code_input = (EditText)findViewById(R.id.p3_code_input);
		p1_tv1 = (TextView)findViewById(R.id.p1_tv1);
		p2_tv1 = (TextView)findViewById(R.id.p2_tv1);
		p2_tv2 = (TextView)findViewById(R.id.p2_tv2);
		p2_birth = (TextView)findViewById(R.id.p2_birth);
		p2_country = (TextView)findViewById(R.id.p2_country);
		p2_country2 = (TextView)findViewById(R.id.p2_country2);
		p2_skip = (TextView)findViewById(R.id.p2_skip);
		p3_tv1 = (TextView)findViewById(R.id.p3_tv1);
		p3_tv2 = (TextView)findViewById(R.id.p3_tv2);
		p3_tv3 = (TextView)findViewById(R.id.p3_tv3);
		p3_tv4 = (TextView)findViewById(R.id.p3_tv4);
		p3_tv5 = (TextView)findViewById(R.id.p3_tv5);
		p3_tv6 = (TextView)findViewById(R.id.p3_tv6);
		p3_tv7 = (TextView)findViewById(R.id.p3_tv7);
		p3_tv8 = (TextView)findViewById(R.id.p3_tv8);
		p4_tv1 = (TextView)findViewById(R.id.p4_tv1);
		p4_tv2 = (TextView)findViewById(R.id.p4_tv2);
		p1_ok = (Button)findViewById(R.id.p1_ok);//
		p2_Button1 = (Button)findViewById(R.id.p2_button1);
		p2_boy = (Button)findViewById(R.id.p2_boy);
		p2_girl = (Button)findViewById(R.id.p2_girl);
		p2_boygirl = (Button)findViewById(R.id.p2_boygirl);
		p2_ok = (Button)findViewById(R.id.p2_ok);//
		p3_codeBtn = (Button)findViewById(R.id.p3_codeBtn);
		p3_login = (Button)findViewById(R.id.p3_login);//
		p3_mail = (Button)findViewById(R.id.p3_mail);
		p4_login = (Button)findViewById(R.id.p4_login);//
		backBtn = (ImageButton)findViewById(R.id.backBtn);


		p1_id.setTypeface(typeface);
		p1_pw.setTypeface(typeface);
		p1_email.setTypeface(typeface);
		p1_nickname.setTypeface(typeface);
		p3_code_input.setTypeface(typeface);
		p1_tv1.setTypeface(typeface);
		p1_ok.setTypeface(typeface);
		p2_tv1.setTypeface(typeface);
		p2_tv2.setTypeface(typeface);
		p2_birth.setTypeface(typeface);
		p2_country.setTypeface(typeface);
		p2_country2.setTypeface(typeface);
		p2_skip.setTypeface(typeface);
		p3_tv1.setTypeface(typeface);
		p3_tv2.setTypeface(typeface);
		p3_tv3.setTypeface(typeface);
		p3_tv4.setTypeface(typeface);
		p3_tv5.setTypeface(typeface);
		p3_tv6.setTypeface(typeface);
		p3_tv7.setTypeface(typeface);
		p3_tv8.setTypeface(typeface);
		p4_tv1.setTypeface(typeface);
		p4_tv2.setTypeface(typeface);
		p2_Button1.setTypeface(typeface);
		p2_boy.setTypeface(typeface);
		p2_girl.setTypeface(typeface);
		p2_boygirl.setTypeface(typeface);
		p2_ok.setTypeface(typeface);
		p3_codeBtn.setTypeface(typeface);
		p3_login.setTypeface(typeface);
		p3_mail.setTypeface(typeface);
		p4_login.setTypeface(typeface);

		page2.setVisibility(View.INVISIBLE);
		page3.setVisibility(View.INVISIBLE);
		p4_tv1.setVisibility(View.INVISIBLE);
		p4_tv2.setVisibility(View.INVISIBLE);
		p4_login.setVisibility(View.INVISIBLE);


		//첫번째 화면 계속 버튼
		p1_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(!p1_id.getText().toString().equals("")&&!p1_pw.getText().toString().equals("")&&!p1_nickname.getText().toString().equals("")&&!p1_email.getText().toString().equals("")){
					if(p1_pw.getText().toString().length()<6){
						Toast toast = Toast.makeText(Signup.this,"비밀번호를 6자이상 입력하세요.",Toast.LENGTH_LONG);
						toast.show();
					}else{					
						page1.setVisibility(View.GONE);
						page2.setVisibility(View.VISIBLE);
					}
				}else{
					Toast toast = Toast.makeText(Signup.this, "값을 모두 입력하세요.", Toast.LENGTH_LONG);
					toast.show();
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

		//두번째 화면 가입하기 버튼
		p2_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				page2.setVisibility(View.GONE);
				page3.setVisibility(View.VISIBLE);
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

		//타이틀 뒤로가기 버튼
		backBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Signup.this,Login.class);
				startActivity(intent);

			}
		});

		//건너뛰기
		p2_skip.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
		p2_skip.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(Signup.this, "건너뛰셨습니다.", Toast.LENGTH_LONG);
				toast.show();
			}
		});
		p2_skip.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				String color = "#dddddd";
				p2_skip.setTextColor(Color.parseColor(color));
				return false;
			}
		});
		//인증버튼
		p3_codeBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(!p3_code_input.getText().toString().equals("huray")){
					Toast toast = Toast.makeText(Signup.this, "인증코드가 다릅니다. 재발송 버튼을 눌러주세요.", Toast.LENGTH_LONG);
					toast.show();
					p3_code_input.setText("");
				}else{
					Toast toast = Toast.makeText(Signup.this, "메인화면으로", Toast.LENGTH_LONG);
					toast.show();
				}
			}
		});
		p3_codeBtn.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					p3_codeBtn.setBackgroundResource(R.drawable.sign_up_code_btn_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					p3_codeBtn.setBackgroundResource(R.drawable.sign_up_code_btn);//버튼을 누르지 않을 때
				}

				return false;
			}
		});
		
		//인증메일 재발송
		p3_mail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				p3_tv1.setVisibility(View.INVISIBLE);
				p3_tv2.setVisibility(View.INVISIBLE);
				p3_login.setVisibility(View.INVISIBLE);
				p4_tv1.setVisibility(View.VISIBLE);
				p4_tv2.setVisibility(View.VISIBLE);
				p4_login.setVisibility(View.VISIBLE);
			}
		});
		p3_mail.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					p3_mail.setBackgroundResource(R.drawable.login_btn_bg_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					p3_mail.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
				}
				
				return false;
			}
		});
		
		//로그인 버튼
		p3_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Signup.this,Login.class);
				startActivity(intent);
			}
		});
		p3_login.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					p3_login.setBackgroundResource(R.drawable.login_btn_bg_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					p3_login.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
				}
				
				
				
				return false;
			}
		});
		
		
		
	}//onCreate

	//성별 버튼 
	@Override
	public void onClick(View v) {
		String color = "#000000";
		switch (v.getId()) {
		case R.id.p2_boy:
			p2_girl.setBackgroundResource(R.drawable.signup_profile);
			p2_boygirl.setBackgroundResource(R.drawable.signup_profile);
			p2_boy.setBackgroundResource(R.drawable.signup_profile_over);
			p2_boy.setTextColor(Color.parseColor(color));
			break;

		case R.id.p2_girl:
			p2_boy.setBackgroundResource(R.drawable.signup_profile);
			p2_boygirl.setBackgroundResource(R.drawable.signup_profile);
			p2_girl.setBackgroundResource(R.drawable.signup_profile_over);
			p2_girl.setTextColor(Color.parseColor(color));
			break;

		case R.id.p2_boygirl:
			p2_boy.setBackgroundResource(R.drawable.signup_profile);
			p2_girl.setBackgroundResource(R.drawable.signup_profile);
			p2_boygirl.setBackgroundResource(R.drawable.signup_profile_over);
			p2_boygirl.setTextColor(Color.parseColor(color));
			break;
		}
	}



}
