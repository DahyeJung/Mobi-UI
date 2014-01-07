package com.example.mobitest.setting;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
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
import android.widget.TextView;

import com.example.mobitest.Network;
import com.example.mobitest.R;

public class Proposal extends Activity{

	ImageButton backBtn, picture;
	TextView id, counter, maxnum, info;
	EditText contents;
	Typeface typeface;
	Button ok;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.proposal);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.proposal_title);
		//글꼴 지정
		Network nw = new Network();

		typeface = nw.typeface;

		backBtn = (ImageButton)findViewById(R.id.backBtn);
		id = (TextView)findViewById(R.id.id);
		id.setTypeface(typeface);//id에 글꼴 지정
		counter = (TextView)findViewById(R.id.count);
		counter.setTypeface(typeface);
		maxnum = (TextView)findViewById(R.id.textView3);
		maxnum.setTypeface(typeface);
		info = (TextView)findViewById(R.id.info);
		info.setTypeface(typeface);
		contents = (EditText)findViewById(R.id.contents);
		contents.setTypeface(typeface);
		picture = (ImageButton)findViewById(R.id.picture);
		ok = (Button)findViewById(R.id.ok);
		ok.setTypeface(typeface);

		//뒤로가기
		backBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Proposal.this, Setting.class);
				startActivity(intent);
			}
		});

		//내용
		contents.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				counter.setText(String.valueOf(s.length()));//글자수
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

		picture.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					picture.setImageResource(R.drawable.query_btn_add_pic_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					picture.setImageResource(R.drawable.query_btn_add_pic);//버튼을 누르지 않을 때
				}

				return false;
			}
		});
		//보내기(확인) 버튼
		ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Proposal.this, Setting.class);
				startActivity(intent);
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

	}//onCreate
}
