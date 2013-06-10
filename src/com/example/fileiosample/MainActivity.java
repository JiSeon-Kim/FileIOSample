package com.example.fileiosample;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

  private EditText editName;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    editName = (EditText)findViewById(R.id.editName);
    final SharedPreferences pref = getSharedPreferences("test", MODE_PRIVATE);
    String name = pref.getString("name", "");
    editName.setText(name);
    
    Button btnSave = (Button)findViewById(R.id.btnSave);
    btnSave.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        String name = editName.getText().toString();
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", name);
        editor.commit();
      }
    });
  }
}


