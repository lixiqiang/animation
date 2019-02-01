package com.qiang.animation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text_one)
    TextView textOne;
    @BindView(R.id.text_two)
    TextView textTwo;
    @BindView(R.id.text_three)
    TextView textThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.text_one, R.id.text_two, R.id.text_three, R.id.text_four,R.id.text_five})

    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.text_one:
                intent.setClass(this, ViewAnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.text_two:
                break;
            case R.id.text_three:
                intent.setClass(this, PropertyActivity.class);
                startActivity(intent);

                break;
            case R.id.text_four:
                intent.setClass(this, LottieActivity.class);
                startActivity(intent);
                break;

            case R.id.text_five:
                intent.setClass(this, SvgActivity.class);
                startActivity(intent);

            default:
                break;
        }
    }
}
