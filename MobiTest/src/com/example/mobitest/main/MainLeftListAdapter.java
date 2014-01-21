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

public class MainLeftListAdapter extends ArrayAdapter<ListData>{

	private ArrayList<ListData> items;

	int selected = 0;
	int type = 0;
	public static final int TYPE_DAY = 0;
	public static final int TYPE_GENRE = 1;
	public static final int TYPE_MY = 2;


	public MainLeftListAdapter(Context context, int textViewResourceId, ArrayList<ListData> items, int type) {
		super(context, textViewResourceId, items);
		this.items = items;
		this.type = type;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if(v==null){
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			switch (type) {
			case TYPE_DAY:
				v = vi.inflate(R.layout.main_left, null);
				break;

			case TYPE_GENRE:
				v = vi.inflate(R.layout.main_left_genre, null);
				break;

			case TYPE_MY:
				v = vi.inflate(R.layout.main_left_my, null);
				break;


			default:
				break;
			}
		}
		ListData listdata = items.get(position);

		TextView lefttv = (TextView)v.findViewById(R.id.left_text);
		ImageView leftArrow = (ImageView) v.findViewById(R.id.left_arrow);
		if(listdata != null){
			lefttv.setText(listdata.getDay());
		}

		int textSize = 25;

		switch (type) {
		case TYPE_DAY:
			if(lefttv.length()==1){
				textSize = 26;
				lefttv.setPadding(20, 25, 20, 25);
			}else if(lefttv.length()==2){
				textSize = 21;
				lefttv.setPadding(10, 25, 10, 25);
			}
			
			
			break;

		case TYPE_GENRE:
			if(lefttv.length()==3){
				textSize = 19;
			//  lefttv.setPadding(left, top, right, bottom)
			}else if(lefttv.length()==2){
				textSize = 21;
			}
			lefttv.setPadding(10, 30, 10, 30);
			
			break;

		case TYPE_MY:

				textSize = 20;
				lefttv.setPadding(10, 30, 10, 30);
		
			break;


		default:
			break;
		}

		lefttv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,textSize);


		if(position == selected) {
			leftArrow.setVisibility(View.VISIBLE);
			lefttv.setTextColor(Color.parseColor("#ffe4354a"));
		}else {
			leftArrow.setVisibility(View.INVISIBLE);
			lefttv.setTextColor(Color.parseColor("#ff777777"));
		}




		return v;


	}	

}


class ListData{
	private String Day;
	public ListData(String Day){
		this.Day = Day;
	}
	public String getDay(){
		return Day;

	}
	public void setDay(String day){
		Day = day;
	}

}


