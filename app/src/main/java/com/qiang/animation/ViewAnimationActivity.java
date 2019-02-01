package com.qiang.animation;

import android.animation.AnimatorSet;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author lixiqiang
 * @data：2019/1/24 0024
 */
public class ViewAnimationActivity extends AppCompatActivity {


    @BindView(R.id.text_one)
    TextView textOne;
    @BindView(R.id.text_two)
    TextView textTwo;
    @BindView(R.id.text_three)
    TextView textThree;
    @BindView(R.id.text_four)
    TextView textFour;
    @BindView(R.id.text_five)
    TextView textFive;
    @BindView(R.id.image_view)
    ImageView imageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
    }

    @OnClick({R.id.text_one, R.id.text_two, R.id.text_three, R.id.text_four, R.id.text_five})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_one:
                alphaAnimation();
                break;
            case R.id.text_two:
                rotateAnimation();
                break;
            case R.id.text_three:
                scaleAnimation();
                break;
            case R.id.text_four:
                translateAnimation();

                break;
            case R.id.text_five:
                setAnimation();

            default:
                break;
        }
    }

    private void translateAnimation() {
//        Animation animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.translate_1);
//        imageView.startAnimation(animation);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 360, 0, 360);
        translateAnimation.setDuration(1000);
        imageView.startAnimation(translateAnimation);

    }

    private void setAnimation() {
        Animation animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.set_animation_1);
        imageView.startAnimation(animation);

//        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
//
//        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, (float) (imageView.getWidth() * 0.5), (float) (imageView.getHeight() * 0.5));
//
//        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 3, 1, 3, (float) (imageView.getWidth() * 0.5), (float) (imageView.getHeight() * 0.5));
//
//        TranslateAnimation translateAnimation = new TranslateAnimation(0, 360, 0, 360);
//
//
//        AnimationSet animationSet = new AnimationSet(true);
//        animationSet.addAnimation(alphaAnimation);
//        animationSet.addAnimation(rotateAnimation);
//        animationSet.addAnimation(scaleAnimation);
//        animationSet.addAnimation(translateAnimation);
//        animationSet.setDuration(2000);
//        imageView.startAnimation(animationSet);

    }

    private void scaleAnimation() {
//        Animation animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.scale_1);
//        imageView.startAnimation(animation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 3, 1, 3, (float) (imageView.getWidth() * 0.5), (float) (imageView.getHeight() * 0.5));
        scaleAnimation.setDuration(2000);
        imageView.startAnimation(scaleAnimation);

    }

    private void rotateAnimation() {
        Animation animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.rotate_1);
        imageView.startAnimation(animation);
//        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, (float) (imageView.getWidth() * 0.5), (float)(imageView.getHeight() * 0.5));
//        rotateAnimation.setDuration(1000);
//        imageView.startAnimation(rotateAnimation);

    }

    private void alphaAnimation() {

        // xml文件方式
        Animation animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.alpha_1);
        imageView.startAnimation(animation);
        // 代码方式
//        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
//        alphaAnimation.setDuration(1000);
//        alphaAnimation.setFillAfter(true);
//        alphaAnimation.setRepeatCount(2);
//        imageView.startAnimation(alphaAnimation);
    }
}
