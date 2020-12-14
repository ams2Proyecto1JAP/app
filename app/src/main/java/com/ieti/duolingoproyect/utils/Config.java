package com.ieti.duolingoproyect.utils;

import android.os.Build;
import android.util.Base64;
import android.util.Log;
import android.util.Xml;

import androidx.annotation.RequiresApi;

import com.ieti.duolingoproyect.Models.Data;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Config {

    private static Config configurator;
    private Hashtable<String, String> configurations;
    private File configFile;

    public static final String configRoot = "config";
    public static final String configParamIp = "ipServer";
    public static final String configParamUser = "username";
    public static final String configParamPassword = "password";



    private Config(File configFile)
    {
        this.configFile = configFile;
        this.configurations = new Hashtable<String, String>();
        loadConfigurations();
    }

    private void loadConfigurations()
    {
        this.configurations.clear();
        Document doc = getDocFromXML(this.configFile);
        NodeList configs = doc.getFirstChild().getChildNodes();
        for (int i = 0; i < configs.getLength(); i++)
        {
            Node param = configs.item(i);
            String key = param.getNodeName();
            String value = param.getTextContent();
            if (!key.equals("#text"))
            {
                configurations.put(key, value);
            }

        }

        /*
        Enumeration<String> keys = configurations.keys();

        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            Log.d("configgggg", key + ", " + configurations.get(key));
        }*/
    }

    private Document getDocFromXML(File configFile)
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
            return db.parse(configFile);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Config getConfigInstance(File configFile) {
        if (configurator == null)
        {

            configurator = new Config(configFile);
            return configurator;
        }
        else
        {
            return configurator;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String getValue(String key)
    {
        if (key != configParamPassword)
            return configurations.get(key);
        else
        {
            String pwEncryptedBase64 = configurations.get(key);

            byte[] pwEncrypted = Base64.decode(pwEncryptedBase64, Base64.DEFAULT);

            byte[] cKey = Crypt.generateKey(Data.key);
            byte[] pwDecrypted = Crypt.decrypt(cKey, pwEncrypted);
            return new String(pwDecrypted, StandardCharsets.UTF_8);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void setValue(String key, String value)
    {
        configurations.put(key, value);
        String ip = configurations.get(configParamIp);
        String user = configurations.get(configParamUser);
        String pw = configurations.get(configParamPassword);

        switch(key)
        {
            case configParamIp:
                ip = value;
                break;
            case configParamUser:
                user = value;
                break;
            case configParamPassword:
                pw = value;
                break;

        }
        generateConfig(Data.configDir, ip, user, pw, true);
        loadConfigurations();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void generateConfig(File dir, String ip, String username, String password, boolean delete){
        File configFile = new File(dir, Data.configFileName);
        Data.configFile = configFile;

        // FALSE --> si se llama al arrancar la aplicacion para asegurarnos que genera el fichero si no existe
        // TRUE --> si se llama para overwritear el fichero, como serializer no permite modificar nodos, hay
        // que borrar el fichero y volverlo a crear de nuevo
        if (delete)
        {
            configFile.delete();
        }
        if (!configFile.exists())
        {
            try {
                configFile.createNewFile();

                FileOutputStream fos = new FileOutputStream(configFile);
                XmlSerializer serializer = Xml.newSerializer();
                serializer.setOutput(fos, "UTF-8");
                serializer.startDocument(null, Boolean.valueOf(true));
                serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);

                serializer.startTag(null, configRoot);

                serializer.startTag(null, configParamIp);
                serializer.text(ip);
                serializer.endTag(null, configParamIp);

                serializer.startTag(null, configParamUser);
                serializer.text(username);
                serializer.endTag(null, configParamUser);

                serializer.startTag(null, configParamPassword);
                byte[] key = Crypt.generateKey(Data.key);
                byte[] pwEncrypted = Crypt.encrypt(key, password.getBytes());

                String encryptedPw = Base64.encodeToString(pwEncrypted, Base64.DEFAULT);



                serializer.text(encryptedPw);
                serializer.endTag(null, configParamPassword);


                serializer.endDocument();
                serializer.flush();


                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }
}
