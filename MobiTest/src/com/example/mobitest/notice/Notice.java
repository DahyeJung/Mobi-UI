package com.example.mobitest.notice;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mobitest.R;
import com.example.mobitest.comment.CommentArray;

public class Notice extends ListActivity{
	String [] title = {
		"새로운 웹툰 서비스가 시작됩니다.",
		"13.07.23"
	};
	
	String[] date = {
		"13.07.23",
		"13.07.23"
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.comment_list);

		user = (TextView)findViewById(R.id.user);
		time = (TextView)findViewById(R.id.time);
		content = (TextView)findViewById(R.id.contents);
		title = (TextView)findViewById(R.id.title);

		/*user.setTypeface(typeface);
		time.setTypeface(typeface);
		content.setTypeface(typeface);
		title.setTypeface(typeface);*/
		
		CommentArray adapter = 
				new CommentArray(this, nickname, contents , date);
		setListAdapter(adapter);

	}

}
