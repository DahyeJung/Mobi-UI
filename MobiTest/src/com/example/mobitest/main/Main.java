package com.example.mobitest.main;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
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

import com.example.mobitest.R;
import com.example.mobitest.login.Login;
import com.example.mobitest.setting.Setting;

public class Main extends Activity{

	public ArrayList<Category> Rightlist;
	public ArrayList<ListData> Leftlist;
	public ListData data;
	public MainListAdapter leftadapter;//왼쪽
	public MainListAdapter2 rightadapter;//월
	public MainListAdapter3 rightadapter2;//화
	public MainListAdapter4 rightadapter3;//수
	public MainListAdapter5 rightadapter4;//목
	public MainListAdapter6 rightadapter5;//금
	public MainListAdapter7 rightadapter6;//토
	public MainListAdapter8 rightadapter7;//일
	public MainListAdapter9 rightadapter8;//완결


	ImageButton search, menuRight, menuLeft, filterArrow;
	TextView title, toonNickname, toonTitle, toonAgelimit, toonDaysOfWeek, toonGenreMain, toonGenreSub, toonIsFamous, toonRatingAvg, toonPublishingDate;
	Button together, buyink, country;
	ListView list;
	ImageView adult, arrow;
	RelativeLayout rl_img;

	Login lg = new Login();

	String friendsJSON;
	JSONArray JsonArray = null;
	JsonParsingHelper parser = new JsonParsingHelper();

	boolean imgpressed = false;

	View v = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.main_list);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.main_title);

		search = (ImageButton)findViewById(R.id.search);
		menuRight = (ImageButton)findViewById(R.id.menu_right);
		menuLeft = (ImageButton)findViewById(R.id.menu_left);
		filterArrow = (ImageButton)findViewById(R.id.imageView1);
		title = (TextView)findViewById(R.id.title);
		together = (Button)findViewById(R.id.together);
		buyink = (Button)findViewById(R.id.buyink);
		country = (Button)findViewById(R.id.country);
		list = (ListView)findViewById(R.id.rightlist);

		friendsJSON = Utils.jsonToStringFromAssetFolder("file/toons.json", getApplicationContext());

		//new getList().execute();
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

		menuRight.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					menuRight.setBackgroundResource(R.drawable.menu_right_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					menuRight.setBackgroundResource(R.drawable.menu_right);//버튼을 누르지 않을 때
				}

				return false;
			}
		});
		menuRight.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Main.this,Setting.class);
				startActivity(intent);
			}
		});

		menuLeft.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					menuLeft.setBackgroundResource(R.drawable.menu_left_over);
				}if(event.getAction()==MotionEvent.ACTION_UP){
					menuLeft.setBackgroundResource(R.drawable.menu_left);//버튼을 누르지 않을 때
				}
				return false;
			}
		});

		Leftlist = new ArrayList<ListData>();
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
		data = new ListData("완결");
		Leftlist.add(data);

		ListView custom_left_list = (ListView)findViewById(R.id.leftlist);
		leftadapter = new MainListAdapter(this, android.R.layout.simple_list_item_1, Leftlist);

		custom_left_list.setAdapter(leftadapter);
		custom_left_list.setOnItemClickListener(itemClickListenerofDaysOfWeek);

		try {
			Rightlist = parser.getCities(friendsJSON);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rightadapter = new MainListAdapter2(this, android.R.layout.simple_list_item_1, Rightlist);


		try {
			Rightlist = parser.getCities2(friendsJSON);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rightadapter2 = new MainListAdapter3(this, android.R.layout.simple_list_item_1, Rightlist);


		try {
			Rightlist = parser.getCities3(friendsJSON);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rightadapter3 = new MainListAdapter4(this, android.R.layout.simple_list_item_1, Rightlist);


		try {
			Rightlist = parser.getCities4(friendsJSON);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rightadapter4 = new MainListAdapter5(this, android.R.layout.simple_list_item_1, Rightlist);


		try {
			Rightlist = parser.getCities5(friendsJSON);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rightadapter5 = new MainListAdapter6(this, android.R.layout.simple_list_item_1, Rightlist);


		try {
			Rightlist = parser.getCities6(friendsJSON);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rightadapter6 = new MainListAdapter7(this, android.R.layout.simple_list_item_1, Rightlist);


		try {
			Rightlist = parser.getCities7(friendsJSON);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rightadapter7 = new MainListAdapter8(this, android.R.layout.simple_list_item_1, Rightlist);


		/*	try {
			Rightlist = parser.getCities8(friendsJSON);//완결
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		list.setVerticalScrollBarEnabled(true);
		list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

	}//onCreate
	/**
	 * Leftlistview item click
	 */
	private OnItemClickListener itemClickListenerofDaysOfWeek = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> adapterView, View clickedView, int pos,
				long id) {


			LayoutInflater l =(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = l.inflate(R.layout.main_left, null);
			arrow = (ImageView)findViewById(R.id.left_arrow);

			imgpressed = true;

			if(imgpressed==true){
				Toast toast = Toast.makeText(Main.this, (pos+1)+"번째 눌러졌음", Toast.LENGTH_LONG);
				toast.show();
				arrow.setVisibility(View.VISIBLE);
				imgpressed = false;
			}else if(imgpressed==false){
				Toast toast = Toast.makeText(Main.this, (pos+1)+"번째 손 뗌", Toast.LENGTH_LONG);
				toast.show();
				arrow.setVisibility(View.INVISIBLE);
				imgpressed = true;
			}

			if(pos == 0){
				//월요일인 값. 나와야됨
				list.setAdapter(rightadapter);
			}else if(pos == 1){
				list.setAdapter(rightadapter2);
			}else if(pos == 2){
				list.setAdapter(rightadapter3);
			}else if(pos == 3){
				list.setAdapter(rightadapter4);
			}else if(pos == 4){
				list.setAdapter(rightadapter5);
			}else if(pos == 5){
				list.setAdapter(rightadapter6);
			}else if(pos == 6){
				list.setAdapter(rightadapter6);
			}

		}
	};

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if(keyCode == KeyEvent.KEYCODE_BACK){
			AlertDialog dialog = createdialogBox();//alertdialog 객체 생성
			dialog.show();
		}
		return false;
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
