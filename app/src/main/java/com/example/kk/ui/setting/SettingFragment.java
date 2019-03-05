package com.example.kk.ui.setting;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;



import com.example.kk.R;
public class SettingFragment extends Fragment {


    SeekBar seekBar1 ;
    SeekBar seekBar2;
    SeekBar seekBar3 ;

    int seekValue1;
    int seekValue2;
    int seekValue3 ;

    TextView translit1;
    TextView exa;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(com.example.kk.R.layout.fragment_setting,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //translit1 = view.findViewById(R.id.kuranKazakh);
        exa = view.findViewById(R.id.quran);

        seekBar1 = view.findViewById(com.example.kk.R.id.seekBar1);
        seekBar2 = view.findViewById(com.example.kk.R.id.seekBar2);
        seekBar3 = view.findViewById(com.example.kk.R.id.seekBar3);


        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekValue1 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                exa.setText("h ");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                exa.setTextSize(seekValue1);

            }
        });

    }

}