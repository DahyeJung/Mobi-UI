package com.example.mobitest.view;

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

			names = json.getJSONArray("episodes");

			for(int i = 0; i<names.length();i++){
				JSONObject c= names.getJSONObject(i);

				Category cat = new Category();
				String episode_title = c.getString("episode_title");
				String episode_order = c.getString("episode_order");
				String view_cost = c.getString("view_cost");
				String gold_ink_only = c.getString("gold_ink_only");
				String rating_avg = c.getString("rating_avg");
				String publishing_date = c.getString("publishing_date");

				publishing_date = publishing_date.replace(publishing_date.substring(9, 18), "");
				cat.setEpisode_title(episode_title);
				cat.setEpisode_order(episode_order);
				cat.setView_cost(view_cost);
				cat.setGold_ink_only(gold_ink_only);
				cat.setRating_avg(rating_avg);
				cat.setPublishing_date(publishing_date);

				arraytoon.add(cat);
			}
		}catch(JSONException e){
			e.printStackTrace();
		}

		return arraytoon;
	}
}
