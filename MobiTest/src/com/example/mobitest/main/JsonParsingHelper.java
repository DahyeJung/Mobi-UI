package com.example.mobitest.main;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParsingHelper {

	public static final int TYPE_DAY = 0;
	public static final int TYPE_GENRE = 1;
	public static final int TYPE_MY = 2;

	public ArrayList<Category> getWebtoons(String webtoonsJson, int dayOfWeek, int type) throws JSONException
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
				String genre_main = c.getString("genre_main");
				String genre_sub = c.getString("genre_sub");
				String is_famous = c.getString("is_famous");
				String rating_avg = c.getString("rating_avg");
				String publishing_date = c.getString("publishing_date");
				String view_count = c.getString("view_count");
				String days_of_week = c.getString("days_of_week");

				switch (type) {
				
				case TYPE_DAY:
					String str2 = days_of_week.replace("[", "");
					String str3 = str2.replace("]", "");
					String strArray[] = str3.split(",");
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
					break;

				case TYPE_GENRE:

				String strPos = String.valueOf(dayOfWeek+1);

				if(genre_main.equals(strPos)||genre_sub.equals(strPos)){

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

				break;


				case TYPE_MY:

					if(toon_title.equals("애정시대")||toon_title.equals("움비처럼")||toon_title.equals("신의 탑")||toon_title.equals("세렌디파티")){

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
					break;

				default:
					break;
				}
			}
		}catch(JSONException e){
			e.printStackTrace();
		}
		
		
		
		
		return arraytoon;

	}


}
