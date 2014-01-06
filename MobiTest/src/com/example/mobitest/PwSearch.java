package com.example.mobitest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PwSearch extends Activity{

	ImageButton backBtn;
	RelativeLayout page1, page2, page3;
	TextView p1_tv1, p1_error, p2_tv1, p2_tv2, p3_tv1, p3_tv2, p3_tv3;
	EditText p1_id, p1_email, p2_id, p2_email;
	Button p1_ok, p2_ok, p3_ok;
	Typeface typeface;

	Network nw = new Network();
	Login lg = new Login();

	private boolean BackButtonTouched = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.pw_search);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.pw_search_title);

		typeface = nw.typeface;

		backBtn = (ImageButton)findViewById(R.id.backBtn);
		page1 = (RelativeLayout)findViewById(R.id.page1);
		page2 = (RelativeLayout)findViewById(R.id.page2);
		page3 = (RelativeLayout)findViewById(R.id.page3);
		p1_tv1 = (TextView)findViewById(R.id.p1_tv1);
		p1_error = (TextView)findViewById(R.id.p1_error);
		p2_tv1 = (TextView)findViewById(R.id.p2_tv1);
		p2_tv2 = (TextView)findViewById(R.id.p2_tv2);
		p3_tv1 = (TextView)findViewById(R.id.p3_tv1);
		p3_tv2 = (TextView)findViewById(R.id.p3_tv2);
		p3_tv3 = (TextView)findViewById(R.id.p3_tv3);
		p1_id = (EditText)findViewById(R.id.p1_id);
		p1_email = (EditText)findViewById(R.id.p1_pw);
		p2_id = (EditText)findViewById(R.id.p2_id);
		p2_email = (EditText)findViewById(R.id.p2_pw);
		p1_ok = (Button)findViewById(R.id.p1_ok);
		p2_ok = (Button)findViewById(R.id.p2_ok);
		p3_ok = (Button)findViewById(R.id.p3_ok);

		p1_tv1.setTypeface(typeface);
		p1_error.setTypeface(typeface);
		p2_tv1.setTypeface(typeface);
		p2_tv2.setTypeface(typeface);
		p3_tv1.setTypeface(typeface);
		p3_tv2.setTypeface(typeface);
		p3_tv3.setTypeface(typeface);
		p1_id.setTypeface(typeface);
		p1_email.setTypeface(typeface);
		p2_id.setTypeface(typeface);
		p2_email.setTypeface(typeface);
		p1_ok.setTypeface(typeface);
		p2_ok.setTypeface(typeface);
		p3_ok.setTypeface(typeface);

		p1_error.setVisibility(View.INVISIBLE);//미입력
		page2.setVisibility(View.INVISIBLE);//오류
		page3.setVisibility(View.INVISIBLE);//정상

		//뒤로가기버튼
		backBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PwSearch.this, Login.class);
				startActivity(intent);
				p1_error.setVisibility(View.INVISIBLE);
			}
		});

		//첫번째 페이지 id, email
		p1_id.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus == false){
					p1_id.setBackgroundResource(R.drawable.login_input);
				}if(hasFocus == true){
					p1_id.setBackgroundResource(R.drawable.login_input_over);
				}
			}
		});
		p1_email.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus == false){
					p1_email.setBackgroundResource(R.drawable.login_input);
				}if(hasFocus == true){
					p1_email.setBackgroundResource(R.drawable.login_input_over);
				}

			}
		});

		//두번째 페이지 id, email
		p2_id.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus == false){
					p2_id.setBackgroundResource(R.drawable.login_input);
				}if(hasFocus == true){
					p2_id.setBackgroundResource(R.drawable.login_input_over);
				}
			}
		});
		p2_email.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus == false){
					p2_email.setBackgroundResource(R.drawable.login_input);
				}if(hasFocus == true){
					p2_email.setBackgroundResource(R.drawable.login_input_over);
				}
			}
		});

		//비밀번호 첫번째 창
		p1_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(p1_id.getText().toString().equals("huray")&&p1_email.getText().toString().equals("huray@huray.net")){
					page1.setVisibility(View.GONE);
					page3.setVisibility(View.VISIBLE);
				}else if(p1_id.getText().toString().equals("")||p1_email.getText().toString().equals("")){
					p1_error.setVisibility(View.VISIBLE);
				}else{
					page1.setVisibility(View.GONE);
					page2.setVisibility(View.VISIBLE);
				}
			}
		});
		//비밀번호 두번째 창
		p2_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(p2_id.getText().toString().equals("huray")&&p2_email.getText().toString().equals("huray@huray.net")){
					page2.setVisibility(View.GONE);
					page3.setVisibility(View.VISIBLE);
				}else{
					Toast toast = Toast.makeText(PwSearch.this, "다시 입력해주세요.", Toast.LENGTH_LONG);
					toast.show();
					p2_id.setText("");
					p2_email.setText("");
				}
			}
		});
		//비밀번호 세번째 창
		p3_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PwSearch.this,Login.class);
				startActivity(intent);
			}
		});
	}//onCreate

	@Override
	public void onBackPressed() {
		if(BackButtonTouched == false){
			BackButtonTouched = true;
			Toast toast = Toast.makeText(PwSearch.this, "한번 더 누르시면 종료됩니다.", Toast.LENGTH_LONG);
			toast.show();
		}else if(BackButtonTouched == true){
			lg.ExitProcess();
		}
	}

}
