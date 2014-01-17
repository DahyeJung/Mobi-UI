package com.example.mobitest.main;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.json.JSONArray;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.mobitest.R;
import com.example.mobitest.login.Login;
import com.example.mobitest.view.ViewListAdapter;

public class MainRightListAdapter extends ArrayAdapter<Category>{

	public ListData data;
	public MainLeftListAdapter adapter;
	public MainRightListAdapter adapter2;

	ImageButton search, menuRight, menuLeft, filterArrow;
	TextView title, no, toonNickname, toonTitle, toonAgelimit, toonDaysOfWeek, toonGenreMain, toonGenreSub, toonIsFamous, toonRatingAvg, toonPublishingDate;
	Button together, buyink, country;
	ListView list;
	ImageView adult, arrow, isfamous, rate;
	RelativeLayout rl_img;

	Login lg = new Login();

	String friendsJSON;
	JSONArray JsonArray = null;
	JsonParsingHelper parser = new JsonParsingHelper();

	boolean imgpressed = false;

	View v = null;
		
	private ArrayList<Category> items;
	
	private final static Comparator<Category> ratingComparator = new Comparator<Category>() {
		
		@Override
		public int compare(Category lhs, Category rhs) {
			float lhsRating = Float.valueOf(lhs.RatingAvg);
			float rhsRating = Float.valueOf(rhs.RatingAvg);
			
			if(lhsRating > rhsRating) {
				return -2;
			}
			
			return 2;
		}
	};
	
	private final static Comparator<Category> dataComparator = new Comparator<Category>() {
		private final Collator collator = Collator.getInstance();
		
		@Override
		public int compare(Category lhs, Category rhs) {
			String lhsDate = lhs.PublishingDate;
			String rhsDate = rhs.PublishingDate;
			
			return collator.compare(rhsDate, lhsDate);
		}
	};

	private final static Comparator<Category> viewcountComparator = new Comparator<Category>() {
		private final Collator collator = Collator.getInstance();
		
		@Override
		public int compare(Category lhs, Category rhs) {
			String lhsDate = lhs.ViewCount;
			String rhsDate = rhs.ViewCount;
			
			return collator.compare(rhsDate, lhsDate);
		}
	};

	public MainRightListAdapter(Context context, int textViewResourceId, ArrayList<Category> items) {
		super(context, textViewResourceId, items);
		this.items = items;	
	}
	
	public static final int METHOD_BY_UPDATE = 0;
	public static final int METHOD_BY_RATING = 1;
	public static final int METHOD_BY_VIEWCOUNT = 2;
	
	public void sortBy(int method) {
		switch (method) {
		case METHOD_BY_UPDATE: // by update date
			Collections.sort(this.items,dataComparator);
			break;
		case METHOD_BY_RATING: // by rating
			Collections.sort(this.items,ratingComparator);
			break;
		case METHOD_BY_VIEWCOUNT: // by viewcount
			Collections.sort(this.items,viewcountComparator);
		default:
			
			break;
		}
		
		notifyDataSetChanged();
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
		isfamous = (ImageView)v.findViewById(R.id.good_img);
		rl_img = (RelativeLayout)v.findViewById(R.id.img);
		rate = (ImageView)v.findViewById(R.id.rate_img);
		
		adult.setVisibility(View.INVISIBLE);
		isfamous.setVisibility(View.INVISIBLE);
		
//		ImageView ivBorder = ((ImageView)v.findViewById(R.id.border));
//		ivBorder.setImageDrawable(new ColorDrawable(0xFF0000FF));
//		ivBorder.setVisibility(View.VISIBLE);

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
			double_ratingavg1 = Double.parseDouble(ratingavg);
			int_ratingavg = (int) Math.floor(double_ratingavg1);
			Avg = Integer.toString(int_ratingavg);
		}

		String famous = items.get(position).getIsFamous();

		if(famous.equals("true")){
			isfamous.setVisibility(View.VISIBLE);
		}


		toonNickname.setText(items.get(position).getNickname());
		toonTitle.setText(items.get(position).getToonTitle());
		/*toonAgelimit.setText(Rightlist.get(position).getAgeLimit());
		toonDaysOfWeek.setText(Rightlist.get(position).getDaysOfWeek());
		toonGenreMain.setText(Rightlist.get(position).getGenreMain());
		toonGenreSub.setText(Rightlist.get(position).getGenreSub());
		toonIsFamous.setText(Rightlist.get(position).getIsFamous());*/
		toonRatingAvg.setText(Avg);
		toonPublishingDate.setText(items.get(position).getPublishingDate());
		return v;
	}

}