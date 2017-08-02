package org.wangchenlong.wcl_onboarding_demo;

import java.util.ArrayList;
import java.util.List;


/**
 * 数据
 * <p>
 * Created by wangchenlong on 16/3/1.
 */
public class ModelItem {
    private String mName;
    private int mImgId;

    public ModelItem(String name, int imgId) {
        mName = name;
        mImgId = imgId;
    }

    public int getImgId() {
        return mImgId;
    }

    public String getName() {
        return mName;
    }

    // 获取模拟数据
    public static List<ModelItem> getFakeItems() {
        ArrayList<ModelItem> itemsList = new ArrayList<>();
        itemsList.add(new ModelItem("Total Girls", R.drawable.img_total_girls));
        itemsList.add(new ModelItem("Jessica Jung", R.drawable.img_jessicajung));
        itemsList.add(new ModelItem("Kim Hyoyeon", R.drawable.img_kimhyoyeon));
        itemsList.add(new ModelItem("Seo Hyun", R.drawable.img_seohyun));
        itemsList.add(new ModelItem("Soo Young", R.drawable.img_sooyoung));
        itemsList.add(new ModelItem("Sunny", R.drawable.img_sunny));
        itemsList.add(new ModelItem("Taeyeon", R.drawable.img_taeyeon));
        itemsList.add(new ModelItem("Tiffany", R.drawable.img_tiffany));
        itemsList.add(new ModelItem("Yoona", R.drawable.img_yoona));
        itemsList.add(new ModelItem("Yuri", R.drawable.img_yuri));
        return itemsList;
    }
}
