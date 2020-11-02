package com.example.ad41_daongochai_listviewdemo2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterListItemOrder extends BaseAdapter {

    List<ItemOrder> itemOrderList;

    public AdapterListItemOrder(List<ItemOrder> itemOrderList) {
        this.itemOrderList = itemOrderList;
    }

    @Override
    public int getCount() {
        return itemOrderList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemOrderList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.contact_item, parent, false);

        TextView itemOrderName = view.findViewById(R.id.tv_name_item_order);
        TextView itemOderPrice = view.findViewById(R.id.tv_price_item_order);

        ItemOrder itemOrder = itemOrderList.get(position);

        itemOrderName.setText(itemOrder.getNameItem());
        itemOderPrice.setText(itemOrder.getPriceItem()+"$");

        return view;
    }
}
