package com.coderefer.androidsplashscreenexample;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.support.v7.internal.widget.AppCompatPopupWindow;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class Manual extends ActionBarActivity {
    private RadioGroup rg;
    private static final String TAG="com.codechefamit";
    private static int col= Color.BLUE;
    private static int face=1;
    public static Cube cube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cube=new Cube();
        final String[] facesList={"Blue","Red","Green","Orange","Yellow","White"};



        cube.saveCubeState(Camera_Input.cc);


        final ListView prevList=(ListView)findViewById(R.id.prevList);
        ListAdapter faceAdapt=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,facesList);
        prevList.setAdapter(faceAdapt);

       prevList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Button prevML=(Button)findViewById(R.id.prevML);
               Button prevMM=(Button)findViewById(R.id.prevMM);
               Button prevMR=(Button)findViewById(R.id.prevMR);
               Button prevTL=(Button)findViewById(R.id.prevTL);
               Button prevTM=(Button)findViewById(R.id.prevTM);
               Button prevTR=(Button)findViewById(R.id.prevTR);
               Button prevBL=(Button)findViewById(R.id.prevBL);
               Button prevBM=(Button)findViewById(R.id.prevBM);
               Button prevBR=(Button)findViewById(R.id.prevBR);

               Face f=new Face();
               switch (position+1){
                   case 1:
                       f=cube.blue;
                       break;
                   case 2:
                       f=cube.red;
                       break;
                   case 3:
                       f=cube.green;
                       break;
                   case 4:
                       f=cube.orange;
                       break;
                   case 5:
                       f=cube.yellow;
                       break;
                   case 6:
                       f=cube.white;
                       break;
               }
               prevML.setBackgroundColor(intToColor(f.ml));
               prevMM.setBackgroundColor(intToColor(f.mm));
               prevMR.setBackgroundColor(intToColor(f.mr));
               prevTL.setBackgroundColor(intToColor(f.tl));
               prevTM.setBackgroundColor(intToColor(f.tm));
               prevTR.setBackgroundColor(intToColor(f.tr));
               prevBL.setBackgroundColor(intToColor(f.bl));
               prevBM.setBackgroundColor(intToColor(f.bm));
               prevBR.setBackgroundColor(intToColor(f.br));
           }
       });

        rg=(RadioGroup)findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                char ch = rb.getText().toString().charAt(0);
                switch (ch) {
                    case 'B':
                        col = Color.BLUE;
                        break;
                    case 'R':
                        col = Color.RED;
                        break;
                    case 'G':
                        col = Color.GREEN;
                        break;
                    case 'O':
                        col=Color.rgb(255,140,0);
                        break;
                    case 'Y':
                        col = Color.YELLOW;
                        break;
                    case 'W':
                        col = Color.WHITE;

                        break;
                    default:
                        Toast.makeText(Manual.this, "Error in picking color", Toast.LENGTH_SHORT).show();
                }
            }
        });

         final Button btnTL=(Button)findViewById(R.id.btnTL);
         final Button btnBL=(Button)findViewById(R.id.btnBL);
         final Button btnML=(Button)findViewById(R.id.btnML);
         final Button btnTR=(Button)findViewById(R.id.btnTR);
         final Button btnTM=(Button)findViewById(R.id.btnTM);
         final Button btnMR=(Button)findViewById(R.id.btnMR);
         final Button btnBR=(Button)findViewById(R.id.btnBR);
         final Button btnBM=(Button)findViewById(R.id.btnBM);
         final Button btnSave=(Button)findViewById(R.id.btnSave);

        btnSave.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (face){
                    case 1:
                        cube.blue.mm=1;
                        cube.blue.tl=buttonToInt(btnTL);
                        cube.blue.tr=buttonToInt(btnTR);
                        cube.blue.tm=buttonToInt(btnTM);
                        cube.blue.ml=buttonToInt(btnML);
                        cube.blue.mr=buttonToInt(btnMR);
                        cube.blue.bl=buttonToInt(btnBL);
                        cube.blue.bm=buttonToInt(btnBM);
                        cube.blue.br=buttonToInt(btnBR);
                        break;
                    case 2:
                        cube.red.mm=2;
                        cube.red.tl=buttonToInt(btnTL);
                        cube.red.tr=buttonToInt(btnTR);
                        cube.red.tm=buttonToInt(btnTM);
                        cube.red.ml=buttonToInt(btnML);
                        cube.red.mr=buttonToInt(btnMR);
                        cube.red.bl=buttonToInt(btnBL);
                        cube.red.bm=buttonToInt(btnBM);
                        cube.red.br=buttonToInt(btnBR);
                        break;
                    case 3:
                        cube.green.mm=3;
                        cube.green.tl=buttonToInt(btnTL);
                        cube.green.tr=buttonToInt(btnTR);
                        cube.green.tm=buttonToInt(btnTM);
                        cube.green.ml=buttonToInt(btnML);
                        cube.green.mr=buttonToInt(btnMR);
                        cube.green.bl=buttonToInt(btnBL);
                        cube.green.bm=buttonToInt(btnBM);
                        cube.green.br=buttonToInt(btnBR);
                        break;
                    case 4:
                        cube.orange.mm=4;
                        cube.orange.tl=buttonToInt(btnTL);
                        cube.orange.tr=buttonToInt(btnTR);
                        cube.orange.tm=buttonToInt(btnTM);
                        cube.orange.ml=buttonToInt(btnML);
                        cube.orange.mr=buttonToInt(btnMR);
                        cube.orange.bl=buttonToInt(btnBL);
                        cube.orange.bm=buttonToInt(btnBM);
                        cube.orange.br=buttonToInt(btnBR);
                        break;
                    case 5:
                        cube.yellow.mm=5;
                        cube.yellow.tl=buttonToInt(btnTL);
                        cube.yellow.tr=buttonToInt(btnTR);
                        cube.yellow.tm=buttonToInt(btnTM);
                        cube.yellow.ml=buttonToInt(btnML);
                        cube.yellow.mr=buttonToInt(btnMR);
                        cube.yellow.bl=buttonToInt(btnBL);
                        cube.yellow.bm=buttonToInt(btnBM);
                        cube.yellow.br=buttonToInt(btnBR);
                        break;
                    case 6:
                        cube.white.mm=6;
                        cube.white.tl=buttonToInt(btnTL);
                        cube.white.tr=buttonToInt(btnTR);
                        cube.white.tm=buttonToInt(btnTM);
                        cube.white.ml=buttonToInt(btnML);
                        cube.white.mr=buttonToInt(btnMR);
                        cube.white.bl=buttonToInt(btnBL);
                        cube.white.bm=buttonToInt(btnBM);
                        cube.white.br=buttonToInt(btnBR);
                        break;
                }
                Toast.makeText(Manual.this,"Face Saved",Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        btnBL.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                changeColor(btnBL);
                return true;
            }
        });
        btnBR.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                changeColor(btnBR);
                return true;
            }
        });
        btnBM.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                changeColor(btnBM);
                return true;
            }
        });
        btnTR.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                changeColor(btnTR);
                return true;
            }
        });
        btnTM.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                changeColor(btnTM);
                return true;
            }
        });
        btnTL.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                changeColor(btnTL);
                return true;
            }
        });
        btnMR.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                changeColor(btnMR);
                return true;
            }
        });
        btnML.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                changeColor(btnML);
                return true;
            }
        });
    }


    public void nextFace(View v){
        TextView textIns=(TextView)findViewById(R.id.textInstruction);
        Button btnMM=(Button)findViewById(R.id.btnMM);
        Button btnTL=(Button)findViewById(R.id.btnTL);
        Button btnBL=(Button)findViewById(R.id.btnBL);
        Button btnML=(Button)findViewById(R.id.btnML);
        Button btnTR=(Button)findViewById(R.id.btnTR);
        Button btnTM=(Button)findViewById(R.id.btnTM);
        Button btnMR=(Button)findViewById(R.id.btnMR);
        Button btnBR=(Button)findViewById(R.id.btnBR);
        Button btnBM=(Button)findViewById(R.id.btnBM);


        btnTL.setBackgroundColor(Color.BLACK);
        btnTM.setBackgroundColor(Color.BLACK);
        btnTR.setBackgroundColor(Color.BLACK);
        btnML.setBackgroundColor(Color.BLACK);
        btnMR.setBackgroundColor(Color.BLACK);
        btnBL.setBackgroundColor(Color.BLACK);
        btnBM.setBackgroundColor(Color.BLACK);
        btnBR.setBackgroundColor(Color.BLACK);
            switch (face) {
                case 1:
                    btnMM.setBackgroundColor(Color.RED);
                    face++;
                    textIns.setText(R.string.keepyellow);
                    textIns.setBackgroundColor(Color.YELLOW);
                    textIns.setTextColor(Color.BLACK);
                    break;
                case 2:
                    btnMM.setBackgroundColor(Color.GREEN);
                    face++;
                    textIns.setText(R.string.keepyellow);
                    textIns.setBackgroundColor(Color.YELLOW);
                    textIns.setTextColor(Color.BLACK);
                    break;
                case 3:
                    btnMM.setBackgroundColor(Color.rgb(255, 140, 0));
                    face++;
                    textIns.setText(R.string.keepyellow);
                    textIns.setBackgroundColor(Color.YELLOW);
                    textIns.setTextColor(Color.BLACK);
                    break;
                case 4:
                    btnMM.setBackgroundColor(Color.YELLOW);
                    face++;
                    textIns.setText(R.string.keepgreen);
                    textIns.setBackgroundColor(Color.GREEN);
                    textIns.setTextColor(Color.BLACK);
                    break;
                case 5:
                    btnMM.setBackgroundColor(Color.WHITE);
                    face++;
                    textIns.setText(R.string.keepblue);
                    textIns.setBackgroundColor(Color.BLUE);
                    textIns.setTextColor(Color.WHITE);
                    break;
                case 6:
                    btnMM.setBackgroundColor(Color.BLUE);
                    face = 1;
                    textIns.setText(R.string.keepyellow);
                    textIns.setBackgroundColor(Color.YELLOW);
                    textIns.setTextColor(Color.BLACK);
                    break;
            }
    }

    public int buttonToInt(Button btn){
        ColorDrawable cd=(ColorDrawable)btn.getBackground();
        int color=cd.getColor();
        int r;
        switch (color){
            case Color.BLUE:
                r=1;
                break;
            case Color.RED:
                r=2;
                break;
            case Color.GREEN:
                r=3;
                break;
            case Color.YELLOW:
                r=5;
                break;
            case Color.WHITE:
                r=6;
                break;
            default:
                r=4;
        }
        return r;
    }

    public int intToColor(int d){
        int col;
        switch (d){
            case 1:
                col=Color.BLUE;
                break;
            case 2:
                col=Color.RED;
                break;
            case 3:
                col=Color.GREEN;
                break;
            case 4:
                col=Color.rgb(255,140,0);
                break;
            case 5:
                col=Color.YELLOW;
                break;
            case 6:
                col=Color.WHITE;
                break;
            default:
                col=Color.BLACK;
        }
        return col;
    }



    public void solveCube(View view) {
        if (cube.validation()) {
            Intent i = new Intent(this, SolveActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(this,"Cube is not valid",Toast.LENGTH_SHORT).show();

        }
    }

    public void changeColor(Button btn){
        btn.setBackgroundColor(col);
    }

}
