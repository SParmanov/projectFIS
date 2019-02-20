package com.example.kk.ui.kuran;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kk.R;
import com.example.kk.model.Sura;

import java.util.ArrayList;
// TODO Asygyp zhasa saldym durystap alarsyn
public class SurasAdapter extends BaseAdapter {

    private ArrayList<Sura> suras;




    public SurasAdapter(ArrayList<Sura> suras) {
        this.suras = suras;
    }

    @Override
    public int getCount() {
        return suras.size();
    }


    @Override
    public Object getItem(int position) {
        return suras.get(position);
    }

    @Override
    public long getItemId(int position) {
        return suras.get(position).getId();
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sura, parent, false);

        TextView empty =  convertView.findViewById(R.id.id);
        TextView kazakh_names = convertView.findViewById(R.id.kazakh_names);
        TextView arabic_names = convertView.findViewById(R.id.arabic_names);
        TextView lengthSura = convertView.findViewById(R.id.lengthSura);
        TextView kuranAddress =  convertView.findViewById(R.id.kuranAddress);



        Sura sura = suras.get(position);

        //empty.setText(sura.getId());
        empty.setText(String.format("%d%s", sura.getId(),""));
        kazakh_names.setText(sura.getKazakh_names());
        arabic_names.setText(sura.getArabic_names());
        lengthSura.setText(sura.getLengthSura()+" аят");
        kuranAddress.setText(sura.getKuranAddress());
        

        return convertView;
    }
}