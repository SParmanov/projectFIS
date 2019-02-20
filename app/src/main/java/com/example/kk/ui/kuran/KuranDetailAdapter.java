package com.example.kk.ui.kuran;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class KuranDetailAdapter extends ArrayAdapter<KuranDetailWord> {
    private Typeface scheherazade;



    public KuranDetailAdapter(Context context, ArrayList<KuranDetailWord> users) {
        super(context, 0, users);
        scheherazade = Typeface.createFromAsset(context.getAssets(), "Scheherazade.ttf");
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        KuranDetailWord kuranDetailWord = getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_kuran_detail, parent, false);
        }
        TextView id = convertView.findViewById(R.id.id);
        TextView translit = convertView.findViewById(R.id.translit);
        TextView kuranKazakh = convertView.findViewById(R.id.kuranKazakh);
        TextView kuranArabic = convertView.findViewById(R.id.kuranArabic);


        kuranArabic.setTypeface(scheherazade);


        id.setText(kuranDetailWord.id+"");
        kuranKazakh.setText(kuranDetailWord.translit);
        translit.setText(kuranDetailWord.kuranKazakh);
        kuranArabic.setText(kuranDetailWord.kuranArabic);

        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.fade_in);
        convertView.startAnimation(animation);

        return convertView;
    }
}

