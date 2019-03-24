package com.example.onload;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);



        View backgroundimage = findViewById(R.id.back);
        Drawable background = backgroundimage.getBackground();
        background.setAlpha(120);

        Button next = findViewById(R.id.next);
        Button clear = findViewById(R.id.clear);
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
                    try {
                        show.setText(States.get());
                    } catch (Exception e) {
                        States.map.clear();
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                if(arg1.equals("S")) {
                   // state.setKeyListener(DigitsKeyListener.getInstance("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
                }
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                States.map.clear();
                States.grammar="";
                show.setText("");
                state.setInputType(1);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(States.map.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Empty Grammar!!!",Toast.LENGTH_SHORT).show();
                }
                else {

                    try {
                        Parser.initialize(States.map);
                       /* if(!Parser.checkValid())    {
                            Toast.makeText(getApplicationContext(),"Invalid Grammar Format..!!",Toast.LENGTH_SHORT).show();
                            return;
                        }*/
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_LONG).show();
                        return;
                    }
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(i);
                }
            }
        });

    }
}
