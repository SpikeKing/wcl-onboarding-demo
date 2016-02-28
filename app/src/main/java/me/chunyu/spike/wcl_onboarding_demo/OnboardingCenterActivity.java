package me.chunyu.spike.wcl_onboarding_demo;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 加载中心
 * <p/>
 * Created by wangchenlong on 16/2/28.
 */
public class OnboardingCenterActivity extends AppCompatActivity {
    public static final int STARTUP_DELAY = 300; // 启动延迟
    public static final int ANIM_ITEM_DURATION = 1000;
    public static final int ITEM_DELAY = 300;

    @Bind(R.id.onboard_ll_container) LinearLayout mLlContainer;
    @Bind(R.id.onboard_iv_logo) ImageView mIvLogo;
    @Bind(R.id.onboard_b_choice_1) Button mBChoice1;
    @Bind(R.id.onboard_b_choice_2) Button mBChoice2;

    private View.OnClickListener mNiceListener = new View.OnClickListener() {
        @Override public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Nice!", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener mBackListener = new View.OnClickListener() {
        @Override public void onClick(View v) {
            onBackPressed();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_center);
        ButterKnife.bind(this);

        // 向下移动
        ViewCompat.animate(mIvLogo)
                .translationY(-300)
                .setStartDelay(STARTUP_DELAY)
                .setDuration(ANIM_ITEM_DURATION)
                .setInterpolator(new DecelerateInterpolator(1.2f))
                .start();

        for (int i = 0; i < mLlContainer.getChildCount(); i++) {
            View v = mLlContainer.getChildAt(i);
            ViewPropertyAnimatorCompat viewAnimator;

            // TextView控件, Button是TextView的子类
            // 从消失到显示
            if (!(v instanceof Button)) {
                viewAnimator = ViewCompat.animate(v)
                        .translationY(50).alpha(1)
                        .setStartDelay((ITEM_DELAY * i) + 500)
                        .setDuration(1000);
            } else { // Button控件, 从缩小到扩大
                viewAnimator = ViewCompat.animate(v)
                        .scaleY(1).scaleX(1)
                        .setStartDelay((ITEM_DELAY * i) + 500)
                        .setStartDelay(500);
            }

            viewAnimator.setInterpolator(new DecelerateInterpolator()).start();
        }

        mBChoice1.setOnClickListener(mNiceListener);
        mBChoice2.setOnClickListener(mBackListener);
    }
}
