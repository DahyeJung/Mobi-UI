package com.example.mobitest.main;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import android.widget.ListView;

public class JsonParsingHelper {

	public ArrayList<Category> getWebtoons(String webtoonsJson, int dayOfWeek) throws JSONException
	{
		ArrayList<Category> arraytoon = new ArrayList<Category>();

		JSONArray names = null;

		JSONObject json = new JSONObject(webtoonsJson);

		try{

			names = json.getJSONArray("toons");

			for(int i = 0; i<names.length();i++){
				JSONObject c= names.getJSONObject(i);

				Category cat = new Category();
				String nickname = c.getString("nickname");
				String toon_title = c.getString("toon_title");
				String age_limit = c.getString("age_limit");
				String days_of_week = c.getString("days_of_week");

				String str2 = days_of_week.replace("[", "");
				String str3 = str2.replace("]", "");
				String strArray[] = str3.split(",");

				String genre_main = c.getString("genre_main");
				String genre_sub = c.getString("genre_sub");
				String is_famous = c.getString("is_famous");
				String rating_avg = c.getString("rating_avg");
				String publishing_date = c.getString("publishing_date");
				String view_count = c.getString("view_count");

				if(dayOfWeek < strArray.length) {
					if(strArray[dayOfWeek].equals("true")){
						
						cat.setNickname(nickname);
						cat.setToonTitle(toon_title);
						cat.setAgeLimit(age_limit);
						cat.setDaysOfWeek(days_of_week);
						cat.setGenreMain(genre_main);
						cat.setGenreSub(genre_sub);
						cat.setIsFamous(is_famous);
						cat.setRatingAvg(rating_avg);
						cat.setPublishingDate(publishing_date);
						cat.setViewCount(view_count);
						
						arraytoon.add(cat);
						
					}
				}
			}
		}catch(JSONException e){
			e.printStackTrace();
		}

		return arraytoon;


	}


}
