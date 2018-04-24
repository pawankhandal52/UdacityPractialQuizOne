package com.udacitygooglescrolership.udacitypractialquizone;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    
    TextView  mUserName,mUserEmail,mAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    
         mUserName = findViewById(R.id.textview_user_name);
         mUserEmail = findViewById(R.id.textview_user_email);
         mAbout = findViewById(R.id.textview_about);
        SessionManager sessionManager = new SessionManager(getApplicationContext());
    
       
            mUserName.setText(sessionManager.getUserName());
            mUserEmail.setText(sessionManager.getUserEmail());
            mAbout.setText(sessionManager.getUserAbout());
      
    
    
        if (savedInstanceState != null){
            mUserName.setText(savedInstanceState.getString("user_name"));
            mUserName.setText(savedInstanceState.getString("user_email"));
            mUserName.setText(savedInstanceState.getString("user_about"));
        }
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("user_name",mUserName.getText().toString().trim());
        outState.putString("user_email",mUserName.getText().toString().trim());
        outState.putString("user_about",mUserName.getText().toString().trim());
        super.onSaveInstanceState(outState);
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null){
            mUserName.setText(savedInstanceState.getString("user_name"));
            mUserName.setText(savedInstanceState.getString("user_email"));
            mUserName.setText(savedInstanceState.getString("user_about"));
        }
    }
}
