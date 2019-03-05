package com.example.kk.ui.kuran;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kk.R;
import com.example.kk.model.Sura;

import java.util.ArrayList;

public class KuranFragment  extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kuran,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        String []kazakh_names = getResources().getStringArray(R.array.kazakh_names);
        String []arabic_names = getResources().getStringArray(R.array.arabic_names);
        String [] kuranAddress = getResources().getStringArray(R.array.suraAddress);
        String [] suraLength = getResources().getStringArray(R.array.suraLength);


        final ArrayList<Sura> suras = new ArrayList<>();
        for(int i=0;i<114;i++){
            suras.add(new Sura(i+1 , kazakh_names[i], arabic_names[i], suraLength[i] +"",kuranAddress[i] ));
        }




        SurasAdapter adapter = new SurasAdapter(suras);


        //ListView listView = view.findViewById(R.id.kuranlist);
        ListView surasList = view.findViewById(R.id.list_sura);


        surasList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), SuraDetailActivity.class);
                intent.putExtra(SuraDetailActivity.ARG_ID, suras.get(position).id);
                startActivity(intent);
            }
        });


        surasList.setAdapter(adapter);
    }
}