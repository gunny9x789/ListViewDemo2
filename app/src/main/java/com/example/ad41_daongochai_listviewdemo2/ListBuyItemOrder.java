package com.example.ad41_daongochai_listviewdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListBuyItemOrder extends AppCompatActivity implements ListItem {
    private ImageView imgBack;
    private ListView listItemBuy;
    private TextView priceItem2;
    private TextView btnBuy2;
    private TextView countItem, priceItem1;

    private AdapterListItemOrder adapterListItemOrder2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_buy_item_order);

        imgBack = findViewById(R.id.img_back);
        listItemBuy = findViewById(R.id.list_item_buy_order);
        priceItem2 = findViewById(R.id.tv_price_item2);
        countItem = findViewById(R.id.tv_count_order);
        priceItem1 = findViewById(R.id.tv_price_item1);
        btnBuy2 = findViewById(R.id.btnBuy2);

        adapterListItemOrder2 = new AdapterListItemOrder(itemBuyList);
        listItemBuy.setAdapter(adapterListItemOrder2);

        Intent intent = getIntent();
        int price = intent.getIntExtra("price1", 0);
        int count = intent.getIntExtra("countItem1",0);
        priceItem2.setText(price+"$");

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Order_screen.class);
                intent.putExtra("countItem2",count);
                intent.putExtra("price2", price);
                startActivity(intent);
            }
        });

        btnBuy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priceItem2.setText("0$");
                if (itemBuyList.size() > 0) {
                    Toast toast = Toast.makeText(getBaseContext(), "Mua thành công hết " + price + "$", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getBaseContext(), "Chọn sản phẩm muốn mua", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                itemBuyList.clear();
                Intent intent1 = new Intent(getBaseContext(),Order_screen.class);
                intent.putExtra("countItem2",0);
                intent.putExtra("price2", 0);
                startActivity(intent1);
            }
        });

    }
}