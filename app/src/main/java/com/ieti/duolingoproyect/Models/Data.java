package com.ieti.duolingoproyect.Models;

import java.io.File;
import java.util.ArrayList;

public class Data {

    public static Course course;
    public static ArrayList<String> myCourses = new ArrayList<String>();
    public static ArrayList<String> allCourses = new ArrayList<String>();
    public static User appUser = null;
    public static final String EXS_TYPE_TEST = "testType";
    public static final String EXS_TYPE_OPEN_TRAD = "tradOpen";

    public static final String testType1 = "{\"testExercise\":{\"phrTranslated\": \"Hello\",\"phrBadTranslated1\": \"Car\",\"phrBadTranslated2\": \"Plane\",\"phrToTranslate\": \"Hola\"}}";
    public static final String testType2 = "{\"testExercise\":{\"phrTranslated\": \"The car is green\",\"phrBadTranslated1\": \"Green is the car\",\"phrBadTranslated2\": \"Is the car green\",\"phrToTranslate\": \"El coche es verde\"}}";
    public static final String testType3 = "{\"testExercise\":{\"phrTranslated\": \"I play Pokemon\",\"phrBadTranslated1\": \"I plays Pokemon\",\"phrBadTranslated2\": \"Me play Pokemon\",\"phrToTranslate\": \"Yo juego a Pokemon\"}}";

    public static final String configFileName = "config.xml";
    public static File configFile;
    public static File configDir;

    public static final String key = "S3cR3tP@ssw0rd";

}
