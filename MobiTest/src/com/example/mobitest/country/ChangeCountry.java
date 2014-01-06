package com.example.mobitest.country;

import android.app.ListActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobitest.Network;
import com.example.mobitest.R;

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

