package com.example.lmlopez.memoriaexterna;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!compruebaMemoria())
            Toast.makeText(this, "Memoria no disponible", Toast.LENGTH_SHORT).show();
        else {
            //File root = Environment.getExternalStorageDirectory();
            File root = Environment.getRootDirectory();
            Toast.makeText(this, root.getAbsolutePath(), Toast.LENGTH_LONG).show();
            Log.i("EMR", root.getAbsolutePath());

            for(File fileName : root.listFiles()){
                Log.i("LIST", fileName.isDirectory() ? "/" + fileName.getName() : fileName.getName());
            }

            /*File documentsDir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);

            File fichero = new File(documentsDir, "texto.txt");

            PrintWriter writer = null;

            try {
                writer = new PrintWriter(new FileWriter(fichero));

                writer.println("Hola Mundo");
                Toast.makeText(this, "Fichero de texto creado", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (writer != null)
                    writer.close();
            }
*/
        }


    }

    public static boolean compruebaMemoria() {
        boolean sdDisponible = false;
        boolean sdAccesoEscritura = false;

        //Comprobamos el estado de la memoria externa (tarjeta SD)
        String estado = Environment.getExternalStorageState();

        if (estado.equals(Environment.MEDIA_MOUNTED))
        {
            sdDisponible = true;
            sdAccesoEscritura = true;
        }
        else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
        {
            sdDisponible = true;
            sdAccesoEscritura = false;
        }
        else
        {
            sdDisponible = false;
            sdAccesoEscritura = false;
        }

        return sdDisponible && sdAccesoEscritura;
    }
}
