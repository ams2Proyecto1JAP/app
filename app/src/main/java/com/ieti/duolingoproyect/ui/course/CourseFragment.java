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

public class CourseFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    private CourseViewModel courseViewModel;
    RecyclerView rvCategories;
    Course ingles;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        courseViewModel =
                new ViewModelProvider(this).get(CourseViewModel.class);
        View root = inflater.inflate(R.layout.fragment_course, container, false);

        Spinner spinnerMyCourses = root.findViewById(R.id.spinnerMyCourses);
        Spinner spinnerAddCourses =  root.findViewById(R.id.spinnerAddCourses);
        
        //ArrayAdapter<CharSequence> adapterMyCourses= new ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_dropdown_item, Data.myCourses);
        ArrayAdapter<CharSequence> adapterAddCourses = new ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_dropdown_item, Data.allCourses);
        for(String s : Data.allCourses){
            Log.d("Spinner ", s);
        }

        //adapterMyCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterAddCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //spinnerMyCourses.setAdapter(adapterMyCourses);
        spinnerAddCourses.setAdapter(adapterAddCourses);

        spinnerMyCourses.setOnItemSelectedListener(this);
        spinnerAddCourses.setOnItemSelectedListener(this);

        rvCategories = root.findViewById(R.id.rvCategories);
        //RecyclerAdapter recyclerAdapter = new RecyclerAdapter(ingles.getCategories(), ingles.getCurrentLevels());
        rvCategories.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //rvCategories.setAdapter(recy,clerAdapter);
        //Course ingles = Data.courses.get(0);
        /*rvCategories = root.findViewById(R.id.rvCategories);
        RecyclerAdapter rAdapter = new RecyclerAdapter(ingles.getCategories(), ingles.getCurrentLevels());
        rvCategories.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rvCategories.setAdapter(rAdapter);*/

        return root;
    }@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        searchCourse(text, getContext());
        //displayCategories(ingles);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void searchCourse(String language, Context context){
        for(Course c: Data.courses){
            if(c.getLanguage().equals(language)){
                //Toast.makeText(this.getContext(), "Found!", Toast.LENGTH_SHORT).show();
                //courseId = c.getCourseId();
                //showCategories();
                displayCategories(c, rvCategories, context);
            }
        }
    }

    public void displayCategories(Course course, RecyclerView rvCategories, Context context){
        RecyclerAdapter rAdapter = new RecyclerAdapter(course.getCategories(), course.getCurrentLevels(), context);
        rvCategories.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rvCategories.setAdapter(rAdapter);
    }
}