package org.wangchenlong.wcl_onboarding_demo.animators;

import android.support.v7.widget.RecyclerView;
import android.view.animation.DecelerateInterpolator;

/**
 * 动画生成器
 * Created by renaud on 14/12/15.
 */
public class ItemAnimatorFactory {
    static public RecyclerView.ItemAnimator slidein() {
        SlideInUpDelayedAnimator animator = new SlideInUpDelayedAnimator(new DecelerateInterpolator(1.2f));
        animator.setAddDuration(600);
        return animator;
    }
}
