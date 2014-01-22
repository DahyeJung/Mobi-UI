package com.example.mobitest.buyink;

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

public class CustomArrayAdapter extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] goldink;
    private final String[] blueink;
    private final String[] price;
    
    public CustomArrayAdapter(Activity context, 
    String[] goldink, String[] blueink, String[] price) {
        super(context, R.layout.buy_goldink, goldink);
        this.context = context;
        this.goldink = goldink;
        this.blueink = blueink;
        this.price = price;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {     

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.buy_goldink, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.tv1); 
        TextView txtDescription = (TextView) rowView.findViewById(R.id.tv3); 
        TextView ddd = (TextView)rowView.findViewById(R.id.price);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.blueink_ic);
        ImageView imageView2 = (ImageView) rowView.findViewById(R.id.goldink_ic);
        //---customize the content of each row based on position---
        txtTitle.setText(goldink[position]);
        txtDescription.setText(blueink[position]);
        ddd.setText(price[position]);
        imageView.setImageResource(R.drawable.buy_ink_blue);
        
        if(position<=3){
        imageView2.setImageResource(R.drawable.buy_ink_gold);
        }else{
        imageView2.setImageResource(R.drawable.buy_ink_bottle);
        }
        return rowView;
    }
    
}

