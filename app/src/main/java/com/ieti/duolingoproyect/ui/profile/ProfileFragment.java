package com.ieti.duolingoproyect.ui.profile;

import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ieti.duolingoproyect.Models.Data;
import com.ieti.duolingoproyect.Models.User;
import com.ieti.duolingoproyect.R;
import com.ieti.duolingoproyect.utils.Config;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private User appUser;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);



        appUser = Data.appUser;

        final TextView txtProfile = root.findViewById(R.id.txtProfile);
        final TextView txtPoints = root.findViewById(R.id.txtPoints);
        final TextView txtCoins = root.findViewById(R.id.txtCoins);

        txtProfile.setText(appUser.getUsername());
        txtPoints.setText(String.valueOf(appUser.getPoints()));
        txtCoins.setText(String.valueOf(appUser.getCoins()));

        txtProfile.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
        txtPoints.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
        txtCoins.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);

        txtProfile.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        txtPoints.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
        txtCoins.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);



        final ImageView ivPoints = root.findViewById(R.id.ivPoints);
        final ImageView ivCoins = root.findViewById(R.id.ivCoins);

        ivPoints.setImageDrawable(getResources().getDrawable(R.drawable.ic_lighting));
        ivCoins.setImageDrawable(getResources().getDrawable(R.drawable.ic_money));


        Config configurator = Config.getConfigInstance(Data.configFile);
        final EditText etIp = root.findViewById(R.id.etIpserver);
        final EditText etUs = root.findViewById(R.id.etUsername);
        final EditText etPw = root.findViewById(R.id.etPassword);

        etIp.setText(configurator.getValue(Config.configParamIp));
        etUs.setText(configurator.getValue(Config.configParamUser));
        etPw.setText(configurator.getValue(Config.configParamPassword));

        final Button btSave = root.findViewById(R.id.btSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                configurator.setValue(Config.configParamIp, etIp.getText().toString());
                configurator.setValue(Config.configParamUser, etUs.getText().toString());
                configurator.setValue(Config.configParamPassword, etPw.getText().toString());
            }
        });






        /*
        profileViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        return root;
    }
}