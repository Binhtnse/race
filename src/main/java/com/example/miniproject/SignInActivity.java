package com.example.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{
    EditText username;
    EditText password;
    Button signIn;
    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.edUsername);
        password = (EditText) findViewById(R.id.edPassword);
        signIn = (Button) findViewById(R.id.btnsignIn);

        signIn.setOnClickListener(this);
    }
    private boolean checkInput(){
        if(TextUtils.isEmpty(username.getText().toString())){
            username.setError(REQUIRE);
            return false;
        }
        if(TextUtils.isEmpty(password.getText().toString())){
            password.setError(REQUIRE);
            return false;
        }
        return true;
    }
    private void signIn(){
        if(!checkInput()){
            return;
        }
        Intent intent = new Intent(this, TutorialActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onClick(View v){
        int id = v.getId();
        if (id == R.id.btnsignIn) {
            signIn();
        }
    }
}
