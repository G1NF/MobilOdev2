package com.example.mobilprogramlamaodev2.activities;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilprogramlamaodev2.R;
import com.example.mobilprogramlamaodev2.models.User;
import com.example.mobilprogramlamaodev2.utils.SharedPrefUtil;
import com.example.mobilprogramlamaodev2.utils.UserUtil;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    EditText usernameInput , passwordInput;
    ArrayList<User> users = new ArrayList<>();
    private int numberOfTry = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        boolean exit = intent.getBooleanExtra("EXIT", false);
        if (exit) {
            finish();
        }
        setContentView(R.layout.activity_login);
        loginButton = (Button)findViewById(R.id.loginButton);
        usernameInput = (EditText)findViewById(R.id.usernameInput);
        passwordInput = (EditText)findViewById(R.id.passwordInput);

        users.add(new User("admin", "admin", "user6.png", 0, 183, 83, 25, 0, R.drawable.user3));
        users.add(new User("user1", "123", "user1.png", 0, 180, 80, 20, 0, R.drawable.user1));
        users.add(new User("user2", "123", "user2.png", 1, 150, 60, 26, 1, R.drawable.user2));
        users.add(new User("user3", "123456", "user3.png", 0, 170, 80, 70, 0, R.drawable.user3));
        users.add(new User("user4", "456123", "user4.png", 1, 160, 60, 26, 1, R.drawable.user1));
        users.add(new User("user5", "123098", "user5.png", 0, 180, 80, 40, 0, R.drawable.user2));
        users.add(new User("user6", "098", "user6.png", 1, 150, 60, 36, 1, R.drawable.user3));

//        SharedPrefUtil.addUsersInfos(this, users);
        UserUtil.allUsers = users;
    }
    public void loginAction(View view) {
        User temp = checkUserNamePassword(usernameInput.getText().toString(), passwordInput.getText().toString());
        if(temp != null) {
            UserUtil.logedUser = temp;
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);

        }else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Warning");
            builder.setMessage("Username or password is wrong");
            if (++numberOfTry == 3){
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Warning");
                builder.setMessage("You entered wrong 3 times!");


                System.exit(0);
            }
            builder.show();
        }
    }

    private User checkUserNamePassword(String userName, String password){
        for (User user: users){
            if (user.getUserName().compareTo(userName) == 0 && user.getPassword().compareTo(password) == 0){
                return user;
            }
        }
        return null;
    }
}
