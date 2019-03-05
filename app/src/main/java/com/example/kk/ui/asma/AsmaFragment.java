package com.example.kk.ui.asma;

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
import com.example.kk.model.Asma;

import java.util.ArrayList;

public class  AsmaFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_asma,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView surasList = view.findViewById(R.id.list_asma);

        String [] namesAllah = getResources().getStringArray(R.array.namesAlla);

        final ArrayList<Asma> asma = new ArrayList<>();

        for (int i = 0 ; i<99 ; i++){

            asma.add(new Asma(i+1,(i+1)+" "+ namesAllah[i]));
        }


        AsmaAdapter adapter = new AsmaAdapter(asma);



        surasList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), AsmaDetailActivity.class);
                intent.putExtra(AsmaDetailActivity.ARG_ID, asma.get(position).getNumber());
                startActivity(intent);
            }
        });



        surasList.setAdapter(adapter);
    }



}
