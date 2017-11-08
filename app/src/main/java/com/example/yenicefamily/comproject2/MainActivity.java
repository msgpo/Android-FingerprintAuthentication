package com.example.yenicefamily.comproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Intent SecondAuthenticatonPage = new Intent(this, SecondAuthenticaon.class);

        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);

        String EnteredUsername = username.getText().toString();
        String EnteredPassword = password.getText().toString();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(this.openFileInput("userInformation.txt")));
            String line;

            boolean isFound = false;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\|");


                if(split[0].equals(EnteredUsername) && split[1].equals(EncryptionHelper.encryptPassword(EnteredPassword))){
                    isFound = true;
                    break;
                }
                else{
                    // Toast.makeText(this, split[0] + " - " + EncryptionHelper.encryptPassword(EnteredPassword), Toast.LENGTH_SHORT).show();
                    continue;
                }
            }

            if(!isFound){
                    Toast.makeText(this, "Login is failed!", Toast.LENGTH_SHORT).show();
            }
            else{
                SecondAuthenticatonPage.putExtra("WhoAmI", EnteredUsername);
                startActivity(SecondAuthenticatonPage);
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void onClick2(View view){
        Intent SignUpPage = new Intent(this, SignUpActivity.class);
        startActivity(SignUpPage);
    }

    // It shows the username and encypted password in the 'userInformation.txt' file.
    public void ekranaYaz(View view){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(this.openFileInput("userInformation.txt")));
            String line;
            while ((line = br.readLine()) != null) {
                Toast.makeText(this, line, Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
