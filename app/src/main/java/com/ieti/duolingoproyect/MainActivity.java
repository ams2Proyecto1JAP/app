package com.ieti.duolingoproyect;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ieti.duolingoproyect.Models.Category;
import com.ieti.duolingoproyect.Models.Course;
import com.ieti.duolingoproyect.Models.Data;
import com.ieti.duolingoproyect.Models.Exercice;
import com.ieti.duolingoproyect.Models.Level;
import com.ieti.duolingoproyect.Models.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int courseId = 0;
    Course ingles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        User user = new User(1, "usuario1", 650, 130);
        Data.appUser = user;

        Data.myCourses.add(" - ");
        Data.myCourses.add("English");
        Data.myCourses.add("French");

        Data.addCourses.add(" - ");
        Data.addCourses.add("Japanese");
        Data.addCourses.add("Chinese");
        Data.addCourses.add("Portuguese");

        ingles = new Course(1, "English");
        Course frances = new Course(2, "French");

        Category basicIng = new Category(1, "Basic");
        Category foodIng = new Category(2, "Food");
        ArrayList<Category> categoriesIng = new ArrayList<Category>();
        categoriesIng.add(basicIng);
        categoriesIng.add(foodIng);
        Category basicFr = new Category(3, "Basic");
        Category sportsFr = new Category(4, "Sports");
        ArrayList<Category> categoriesFr = new ArrayList<Category>();
        categoriesFr.add(basicFr);
        categoriesFr.add(sportsFr);

        Level basicL1Ing = new Level(1, 1);
        Level basicL2Ing = new Level(2, 2);
        Level foodL1Ing = new Level(3, 1);
        ArrayList<Level> levelsBasicIng = new ArrayList<Level>();
        levelsBasicIng.add(basicL1Ing);
        levelsBasicIng.add(basicL2Ing);
        ArrayList<Level> levelsFoodIng = new ArrayList<Level>();
        levelsFoodIng.add(foodL1Ing);

        Level basicL1Fr = new Level(4, 1);
        Level basicL2Fr = new Level(5, 2);
        Level sportsL1Fr = new Level(6, 1);
        ArrayList<Level> levelsBasicFr = new ArrayList<Level>();
        levelsBasicFr.add(basicL1Fr);
        levelsBasicFr.add(basicL2Fr);
        ArrayList<Level> levelsSportsFr = new ArrayList<Level>();
        levelsBasicFr.add(sportsL1Fr);

        Exercice basicL1IngEx1 = new Exercice(1, "basicL1IngEx1");
        Exercice basicL1IngEx2 = new Exercice(2, "basicL1IngEx2");
        Exercice basicL1IngEx3 = new Exercice(3, "basicL1IngEx2");
        Exercice basicL1IngEx4 = new Exercice(4, "basicL1IngEx2");
        Exercice basicL1IngEx5 = new Exercice(5, "basicL1IngEx2");

        ArrayList<Exercice> basicL1IngExerices = new ArrayList<Exercice>();
        basicL1IngExerices.add(basicL1IngEx1);
        basicL1IngExerices.add(basicL1IngEx2);
        basicL1IngExerices.add(basicL1IngEx3);
        basicL1IngExerices.add(basicL1IngEx4);
        basicL1IngExerices.add(basicL1IngEx5);

        basicL1Ing.setExercices(basicL1IngExerices);
        Exercice basicL2IngEx1 = new Exercice(1, "basicL2IngEx1");
        Exercice basicL2IngEx2 = new Exercice(2, "basicL2IngEx1");
        ArrayList<Exercice> basicL2IngExerices = new ArrayList<Exercice>();
        basicL2IngExerices.add(basicL2IngEx1);
        basicL2IngExerices.add(basicL2IngEx2);
        basicL2Ing.setExercices(basicL2IngExerices);
        Exercice foodL1IngEx1 = new Exercice(1, "foodL1IngEx1");
        Exercice foodL1IngEx2 = new Exercice(2, "foodL1IngEx2");
        ArrayList<Exercice> foodL1IngExerices = new ArrayList<Exercice>();
        foodL1IngExerices.add(foodL1IngEx1);
        foodL1IngExerices.add(foodL1IngEx2);
        foodL1Ing.setExercices(foodL1IngExerices);

        Exercice basicL1FrEx1 = new Exercice(1, "basicL1FrEx1");
        Exercice basicL1FrEx2 = new Exercice(2, "basicL1FrEx2");
        ArrayList<Exercice> basicL1FrExerices = new ArrayList<Exercice>();
        basicL1FrExerices.add(basicL1FrEx1);
        basicL1FrExerices.add(basicL1FrEx2);
        basicL1Fr.setExercices(basicL1FrExerices);
        Exercice basicL2FrEx1 = new Exercice(1, "basicL2FrEx1");
        Exercice basicL2FrEx2 = new Exercice(2, "basicL2FrEx2");
        ArrayList<Exercice> basicL2FrExerices = new ArrayList<Exercice>();
        basicL2FrExerices.add(basicL2FrEx1);
        basicL2FrExerices.add(basicL2FrEx2);
        basicL2Fr.setExercices(basicL2FrExerices);
        Exercice sportsL1FrEx1 = new Exercice(1, "sportsL1FrEx1");
        Exercice sportsL1FrEx2 = new Exercice(2, "sportsL1FrEx2");
        ArrayList<Exercice> sportsL1FrExerices = new ArrayList<Exercice>();
        sportsL1FrExerices.add(sportsL1FrEx1);
        sportsL1FrExerices.add(sportsL1FrEx2);
        sportsL1Fr.setExercices(sportsL1FrExerices);

        basicIng.setLevels(levelsBasicIng);
        foodIng.setLevels(levelsFoodIng);
        basicFr.setLevels(levelsBasicFr);
        sportsFr.setLevels(levelsSportsFr);

        ingles.setCategories(categoriesIng);
        frances.setCategories(categoriesFr);

        ArrayList<Level> currentLevelsIng = new ArrayList<Level>();
        currentLevelsIng.add(basicL1Ing);
        currentLevelsIng.add(foodL1Ing);
        ingles.setCurrentLevels(currentLevelsIng);

        ArrayList<Level> currentLevelsFr = new ArrayList<Level>();
        currentLevelsFr.add(basicL1Fr);
        currentLevelsFr.add(sportsL1Fr);
        frances.setCurrentLevels(currentLevelsFr);


        Data.courses.add(ingles);
        Data.courses.add(frances);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.f_course, R.id.f_profile, R.id.f_league, R.id.f_shop)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);



    }


}