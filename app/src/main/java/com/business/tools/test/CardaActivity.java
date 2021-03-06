package com.business.tools.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.business.toos.R;
import com.example.core.ContextTools;
import com.example.core.base.BaseSkinActivity;
import com.example.ui.image_card.CardDataItem;
import com.example.ui.image_card.CardSlidePanel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Petterp
 * on 2019-12-08
 * Function:
 */
public class CardaActivity extends BaseSkinActivity {

    private CardSlidePanel.CardSwitchListener cardSwitchListener;

    private int imagePaths[] = {R.drawable.wall01,
            R.drawable.wall02,
            R.drawable.wall03,
            R.drawable.wall04,
            R.drawable.wall05,
            R.drawable.wall06,
    }; // 6个图片


    private List<CardDataItem> dataList = new ArrayList<CardDataItem>();


    @Override
    public int layout() {
        return R.layout.card_layout;
    }

    @Override
    public void bindView() {
        CardSlidePanel slidePanel = findViewById(R.id.image_slide_panel);
        cardSwitchListener = new CardSlidePanel.CardSwitchListener() {

            @Override
            public void onShow(int index) {
                Toast.makeText(ContextTools.Companion.getContext(), "TestCardFragment"+"正在显示=" +index, Toast.LENGTH_SHORT).show();

            }
            //type 0=右边 ，-1=左边
            @Override
            public void onCardVanish(int index, int type) {
                Toast.makeText(ContextTools.Companion.getContext(), "TestCardFragment"+ "正在消失=" + index + " 消失type=" + type, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(View cardView, int index) {
                Toast.makeText(ContextTools.Companion.getContext(), "TestCardFragment"+"卡片点击=" + index, Toast.LENGTH_SHORT).show();
            }
        };
        slidePanel.setCardSwitchListener(cardSwitchListener);
        prepareDataList();
        slidePanel.fillData(dataList);
    }

    //封装数据
    private void prepareDataList() {
        int num = imagePaths.length;
        //重复添加数据10次（测试数据太少）
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < num; i++) {
                CardDataItem dataItem = new CardDataItem();
                dataItem.imagePath = imagePaths[i];
                dataList.add(dataItem);
            }
        }
    }


}
