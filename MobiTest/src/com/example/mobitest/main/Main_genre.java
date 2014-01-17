package com.example.mobitest.main;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobitest.R;
import com.example.mobitest.account.Account;
import com.example.mobitest.login.Login;
import com.example.mobitest.setting.Setting;

public class Main_genre extends Activity{

	public ArrayList<Category> RightArray;
	public ArrayList<ListData> LeftArray;
	public ListData Leftdata;
	public ArrayList<String> MainArray;
	public ArrayAdapter<String> adapter;
	public MainLeftListAdapter2 Leftadapter;//왼쪽
	public MainRightListAdapter Rightadapter;//오른쪽
	ImageButton search, menuRight, menuLeft, filterArrow, more;
	TextView title, toonNickname, toonTitle, toonAgelimit, toonDaysOfWeek, toonGenreMain, toonGenreSub, toonIsFamous, toonRatingAvg, toonPublishingDate;
	Button together, buyink, country;
	ListView Leftlist, Rightlist;
	ImageView adult, arrow;
	RelativeLayout rl_img;
	LinearLayout title_linear;

	Login lg = new Login();

	String webtoonJSON;
	JSONArray JsonArray = null;
	JsonParsingHelper2 parser = new JsonParsingHelper2();

	AlertDialog alertDialogStores;

	int sortMethod = MainRightListAdapter.METHOD_BY_UPDATE;
	
	int pos = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.main_genre_list);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.main_title);

		MainArray = new ArrayList<String>();
		MainArray.add("업데이트순");
		MainArray.add("조회순");
		MainArray.add("별점순");

		search = (ImageButton)findViewById(R.id.search);
		menuRight = (ImageButton)findViewById(R.id.menu_right);
		menuLeft = (ImageButton)findViewById(R.id.menu_left);
		title = (TextView)findViewById(R.id.country_title);
		Rightlist = (ListView)findViewById(R.id.rightlist);
		Leftlist = (ListView)findViewById(R.id.leftlist);
		webtoonJSON = Utils.jsonToStringFromAssetFolder("file/toons.json", getApplicationContext());

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
				Intent intent = new Intent(Main_genre.this,Account.class);
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
		menuLeft.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Main_genre.this,MainLeftMenu.class);
				intent.putExtra("main_genre", "main_genre");
				startActivity(intent);

			}
		});

		more = (ImageButton)findViewById(R.id.more);

		title_linear = (LinearLayout)findViewById(R.id.linearlayout);
		title_linear.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				if(event.getAction()==MotionEvent.ACTION_DOWN){//버튼을 누르고 있을 때
					title.setTextColor(Color.parseColor("#e4354a"));
					more.setBackgroundResource(R.drawable.filter_arrow2);
				}if(event.getAction()==MotionEvent.ACTION_UP){//버튼을 누르지 않을 때
					title.setTextColor(Color.parseColor("#D0D0D0"));
					more.setBackgroundResource(R.drawable.filter_arrow);
				}
				return false;
			}
		});
		title_linear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				showPopUp();

			}
		});

		LeftArray = new ArrayList<ListData>();
		Leftdata = new ListData("판타지");
		LeftArray.add(Leftdata);
		Leftdata = new ListData("드라마");
		LeftArray.add(Leftdata);
		Leftdata = new ListData("일상");
		LeftArray.add(Leftdata);
		Leftdata = new ListData("액션");
		LeftArray.add(Leftdata);
		Leftdata = new ListData("순정");
		LeftArray.add(Leftdata);
		Leftdata = new ListData("감성");
		LeftArray.add(Leftdata);
		Leftdata = new ListData("스릴러");
		LeftArray.add(Leftdata);

		Leftadapter = new MainLeftListAdapter2(this, android.R.layout.simple_list_item_1, LeftArray);

		Leftlist.setAdapter(Leftadapter);
		Leftlist.setOnItemClickListener(itemClickListenerofDaysOfWeek);

		/*try {
			RightArray = parser.getWebtoons(webtoonJSON);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		onLeftItemClick(pos);
		ddd();

		Rightlist.setAdapter(Rightadapter);
		Rightlist.setOnItemClickListener(itemClickListenerRight);
		Rightlist.setVerticalScrollBarEnabled(false);
		Rightlist.setChoiceMode(ListView.CHOICE_MODE_NONE);
		Rightlist.setCacheColorHint(0x00000000);
		Rightlist.setSelector(new ColorDrawable(Color.TRANSPARENT));

	}//onCreate

	private OnItemClickListener itemClickListenerRight = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

			Intent intent = new Intent(Main_genre.this, com.example.mobitest.view.View.class);

			intent.putExtra("title",RightArray.get(position).getToonTitle()); 
			intent.putExtra("nickname", RightArray.get(position).getNickname());
			intent.putExtra("rating_avg", RightArray.get(position).getRatingAvg());

			startActivity(intent);
		}


	};

	/**
	 * Leftlistview item click
	 */
	private OnItemClickListener itemClickListenerofDaysOfWeek = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> adapterView, View clickedView, int pos,
				long id) {

			onLeftItemClick(pos);
			
		}
	};

	void onLeftItemClick(int pos){
		Leftadapter.selected = pos;
		Leftadapter.notifyDataSetChanged();
		
		try{
			RightArray = parser.getWebtoons(webtoonJSON, pos);
		}catch(JSONException e){
			
		}
		if(RightArray.size()==0){
			Toast.makeText(Main_genre.this, "해당 항목이 없습니다.", Toast.LENGTH_LONG).show();
		}
		ddd();
		Rightlist.setAdapter(Rightadapter);
	}
	
	public void ddd(){
		Rightadapter = new MainRightListAdapter(this, android.R.layout.simple_list_item_1, RightArray);
		onTitleClick(sortMethod);
	}


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

	public void showPopUp(){
		
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,MainArray);

		ListView listViewItems = new ListView(this);
		listViewItems.setAdapter(adapter);

		listViewItems.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {

				onTitleClick(pos);
				sortMethod = pos;
				alertDialogStores.dismiss();
			}
		});
		alertDialogStores = new AlertDialog.Builder(Main_genre.this).setView(listViewItems).show();
		
	}
		
		void onTitleClick(int pos){
			switch (pos) {
			case 0:
				Rightadapter.sortBy(MainRightListAdapter.METHOD_BY_UPDATE);
				break;

			case 1:
				Rightadapter.sortBy(MainRightListAdapter.METHOD_BY_VIEWCOUNT);
				break;	

			case 2:
				Rightadapter.sortBy(MainRightListAdapter.METHOD_BY_RATING);
				break;

			default:

				break;
			}
			title.setText(MainArray.get(pos));
		}
		
}
