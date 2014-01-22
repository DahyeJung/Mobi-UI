package com.example.mobitest.view;

import java.util.ArrayList;

import org.json.JSONException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobitest.Network;
import com.example.mobitest.R;
import com.example.mobitest.login.Login;

public class View extends Activity{

	public ArrayList<Category> ListArray;
	public ViewListAdapter listadapter;
	ImageButton backBtn, favorBtn, alarmBtn;
	TextView title, toonNickname, toonTitle, Title, NickName, RatingAvg, toonAgelimit, toonDaysOfWeek, toonGenreMain, toonGenreSub, toonIsFamous, toonRatingAvg, toonPublishingDate;
	ListView listView;
	ImageView adult, toon_info, first_chap, download, gift, rate, top, bottom;
	RelativeLayout rl_img;
	Button button1, button2, button3, button4;

	Network nw = new Network();
	Login lg = new Login();

	String webtoonJSON;
	String toon_title;
	String toon_nickname;
	String rating_avg;

	Typeface typeface;
	
	JsonParsingHelper parser = new JsonParsingHelper();

	private boolean imgpressed = false;
	private boolean imgpressed2 = false;
	
	double double_ratingavg;
	View v = null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.view);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.view_title);

		Intent intent = getIntent();
		toon_title = intent.getStringExtra("title");
		toon_nickname = intent.getStringExtra("nickname");
		rating_avg = intent.getStringExtra("rating_avg");
		
		rate = (ImageView)findViewById(R.id.imageView2);
		
		double double_ratingavg = Double.valueOf(rating_avg).doubleValue();

		if(double_ratingavg == 0.0 ){
			rate.setImageResource(R.drawable.rate_0);
		}else if(double_ratingavg>0.0 && double_ratingavg<2.0){
			rate.setImageResource(R.drawable.rate_1);
		}else if(double_ratingavg>=2.0 && double_ratingavg<3.0){
			rate.setImageResource(R.drawable.rate_2);
		}else if(double_ratingavg>=3.0 && double_ratingavg<4.0){
			rate.setImageResource(R.drawable.rate_3);
		}else if(double_ratingavg>=4.0 && double_ratingavg<5.0){
			rate.setImageResource(R.drawable.rate_4);
		}else if(double_ratingavg>=5.0 && double_ratingavg<6.0){
			rate.setImageResource(R.drawable.rate_5);
		}else if(double_ratingavg>=6.0 && double_ratingavg<7.0){
			rate.setImageResource(R.drawable.rate_6);
		}else if(double_ratingavg>=7.0 && double_ratingavg<8.0){
			rate.setImageResource(R.drawable.rate_7);
		}else if(double_ratingavg>=8.0 && double_ratingavg<9.0){
			rate.setImageResource(R.drawable.rate_8);
		}else if(double_ratingavg>=9.0 && double_ratingavg<=9.9){
			rate.setImageResource(R.drawable.rate_9);
		}else if(double_ratingavg == 10.0){
			rate.setImageResource(R.drawable.rate_10);
		}
		
		double double_ratingavg1 = 0;
		String Avg = null;
		int int_ratingavg = 0;
		if(double_ratingavg!=10){
			double_ratingavg1 = Double.parseDouble(String.format("%.1f", double_ratingavg));
			Avg = Double.toString(double_ratingavg1);
		}else{
			double_ratingavg1 = Double.parseDouble(rating_avg);
			int_ratingavg = (int) Math.floor(double_ratingavg1);
			Avg = Integer.toString(int_ratingavg);
		}

		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		button3 = (Button)findViewById(R.id.button3);
		button4 = (Button)findViewById(R.id.button4);
		toon_info = (ImageView)findViewById(R.id.imageView3);
		first_chap = (ImageView)findViewById(R.id.imageView4);
		download = (ImageView)findViewById(R.id.imageView5);
		gift = (ImageView)findViewById(R.id.ImageView6);
		top = (ImageView)findViewById(R.id.top);
		bottom = (ImageView)findViewById(R.id.bottom);
		Title = (TextView)findViewById(R.id.textView1);
		Title.setText(toon_title);
		typeface = nw.typeface;
		Title.setTypeface(typeface);
		
		NickName = (TextView)findViewById(R.id.textView3);
		NickName.setText(toon_nickname);
		NickName.setTypeface(typeface);
		RatingAvg = (TextView)findViewById(R.id.textView2);
		RatingAvg.setText(Avg);
		RatingAvg.setTypeface(typeface);
		backBtn = (ImageButton)findViewById(R.id.backBtn);

		backBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(android.view.View v) {

				onBackPressed();
			}
		});


		favorBtn = (ImageButton)findViewById(R.id.favorBtn);
		favorBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(android.view.View v) {
				if(imgpressed == false){
					imgpressed = true;
					favorBtn.setBackgroundResource(R.drawable.favor_over);
				}else if(imgpressed == true){
					imgpressed = false;
					favorBtn.setBackgroundResource(R.drawable.favor);
				}

			}
		});

		alarmBtn = (ImageButton)findViewById(R.id.alarmBtn);
		alarmBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(android.view.View v) {
				if(imgpressed2 == false){
					imgpressed2 = true;
					alarmBtn.setBackgroundResource(R.drawable.alarm_over);
				}else if(imgpressed2 == true){
					imgpressed2 = false;
					alarmBtn.setBackgroundResource(R.drawable.alarm);
				}
			}
		});

		button1.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(android.view.View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					toon_info.setImageResource(R.drawable.toon_info_over);
					button1.setTextColor(Color.parseColor("#e4354a"));
					button1.setBackgroundColor(Color.parseColor("#111111"));
				}if(event.getAction()==MotionEvent.ACTION_UP){
					toon_info.setImageResource(R.drawable.toon_info);
					button1.setTextColor(Color.parseColor("#d6d6d6"));
					button1.setBackgroundColor(Color.parseColor("#202020"));
				}

				return false;
			}
		});

		button2.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(android.view.View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					first_chap.setImageResource(R.drawable.first_chap_over);
					button2.setTextColor(Color.parseColor("#e4354a"));
					button2.setBackgroundColor(Color.parseColor("#111111"));
					
				}if(event.getAction()==MotionEvent.ACTION_UP){
					first_chap.setImageResource(R.drawable.first_chap);
					button2.setTextColor(Color.parseColor("#d6d6d6"));
					button2.setBackgroundColor(Color.parseColor("#202020"));
				}
				return false;
			}
		});

		button3.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(android.view.View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					download.setImageResource(R.drawable.download_over);
					button3.setTextColor(Color.parseColor("#e4354a"));
					button3.setBackgroundColor(Color.parseColor("#111111"));
					
				}if(event.getAction()==MotionEvent.ACTION_UP){
					download.setImageResource(R.drawable.download);
					button3.setTextColor(Color.parseColor("#d6d6d6"));
					button3.setBackgroundColor(Color.parseColor("#202020"));
				}
				return false;
			}
		});

		button4.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(android.view.View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					gift.setImageResource(R.drawable.gift_over);
					button4.setTextColor(Color.parseColor("#e4354a"));
					button4.setBackgroundColor(Color.parseColor("#111111"));
					
				}if(event.getAction()==MotionEvent.ACTION_UP){
					gift.setImageResource(R.drawable.gift);
					button4.setTextColor(Color.parseColor("#d6d6d6"));
					button4.setBackgroundColor(Color.parseColor("#202020"));
				}


				return false;
			}
		});

		top.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(android.view.View v) {
				listView.setSelectionAfterHeaderView();
			}
		});

		bottom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(android.view.View v) {
				listView.setSelection(listView.getHeight());
				
			}
		});

		webtoonJSON = Utils.jsonToStringFromAssetFolder("file/toons_list.json", getApplicationContext());


		listView = (ListView)findViewById(R.id.listview);
		//new getList().execute();
		try {
			ListArray = parser.getWebtoons(webtoonJSON);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listadapter = new ViewListAdapter(this, android.R.layout.simple_list_item_1, ListArray);
		listView.setAdapter(listadapter);
		listView.setVerticalScrollBarEnabled(false);
		listView.setChoiceMode(ListView.CHOICE_MODE_NONE);
		listView.setCacheColorHint(0x00000000);
		listView.setSelector(new ColorDrawable(Color.TRANSPARENT));
		listView.setDivider(null);
	}//onCreate

	@Override
	public void onBackPressed() {
		Toast.makeText(this, "Bye!", Toast.LENGTH_SHORT).show();
		super.onBackPressed();
	}
	/**
	 * 종료버튼을 두번 눌렀을 때 나오는 dialogbox
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
