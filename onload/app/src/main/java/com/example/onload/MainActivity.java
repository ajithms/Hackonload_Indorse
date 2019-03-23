package com.example.onload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        States.map.clear();
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.add);
        final EditText state = findViewById(R.id.state);
        final TextView show = findViewById(R.id.display);
        final EditText rule = findViewById(R.id.rule);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String arg1 = state.getText().toString();
                String arg2 =  rule.getText().toString();
                if(!arg1.isEmpty() && !arg2.isEmpty()) {
                    States.set(arg1 , arg2);
                    state.setText("");
                    rule.setText("");
                    state.setInputType(InputType.TYPE_CLASS_TEXT);
                    show.setText(States.get());
                }
            }
        });

    }
}
