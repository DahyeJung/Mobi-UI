package com.example.mobitest.main;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobitest.R;

public class MainLeftListAdapter3 extends ArrayAdapter<ListData>{

	private ArrayList<ListData> items;

	public MainLeftListAdapter3(Context context, int textViewResourceId, ArrayList<ListData> items) {
		super(context, textViewResourceId, items);
		this.items = items;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if(v==null){
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.main_left_my, null);
		}
		ListData listdata = items.get(position);

		if(listdata != null){
			TextView lefttv = (TextView)v.findViewById(R.id.left_text);
			lefttv.setText(listdata.getDay());
			
			ImageView imageview = (ImageView)v.findViewById(R.id.left_arrow);
			imageview.setImageResource(R.drawable.date_arrow);
		}

		return v;
	}
}
