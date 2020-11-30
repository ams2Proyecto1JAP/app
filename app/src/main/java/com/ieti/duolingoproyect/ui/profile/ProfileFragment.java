package com.ieti.duolingoproyect.ui.profile;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ieti.duolingoproyect.Models.Data;
import com.ieti.duolingoproyect.Models.User;
import com.ieti.duolingoproyect.R;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private User appUser;

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


        Toast.makeText(this.getContext(), "hola", Toast.LENGTH_SHORT).show();


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