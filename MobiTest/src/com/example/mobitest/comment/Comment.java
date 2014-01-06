package com.example.mobitest.comment;

import android.app.ListActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobitest.Network;
import com.example.mobitest.R;

public class Comment extends ListActivity  {
	String [] nickname = {
			"가나",
			"다라",
			"마바",
			"사아",
			"자차",
	};
	String[] contents = {
			"안녕하세요.",
			"산은 산이요,",
			"물은 물이로다.",
			"댓글 내용",
			"(최대 1000byte)"
	};
	String[] date = {
			"2011.01.12",
			"2012.02.23",
			"2012.05.07",
			"2012.08.14",
			"2022.05.06"
	};

	TextView user, time, content, title;
	Typeface typeface;
	Network nw = new Network();


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

