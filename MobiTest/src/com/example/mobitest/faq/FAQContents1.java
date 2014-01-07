package com.example.mobitest.faq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

import com.example.mobitest.R;

public class FAQContents1 extends Activity{

	ImageButton backBtn;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.faq_contents1);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.faq_title);
		
		backBtn = (ImageButton)findViewById(R.id.backBtn);
		backBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FAQContents1.this,FAQ.class);
				startActivity(intent);
			}
		});
	}

}