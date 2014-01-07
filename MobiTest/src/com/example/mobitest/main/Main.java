package com.example.mobitest.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mobitest.R;
import com.example.mobitest.Together;
import com.example.mobitest.buyink.BuyInk;
import com.example.mobitest.country.ChangeCountry;
import com.example.mobitest.login.Login;
import com.example.mobitest.setting.Setting;

public class Main extends Activity{
	/*
	private ArrayList<ListData> Leftlist;
	private ListData data;
	private MainListAdapter adapter;
	 */
	ImageButton search, menu_right, menu_left, filter_arrow;
	TextView title;
	Button together, buyink, country;
	
	Login lg = new Login();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.main_contents);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.main_title);

		search = (ImageButton)findViewById(R.id.search);
		menu_right = (ImageButton)findViewById(R.id.menu_right);
		menu_left = (ImageButton)findViewById(R.id.menu_left);
		filter_arrow = (ImageButton)findViewById(R.id.imageView1);
		title = (TextView)findViewById(R.id.title);
		together = (Button)findViewById(R.id.together);
		buyink = (Button)findViewById(R.id.buyink);
		country = (Button)findViewById(R.id.country);
		
		
		buyink.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					buyink.setBackgroundResource(R.drawable.login_btn_bg_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					buyink.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
				}
				return false;
			}
		});
		buyink.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Main.this,BuyInk.class);
				startActivity(intent);
			}
		});
		
		country.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					country.setBackgroundResource(R.drawable.login_btn_bg_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					country.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
				}
				return false;
			}
		});
		country.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Main.this,ChangeCountry.class);
				startActivity(intent);
			}
		});
		
		together.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					together.setBackgroundResource(R.drawable.login_btn_bg_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					together.setBackgroundResource(R.drawable.login_btn_bg);//버튼을 누르지 않을 때
				}
				return false;
			}
		});
		together.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Main.this,Together.class);
				startActivity(intent);
			}
		});
		
		
		search.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					search.setBackgroundResource(R.drawable.search_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					search.setBackgroundResource(R.drawable.search);//버튼을 누르지 않을 때
				}
				return false;
			}
		});

		menu_right.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					menu_right.setBackgroundResource(R.drawable.menu_right_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					menu_right.setBackgroundResource(R.drawable.menu_right);//버튼을 누르지 않을 때
				}

				return false;
			}
		});
		menu_right.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Main.this,Setting.class);
				startActivity(intent);
			}
		});

		menu_left.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					menu_left.setBackgroundResource(R.drawable.menu_left_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					menu_left.setBackgroundResource(R.drawable.menu_left);//버튼을 누르지 않을 때
				}
				return false;
			}
		});
		
		/*
		Leftlist = new ArrayList<ListData>();
		data = new ListData(R.drawable.main_icon_date);
		Leftlist.add(data);
		data = new ListData("월");
		Leftlist.add(data);
		data = new ListData("화");
		Leftlist.add(data);
		data = new ListData("수");
		Leftlist.add(data);
		data = new ListData("목");
		Leftlist.add(data);
		data = new ListData("금");
		Leftlist.add(data);
		data = new ListData("토");
		Leftlist.add(data);
		data = new ListData("일");
		Leftlist.add(data);

		ListView custom_left_list = (ListView)findViewById(R.id.Leftlistview);
		adapter = new MainListAdapter(this, android.R.layout.simple_list_item_1, Leftlist);
		custom_left_list.setAdapter(adapter);*/
		
		
	}//onCreate
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		if(keyCode == KeyEvent.KEYCODE_BACK){
			AlertDialog dialog = createdialogBox();//alertdialog 객체 생성
			dialog.show();
		}

		
		return false;
	}

	public AlertDialog createdialogBox() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("알림!");
		builder.setMessage("종료하시겠습니까?");
		builder.setIcon(R.drawable.icon);
		builder.setPositiveButton("네", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				lg.ExitProcess();
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
	
	
}
