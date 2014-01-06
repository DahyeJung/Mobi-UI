package com.example.mobitest.country;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobitest.R;

public class ChangeCountryArray extends ArrayAdapter<String>{
	private final Activity context;
	private final String[] country;
	private final int[] image;
	
	public ChangeCountryArray(Activity context, 
			String[] country, int[] image ) {
		super(context, R.layout.country, country);
		this.context = context;
		this.country = country;
		this.image = image;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {     
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.country, null, true);

		TextView tv1 = (TextView) rowView.findViewById(R.id.countrytv); 
		ImageView img = (ImageView) rowView.findViewById(R.id.countryimg);
		//---customize the content of each row based on position---
		tv1.setText(country[position]);
		img.setImageResource(image[position]);

		return rowView;
	}

}

