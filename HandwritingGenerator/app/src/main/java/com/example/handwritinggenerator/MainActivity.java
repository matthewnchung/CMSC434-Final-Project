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
        mainScreen();

    }

    private void mainScreen() {
        setContentView(R.layout.activity_main);
        myImage = (ImageView) findViewById(R.id.myImage);
        button = (Button) findViewById(R.id.button);
        saved_fonts = (Button) findViewById(R.id.saved_fonts);
        Button profile = (Button) findViewById(R.id.profile);
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
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile();
            }
        });
    }
    private void takePicture() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,0);
    }

    private void characters() {

                setContentView(R.layout.loading);
                Button back = (Button) findViewById(R.id.back_share);
                Button edit = (Button) findViewById(R.id.bigone);
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
                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editChar();
                    }
                });


    }

    private void editChar() {
        setContentView(R.layout.editchar);
        Button retake = (Button) findViewById(R.id.retake);
        Button upload = (Button) findViewById(R.id.upload);
        Button back_edit = (Button) findViewById(R.id.back_edit);
        retake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i);
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainScreen();
            }
        });
        back_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                characters();
            }
        });


    }

    private void profile() {
        setContentView(R.layout.profile);
        Button back_profile = (Button) findViewById(R.id.back_profile);
        back_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainScreen();
            }
        });
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
        Button back_saved_fonts = (Button) findViewById(R.id.back_saved_fonts);
        font1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                characters();
            }
        });
        back_saved_fonts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainScreen();            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        setContentView(R.layout.loading_bar_screen);

        final ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);

        ObjectAnimator.ofInt(progress, "progress", 100)
                        .setDuration(1000)
                        .start();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                characters();
            }},1000);

    }


}
