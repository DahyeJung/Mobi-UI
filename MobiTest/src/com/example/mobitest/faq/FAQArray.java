package com.example.mobitest.faq;

import android.app.Activity;
import android.content.Intent;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.mobitest.R;

public class FAQArray extends ArrayAdapter<String>{
	private final Activity context;
	private final String[] title;
	private final String[] date;

	public FAQArray(Activity context, 
			String[] title, String[] date) {
		super(context, R.layout.comment, title);
		this.context = context;
		this.title = title;
		this.date = date;

	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {     
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.notice_list_contents, null, true);

		TextView user_tv = (TextView) rowView.findViewById(R.id.title); 
		TextView date_tv = (TextView) rowView.findViewById(R.id.date); 
		//---customize the content of each row based on position---
		user_tv.setText(title[position]);
		date_tv.setText(date[position]);
		
		
		return rowView;
	}
	
	
}
