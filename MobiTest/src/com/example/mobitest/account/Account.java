package com.example.mobitest.account;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobitest.R;
import com.example.mobitest.main.Main;
import com.example.mobitest.setting.Setting;

public class Account extends Activity{

	RelativeLayout rl1, rl2, rl3, rl4;
	ImageView img1, img2, img3, img4;
	TextView tv1, tv2, tv3, tv4;
	ImageButton imgbtn1, imgbtn2, imgbtn3, imgbtn4, backBtn;
	String intenttxt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		/*Intent intent = getIntent();
		intenttxt = intent.getStringExtra("main");*/
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.account);

		rl1 = (RelativeLayout)findViewById(R.id.rl1);
		rl2 = (RelativeLayout)findViewById(R.id.rl2);
		rl3 = (RelativeLayout)findViewById(R.id.rl3);
		rl4 = (RelativeLayout)findViewById(R.id.rl4);
		img1 = (ImageView)findViewById(R.id.imageView1);
		img2 = (ImageView)findViewById(R.id.imageView3);
		img3 = (ImageView)findViewById(R.id.imageView5);
		img4 = (ImageView)findViewById(R.id.imageView7);
		tv1 = (TextView)findViewById(R.id.textView1);
		tv2 = (TextView)findViewById(R.id.textView3);
		tv3 = (TextView)findViewById(R.id.textView4);
		tv4 = (TextView)findViewById(R.id.textView5);
		imgbtn1 = (ImageButton)findViewById(R.id.imageButton);
		imgbtn2 = (ImageButton)findViewById(R.id.imageButton2);
		imgbtn3 = (ImageButton)findViewById(R.id.imageButton3);
		imgbtn4 = (ImageButton)findViewById(R.id.imageButton4);
		backBtn = (ImageButton)findViewById(R.id.backBtn);

		backBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				finish();
			}
		});

		rl1.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					img1.setImageResource(R.drawable.my_icon_my_over);
					tv1.setTextColor(Color.parseColor("#ef4358"));
					imgbtn1.setBackgroundResource(R.drawable.menu_arrow_over);
					Log.e("눌렀음","ㅇㅇㅇㅇ");
				}if(event.getAction()==MotionEvent.ACTION_UP){
					img1.setImageResource(R.drawable.my_icon_my);
					tv1.setTextColor(Color.parseColor("#cccccc"));
					imgbtn1.setBackgroundResource(R.drawable.menu_arrow);
					Log.e("안눌렀음", "ㅇㅇㅇㅇ");
				}

				return true;
			}
		});

		rl2.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					img2.setImageResource(R.drawable.my_icon_gift_over);
					tv2.setTextColor(Color.parseColor("#ef4358"));
					imgbtn2.setBackgroundResource(R.drawable.menu_arrow_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					img2.setImageResource(R.drawable.my_icon_gift);
					tv2.setTextColor(Color.parseColor("#cccccc"));
					imgbtn2.setBackgroundResource(R.drawable.menu_arrow);
				}

				return true;
			}
		});

		rl3.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					img3.setImageResource(R.drawable.my_icon_ink_over);
					tv3.setTextColor(Color.parseColor("#ef4358"));
					imgbtn3.setBackgroundResource(R.drawable.menu_arrow_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					img3.setImageResource(R.drawable.my_icon_ink);
					tv3.setTextColor(Color.parseColor("#cccccc"));
					imgbtn3.setBackgroundResource(R.drawable.menu_arrow);
				}

				return true;
			}
		});
		rl4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(Account.this, Setting.class);
				startActivity(intent);

			}
		});
	}
}
