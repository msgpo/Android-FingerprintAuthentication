package com.example.yenicefamily.comproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class welcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        Bundle ComingData = getIntent().getExtras();
        if(ComingData == null){
            return;
        }

        String logged_user = ComingData.getString("WhoAmI");
        TextView username = (TextView)findViewById(R.id.textView5);
        username.setText("Welcome " + logged_user.toUpperCase() + " to our application.");
    }
}
