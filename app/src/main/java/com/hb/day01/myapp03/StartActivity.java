package com.hb.day01.myapp03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        editText= (EditText) findViewById(R.id.editText);
    }

    public void onClick(View v){
        //secActivity 호출
        if(R.id.btn1==v.getId()) {
            Intent intent = new Intent(this, SecActivity.class);
            startActivity(intent);
        }else if(R.id.btn2==v.getId()){
            String msg = editText.getText().toString();

            Toast alert = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            alert.show();
        }else if(R.id.btn3==v.getId()) {
            Intent intent = new Intent(this, WebActivity.class);
            startActivity(intent);
        }
    }
}
