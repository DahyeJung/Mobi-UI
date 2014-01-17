package com.example.mobitest.main;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
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

	public MainLeftListAdapter(Context context, int textViewResourceId, ArrayList<ListData> items) {
		super(context, textViewResourceId, items);
		this.items = items;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		if(v==null){
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.main_left, null);
		}
		ListData listdata = items.get(position);

		TextView lefttv = (TextView)v.findViewById(R.id.left_text);
		ImageView leftArrow = (ImageView) v.findViewById(R.id.left_arrow);
		
		if(listdata != null){
			lefttv.setText(listdata.getDay());
		}
		
		if(position == selected) {
			leftArrow.setVisibility(View.VISIBLE);
			lefttv.setTextColor(Color.parseColor("#ffe4354a"));
			
		}
		else {
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
