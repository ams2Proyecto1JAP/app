package com.ieti.duolingoproyect.ui.course;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ieti.duolingoproyect.Models.Course;
import com.ieti.duolingoproyect.Models.Data;
import com.ieti.duolingoproyect.Models.RecyclerAdapter;
import com.ieti.duolingoproyect.R;

public class CourseFragment extends Fragment {

    private CourseViewModel courseViewModel;
    private Context context;
    RecyclerView rvCategories;
    Course ingles;
    private boolean firstClick;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        courseViewModel =
                new ViewModelProvider(this).get(CourseViewModel.class);
        View root = inflater.inflate(R.layout.fragment_course, container, false);

        firstClick = false;
        context = getContext();
        Spinner spinnerMyCourses = root.findViewById(R.id.spinnerMyCourses);
        Spinner spinnerAddCourses =  root.findViewById(R.id.spinnerAddCourses);
        
        ArrayAdapter<CharSequence> adapterMyCourses= new ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_dropdown_item, Data.myCourses);
        ArrayAdapter<CharSequence> adapterAddCourses = new ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_dropdown_item, Data.allCourses);


        adapterMyCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterAddCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerMyCourses.setAdapter(adapterMyCourses);
        spinnerAddCourses.setAdapter(adapterAddCourses);


        rvCategories = root.findViewById(R.id.rvCategories);

        rvCategories.setLayoutManager(new LinearLayoutManager(this.getContext()));

        spinnerMyCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                displayCategories(Data.course, rvCategories, getContext());


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerAddCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!firstClick)
                    firstClick = true;
                else
                {

                    String crs = Data.allCourses.get(position);
                    //Log.d("crs", String.valueOf(position) + ", " + crs);
                    Data.allCourses.remove(position);


                    Data.myCourses.add(crs);


                    ArrayAdapter<CharSequence> adapterMyCourses= new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, Data.myCourses);
                    ArrayAdapter<CharSequence> adapterAddCourses = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, Data.allCourses);
                    spinnerMyCourses.setAdapter(adapterMyCourses);
                    spinnerAddCourses.setAdapter(adapterAddCourses);
                    firstClick = false;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        return root;
    }

    public void displayCategories(Course course, RecyclerView rvCategories, Context context){
        RecyclerAdapter rAdapter = new RecyclerAdapter(course.getCategories(), context);
        rvCategories.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rvCategories.setAdapter(rAdapter);
    }
}