package com.example.mobitest.main;

import java.util.ArrayList;

import javax.security.auth.PrivateCredentialPermission;

import android.content.Context;
import android.text.method.ArrowKeyMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.mobitest.R;

public class MainListAdapter extends ArrayAdapter<ListData>{

	private ArrayList<ListData> items;

	public MainListAdapter(Context context, int textViewResourceId, ArrayList<ListData> items) {
		super(context, textViewResourceId, items);
		this.items = items;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if(v==null){
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.main_left, null);
		}
		ListData listdata = items.get(position);

		if(listdata != null){
			TextView lefttv = (TextView)v.findViewById(R.id.left_text);

			lefttv.setText(listdata.getDay());
		}

		return v;
	}
}

class ListData{
	private String Day;

	public ListData(String Day){
		this.Day = Day;
	}
	public String getDay(){
		return Day;

	}
	public void setDay(String day){
		Day = day;
	}
}