package com.corphish.nightlight.UI.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.corphish.nightlight.Engine.Core;
import com.corphish.nightlight.Helpers.PreferenceHelper;
import com.corphish.nightlight.R;

/**
 * Created by Avinaba on 10/24/2017.
 * Force switch fragment
 */

public class ForceSwitchFragment extends Fragment {

    private boolean forceSwitchEnabled;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        forceSwitchEnabled = PreferenceHelper.getForceSwitchStatus(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.card_force_switch, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SwitchCompat forceSwitch;
        forceSwitch = getView().findViewById(R.id.force_switch);

        forceSwitch.setChecked(forceSwitchEnabled);
        forceSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Core.applyNightModeAsync(b, getContext());
                PreferenceHelper.putForceSwitchStatus(getContext(), b);
            }
        });
    }
}
