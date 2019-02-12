package com.example.kk.ui.kuran;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        ListView surasList = view.findViewById(R.id.list_sura);

        ArrayList<Sura> suras = new ArrayList<>();
        suras.add(new Sura("content 1", "title 1", 1, Sura.FROM_MEDINA));
        suras.add(new Sura("content 2", "title 2", 2, Sura.FROM_MEKKE));

        SurasAdapter adapter = new SurasAdapter(suras);
        surasList.setAdapter(adapter);
    }
}