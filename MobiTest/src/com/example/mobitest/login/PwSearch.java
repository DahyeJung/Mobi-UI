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

		p1_id.setFilters(new InputFilter[]{filterAlpha});
		p2_id.setFilters(new InputFilter[]{filterAlpha});

		//뒤로가기버튼
		backBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PwSearch.this, Login.class);
				startActivity(intent);
				p1_error.setVisibility(View.INVISIBLE);
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

		//비밀번호 세번째 창
		p3_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PwSearch.this,Login.class);
				startActivity(intent);
			}
		});
		p3_ok.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					p3_ok.setBackgroundResource(R.drawable.login_btn_bg_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					p3_ok.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
				}

				return false;
			}
		});


	}//onCreate

	public InputFilter filterAlpha = lg.filterAlpha;
	@Override
	public void onBackPressed() {
		if(BackButtonTouched == false){
			BackButtonTouched = true;
			Toast toast = Toast.makeText(PwSearch.this, "한번 더 누르시면 로그인화면으로 돌아갑니다.", Toast.LENGTH_LONG);
			toast.show();
		}else if(BackButtonTouched == true){
			Intent intent = new Intent(PwSearch.this,Login.class);
			startActivity(intent);
		}
	}

}
