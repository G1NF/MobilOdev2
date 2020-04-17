package com.example.mobilprogramlamaodev2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mobilprogramlamaodev2.R;
import com.example.mobilprogramlamaodev2.adapter.UserAdapter;
import com.example.mobilprogramlamaodev2.models.User;
import com.example.mobilprogramlamaodev2.utils.UserUtil;

public class ListUsersActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (UserUtil.logedUser.getAppMode() == 0){
            setTheme(android.R.style.Theme_Light_NoTitleBar);
        }
        else {
            setTheme(android.R.style.Theme_NoTitleBar);

        }
        setContentView(R.layout.activity_list_users);


        recyclerView = (RecyclerView) findViewById(R.id.recylerview);

        UserAdapter userAdapter = new UserAdapter(this, UserUtil.allUsers);
        recyclerView.setAdapter(userAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
