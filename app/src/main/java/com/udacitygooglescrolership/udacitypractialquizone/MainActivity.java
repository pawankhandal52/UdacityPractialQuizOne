package com.udacitygooglescrolership.udacitypractialquizone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    
    EditText mEditTextUserName,mEditTextUserEmail,mEditTextUserAbout;
    private final String TAG = MainActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextUserName = findViewById(R.id.edittext_name);
        mEditTextUserEmail = findViewById(R.id.edittext_email);
        mEditTextUserAbout = findViewById(R.id.edittext_about);
    
        Log.d(TAG, "onCreate: Saved data "+savedInstanceState);
        if (savedInstanceState != null){
            Log.d(TAG, "onCreate: 1"+savedInstanceState.getString("user_name"));
            mEditTextUserName.setText(savedInstanceState.getString("user_name"));
            mEditTextUserEmail.setText(savedInstanceState.getString("user_email"));
            mEditTextUserAbout.setText(savedInstanceState.getString("user_about"));
        }
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id  = item.getItemId();
        if (id == R.id.action_profile){
            startDetailActivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void next(View view) {
        startDetailActivity();
    }
    
    public void startDetailActivity(){
        //Before Starting the activity save the data in SharedPrefrance
        SessionManager sessionManager = new SessionManager(getApplicationContext());
        sessionManager.setUserData(mEditTextUserName.getText().toString().trim(),
                mEditTextUserEmail.getText().toString().trim(),
                mEditTextUserAbout.getText().toString().trim());
        
        //Clear the text
        mEditTextUserName.setText("");
        mEditTextUserEmail.setText("");
        mEditTextUserEmail.setText("");
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        startActivity(intent);
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
    
        outState.putString("user_name",mEditTextUserName.getText().toString().trim());
        outState.putString("user_email",mEditTextUserEmail.getText().toString().trim());
        outState.putString("user_about",mEditTextUserAbout.getText().toString().trim());
        Log.d(TAG, "onSaveInstanceState: "+outState);
        super.onSaveInstanceState(outState);
        //Bundle bundle = new Bundle();
        
        //outState.putBundle();
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: "+savedInstanceState);
        if (savedInstanceState != null){
            mEditTextUserName.setText(savedInstanceState.getString("user_name"));
            mEditTextUserEmail.setText(savedInstanceState.getString("user_email"));
            mEditTextUserAbout.setText(savedInstanceState.getString("user_about"));
        }
    }
}
