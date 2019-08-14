package com.friendship.talk.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.friendship.talk.TalkAppApplication;
import com.friendship.talk.Model.UserData;
import com.friendship.talk.Response.TransferDetailsResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class Preferences {

    public static final String KEY_USER_DATA = "key_user_data";
    public static final String KEY_ACCOUNT_DATA = "key_account_data";

    private static SharedPreferences get() {
        return TalkAppApplication.getAppContext().getSharedPreferences(ConstantValue.APP_Name_PREF, Context.MODE_PRIVATE);
    }

    public static boolean removePref() {
        return get().edit().clear().commit();
    }

    public static boolean setString(String _key, String value) {
        return get().edit().putString(_key, value).commit();
    }

    public static boolean setDouble(String _key, Float value) {
        return get().edit().putFloat(_key, value).commit();
    }

    public static float getDouble(String _key) {
        return get().getFloat(_key, 0.0f);
    }

    public static String getString(String _key) {
        return get().getString(_key, "");
    }

    public static String getString(String _key, String def_value) {
        return get().getString(_key, def_value);
    }

    public static int getInt(String _key) {
        return get().getInt(_key, 0);
    }

    public static boolean setInt(String _key, int value) {
        return get().edit().putInt(_key, value).commit();
    }

    public static boolean getBoolean(String _key) {
        return get().getBoolean(_key, false);
    }

    public static boolean setBoolean(String _key, boolean value) {
        return get().edit().putBoolean(_key, value).commit();
    }

    public static void remove(String _key) {
        get().edit().remove(_key).commit();
    }

    public static boolean isContainKey(String _key) {
        return get().contains(_key);
    }

    public static void setUserData(UserData userData) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(userData);
            setString(KEY_USER_DATA, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static UserData getUserData() {
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<UserData>() {
            }.getType();
            return gson.fromJson(getString(KEY_USER_DATA), type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new UserData();
    }

    

}