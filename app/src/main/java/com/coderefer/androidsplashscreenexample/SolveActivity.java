package com.coderefer.androidsplashscreenexample;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class SolveActivity extends ActionBarActivity {

    private String[] ph1r,ph2r,ph3r,ph4r,ph5r,ph6r,ph7r;
    private Cube state1,state2,state3,state4,state5,state6,state7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve);

        TextView descText=(TextView)findViewById(R.id.descText);
        descText.setText("This phase will give a white cross on bottom of cube.");

        Cube c=Manual.cube;
        ph1r=ph2r=ph3r=ph4r=ph5r=ph6r=ph7r=null;
        setTitle("Solve Cube");

        final ListView steps=(ListView)findViewById(R.id.steps);
        steps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView imgView=(ImageView)findViewById(R.id.imgView);
                String si=String.valueOf(parent.getItemAtPosition(position));
                if(si.contains("Anti")){
                    if(si.contains("Left"))
                        imgView.setImageResource(R.drawable.al);
                    else if(si.contains("Right"))
                        imgView.setImageResource(R.drawable.ar);
                    else if(si.contains("Up"))
                        imgView.setImageResource(R.drawable.au);
                    else if(si.contains("Front"))
                        imgView.setImageResource(R.drawable.af);
                    else
                        imgView.setImageResource(R.drawable.ab);
                }
                else{
                    if(si.contains("Left"))
                        imgView.setImageResource(R.drawable.l);
                    else if(si.contains("Right"))
                        imgView.setImageResource(R.drawable.r);
                    else if(si.contains("Up"))
                        imgView.setImageResource(R.drawable.u);
                    else if(si.contains("Front"))
                        imgView.setImageResource(R.drawable.f);
                    else
                        imgView.setImageResource(R.drawable.b);
                }
            }
        });




        final String phases[]={"White Cross","White Corners","Edges","Yellow Cross","Yellow Corners","Correcting Corners","Complete Cube"};
        ListAdapter phaseAdapt=new ArrayAdapter<String >(this,android.R.layout.simple_list_item_1,phases);
        ListView elv=(ListView)findViewById(R.id.phases);
        elv.setAdapter(phaseAdapt);

        ArrayList<String> list=new ArrayList<String>();

        c.index=0;
        c.phase1();
        state1=new Cube();
        state1.saveCubeState(c);
        for(int i=0;i<c.index;i++) {
            if(!c.rotation[i].equals(""))
                list.add(c.rotation[i]);
        }
        ph1r=list.toArray(new String[list.size()]);

        list=new ArrayList<String>();
        c.index=0;
        c.phase2();
        state2=new Cube();
        state2.saveCubeState(c);
        for(int i=0;i<c.index;i++) {
            if(!c.rotation[i].equals(""))
                list.add(c.rotation[i]);
        }
        ph2r=list.toArray(new String[list.size()]);

        list=new ArrayList<String>();
        c.index=0;
        c.phase3();
        state3=new Cube();
        state3.saveCubeState(c);
        for(int i=0;i<c.index;i++) {
            if(!c.rotation[i].equals(""))
                list.add(c.rotation[i]);
        }
        ph3r=list.toArray(new String[list.size()]);

        list=new ArrayList<String>();
        c.index=0;
        c.phase4();
        state4=new Cube();
        state4.saveCubeState(c);
        for(int i=0;i<c.index;i++) {
            if(!c.rotation[i].equals(""))
                list.add(c.rotation[i]);
        }
        ph4r=list.toArray(new String[list.size()]);


        list=new ArrayList<String>();
        c.index=0;
        c.phase5();
        state5=new Cube();
        state5.saveCubeState(c);
        for(int i=0;i<c.index;i++) {
            if(!c.rotation[i].equals(""))
                list.add(c.rotation[i]);
        }
        ph5r=list.toArray(new String[list.size()]);


        list=new ArrayList<String>();
        c.index=0;
        c.phase6();
        state6=new Cube();
        state6.saveCubeState(c);
        for(int i=0;i<c.index;i++) {
            if(!c.rotation[i].equals(""))
                list.add(c.rotation[i]);
        }
        ph6r=list.toArray(new String[list.size()]);


        list=new ArrayList<String>();
        c.index=0;
        c.phase7();
        state7=new Cube();
        state7.saveCubeState(c);
        for(int i=0;i<c.index;i++) {
            if(!c.rotation[i].equals(""))
                list.add(c.rotation[i]);
        }
        ph7r=list.toArray(new String[list.size()]);


        steps.setAdapter(new ArrayAdapter<String>(SolveActivity.this,android.R.layout.simple_list_item_1,ph1r));

        elv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView descText=(TextView)findViewById(R.id.descText);
                String phase=String.valueOf(parent.getItemAtPosition(position));
                ListAdapter stepAdapt;
                ImageView imgDesc=(ImageView)findViewById(R.id.imgDesc);
                switch (phase){
                    case "White Cross":
                        stepAdapt=new ArrayAdapter<String>(SolveActivity.this,android.R.layout.simple_list_item_1,ph1r);
                        steps.setAdapter(stepAdapt);
                        descText.setText("This phase will give a white cross on bottom of cube.");
                        imgDesc.setImageResource(R.drawable.cross);
                        break;
                    case "White Corners":
                        stepAdapt=new ArrayAdapter<String>(SolveActivity.this,android.R.layout.simple_list_item_1,ph2r);
                        steps.setAdapter(stepAdapt);
                        descText.setText("This phase will get white corners to their correct position.");
                        imgDesc.setImageResource(R.drawable.corners);
                        break;
                    case "Edges":
                        stepAdapt=new ArrayAdapter<String>(SolveActivity.this,android.R.layout.simple_list_item_1,ph3r);
                        steps.setAdapter(stepAdapt);
                        descText.setText("This phase will get edges to their correct position.");
                        imgDesc.setImageResource(R.drawable.edges);
                        break;
                    case "Yellow Cross":
                        stepAdapt=new ArrayAdapter<String>(SolveActivity.this,android.R.layout.simple_list_item_1,ph4r);
                        steps.setAdapter(stepAdapt);
                        descText.setText("This phase will give a yellow cross on the top of cube.");
                        imgDesc.setImageResource(R.drawable.ycross);
                        break;
                    case "Yellow Corners":
                        stepAdapt=new ArrayAdapter<String>(SolveActivity.this,android.R.layout.simple_list_item_1,ph5r);
                        steps.setAdapter(stepAdapt);
                        descText.setText("This phase will get yellow corners to the top.");
                        imgDesc.setImageResource(R.drawable.ycross);
                        break;
                    case "Correcting Corners":
                        stepAdapt=new ArrayAdapter<String>(SolveActivity.this,android.R.layout.simple_list_item_1,ph6r);
                        steps.setAdapter(stepAdapt);
                        descText.setText("This phase will get yellow corners to thir correct position.");
                        imgDesc.setImageResource(R.drawable.correct);
                        break;
                    case "Complete Cube":
                        stepAdapt=new ArrayAdapter<String>(SolveActivity.this,android.R.layout.simple_list_item_1,ph7r);
                        steps.setAdapter(stepAdapt);
                        descText.setText("This phase will complete the cube.");
                        imgDesc.setImageResource(R.drawable.complete);
                        break;
                }
            }
        });


        TextView textMoves=(TextView)findViewById(R.id.textMoves);
        textMoves.setText("Total Moves : "+c.moves);

    }

}
