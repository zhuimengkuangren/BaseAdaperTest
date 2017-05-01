package com.zhuimeng.baseadapertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
    }

    private void initView() {
        buttonOne = (Button) findViewById(R.id.bt_one);
        buttonTwo = (Button) findViewById(R.id.bt_two);
        buttonThree = (Button) findViewById(R.id.bt_three);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_one:
                Intent intentOne = new Intent(this, ActivityOne.class);
                startActivity(intentOne);
                break;
            case R.id.bt_two:
                Intent intentTwo = new Intent(this, ActivityTwo.class);
                startActivity(intentTwo);
                break;
            case R.id.bt_three:
                Intent intentThree = new Intent(this, ActivityThree.class);
                startActivity(intentThree);
                break;
            default:
                break;
        }
    }
}
