package com.example.kk.ui.kuran;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kk.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KuranDetailActivity extends AppCompatActivity {

    public static final String ARG_ID = "kuranId";
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_kuran_detail);
        id = getIntent().getIntExtra(ARG_ID, 1);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        String[] arabic_names = getResources().getStringArray(R.array.arabic_names);
        String[] kazakh_names = getResources().getStringArray(R.array.kazakh_names);

        int index = id-1;
        String title = kazakh_names[index]+""+arabic_names[index];
        getSupportActionBar().setTitle(title);

        int kazakh = getResources().getIdentifier("kazakh"+"_"+(id),"array",this.getPackageName());
        int trans = getResources().getIdentifier("translit"+"_"+(id),"array",this.getPackageName());
        int arabic = getResources().getIdentifier("arabic"+"_"+(id),"array",this.getPackageName());


        String [] translit = getResources().getStringArray(trans);
        String [] kuranKazakh = getResources().getStringArray(kazakh);
        String [] kuranArabic = getResources().getStringArray(arabic);

        final ArrayList<KuranDetailWord> kuranDetailWords = new ArrayList<>();


        if(id==1){
            for (int i=0;i<translit.length ;i++){
                kuranDetailWords.add(new KuranDetailWord((i+1)+"",translit[i],kuranKazakh[i],kuranArabic[i]));
            }
        }
        else{
            kuranDetailWords.add(new KuranDetailWord("",translit[0],kuranKazakh[0],kuranArabic[0]));

            for (int i=1;i<translit.length ;i++){

                kuranDetailWords.add(new KuranDetailWord( i+"", translit[i] , kuranKazakh[i] , kuranArabic[i]));
            }
        }






        KuranDetailAdapter itemsAdapter =
                new KuranDetailAdapter(this, kuranDetailWords);

        ListView listView = (ListView) findViewById(R.id.kuranDetailList);
        listView.setAdapter(itemsAdapter);





    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}








