package com.example.mobitest.view;

import android.app.Activity;
import android.content.Intent;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.mobitest.R;

public class ViewArray extends ArrayAdapter<String>{
	private final Activity context;
	private final String[] title;
	private final String[] date;
	
	public ViewArray(Activity context, 
			String[] title, String[] date) {
		super(context, R.layout.view, title);
		this.context = context;
		this.title = title;
		this.date = date;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {     
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.view_contents, null, true);

		TextView user_tv = (TextView) rowView.findViewById(R.id.textView1); 
		TextView date_tv = (TextView) rowView.findViewById(R.id.textView2); 
		ImageView img = (ImageView)rowView.findViewById(R.id.imageView1);
		ImageView img2 = (ImageView)rowView.findViewById(R.id.imageView2);
		ImageView tag1 = (ImageView)rowView.findViewById(R.id.imageView3);
		ImageView tag2 = (ImageView)rowView.findViewById(R.id.imageView4);
		ImageView tag3 = (ImageView)rowView.findViewById(R.id.imageView5);
		
		user_tv.setText(title[position]);
		date_tv.setText(date[position]);
		img.setImageResource(R.drawable.chapter_list_img02);
		img2.setImageResource(R.drawable.rate_9);
		tag1.setImageResource(R.drawable.tag_shared);
		tag2.setImageResource(R.drawable.tag_downloaded);
		tag3.setImageResource(R.drawable.tag_gifted);
		
		return rowView;
	}
	
	
}
