package com.example.saveuiass2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText met1;
private TextView mtvSaveData;
private Button mbtnChangeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        met1 = findViewById(R.id.et1);
        mtvSaveData = findViewById(R.id.tvSavedata);
        mbtnChangeText = findViewById(R.id.btnchangetext);

        met1.addTextChangedListener(textWatcher);

    mbtnChangeText.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           mtvSaveData.setText("Button clicked");
        }
    });
    }
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
          if (s.toString().length()>6){
              Toast.makeText(MainActivity.this,met1.getText(),Toast.LENGTH_SHORT).show();
          }
        }
    };

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
outState.putString("key","Button clicked");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String data = savedInstanceState.getString("key");
        mtvSaveData.setText(data);
    }
}