package com.example.mobitest.buyink;

import android.app.ListActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobitest.Network;
import com.example.mobitest.R;

public class BuyInk extends ListActivity  {
	String [] goldink = {
			"2,000",
			"3,000",
			"4,000",
			"5,000",
			"10,000",
			"15,000"
	};
	String[] blueink = {
			"100",
			"150",
			"200",
			"250",
			"500",
			"750"
	};
	String[] price = {
			"1,99 USD",
			"2,99 USD",
			"2,99 USD",
			"3,99 USD",
			"6,99 USD",
			"7,99 USD"
	};

	TextView tv1, tv2, tv3, tvPrice, title;
	Typeface typeface;
	Network nw = new Network();


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.buy_goldink_list);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.buy_goldink_title);

		tv1 = (TextView)findViewById(R.id.tv1);
		tv2 = (TextView)findViewById(R.id.tv2);
		tv3 = (TextView)findViewById(R.id.tv3);
		tvPrice = (TextView)findViewById(R.id.price);
		title = (TextView)findViewById(R.id.title);

		tv1.setTypeface(typeface);
		tv2.setTypeface(typeface);
		tv3.setTypeface(typeface);
		tvPrice.setTypeface(typeface);
		title.setTypeface(typeface);
		
		BuyInkArray adapter = 
				new BuyInkArray(this, goldink, blueink, price);
		setListAdapter(adapter);

	}

}

