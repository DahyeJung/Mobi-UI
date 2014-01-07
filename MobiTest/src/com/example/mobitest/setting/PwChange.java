package com.example.mobitest.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobitest.R;

public class PwChange extends Activity{
	
	ImageButton backBtn;
	TextView error;
	Button ok;
	EditText pw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.pw_change);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.pw_change_title);
		
		error = (TextView)findViewById(R.id.error);
		ok = (Button)findViewById(R.id.ok);
		pw = (EditText)findViewById(R.id.pw);
		backBtn = (ImageButton)findViewById(R.id.backBtn);
		
		error.setVisibility(View.INVISIBLE);
		
		backBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PwChange.this,Setting.class);
				startActivity(intent);
			}
		});
		
		//비밀번호 변경 버튼
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(pw.getText().toString().equals("huray")){
					Toast toast = Toast.makeText(PwChange.this, "비밀번호가 변경되었습니다.", Toast.LENGTH_LONG);
					toast.show();
					Intent intent = new Intent(PwChange.this,MyInform.class);
					startActivity(intent);
				}else{
					error.setVisibility(View.VISIBLE);
				}
			}
		});
		
		ok.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					ok.setBackgroundResource(R.drawable.login_btn_bg_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					ok.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
				}
				return false;
			}
		});
	}
}
