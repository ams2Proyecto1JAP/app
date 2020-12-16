package com.ieti.duolingoproyect;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ieti.duolingoproyect.Models.Category;
import com.ieti.duolingoproyect.Models.Course;
import com.ieti.duolingoproyect.Models.Data;
import com.ieti.duolingoproyect.Models.Exercice;
import com.ieti.duolingoproyect.Models.Level;
import com.ieti.duolingoproyect.Models.User;
import com.ieti.duolingoproyect.connection.InterfaceRMI;
import com.ieti.duolingoproyect.utils.Config;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import lipermi.handler.CallHandler;
import lipermi.net.Client;




public class MainActivity extends AppCompatActivity {
    int courseId = 0;
    Course ingles;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //new ClientService().execute();

        Data.configDir = getApplicationContext().getFilesDir();
        Config.generateConfig(Data.configDir, "0.0.0.0", "defaultUser", "password", false);


        Config configurator = Config.getConfigInstance(Data.configFile);

        User user = new User(1, "usuario1", 650, 130);
        Data.appUser = user;
        Data.initialSessionPoints = Data.appUser.getPoints();

        Course course = new Course(1, "Spanish", "English");

        Category cat1 = new Category(1, "Comida");
        Category cat2 = new Category(2, "Deportes");
        Category cat3 = new Category(3, "Videojuegos");
        Category cat4 = new Category(4, "Animales");

        ArrayList<Category> cats = new ArrayList<Category>();


        Level lvl1 = new Level(1);
        Level lvl2= new Level(2);
        ArrayList<Level> lvls = new ArrayList<Level>();


        Exercice ex1 = new Exercice(1, Data.testType1, Data.EXS_TYPE_OPEN_TRAD);
        Exercice ex2 = new Exercice(2, Data.testType2, Data.EXS_TYPE_TEST);
        Exercice ex3 = new Exercice(3, Data.testType3, Data.EXS_TYPE_TEST);
        ArrayList<Exercice> exs = new ArrayList<Exercice>();
        exs.add(ex1); exs.add(ex2); exs.add(ex3);


        lvl1.setExercices(exs);
        lvl2.setExercices(exs);
        lvls.add(lvl1); lvls.add(lvl2);

        cat1.setLevels(lvls);
        cat2.setLevels(lvls);
        cat3.setLevels(lvls);
        cat4.setLevels(lvls);
        cats.add(cat1); cats.add(cat2); cats.add(cat3); cats.add(cat4);

        course.setCategories(cats);

        Data.course = course;

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.f_course, R.id.f_profile, R.id.f_league, R.id.f_shop)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }


}

class ClientService extends AsyncTask<Void,Void, MainActivity> {

    @Override
    protected MainActivity doInBackground(Void... params) {
        try{
            CallHandler callHandler = new CallHandler();
            Client client = new Client("192.168.56.1", 7777, callHandler);
            InterfaceRMI interfaceRMI = (InterfaceRMI) client.getGlobal(InterfaceRMI.class);
            Data.allCourses  = interfaceRMI.getAllCrs();

            client.close();
        } catch (IOException e){
            Log.d("Tag", "exception client sercice "+e.toString());
        }
        return null;
    }
}