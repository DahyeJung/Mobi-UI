package com.example.mobitest.main;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
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

public class Main_my extends Activity{

	public ArrayList<Category> RightArray;
	public ArrayList<ListData> LeftArray;
	public ListData Leftdata;
	public ArrayList<String> MainArray;
	public ArrayAdapter<String> adapter;
	public MainLeftListAdapter Leftadapter;//왼쪽
	public MainRightListAdapter Rightadapter;//오른쪽
	ImageButton search, menuRight, menuLeft, filterArrow, more;
	TextView title, toonNickname, toonTitle, toonAgelimit, toonDaysOfWeek, toonGenreMain, toonGenreSub, toonIsFamous, toonRatingAvg, toonPublishingDate;
	Button together, buyink, country;
	ListView Leftlist, Rightlist;
	ImageView adult;
	RelativeLayout rl_img;
	LinearLayout title_linear;

	Login lg = new Login();

	String webtoonJSON;
	JSONArray JsonArray = null;
	JsonParsingHelper parser = new JsonParsingHelper();

	AlertDialog alertDialogStores;

	int sortMethod = MainRightListAdapter.METHOD_BY_UPDATE;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.main_my_list);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.main_title);

		MainArray = new ArrayList<String>();
		MainArray.add("업데이트순");
		MainArray.add("조회순");
		MainArray.add("별점순");

		search = (ImageButton)findViewById(R.id.search);
		menuRight = (ImageButton)findViewById(R.id.menu_right);
		menuLeft = (ImageButton)findViewById(R.id.menu_left);
		title = (TextView)findViewById(R.id.main_title);
		Rightlist = (ListView)findViewById(R.id.rightlist);
		Leftlist = (ListView)findViewById(R.id.leftlist);
		webtoonJSON = Utils.jsonToStringFromAssetFolder("file/toons.json", getApplicationContext());

		menuRight.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Main_my.this,Account.class);
				//				intent.putExtra("main_my", "main_my");
				startActivity(intent);
			}
		});

		menuLeft.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Main_my.this,MainLeftMenu.class);
				startActivity(intent);

			}
		});

		more = (ImageButton)findViewById(R.id.more);

		title_linear = (LinearLayout)findViewById(R.id.linearlayout);
		title_linear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				showPopUp();

			}
		});

		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

		LeftArray = new ArrayList<ListData>();

		Leftdata = new ListData("관심");
		LeftArray.add(Leftdata);
		Leftdata = new ListData("최근");
		LeftArray.add(Leftdata);
		Leftdata = new ListData("저장");
		LeftArray.add(Leftdata);


		Leftadapter = new MainLeftListAdapter(this, android.R.layout.simple_list_item_1, LeftArray, MainLeftListAdapter.TYPE_MY);
		Leftlist.setAdapter(Leftadapter);
		Leftlist.setOnItemClickListener(itemClickListenerofDaysOfWeek);
		Leftlist.setCacheColorHint(0x00000000);
		Leftlist.setSelector(new ColorDrawable(Color.TRANSPARENT));
		Leftlist.setDivider(null);

		try {
			RightArray = parser.getWebtoons(webtoonJSON, 0, JsonParsingHelper.TYPE_MY);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		RightadapterSetting();
		Rightadapter.notifyDataSetChanged();
		Rightadapter.sortBy(MainRightListAdapter.METHOD_BY_UPDATE);
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

			Intent intent = new Intent(Main_my.this, com.example.mobitest.view.View.class);

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

		if(pos == 0){
			try {
				RightArray = parser.getWebtoons(webtoonJSON, 0, JsonParsingHelper.TYPE_MY);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
			}

			RightadapterSetting();
			Rightlist.setAdapter(Rightadapter);

		}else {
			RightArray.clear();
			RightadapterSetting();
			Rightlist.setAdapter(Rightadapter);
			Toast.makeText(Main_my.this, "해당 작품이 없습니다.", Toast.LENGTH_LONG).show();
		}

	}//onLeftItemClick

	public void RightadapterSetting(){
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

		alertDialogStores = new AlertDialog.Builder(Main_my.this).setView(listViewItems).show();
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
