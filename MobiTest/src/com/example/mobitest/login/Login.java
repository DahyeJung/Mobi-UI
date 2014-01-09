package com.example.mobitest.login;

import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobitest.Network;
import com.example.mobitest.R;
import com.example.mobitest.main.Main;

public class Login extends Activity{

	LinearLayout layout;
	ImageButton backBtn, clear_id, clear_pw;
	EditText id, pw;
	Button login, mil_login, sign_up;
	TextView id_search, pw_search, error;
	Typeface typeface;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		/*
		IdSearch Id_search = (IdSearch)IdSearch.aActivity; //IdSearch Activity 지우기
		Id_search.finish(); //지우기
		 */
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.login);	
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.login_title);
		//글꼴지정
		Network nw = new Network();

		typeface = nw.typeface;

		id = (EditText)findViewById(R.id.id);
		pw = (EditText)findViewById(R.id.pw);
		login = (Button)findViewById(R.id.ok);
		mil_login = (Button)findViewById(R.id.mil_login);
		sign_up = (Button)findViewById(R.id.sign_up);
		id_search = (TextView)findViewById(R.id.id_search);
		pw_search = (TextView)findViewById(R.id.pw_search);
		backBtn = (ImageButton)findViewById(R.id.backBtn);
		clear_id = (ImageButton)findViewById(R.id.clear_id);
		clear_pw = (ImageButton)findViewById(R.id.clear_pw);
		layout = (LinearLayout)findViewById(R.id.linear);
		error = (TextView)findViewById(R.id.error);

		id.setTypeface(typeface);
		pw.setTypeface(typeface);
		login.setTypeface(typeface);
		mil_login.setTypeface(typeface);
		sign_up.setTypeface(typeface);
		id_search.setTypeface(typeface);
		pw_search.setTypeface(typeface);
		error.setTypeface(typeface);

		clear_id.setVisibility(View.INVISIBLE);//clear id 버튼
		clear_pw.setVisibility(View.INVISIBLE);//clear pw 버튼
		layout.setVisibility(View.INVISIBLE);//error 버튼

		//id,pw 영어,숫자만 입력 + 글자수 14자 제한
		id.setFilters(new InputFilter[] {filterAlpha, new InputFilter.LengthFilter(14)});
		pw.setFilters(new InputFilter[] {filterAlpha, new InputFilter.LengthFilter(14)});

		//id,pw 글씨 밑줄
		id_search.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG); // Text Under Line
		pw_search.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG); //Text Under Line

		//뒤로가기이미지버튼
		backBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				AlertDialog dialog = createdialogBox();//alertdialog 객체 생성
				dialog.show();
			}

		});
		//CLEAR_ID 버튼
		clear_id.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				id.setText("");
			}
		});

		//CLEAR_PW 버튼
		clear_pw.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pw.setText("");
			}
		});

		id.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(s.length()==0){
					clear_id.setVisibility(View.INVISIBLE);
				}else{				
					clear_id.setVisibility(View.VISIBLE);
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

		pw.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(s.length()==0){
					clear_pw.setVisibility(View.INVISIBLE);
				}else{				
					clear_pw.setVisibility(View.VISIBLE);
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

		//밀리언아서 로그인
		mil_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast toast = Toast.makeText(Login.this, "밀리언아서 아이디로 로그인", Toast.LENGTH_LONG);
				toast.show();
			}
		}); 
		mil_login.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					mil_login.setBackgroundResource(R.drawable.login_btn_bg_over02);
					mil_login.setTextColor(Color.parseColor("#333333"));
				}if(event.getAction()==MotionEvent.ACTION_UP){
					mil_login.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
					mil_login.setTextColor(Color.parseColor("#bbbbbb"));
				}
				return false;
			}
		});

		//회원가입
		sign_up.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(Login.this,Signup.class);
				startActivity(intent);
				
				
			}
		});
		sign_up.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					sign_up.setBackgroundResource(R.drawable.login_btn_bg_over);
					sign_up.setTextColor(Color.parseColor("#333333"));
				}if(event.getAction()==MotionEvent.ACTION_UP){
					sign_up.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
					sign_up.setTextColor(Color.parseColor("#bbbbbb"));
				}


				return false;
			}
		});
		//로그인 버튼

		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String id_text = id.getText().toString();
				String pw_text = pw.getText().toString();

				if(id_text.equals("huray") && pw_text.equals("huray")){
					//메인화면으로
					layout.setVisibility(View.INVISIBLE);
					Intent intent = new Intent(Login.this, Main.class);
					startActivity(intent);
				}else{
					layout.setVisibility(View.VISIBLE);
				}
			}
		});
		//아이디찾기
		id_search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Login.this,IdSearch.class);
				startActivity(intent);
			}
		});
		id_search.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					id_search.setTextColor(Color.parseColor("#dddddd"));
				}if(event.getAction()==MotionEvent.ACTION_UP){
					id_search.setTextColor(Color.parseColor("#666666"));
				}
				return false;
			}
		});

		//비밀번호 찾기
		pw_search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Login.this, PwSearch.class);
				startActivity(intent);
			}
		});
		pw_search.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					pw_search.setTextColor(Color.parseColor("#dddddd"));
				}if(event.getAction()==MotionEvent.ACTION_UP){
					pw_search.setTextColor(Color.parseColor("#666666"));
				}
				return false;
			}
		});
		
	}//onCreate

	/**
	 * 아이디, 비밀번호 영문만 입력
	 */
	public InputFilter filterAlpha = new InputFilter() {

		@Override
		public CharSequence filter(CharSequence source, int start, int end,
				Spanned dest, int dstart, int dend) {
			Pattern ps = Pattern.compile("^[a-zA-Z0-9]+$");
			if(!ps.matcher(source).matches()){
				return "";
			}
			return null;
		}
	};
	
	//뒤로가기
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {

		if(keyCode == KeyEvent.KEYCODE_BACK){
			AlertDialog dialog = createdialogBox();//alertdialog 객체 생성
			dialog.show();
		}

		return false;
	};
	
	/**
	 * alertdialog 만들기
	 * 
	 */
	public AlertDialog createdialogBox() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("알림!");
		builder.setMessage("종료하시겠습니까?");
		builder.setIcon(R.drawable.icon);
		builder.setPositiveButton("네", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				ExitProcess();
			}
		});
		builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				dialog.dismiss();//다이얼로그를 화면에서 사라지게 한다.
			}
		});
		AlertDialog dialog = builder.create();
		return dialog;
	}

	/**
	 * 프로세스 종료
	 */
	public void ExitProcess(){
		moveTaskToBack(true);
		android.os.Process.killProcess(android.os.Process.myPid());
	}
}
