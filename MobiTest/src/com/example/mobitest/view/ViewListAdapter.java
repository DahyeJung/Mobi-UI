package com.example.mobitest.view;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mobitest.R;

public class ViewListAdapter extends ArrayAdapter<Category>{

	public ViewListAdapter adapter;

	TextView webtoon_title, date, rating_avg, ink, view_cost;
	ImageView img_rating_avg, bg_ink_bg_blue, tag_ink, tag_shared, tag_download, tag_gift;
	RelativeLayout img;
	

	private boolean imgpressed = false;

	View v = null;



	private ArrayList<Category> items;

	public ViewListAdapter(Context context, int textViewResourceId, ArrayList<Category> items) {
		super(context, textViewResourceId, items);
		this.items = items;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		//View v = null;
		LayoutInflater l = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = l.inflate(R.layout.view_contents, null);

		tag_shared = (ImageView)v.findViewById(R.id.imageButton1);
		tag_download = (ImageView)v.findViewById(R.id.imageButton2);
		tag_gift = (ImageView)v.findViewById(R.id.imageButton3);

		tag_shared.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(imgpressed == false){
					imgpressed = true;
					tag_shared.setBackgroundResource(R.drawable.tag_shared_active);
				}else if(imgpressed == true){
					tag_shared.setBackgroundResource(R.drawable.tag_shared);
				}
			}
		});

		tag_download.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(imgpressed == false){
					imgpressed = true;
					tag_shared.setBackgroundResource(R.drawable.tag_downloaded_active);
				}else if(imgpressed == true){
					tag_shared.setBackgroundResource(R.drawable.tag_downloaded);
				}
			}
		});

		tag_gift.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(imgpressed == false){
					imgpressed = true;
					tag_shared.setBackgroundResource(R.drawable.tag_gifted_active);
				}else if(imgpressed == true){
					tag_shared.setBackgroundResource(R.drawable.tag_gifted);
				}
			}
		});

		webtoon_title = (TextView)v.findViewById(R.id.textView1);
		date = (TextView)v.findViewById(R.id.textView2);
		rating_avg = (TextView)v.findViewById(R.id.textView3);
		img_rating_avg = (ImageView)v.findViewById(R.id.imageView2);
		img = (RelativeLayout)v.findViewById(R.id.imageView1);
		view_cost = (TextView)v.findViewById(R.id.textView4);
		tag_ink = (ImageView)v.findViewById(R.id.imageView3);
		String ratingavg = items.get(position).getRating_avg();
		double double_ratingavg = Double.valueOf(ratingavg).doubleValue();

		if(double_ratingavg>=0 && double_ratingavg<=3.0){
			img.setBackgroundColor(Color.RED);
		}if(double_ratingavg>=3.1 && double_ratingavg <=7.0){
			img.setBackgroundColor(Color.GREEN);
		}if(double_ratingavg>=7.1 && double_ratingavg <=9.9){
			img.setBackgroundColor(Color.BLUE);
		}if(double_ratingavg==10){
			img.setBackgroundColor(Color.WHITE);
		}

		if(double_ratingavg == 0.0 ){
			img_rating_avg.setImageResource(R.drawable.rate_0);
		}else if(double_ratingavg>0.0 && double_ratingavg<2.0){
			img_rating_avg.setImageResource(R.drawable.rate_1);
		}else if(double_ratingavg>=2.0 && double_ratingavg<3.0){
			img_rating_avg.setImageResource(R.drawable.rate_2);
		}else if(double_ratingavg>=3.0 && double_ratingavg<4.0){
			img_rating_avg.setImageResource(R.drawable.rate_3);
		}else if(double_ratingavg>=4.0 && double_ratingavg<5.0){
			img_rating_avg.setImageResource(R.drawable.rate_4);
		}else if(double_ratingavg>=5.0 && double_ratingavg<6.0){
			img_rating_avg.setImageResource(R.drawable.rate_5);
		}else if(double_ratingavg>=6.0 && double_ratingavg<7.0){
			img_rating_avg.setImageResource(R.drawable.rate_6);
		}else if(double_ratingavg>=7.0 && double_ratingavg<8.0){
			img_rating_avg.setImageResource(R.drawable.rate_7);
		}else if(double_ratingavg>=8.0 && double_ratingavg<9.0){
			img_rating_avg.setImageResource(R.drawable.rate_8);
		}else if(double_ratingavg>=9.0 && double_ratingavg<=9.9){
			img_rating_avg.setImageResource(R.drawable.rate_9);
		}else if(double_ratingavg == 10.0){
			img_rating_avg.setImageResource(R.drawable.rate_10);
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
		webtoon_title.setText("["+items.get(position).getEpisode_order()+"회] "+items.get(position).getEpisode_title());
		date.setText(items.get(position).getPublishing_date());
		rating_avg.setText(Avg);

		view_cost.setText(items.get(position).getView_cost());

		if(items.get(position).getGold_ink_only().equals(true)){
			tag_ink.setImageResource(R.drawable.tag_ink_bg_gold);
		}else {
			tag_ink.setImageResource(R.drawable.tag_ink_bg_blue);
		}
		return v;
	}

}