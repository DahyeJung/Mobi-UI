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

public class MainListAdapter extends ArrayAdapter<ListData>{

	private ArrayList<ListData> items;

	public MainListAdapter(Context context, int textViewResourceId, ArrayList<ListData> items) {
		super(context, textViewResourceId, items);
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if(v==null){
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.main_list, null);
		}
		ListData listdata = items.get(position);

		if(listdata != null){
			ImageView leftimg = (ImageView)v.findViewById(R.id.left_img);
			TextView lefttv = (TextView)v.findViewById(R.id.left_text);

			lefttv.setText(listdata.getDay());
			leftimg.setBackgroundResource(listdata.getImage_ID());
			
		}
		return v;

	}

}

class ListData{
	private int Image_ID;
	private String Day;

	public ListData(int Image_ID) {
		this.Image_ID = Image_ID;
	}
	public ListData(String Day){
		this.Day = Day;
	}
	public int getImage_ID(){
		return Image_ID;
	}
	public void setImage_ID(int image_ID){
		Image_ID = image_ID;
	}
	public String getDay(){
		return Day;

	}
	public void setDay(String day){
		Day = day;
	}
}