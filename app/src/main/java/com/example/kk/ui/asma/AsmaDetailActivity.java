package com.example.kk.ui.asma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.kk.R;

public class AsmaDetailActivity extends AppCompatActivity {

    public static final String ARG_ID = "asmaId";
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asma_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        id = getIntent().getIntExtra(ARG_ID, 1);

        String [] names = getResources().getStringArray(R.array.namesAlla);
        String [] namesDesc = getResources().getStringArray(R.array.names_descs);

        ((TextView)findViewById(R.id.asmaDetail)).setText(names[id-1]+"\n"+ namesDesc[id-1]);

        Log.d("myLogs",namesDesc[id-1]);
        int index = id-1;
        String title = names[index];
        getSupportActionBar().setTitle(title);
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


