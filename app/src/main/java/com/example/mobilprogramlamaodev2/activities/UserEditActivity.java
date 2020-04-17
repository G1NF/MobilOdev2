package com.example.mobilprogramlamaodev2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mobilprogramlamaodev2.R;
import com.example.mobilprogramlamaodev2.models.User;
import com.example.mobilprogramlamaodev2.utils.SharedPrefUtil;
import com.example.mobilprogramlamaodev2.utils.UserUtil;

public class UserEditActivity extends AppCompatActivity {

    private TextView et_name;
    private EditText et_height;
    private EditText et_weight;
    private EditText et_age;

    private Spinner sp_gender;
    private Spinner sp_app_mode;

    private Button btn_save;

    private String logedUserName;

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
        setContentView(R.layout.activity_user_edit);
        context = this;

        et_name = findViewById(R.id.et_name);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        et_age = findViewById(R.id.et_age);

        sp_gender = (Spinner) findViewById(R.id.sp_gender);
        sp_app_mode = (Spinner) findViewById(R.id.sp_app_mode);

        btn_save = findViewById(R.id.btn_save);





        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_gender.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.app_modes, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_app_mode.setAdapter(adapter2);

        logedUserName = UserUtil.logedUser.getUserName();
        User temp = SharedPrefUtil.getUser(this, logedUserName);
        et_name.setText(logedUserName);
        String height = temp.getHeight()+"";
        String weight = temp.getWeight()+"";
        String age = temp.getAge()+"";

        et_height.setText(height);
        et_weight.setText(weight);
        et_age.setText(age);


        sp_gender.setSelection(temp.getGender());
        sp_app_mode.setSelection(temp.getAppMode());


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User temp = new User();
                int height= Integer.valueOf(et_height.getText().toString());
                int weight= Integer.valueOf(et_weight.getText().toString());
                int age= Integer.valueOf(et_age.getText().toString());

                temp.setHeight(height);
                temp.setWeight(weight);
                temp.setAge(age);
                temp.setGender(sp_gender.getSelectedItemPosition());
                temp.setAppMode(sp_app_mode.getSelectedItemPosition());

                UserUtil.logedUser.setHeight(height);
                UserUtil.logedUser.setWeight(weight);
                UserUtil.logedUser.setAge(age);
                UserUtil.logedUser.setGender(sp_gender.getSelectedItemPosition());
                UserUtil.logedUser.setAppMode(sp_app_mode.getSelectedItemPosition());
                SharedPrefUtil.editUser(context, temp, logedUserName);

            }
        });

    }
}
