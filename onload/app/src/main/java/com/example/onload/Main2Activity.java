package com.example.onload;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_main2);
        View backgroundimage = findViewById(R.id.lay);
        Drawable background = backgroundimage.getBackground();
        background.setAlpha(120);
        TextView view1 = findViewById(R.id.display1);
        view1.setText(States.grammar);

        Button test = findViewById(R.id.test);
        final EditText string = findViewById(R.id.string);
        final TextView result = findViewById(R.id.result);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Parser.setInput(string.getText().toString());
                    boolean output = Parser.validate();
                    if(output) {
                        result.setText("Yess!!!..String belongs to the given grammar");
                        result.setTextColor(Color.BLUE);
                    }
                    else {
                        result.setText("Sorry!!...String doesnot belongs to the given grammar \nOR\nInvalid Grammar");
                        result.setTextColor(Color.RED);
                    }

                } catch (Exception e) {
                    result.setText("Sorry!!...String doesnot belongs to the given grammar \nOR\nInvalid Grammar");
                    result.setTextColor(Color.RED);
                }
            }
        });

    }
}
