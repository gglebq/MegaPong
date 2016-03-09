package com.example.ping_pongv1;

import android.app.Activity;
import android.content.SharedPreferences;

public class Store {
	private static final String PREFS_NAME = "MyPrefsFile";

	public static void save(String string, Activity activity) {
		SharedPreferences settings = activity.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();

		editor.putString("scoreKey", string);

		// Commit the edits!
		editor.commit();
	}
	
	public static String get(Activity activity) {
		SharedPreferences settings = activity.getSharedPreferences(PREFS_NAME, 0);
		String string = settings.getString("scoreKey", "");
//		((MainActivity) activity).myToast("Your total score is " + string);
//		if (!string.equals("")) {
//			((MainActivity) activity).getMyView().setScore(Integer.parseInt(string));
//		}

		return string;
	}
}
