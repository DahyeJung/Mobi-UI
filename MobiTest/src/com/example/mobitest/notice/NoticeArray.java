package com.example.mobitest.notice;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mobitest.R;

public class NoticeArray extends ArrayAdapter<String>{
	private final Activity context;
	private final String[] user;
	private final String[] time;
	private final String[] content;

	public NoticeArray(Activity context, 
			String[] user, String[] content, String[] time) {
		super(context, R.layout.comment, user);
		this.context = context;
		this.user = user;
		this.content = content;
		this.time = time;

	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {     
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.comment, null, true);

		TextView user_tv = (TextView) rowView.findViewById(R.id.user); 
		TextView time_tv = (TextView) rowView.findViewById(R.id.time); 
		TextView content_tv = (TextView)rowView.findViewById(R.id.contents);
		//---customize the content of each row based on position---
		user_tv.setText(user[position]);
		time_tv.setText(time[position]);
		content_tv.setText(content[position]);

		return rowView;
	}
}