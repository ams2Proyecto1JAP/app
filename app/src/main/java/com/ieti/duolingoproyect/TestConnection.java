package com.ieti.duolingoproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.ieti.duolingoproyect.connection.InterfaceRMI;
import java.io.IOException;
import lipermi.handler.CallHandler;
import lipermi.net.Client;

/**
 * Clases de prueba para testear conexion no tocar ni usar
 */
public class TestConnection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_connection);
        Toast.makeText(TestConnection.this, "probando", Toast.LENGTH_SHORT).show();
        new TestClient().execute();
        Toast.makeText(TestConnection.this, TestData.testData, Toast.LENGTH_LONG).show();
    }
}

class TestClient extends AsyncTask<Void,Void, TestConnection>{

    @Override
    protected TestConnection doInBackground(Void... params) {
        try{
            CallHandler callHandler = new CallHandler();
            Client client = new Client("192.168.1.15", 7777, callHandler);
            InterfaceRMI interfaceRMI = (InterfaceRMI) client.getGlobal(InterfaceRMI.class);
            String resultRequest = interfaceRMI.sayHi();
            TestData.testData = resultRequest;
            client.close();
        } catch (IOException e){

        }
        return null;
    }
}
