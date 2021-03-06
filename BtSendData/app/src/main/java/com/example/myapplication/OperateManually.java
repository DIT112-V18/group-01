package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.nio.charset.Charset;

import static com.example.myapplication.BluetoothConnectionService.write;

public class OperateManually extends AppCompatActivity {


    private static final String TAG = "OperateManually";
    private ImageButton upward_arrow;
    private ImageButton downward_arrow;
    private ImageButton left_arrow;
    private ImageButton right_arrow;
    private ImageButton stopbutton;
    private ImageButton returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operate_manually);


        upward_arrow = findViewById(R.id.arrows_UP);
        downward_arrow = findViewById(R.id.arrows_DOWN);
        left_arrow = findViewById(R.id.arrows_LEFT);
        right_arrow = findViewById(R.id.arrows_RIGHT);
        stopbutton = findViewById(R.id.stopButton);
        returnButton = findViewById(R.id.return_button);


        //setting try catch statements in each function so the app doesnt crash when button if disconnected
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OperateManually.this, UserOptions.class);
                startActivity(intent);

                try {
                    String exitManualControl = "v";
                    byte[] bytes = exitManualControl.getBytes(Charset.defaultCharset());
                    write(bytes);
                } catch (Exception e) {
                    Log.d(TAG, "Not connected by bluetooth");
                }

            }
        });


        downward_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String driveBackwards = "s";
                    byte[] bytes = driveBackwards.getBytes(Charset.defaultCharset());
                    write(bytes);
                } catch (Exception e) {
                    toastMessage("Reconnect bluetooth");
                }
            }
        });


        upward_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String driveForward = "w";
                    byte[] bytes = driveForward.getBytes(Charset.defaultCharset());
                    write(bytes);
                } catch (Exception e) {
                    toastMessage("Reconnect bluetooth");
                }

            }
        });


        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String driveLeft = "a";
                    byte[] bytes = driveLeft.getBytes(Charset.defaultCharset());
                    write(bytes);
                } catch (Exception e) {
                    toastMessage("Reconnect bluetooth");
                }
            }
        });


        right_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String driveRight = "d";
                    byte[] bytes = driveRight.getBytes(Charset.defaultCharset());
                    write(bytes);
                } catch (Exception e) {
                    toastMessage("Reconnect bluetooth");
                }
            }
        });

        stopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String stop = "x";
                    byte[] bytes = stop.getBytes(Charset.defaultCharset());
                    write(bytes);
                } catch (Exception e) {
                    toastMessage("Reconnect bluetooth");
                }
            }
        });

    }

    //for readability , call this method in methods to avoid passing three arguments each time (just one String message instead)
    public void toastMessage(String message) {
        Toast.makeText(OperateManually.this, message, Toast.LENGTH_SHORT).show();
    }
}
