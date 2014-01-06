package com.example.mobitest;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Signup extends Activity{

	Typeface typeface;
	RelativeLayout page1, page2, page3;
	EditText p1_id, p1_pw, p1_email, p1_nickname, p3_code_input;
	TextView p1_tv1, p1_ok, p2_tv1, p2_tv2, p2_birth, p2_country, p2_country2, p2_skip, p3_tv1, p3_tv2, p3_tv3, p3_tv4,
	p3_tv5, p3_tv6, p3_tv7, p3_tv8, p4_tv1, p4_tv2;
	Button p2_Button1, p2_boy, p2_girl, p2_boygirl, p2_ok, p3_codeBtn, p3_login, p3_mail, p4_login;

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
		p1_ok = (TextView)findViewById(R.id.p1_ok);
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
		p2_Button1 = (Button)findViewById(R.id.p2_button1);
		p2_boy = (Button)findViewById(R.id.p2_boy);
		p2_girl = (Button)findViewById(R.id.p2_girl);
		p2_boygirl = (Button)findViewById(R.id.p2_boygirl);
		p2_ok = (Button)findViewById(R.id.p2_ok);
		p3_codeBtn = (Button)findViewById(R.id.p3_codeBtn);
		p3_login = (Button)findViewById(R.id.p3_login);
		p3_mail = (Button)findViewById(R.id.p3_mail);
		p4_login = (Button)findViewById(R.id.p4_login);

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
		
		p1_ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				page1.setVisibility(View.GONE);
				page2.setVisibility(View.VISIBLE);
				
			}
		});
		
		p2_ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				page2.setVisibility(View.GONE);
				page3.setVisibility(View.VISIBLE);
			}
		});
	}
}
