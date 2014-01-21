package com.example.mobitest.main;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobitest.R;

public class MainLeftListAdapter_OLD extends ArrayAdapter<ListData>{

	private ArrayList<ListData> items;
	
	int selected = 0;
	int type = 0;
	public static final int TYPE_DAY = 0;
	public static final int TYPE_GENRE = 1;
	public static final int TYPE_MY = 2;
	

	public MainLeftListAdapter_OLD(Context context, int textViewResourceId, ArrayList<ListData> items, int type) {
		super(context, textViewResourceId, items);
		this.items = items;
		this.type = type;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		View v2 = convertView;
		View v3 = convertView;
		if(v==null){
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.main_left, null);
			v2 = vi.inflate(R.layout.main_left_genre, null);
			v3 = vi.inflate(R.layout.main_left_my, null);
		}
		ListData listdata = items.get(position);

		TextView lefttv = (TextView)v.findViewById(R.id.left_text);
		ImageView leftArrow = (ImageView) v.findViewById(R.id.left_arrow);

		if(listdata != null){
			lefttv.setText(listdata.getDay());
		}
		if(position==7){
			lefttv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
			lefttv.setPadding(10, 22, 10, 22);
		}
		else {
			lefttv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25);
			lefttv.setPadding(20, 6, 20, 6);
			
		}

		if(position == selected) {
			leftArrow.setVisibility(View.VISIBLE);
			lefttv.setTextColor(0xffe4354a);
		}else {
			leftArrow.setVisibility(View.INVISIBLE);
			lefttv.setTextColor(Color.parseColor("#ff777777"));
		}
		
		TextView lefttv2 = (TextView)v2.findViewById(R.id.left_text);
		ImageView leftArrow2 = (ImageView)v2.findViewById(R.id.left_arrow);

		if(listdata != null){
			lefttv2.setText(listdata.getDay());
		}
		if(0<=position && position<=6){
			lefttv2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
			lefttv2.setPadding(10, 20, 10, 20);
		}

		if(position == selected) {
			leftArrow2.setVisibility(View.VISIBLE);
			lefttv2.setTextColor(Color.parseColor("#ffe4354a"));
		}else {
			leftArrow2.setVisibility(View.INVISIBLE);
			lefttv2.setTextColor(Color.parseColor("#ff777777"));
		}
		
		TextView lefttv3 = (TextView)v3.findViewById(R.id.left_text);
		ImageView leftArrow3 = (ImageView)v3.findViewById(R.id.left_arrow);

		if(listdata != null){
			lefttv3.setText(listdata.getDay());
		}
		
		if(position>=0 && position<=2){
			lefttv3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
			lefttv3.setPadding(10, 20, 10, 20);
		}

		if(position == selected) {
			leftArrow3.setVisibility(View.VISIBLE);
			lefttv3.setTextColor(Color.parseColor("#ffe4354a"));
		}else {
			leftArrow3.setVisibility(View.INVISIBLE);
			lefttv3.setTextColor(Color.parseColor("#ff777777"));
		}

		switch (type) {
		case TYPE_DAY:
			return v;
			
		case TYPE_GENRE:
			return v2;
			
		case TYPE_MY:
		default:
			return v3;
		}
	}	

}




