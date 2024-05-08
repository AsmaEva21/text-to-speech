//package com.asmaeva.assignment_texttospeech;

/*import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech t1, t2, t3;
    TextView tx1, tx2, tx3;
    Button b1, b2, b3;
    SeekBar seekBar;

    Button s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx1 = findViewById(R.id.textView4);
        b1 = findViewById(R.id.button3);
        s1 = findViewById(R.id.stopbutton);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = tx1.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();

                // Stop
                if (t2 != null && t2.isSpeaking()) {
                    t2.stop();
                }
                if (t3 != null && t3.isSpeaking()) {
                    t3.stop();
                }

                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);


                String data = tx1.getText().toString();

                float speed = (float) seekBar.getProgress() / 50 ;
                if (speed < 0.1) speed = 0.1f;
                t1.setSpeechRate(speed);
                t1.speak(data,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t1.isSpeaking()){
                    t1.stop();
                } else {
                    Toast.makeText(MainActivity.this,"not speaking",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tx2 = findViewById(R.id.textView);
        b2 = findViewById(R.id.button2);
        seekBar = findViewById(R.id.seekBar);

        t2 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t2.setLanguage(Locale.UK);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = tx2.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();

                // Stop
                if (t1 != null && t1.isSpeaking()) {
                    t1.stop();
                }
                if (t3 != null && t3.isSpeaking()) {
                    t3.stop();
                }

                t2.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        tx3 = findViewById(R.id.textView2);
        b3 = findViewById(R.id.button1);

        t3 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t3.setLanguage(Locale.UK);
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = tx3.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();

                // Stop
                if (t1 != null && t1.isSpeaking()) {
                    t1.stop();
                }
                if (t2 != null && t2.isSpeaking()) {
                    t2.stop();
                }

                t3.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    public void onPause ()
    {
        if (t1 != null) {
            t1.stop();
            //t1.shutdown();
        }

        if (t2 != null) {
            t2.stop();
            //t2.shutdown();
        }
        if (t3 != null) {
            t3.stop();
            // t3.shutdown();
        }
        super.onPause();
    }
}*/

package com.asmaeva.assignment_texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech t1, t2, t3;
    TextView tx1, tx2, tx3;
    Button b1, b2, b3;
    Button s1, s2, s3;
    SeekBar seekBar1, seekBar2, seekBar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize TextViews
        tx1 = findViewById(R.id.textView4);
        tx2 = findViewById(R.id.textView1);
        tx3 = findViewById(R.id.textView2);

        // Initialize Buttons
        b1 = findViewById(R.id.button3);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button1);

        // Initialize Stop Buttons
        s1 = findViewById(R.id.stopbutton);
        s2 = findViewById(R.id.stopbutton2);
        s3 = findViewById(R.id.stopbutton3);

        // Initialize SeekBars
        seekBar1 = findViewById(R.id.seekBar);
        seekBar2 = findViewById(R.id.seekBar2);
        seekBar3 = findViewById(R.id.seekBar3);

        // Initialize TextToSpeech objects
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = t1.setLanguage(Locale.getDefault());
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(MainActivity.this, "Language not supported", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Initialization failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        t2 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = t2.setLanguage(Locale.getDefault());
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(MainActivity.this, "Language not supported", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Initialization failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        t3 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = t3.setLanguage(Locale.getDefault());
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(MainActivity.this, "Language not supported", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Initialization failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set onClickListeners for buttons
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tx1.getText().toString();
                speakText(text, t1, seekBar1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tx3.getText().toString();
                speakText(text, t3, seekBar2);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tx2.getText().toString();
                speakText(text, t2, seekBar3);
            }
        });

        // Set onClickListeners for stop buttons
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSpeaking(t1);
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSpeaking(t3);
            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSpeaking(t2);
            }
        });

        // Set OnSeekBarChangeListener for seekbars
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float speed = (float) progress / 50;
                if (speed < 0.1) speed = 0.1f;
                t1.setSpeechRate(speed);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float speed = (float) progress / 50;
                if (speed < 0.1) speed = 0.1f;
                t2.setSpeechRate(speed);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float speed = (float) progress / 50;
                if (speed < 0.1) speed = 0.1f;
                t3.setSpeechRate(speed);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void speakText(String text, TextToSpeech textToSpeech, SeekBar seekBar) {
        float speed = (float) seekBar.getProgress() / 50;
        if (speed < 0.1) speed = 0.1f;
        textToSpeech.setSpeechRate(speed);
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    private void stopSpeaking(TextToSpeech textToSpeech) {
        if (textToSpeech != null && textToSpeech.isSpeaking()) {
            textToSpeech.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (t1 != null) {
            t1.stop();
            t1.shutdown();
        }
        if (t2 != null) {
            t2.stop();
            t2.shutdown();
        }
        if (t3 != null) {
            t3.stop();
            t3.shutdown();
        }
    }
}