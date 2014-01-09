package com.example.mobitest.main;

import java.util.ArrayList;

import javax.security.auth.PrivateCredentialPermission;

import org.json.JSONArray;

import android.content.Context;
import android.graphics.Color;
import android.text.method.ArrowKeyMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.mobitest.R;
import com.example.mobitest.login.Login;

public class MainListAdapter5 extends ArrayAdapter<Category>{

	public ListData data;
	public MainListAdapter adapter;
	public MainListAdapter5 adapter2;

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



	private ArrayList<Category> items;

	public MainListAdapter5(Context context, int textViewResourceId, ArrayList<Category> items) {
		super(context, textViewResourceId, items);
		this.items = items;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		//View v = null;
		LayoutInflater l = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = l.inflate(R.layout.main_right, null);

		toonNickname = (TextView)v.findViewById(R.id.right_nickname);
		toonTitle = (TextView)v.findViewById(R.id.right_title);	
		/*toonAgelimit = (TextView)v.findViewById(R.id.right_age_limit);
		toonDaysOfWeek = (TextView)v.findViewById(R.id.right_days_of_week);
		toonGenreMain = (TextView)v.findViewById(R.id.right_genre_main);
		toonGenreSub = (TextView)v.findViewById(R.id.right_genre_sub);
		toonIsFamous = (TextView)v.findViewById(R.id.right_is_famous);*/
		toonRatingAvg = (TextView)v.findViewById(R.id.right_rating_avg);
		toonPublishingDate = (TextView)v.findViewById(R.id.right_publishing_date);
		adult = (ImageView)v.findViewById(R.id.adult);
		rl_img = (RelativeLayout)v.findViewById(R.id.img);

		adult.setVisibility(View.INVISIBLE);

		
			String agelimit = items.get(position).getAgeLimit();
			int int_agelimit = Integer.parseInt(agelimit);
			if(int_agelimit==19){
				adult.setVisibility(View.VISIBLE);
			}
			String ratingavg = items.get(position).getRatingAvg();
			double double_ratingavg = Double.valueOf(ratingavg).doubleValue();

			if(double_ratingavg>=0 && double_ratingavg<=3.0){
				rl_img.setBackgroundColor(Color.RED);
			}if(double_ratingavg>=3.1 && double_ratingavg <=7.0){
				rl_img.setBackgroundColor(Color.GREEN);
			}if(double_ratingavg>=7.1 && double_ratingavg <=9.9){
				rl_img.setBackgroundColor(Color.BLUE);
			}if(double_ratingavg==10){
				rl_img.setBackgroundColor(Color.WHITE);
			}
			double double_ratingavg1 = 0;
			String Avg = null;
			int int_ratingavg = 0;
			if(double_ratingavg!=10){
				double_ratingavg1 = Double.parseDouble(String.format("%.1f", double_ratingavg));
				Avg = Double.toString(double_ratingavg1);
			}else{
				double_ratingavg1 = Double.parseDouble(ratingavg);
				int_ratingavg = (int) Math.floor(double_ratingavg1);
				Avg = Integer.toString(int_ratingavg);
			}

			toonNickname.setText(items.get(position).getNickname());
			toonTitle.setText(items.get(position).getToonTitle());
			/*toonAgelimit.setText(Rightlist.get(position).getAgeLimit());
		toonDaysOfWeek.setText(Rightlist.get(position).getDaysOfWeek());
		toonGenreMain.setText(Rightlist.get(position).getGenreMain());
		toonGenreSub.setText(Rightlist.get(position).getGenreSub());
		toonIsFamous.setText(Rightlist.get(position).getIsFamous());*/
			//	toonRatingAvg.setText(Rightlist.get(position).getRatingAvg());
			toonRatingAvg.setText(Avg);
			toonPublishingDate.setText(items.get(position).getPublishingDate());
		
		return v;
	}

}