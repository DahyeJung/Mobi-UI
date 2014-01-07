package com.example.mobitest.country;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mobitest.Network;
import com.example.mobitest.R;
import com.example.mobitest.main.Main;

public class ChangeCountry extends ListActivity  {
	String [] Country = {
			"Armenia",
			"Egypt",
			"Niegeria",
			"Australia",
			"China",
			"Taiwan",
			"South Korea",
			"Japan",
			"France",
			"Italy",
			"United Kingdom"
	};

	int [] Image = {
			R.drawable.country_am,
			R.drawable.country_eg,
			R.drawable.country_ng,
			R.drawable.country_au,
			R.drawable.country_cn,
			R.drawable.country_tw,
			R.drawable.country_kr,
			R.drawable.country_jp,
			R.drawable.country_fr,
			R.drawable.country_it,
			R.drawable.country_gb
	};

	TextView tv1, tv2, tv3, tvPrice, title;
	ImageButton backBtn;
	Typeface typeface;
	Network nw = new Network();


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.country_list);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.country_title);

		tv1 = (TextView)findViewById(R.id.tv1);
		tv2 = (TextView)findViewById(R.id.tv2);
		tv3 = (TextView)findViewById(R.id.tv3);
		tvPrice = (TextView)findViewById(R.id.price);
		title = (TextView)findViewById(R.id.title);
		backBtn = (ImageButton)findViewById(R.id.backBtn);

		backBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ChangeCountry.this,Main.class);
				startActivity(intent);
			}
		});
		
		/*		tv1.setTypeface(typeface);
		tv2.setTypeface(typeface);
		tv3.setTypeface(typeface);
		tvPrice.setTypeface(typeface);
		title.setTypeface(typeface);
		 */		
		ChangeCountryArray adapter = 
				new ChangeCountryArray(this, Country, Image);
		setListAdapter(adapter);

	}

}

