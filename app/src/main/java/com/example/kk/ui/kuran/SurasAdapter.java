package com.example.kk.ui.kuran;

import android.annotation.SuppressLint;
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
        return suras.get(position).getNumber();
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sura, parent, false);
        TextView name = convertView.findViewById(R.id.text_name);
        TextView content = convertView.findViewById(R.id.text_content);
        TextView from = convertView.findViewById(R.id.text_from);
        TextView number = convertView.findViewById(R.id.text_number);

        Sura sura = suras.get(position);
        name.setText(sura.getTitle());
        content.setText(sura.getContent());
        from.setText(sura.getType() == Sura.FROM_MEKKE ? "Mekka" : "Medina");
        number.setText(String.format("%d's surah", sura.getNumber()));
        return convertView;
    }
}
