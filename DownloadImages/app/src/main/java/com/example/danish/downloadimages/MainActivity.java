package com.example.danish.downloadimages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    ImageView downloadingImage;
    public class ImageDownloader extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream inputSteam = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(inputSteam);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void downloadImage(View view){
        //https://vignette.wikia.nocookie.net/kingdomhearts/images/e/ef/Sora_KHIII.png/revision/latest?cb=20170720150326

        ImageDownloader task = new ImageDownloader();
        Bitmap myImage;
        try {
            myImage = task.execute("https://vignette.wikia.nocookie.net/kingdomhearts/images/e/ef/Sora_KHIII.png/revision/latest?cb=20170720150326").get();
            downloadingImage.setImageBitmap(myImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("Interaction", "Button has been tapped ");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadingImage = (ImageView)findViewById(R.id.imageView);
    }
}
