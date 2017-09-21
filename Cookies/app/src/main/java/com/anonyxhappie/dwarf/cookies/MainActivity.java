package com.anonyxhappie.dwarf.cookies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggle = true;
    }

    public void eatCookie(View view){
        ImageView imageView = (ImageView) findViewById(R.id.iv_cookies);
        TextView textView = (TextView) findViewById(R.id.tv_hungry);
        Button button = (Button) findViewById(R.id.b_eat);

        if(toggle){
            imageView.setImageResource(R.drawable.after_cookie);
            textView.setText(R.string.full);
            button.setText(R.string.done);
            toggle=!toggle;
        }else {
            imageView.setImageResource(R.drawable.before_cookie);
            textView.setText(R.string.hungry);
            button.setText(R.string.eat_cookie);
            toggle=!toggle;
        }

    }


}
