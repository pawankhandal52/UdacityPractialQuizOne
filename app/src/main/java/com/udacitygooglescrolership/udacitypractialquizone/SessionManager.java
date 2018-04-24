package com.udacitygooglescrolership.udacitypractialquizone;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by stemdot on 4/24/18,17
 */
public class SessionManager {
    //Prefrance name
    private final String PREF_NAME = "udacitypractialquizone";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Context mContext;
    
    
    SessionManager(Context context){
        mContext = context;
        mSharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }
    
    public void setUserData(String userName, String email, String about){
        mEditor.putString(mContext.getResources().getString(R.string.pref_user_name),userName);
        mEditor.putString(mContext.getResources().getString(R.string.pref_user_email),email);
        mEditor.putString(mContext.getResources().getString(R.string.pref_user_pref),about);
        mEditor.apply();
    }
    
    public String getUserName(){
        return mSharedPreferences.getString(mContext.getResources().getString(R.string.pref_user_name),"DemoUserName");
    }
    public String getUserEmail(){
        return mSharedPreferences.getString(mContext.getResources().getString(R.string.pref_user_email),"DemoUserEmail");
    }
    public String getUserAbout(){
        return mSharedPreferences.getString(mContext.getResources().getString(R.string.pref_user_pref),"DemoUserAbout");
    }
}
