package com.example.mobitest.main;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mobitest.Network;
import com.example.mobitest.R;

public class MainLeftMenu extends Activity{

	RelativeLayout rl1, rl2, rl3;
	ImageView icon_date, icon_genre, icon_my, menu_arrow1, menu_arrow2, menu_arrow3;
	TextView date, genre, my;
	
	Network nw = new Network();
	
	Typeface typeface;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.main_menu_left);
		rl1 = (RelativeLayout)findViewById(R.id.rl1);
		rl2 = (RelativeLayout)findViewById(R.id.rl2);
		rl3 = (RelativeLayout)findViewById(R.id.rl3);
		icon_date = (ImageView)findViewById(R.id.imageView3);
		icon_genre = (ImageView)findViewById(R.id.imageView5);
		icon_my = (ImageView)findViewById(R.id.imageView8);
		menu_arrow1 = (ImageView)findViewById(R.id.imageView4);
		menu_arrow2 = (ImageView)findViewById(R.id.imageView6);
		menu_arrow3 = (ImageView)findViewById(R.id.imageView9);
		date = (TextView)findViewById(R.id.textView1);
		genre = (TextView)findViewById(R.id.textView2);
		my = (TextView)findViewById(R.id.textView3);
		
		typeface = nw.typeface;
		date.setTypeface(typeface);
		genre.setTypeface(typeface);
		my.setTypeface(typeface);
		
		//요일별 웹툰
		rl1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainLeftMenu.this,Main.class);
				startActivity(intent);
			}
		});

		//장르별 웹툰
		rl2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainLeftMenu.this,Main_genre.class);
				startActivity(intent);
			}
		});

		//마이웹툰
		rl3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainLeftMenu.this,Main_my.class);
				startActivity(intent);
			}
		});
	}
	//뒤로가기
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {

		if(keyCode == KeyEvent.KEYCODE_BACK){

			Intent intent = new Intent(MainLeftMenu.this,Main.class);
			startActivity(intent);
		}

		return false;
	};

}
