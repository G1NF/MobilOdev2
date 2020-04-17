package com.example.mobilprogramlamaodev2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobilprogramlamaodev2.R;
import com.example.mobilprogramlamaodev2.utils.UserUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NoteActivity extends AppCompatActivity {

    EditText EditText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (UserUtil.logedUser.getAppMode() == 0){
            setTheme(android.R.style.Theme_Light_NoTitleBar);
        }
        else {
            setTheme(android.R.style.Theme_NoTitleBar);

        }
        setContentView(R.layout.activity_note);

        Button save = (Button) findViewById(R.id.save);
        EditText1 =  findViewById(R.id.EditText1);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save_file("text.txt");
            }
        });
        String text= get_file_content("text.txt");
        EditText1.setText(text);

    }



    public void save_file(String fileName) {
        try {
            OutputStreamWriter out =
                    new OutputStreamWriter(openFileOutput(fileName, 0));
            out.write(EditText1.getText().toString());
            out.close();
            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();
        } catch (Throwable t) {
            Toast.makeText(this, "Error " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public String get_file_content(String fileName) {
        String content = "";
        if (FileExists(fileName)) {
            try {
                InputStream in = openFileInput(fileName);
                if ( in != null) {
                    InputStreamReader tmp = new InputStreamReader( in );
                    BufferedReader reader = new BufferedReader(tmp);
                    String str;
                    StringBuilder buf = new StringBuilder();
                    while ((str = reader.readLine()) != null) {
                        buf.append(str + "\n");
                    } in .close();
                    content = buf.toString();
                }
            } catch (java.io.FileNotFoundException e) {} catch (Throwable t) {
                Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
            }
        }
        return content;
    }
    public boolean FileExists(String fname) {
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }





}
