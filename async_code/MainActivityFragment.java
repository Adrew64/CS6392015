package com.example.adrew.asynctaskproject;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;

//import test!!


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ImageView downloadedImage;
    private ProgressDialog simpleWaitDialog;
    private String downloadUrl = "http://www.vosizneias.com/wp-content/uploads/2010/04/Teaneck.jpg";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);

        Button imageDownloaderButton=(Button)findViewById(R.id.downloadButton);
        downloadedImage=(ImageView)findViewById(R.id.imageView);

        //take out view and just make it an .onclicklistener?.
        imageDownloaderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ImageDownloader().execute(downloadUrl);
            }
        });
    }

    private class ImageDownloader extends AsyncTask<String, Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(String...params){
            return downloadBitmap(params[0]);
        }

        protected void onPreExecute(Bitmap result){
            downloadedImage.setImageBitmap(result);
            simpleWaitDialog.dismiss();
        }

        private Bitmap downloadBitmap(String url){
            final DefaultHttpClient client = new DefaultHttpClient();

            final HttpGet getRequest = new HttpGet(url);
            try{
                HttpResponse response = client.execute(getRequest);
                final int statusCode = response.getStatusLine().getStatusCode();
                if(statusCode != HttpStatus.SC_OK){
                    return null;
                }
                final HttpEntity entity = response.getEntity();
                if(entity != null){
                    InputStream inputStream=null;

                    try{
                        InputStream = entity.getContent();
                        final Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                        return bitmap;
                    }finally {
                        if (inputStream != null){
                            inputStream.close();
                        }
                        entity.consumeContent();
                    }
                }
            }catch (Exception e){
                getRequest.abort();
            }
            return null;
        }
    }

}