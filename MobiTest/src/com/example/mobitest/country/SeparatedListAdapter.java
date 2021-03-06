package com.example.mobitest.country;

import java.util.LinkedHashMap;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.example.mobitest.R;

public class SeparatedListAdapter extends BaseAdapter{

	public final Map<String, Adapter> sections = new LinkedHashMap<String, Adapter>();
	public final ArrayAdapter<String> headers;
	public final static int TYPE_SECTION_HEADER = 0;

	public SeparatedListAdapter(Context context){
		headers = new ArrayAdapter<String>(context,R.layout.country_list_header);
	}
	public void addSection(String section, Adapter adpater){
		this.headers.add(section);
		this.sections.put(section,adpater);
	}



	@Override
	public Object getItem(int position) {
		for(Object section : this.sections.keySet()){
			Adapter adapter = sections.get(section);
			int size = adapter.getCount()+1;

			if(position == 0){
				return section;
			}if(position<size){
				return adapter.getItem(position-1);
			}
			position -=size;
		}
		return null;
	}

	@Override
	public int getCount() {

		int total = 0;
		for(Adapter adapter : this.sections.values()){
			total += adapter.getCount()+1;
		}
		return total;
	}

	@Override
	public int getViewTypeCount() {
		int total = 1;
		for(Adapter adpater : this.sections.values()){
			total += adpater.getViewTypeCount();
		}

		return total;
	}

	@Override
	public int getItemViewType(int position) {
		int type = 1;
		for(Object section : this.sections.keySet()){
			Adapter adapter = sections.get(section);
			int size = adapter.getCount()+1;

			if(position == 0){
				return TYPE_SECTION_HEADER;
			}if(position < size){
				return type + adapter.getItemViewType(position-1);
			}
			position -= size;
			type += adapter.getViewTypeCount();
		}
		return -1;
	}
	public boolean areAllItemSelectable(){
		return false;
	}

	public boolean isEnabled(int position){
		return(getItemViewType(position) != TYPE_SECTION_HEADER);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int sectionnum = 0;
		for(Object section : this.sections.keySet()){
			Adapter adapter = sections.get(section);
			int size = adapter.getCount()+1;

			if(position == 0){
				return headers.getView(sectionnum, convertView, parent);
			}if(position<size){
				return adapter.getView(position-1, convertView, parent);
			}

			position -=size;
			sectionnum++;
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
}
