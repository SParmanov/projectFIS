package com.example.kk.ui.asma;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kk.R;
import com.example.kk.model.Asma;

import java.util.ArrayList;

public class AsmaAdapter extends BaseAdapter {

    private ArrayList<Asma> asma;

    public AsmaAdapter(ArrayList<Asma> asma) {
        this.asma = asma;
    }

    @Override
    public int getCount() {
        return asma.size();
    }

    @Override
    public Object getItem(int position) {
        return asma.get(position);
    }

    @Override
    public long getItemId(int position) {
        return asma.get(position).getNumber();
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_asma, parent, false);

        TextView name = convertView.findViewById(R.id.asmaItemName);
        Asma sura = asma.get(position);
        name.setText(sura.getName());


        return convertView;


    }
}