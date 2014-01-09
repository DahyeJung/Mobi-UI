package com.example.mobitest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

public class Example extends Activity{

	Button artistButton, albumButton, songButton;
	TabHost tabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.example);

		artistButton = (Button)findViewById(R.id.artist_id);
		albumButton = (Button)findViewById(R.id.album_id);
		songButton = (Button)findViewById(R.id.song_id);
		tabHost = (TabHost)findViewById(android.R.id.tabhost);
	}

	public void tabHandler(View target){
		artistButton.setSelected(false);
		albumButton.setSelected(false);
		songButton.setSelected(false);
		if(target.getId()==R.id.artist_id){
			tabHost.setCurrentTab(0);
			artistButton.setSelected(true);
			Toast toast = Toast.makeText(Example.this, "첫번째 Tab 누름", Toast.LENGTH_LONG);
			toast.show();
		}else if(target.getId()==R.id.album_id){
			tabHost.setCurrentTab(1);
			albumButton.setSelected(true);
			Toast toast = Toast.makeText(Example.this, "두번째 Tab 누름", Toast.LENGTH_LONG);
			toast.show();
		}else if(target.getId()==R.id.song_id){
			tabHost.setCurrentTab(2);
			songButton.setSelected(true);
			
			Toast toast = Toast.makeText(Example.this, "세번째 Tab 누름", Toast.LENGTH_LONG);
			toast.show();

		}
	}
}
