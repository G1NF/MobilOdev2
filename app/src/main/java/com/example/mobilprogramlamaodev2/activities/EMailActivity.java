package com.example.mobilprogramlamaodev2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobilprogramlamaodev2.R;
import com.example.mobilprogramlamaodev2.utils.UserUtil;

public class EMailActivity extends AppCompatActivity {
    private Button btn_send;
    private EditText et_to;
    private EditText et_title;
    private EditText et_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (UserUtil.logedUser.getAppMode() == 0){
            setTheme(android.R.style.Theme_Light_NoTitleBar);
        }
        else {
            setTheme(android.R.style.Theme_NoTitleBar);

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        btn_send = findViewById(R.id.btn_send);
        et_to = findViewById(R.id.et_to);
        et_title = findViewById(R.id.et_title);
        et_mail = findViewById(R.id.et_mail);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to = et_to.getText().toString();
                String title = et_title.getText().toString();
                String mail = et_mail.getText().toString();

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{to});
                i.putExtra(Intent.EXTRA_SUBJECT, title);
                i.putExtra(Intent.EXTRA_TEXT   , mail);
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                }
            }
        });
    }
}
