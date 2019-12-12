package com.example.handwritinggenerator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ImageView myImage;
    private Button button;
    private Button saved_fonts;

    // james' comment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImage = (ImageView) findViewById(R.id.myImage);
        button = (Button) findViewById(R.id.button);
        saved_fonts = (Button) findViewById(R.id.saved_fonts);
        saved_fonts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saved_fonts();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });
    }

    private void takePicture() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,0);
    }

    private void characters() {
        setContentView(R.layout.loading_bar_screen);
        final ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);

        ObjectAnimator.ofInt(progress, "progress", 100)
                .setDuration(3000)
                .start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will load the fonts page after the loading bar. */
                setContentView(R.layout.loading);
                Button back = (Button) findViewById(R.id.back_share);
                Button share = (Button) findViewById(R.id.share);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        saved_fonts();
                    }
                });
                share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        share();
                    }
                });

            }
        }, 4000);

    }

    private void share() {
        setContentView(R.layout.share);
        Button back_share = (Button) findViewById(R.id.back_share);
        back_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                characters();
            }
        });
    }
    private void saved_fonts() {
        setContentView(R.layout.saved_fonts);
        Button font1 = (Button) findViewById(R.id.font1);
        font1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                characters();
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        setContentView(R.layout.loading_bar_screen);

        final ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);

        ObjectAnimator.ofInt(progress, "progress", 100)
                        .setDuration(3000)
                        .start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will load the fonts page after the loading bar. */
                setContentView(R.layout.loading);

            }
        }, 4000);

    }


}
