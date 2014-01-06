package com.example.mobitest.comment;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.example.mobitest.R;


public class Tab extends TabActivity{

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.comment_title);

		TabHost tabHost = getTabHost();
		
		

		tabHost.addTab(tabHost.newTabSpec("베스트댓글")
				.setIndicator("list1")
				.setContent(new Intent(this, Comment.class)));



		tabHost.addTab(tabHost.newTabSpec("전체댓글")
				.setIndicator("list2")
				.setContent(new Intent(this, Comment.class)));


	}
}






