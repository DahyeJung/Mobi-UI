package com.example.mobitest.main;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParsingHelper {

	public ArrayList<Category> getWebtoons(String webtoonsJson) throws JSONException
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


				if(strArray[0].equals("true")){

					cat.setNickname(nickname);
					cat.setToonTitle(toon_title);
					cat.setAgeLimit(age_limit);
					cat.setDaysOfWeek(days_of_week);
					cat.setGenreMain(genre_main);
					cat.setGenreSub(genre_sub);
					cat.setIsFamous(is_famous);
					cat.setRatingAvg(rating_avg);
					cat.setPublishingDate(publishing_date);


					arraytoon.add(cat);
				}
			}
		}catch(JSONException e){
			e.printStackTrace();
		}

		return arraytoon;


	}

	public ArrayList<Category> getWebtoons2(String webtoonsJson) throws JSONException
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


				if(strArray[1].equals("true")){

					cat.setNickname(nickname);
					cat.setToonTitle(toon_title);
					cat.setAgeLimit(age_limit);
					cat.setDaysOfWeek(days_of_week);
					cat.setGenreMain(genre_main);
					cat.setGenreSub(genre_sub);
					cat.setIsFamous(is_famous);
					cat.setRatingAvg(rating_avg);
					cat.setPublishingDate(publishing_date);


					arraytoon.add(cat);
				}
			}
		}catch(JSONException e){
			e.printStackTrace();
		}

		return arraytoon;


	}

	public ArrayList<Category> getWebtoons3(String webtoonsJson) throws JSONException
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


				if(strArray[2].equals("true")){

					cat.setNickname(nickname);
					cat.setToonTitle(toon_title);
					cat.setAgeLimit(age_limit);
					cat.setDaysOfWeek(days_of_week);
					cat.setGenreMain(genre_main);
					cat.setGenreSub(genre_sub);
					cat.setIsFamous(is_famous);
					cat.setRatingAvg(rating_avg);
					cat.setPublishingDate(publishing_date);


					arraytoon.add(cat);
				}
			}
		}catch(JSONException e){
			e.printStackTrace();
		}

		return arraytoon;


	}

	public ArrayList<Category> getWebtoons4(String webtoonsJson) throws JSONException
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


				if(strArray[3].equals("true")){

					cat.setNickname(nickname);
					cat.setToonTitle(toon_title);
					cat.setAgeLimit(age_limit);
					cat.setDaysOfWeek(days_of_week);
					cat.setGenreMain(genre_main);
					cat.setGenreSub(genre_sub);
					cat.setIsFamous(is_famous);
					cat.setRatingAvg(rating_avg);
					cat.setPublishingDate(publishing_date);


					arraytoon.add(cat);
				}
			}
		}catch(JSONException e){
			e.printStackTrace();
		}

		return arraytoon;


	}

	public ArrayList<Category> getWebtoons5(String webtoonsJson) throws JSONException
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


				if(strArray[4].equals("true")){

					cat.setNickname(nickname);
					cat.setToonTitle(toon_title);
					cat.setAgeLimit(age_limit);
					cat.setDaysOfWeek(days_of_week);
					cat.setGenreMain(genre_main);
					cat.setGenreSub(genre_sub);
					cat.setIsFamous(is_famous);
					cat.setRatingAvg(rating_avg);
					cat.setPublishingDate(publishing_date);


					arraytoon.add(cat);
				}
			}
		}catch(JSONException e){
			e.printStackTrace();
		}

		return arraytoon;


	}

	public ArrayList<Category> getWebtoons6(String webtoonsJson) throws JSONException
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


				if(strArray[5].equals("true")){

					cat.setNickname(nickname);
					cat.setToonTitle(toon_title);
					cat.setAgeLimit(age_limit);
					cat.setDaysOfWeek(days_of_week);
					cat.setGenreMain(genre_main);
					cat.setGenreSub(genre_sub);
					cat.setIsFamous(is_famous);
					cat.setRatingAvg(rating_avg);
					cat.setPublishingDate(publishing_date);


					arraytoon.add(cat);
				}
			}
		}catch(JSONException e){
			e.printStackTrace();
		}

		return arraytoon;


	}

	public ArrayList<Category> getWebtoons7(String webtoonsJson) throws JSONException
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


				if(strArray[6].equals("true")){

					cat.setNickname(nickname);
					cat.setToonTitle(toon_title);
					cat.setAgeLimit(age_limit);
					cat.setDaysOfWeek(days_of_week);
					cat.setGenreMain(genre_main);
					cat.setGenreSub(genre_sub);
					cat.setIsFamous(is_famous);
					cat.setRatingAvg(rating_avg);
					cat.setPublishingDate(publishing_date);


					arraytoon.add(cat);
				}
			}
		}catch(JSONException e){
			e.printStackTrace();
		}

		return arraytoon;


	}



}
