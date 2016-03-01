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
//        itemsList.add(new ModelItem("Prasad A.", R.drawable.img_prasad));
//        itemsList.add(new ModelItem("Besim  Mazhiqi", R.drawable.img_besim));
//        itemsList.add(new ModelItem("Mark Bridger", R.drawable.img_mark));
//        itemsList.add(new ModelItem("William Mevissem", R.drawable.img_william));
//        itemsList.add(new ModelItem("Darren J Bennet", R.drawable.img_darren));
        return itemsList;
    }
}
