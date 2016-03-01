package me.chunyu.spike.wcl_onboarding_demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据
 * <p>
 * Created by wangchenlong on 16/3/1.
 */
public class ModelItem {
    private String author;
    private int imgId;

    public ModelItem(String author, int imgId) {
        this.author = author;
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public String getAuthor() {
        return author;
    }

    public static List<ModelItem> getFakeItems() {
        ArrayList<ModelItem> itemsList = new ArrayList<>();
        itemsList.add(new ModelItem("Total Girls", R.drawable.img_total_girls));
        itemsList.add(new ModelItem("Jessica Jung", R.drawable.img_jessicajung));
        itemsList.add(new ModelItem("Kim Hyoyeon", R.drawable.img_kimhyoyeon));
        itemsList.add(new ModelItem("Seo Hyun", R.drawable.img_seohyun));
        itemsList.add(new ModelItem("Soo Young", R.drawable.img_sooyoung));
        return itemsList;
    }
}
