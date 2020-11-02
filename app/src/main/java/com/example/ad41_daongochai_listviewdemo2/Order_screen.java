package com.example.ad41_daongochai_listviewdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Order_screen extends AppCompatActivity implements ListItem {
    private ImageView imgBuy;
    private TextView countItem, priceItem1;
    private ListView listItem;
    private TextView btnBuy1;
    private ItemOrder item1, item2, item3, item4, item5, item6;
    private int count;
    int price;

    AdapterListItemOrder adapterListItemOrder1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);

        Intent getInten = getIntent();

        count = getInten.getIntExtra("countItem2",0) ;
        price = getInten.getIntExtra("price2",0) ;;

        imgBuy = findViewById(R.id.img_buy_order);
        countItem = findViewById(R.id.tv_count_order);
        priceItem1 = findViewById(R.id.tv_price_item1);
        listItem = findViewById(R.id.list_item_order);
        btnBuy1 = findViewById(R.id.btnBuy1);

        item1 = new ItemOrder("Pizza Panda", 10);
        item2 = new ItemOrder("KFC Supper", 25);
        item3 = new ItemOrder("Bread Eggs", 10);
        item4 = new ItemOrder("Coca Cola", 5);
        item5 = new ItemOrder("Chicken Supper", 25);
        item6 = new ItemOrder("Cup cake", 10);

        itemOrdersList.clear();

        itemOrdersList.add(item1);
        itemOrdersList.add(item2);
        itemOrdersList.add(item3);
        itemOrdersList.add(item4);
        itemOrdersList.add(item5);
        itemOrdersList.add(item6);

        countItem.setText(count+"");
        priceItem1.setText(price+"$");

        imgBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ListBuyItemOrder.class);
                intent.putExtra("price1", price);
                intent.putExtra("countItem1",count);
                startActivity(intent);

            }
        });

        adapterListItemOrder1 = new AdapterListItemOrder(itemOrdersList);
        listItem.setAdapter(adapterListItemOrder1);

        listItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemOrder itemOrder = itemOrdersList.get(position);
                itemBuyList.add(itemOrder);
                count++;
                countItem.setText(count + "");
                price = price + itemOrder.getPriceItem();
                priceItem1.setText(price + "$");
            }
        });

        btnBuy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countItem.setText("0");
                priceItem1.setText("0$");
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
                Intent intent = getIntent();
                count = intent.getIntExtra("count", 0);
                price = intent.getIntExtra("price2", 0);
            }
        });
    }
}