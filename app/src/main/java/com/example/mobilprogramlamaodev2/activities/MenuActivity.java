package com.example.mobilprogramlamaodev2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mobilprogramlamaodev2.R;
import com.example.mobilprogramlamaodev2.utils.UserUtil;

import java.util.EmptyStackException;

public class MenuActivity extends AppCompatActivity {
    private Button btn_email;
    private Button btn_list_users;
    private Button btn_edit_user_info;
    private Button btn_notebook;
    private Button btn_sensor;
    Intent intent;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (UserUtil.logedUser.getAppMode() == 0){
            setTheme(android.R.style.Theme_Light_NoTitleBar);
        }
        else {
            setTheme(android.R.style.Theme_NoTitleBar);

        }

        setContentView(R.layout.activity_menu);
        context = this;

        btn_email = findViewById(R.id.btn_email);
        btn_list_users = findViewById(R.id.btn_list_users);
        btn_edit_user_info = findViewById(R.id.btn_edit_user_info);
        btn_notebook = findViewById(R.id.btn_notebook);
        btn_sensor = findViewById(R.id.btn_sensor);




        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, EMailActivity.class);
                startActivity(intent);
            }
        });

        btn_list_users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, ListUsersActivity.class);
                startActivity(intent);
            }
        });


        btn_edit_user_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, UserEditActivity.class);
                startActivity(intent);
            }
        });


        btn_sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, SensorActivity.class);
                startActivity(intent);
            }
        });


        btn_notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, NoteActivity.class);
                startActivity(intent);
            }
        });

    }
}
