package com.example.mobitest.faq;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mobitest.R;
import com.example.mobitest.setting.Setting;

public class FAQ extends ListActivity{
	String [] title = {
			"잉크 결제는 어떻게 하나요?",
			"인증번호 문자가 오지 않아요."
	};

	String[] date = {
			"13.09.23",
			"13.09.25"
	};

	TextView user_tv, date_tv;
	ImageButton backBtn;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.comment_list);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.notice_title);

		backBtn = (ImageButton)findViewById(R.id.backBtn);
		user_tv = (TextView)findViewById(R.id.title);
		date_tv = (TextView)findViewById(R.id.date);

		backBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FAQ.this,Setting.class);
				startActivity(intent);
			}
		});

		/*user.setTypeface(typeface);
		date.setTypeface(typeface);
		content.setTypeface(typeface);
		title.setTypeface(typeface);*/


		FAQArray adapter = 
				new FAQArray(this, title, date);
		setListAdapter(adapter);



	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		if(position==0){
			Intent intent = new Intent(FAQ.this,FAQContents1.class);
			startActivity(intent);

		}else if(position==1){
			Intent intent = new Intent(FAQ.this,FAQContents2.class);
			startActivity(intent);
		}

	}


}
