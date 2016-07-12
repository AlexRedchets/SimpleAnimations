package com.example.azvk.simpleanimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ViewGroup viewGroup;
    boolean positionCheck = false;
    boolean sizeCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewGroup = (ViewGroup)findViewById(R.id.activity_main);

        viewGroup.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                moveButton();
                return false;
            }
        });
    }

    public void moveButton() {
        Button button = (Button) findViewById(R.id.button);

        TransitionManager.beginDelayedTransition(viewGroup);

        //change the button position
        RelativeLayout.LayoutParams  positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        if (positionCheck){
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            positionCheck = false;
        }
        else{
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            positionCheck = true;
        }
        button.setLayoutParams(positionRules);

        //change the button size
        ViewGroup.LayoutParams sizeRules = button.getLayoutParams();
        if (sizeCheck){
            sizeRules.width = 250;
            sizeRules.height = 150;
            sizeCheck = false;
        }
        else {
            sizeRules.width = 400;
            sizeRules.height = 300;
            sizeCheck = true;
        }
        button.setLayoutParams(sizeRules);


    }
}
