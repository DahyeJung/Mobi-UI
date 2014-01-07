package com.example.mobitest.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mobitest.R;

public class MyInform extends Activity{

	ImageButton backBtn;
	Button phoneBtn, pwBtn, Logout;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.pw_change);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.my_inform);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.my_inform_title);
		
		backBtn = (ImageButton)findViewById(R.id.backBtn);		
		phoneBtn = (Button)findViewById(R.id.button2);
		pwBtn = (Button)findViewById(R.id.button3);
		Logout = (Button)findViewById(R.id.login);
		
		//이전화면
		backBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MyInform.this,Setting.class);
				startActivity(intent);
			}
		});
		//번호 변경
		phoneBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MyInform.this, NumChange.class);
				startActivity(intent);
			}
		});
		//비밀번호 변경
		pwBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MyInform.this, PwChange.class);
				startActivity(intent);
			}
		});
		//로그아웃
		Logout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(MyInform.this, "로그아웃", Toast.LENGTH_LONG);
				toast.show();
				
			}
		});
	}
	
}
