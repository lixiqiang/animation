package com.qiang.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PropertyActivity extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.text_one, R.id.text_two, R.id.text_three, R.id.text_four, R.id.text_five})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_one:
                alphaAnim();
                break;
            case R.id.text_two:
                rotateAnim();
                break;
            case R.id.text_three:
                scaleAnim();
                break;
            case R.id.text_four:
                translateAnim();
                break;
            case R.id.text_five:
//                setAnim();
                testAnim();
                break;
            default:
                break;
        }
    }

    private void testAnim() {
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "translationX", 0, 360);
//        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float y = (float) animation.getAnimatedValue() + 160 * 3;
//                Log.e("testAnim", "y =" + y);
//                imageView.setY(y);
//            }
//        });
//        objectAnimator.setDuration(2000);
//        objectAnimator.start();


        ValueAnimator animator = new ValueAnimator();
        animator.setDuration(3000);
        animator.setObjectValues(new PointF(0, 0));
        animator.setInterpolator(new LinearInterpolator());

        animator.setEvaluator(new TypeEvaluator<PointF>() {
            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {

                PointF point = new PointF();
                point.x = 1200 * fraction;
                point.y = 600 * fraction * fraction;
                return point;
            }

        });
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointF = (PointF) animation.getAnimatedValue();
                imageView.setX(pointF.x);
                imageView.setY(pointF.y + 480);
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                imageView.setX(480);
                imageView.setY(480);

            }
        });

    }

    private void setAnim() {
    }

    private void translateAnim() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "translationX", 0, 360);
        objectAnimator.setDuration(1000);
        objectAnimator.start();

    }

    private void scaleAnim() {
        //  scaleX  scaleY

        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(imageView, "scaleX", 1, 3, 1);
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(imageView, "scaleY", 1, 3, 1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorX, objectAnimatorY);
        animatorSet.setDuration(1000);
        animatorSet.start();

    }

    private void rotateAnim() {
        // rotationX rotationY
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "rotationY", 0,360);
        objectAnimator.setDuration(1000);
        objectAnimator.start();

//        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.animator_1);
//        animatorSet.setTarget(imageView);
//        animatorSet.start();

    }

    private void alphaAnim() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "alpha", 0f, 1.0f);
        objectAnimator.setDuration(1000);
        objectAnimator.start();

    }
}
