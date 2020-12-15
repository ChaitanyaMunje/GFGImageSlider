package com.gtappdevelopers.autoimageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    //creating a variable for PDF view.
    PDFView pdfView;
    //url of our PDF file.
    String pdfurl="https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing our pdf view.
        pdfView = findViewById(R.id.idPDFView);
        new RetrivePDFfromUrl().execute(pdfurl);

    }

    //create an async task class for loading pdf file from URL.
    class RetrivePDFfromUrl extends AsyncTask<String, Void, InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            //we are using inputstream for getting out PDF.
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                // below is the step where we are creating our connection.
                HttpURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    //response is success.
                    //we are getting input stream from url and storing it in our variable.
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());

                }

            } catch (IOException e) {
                //this is the method to handle errors.
                e.printStackTrace();
                return null;
            }

            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            // after the execution of our async task we are loading our pdf in our pdf view.
            pdfView.fromStream(inputStream).load();

        }
    }

}