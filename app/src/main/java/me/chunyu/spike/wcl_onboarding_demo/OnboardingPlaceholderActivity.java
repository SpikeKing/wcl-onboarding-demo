package me.chunyu.spike.wcl_onboarding_demo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.chunyu.spike.wcl_onboarding_demo.animators.ItemAnimatorFactory;

/**
 * Placeholder的启动动画
 * <p>
 * Created by wangchenlong on 16/2/29.
 */
public class OnboardingPlaceholderActivity extends AppCompatActivity {

    @Bind(R.id.placeholder_tv_title) TextView mTvTitle;
    @Bind(R.id.placeholder_t_toolbar) Toolbar mTToolbar;
    @Bind(R.id.placeholder_rv_recycler) RecyclerView mRvRecycler;
    @Bind(R.id.placeholder_fab_bar) FloatingActionButton mFabBar;

    private PhRecyclerAdapter mPhRecyclerAdapter;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_placeholder);
        ButterKnife.bind(this);

        // 延迟启动动画效果
        new Handler().postDelayed(this::onAnimateCreate, 500);
    }

    // 动画创建
    private void onAnimateCreate() {
        ViewCompat.animate(mTvTitle).alpha(1).start();

        mRvRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRvRecycler.setItemAnimator(ItemAnimatorFactory.slidein());

        mPhRecyclerAdapter = new PhRecyclerAdapter();
        mRvRecycler.setAdapter(mPhRecyclerAdapter);

        mTToolbar.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override public boolean onPreDraw() {
                mTToolbar.getViewTreeObserver().removeOnPreDrawListener(this);
                final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);

                mTToolbar.measure(widthSpec, heightSpec);
                collapseToolbar(mTToolbar.getHeight());
                return true;
            }
        });
    }

    private void collapseToolbar(int height) {
        TypedValue tv = new TypedValue();
        getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true);
        int toolBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        ValueAnimator valueAnimator = ValueAnimator.ofInt(height, toolBarHeight); // 动画
        valueAnimator.addUpdateListener(animation -> {
            ViewGroup.LayoutParams lp = mTToolbar.getLayoutParams();
            lp.height = (Integer) animation.getAnimatedValue();
            mTToolbar.setLayoutParams(lp);
        });
        valueAnimator.start();
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mPhRecyclerAdapter.setItems(ModelItem.getFakeItems());
                ViewCompat.animate(mFabBar).setStartDelay(500)
                        .setDuration(500).scaleX(1).scaleY(1).start();
            }
        });
    }

    // 列表适配器
    public static class PhRecyclerAdapter extends RecyclerView.Adapter<PhRecyclerAdapter.PhViewHolder> {

        private final ArrayList<ModelItem> mItems = new ArrayList<>(); // 数据

        public void setItems(List<ModelItem> items) {
            // 启动动画的关键位, 顺次添加动画效果
            int pos = getItemCount();
            mItems.addAll(items);
            notifyItemRangeInserted(pos, mItems.size());
        }

        @Override
        public PhViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
            return new PhViewHolder(v);
        }

        @Override
        public void onBindViewHolder(PhViewHolder holder, int position) {
            holder.bindTo(mItems.get(position));
        }

        @Override public int getItemCount() {
            return mItems.size();
        }

        // 数据存储
        public static class PhViewHolder extends RecyclerView.ViewHolder {
            @Bind(R.id.item_tv_title) TextView mTvTitle;
            @Bind(R.id.item_iv_image) ImageView mIvImage;

            public PhViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }

            public void bindTo(ModelItem item) {
                mIvImage.setImageResource(item.getImgId());
                mTvTitle.setText(item.getName());
            }
        }
    }

}
