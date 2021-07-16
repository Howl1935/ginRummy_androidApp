package com.example.ginrummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        StringBuilder sb = new StringBuilder();
        TextView tv = findViewById(R.id.loadView);

                AssetManager assetManager = this.getAssets();
        try {
            for(String name : assetManager.list(""))
            {
                if(name.toLowerCase().endsWith("txt"))
                {
                    sb.append(name + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            tv.setText(tv.toString());

    }
    public void loadFileBtn(View v)
    {
        EditText fileName = findViewById(R.id.loadFileText);
        String fname = fileName.getText().toString().toLowerCase() + ".txt";
        FileInputStream fis = null;
        try {

            fis = openFileInput(fname);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);


            StringBuilder sb = new StringBuilder();
            String text;
            while((text = br.readLine()) != null)
            {
                sb.append(text).append("\n");
            }

            Log.d("loadFile", sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}