package com.coderefer.androidsplashscreenexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Pegasus on 19-03-2016.
 */
public class Camera_Input extends Activity {
    ImageView viewImage;
    Button b;
    int count = 0;
    public static  Cube cc=new Cube();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_input);
        b = (Button) findViewById(R.id.btnSelectPhoto);
        viewImage = (ImageView) findViewById(R.id.viewImage);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("The count is kkkjjkkgggugkgujkj   " +count);
               // for (int i = 0; i < 6; i++) {
                    dispatchTakePictureIntent();
                    System.out.println("The count is kkkjloooooooooopj   " + count);
                //}


            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds options to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void Image() {

        Log.d("TAG","inside image()");

        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(Camera_Input.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File f = new File(Environment.getExternalStorageDirectory(), "temp.jpg");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent, 1);
                } else if (options[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);

                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

  /*  @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();

                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),
                            bitmapOptions);
Log.d("tag","The msg " );
                    viewImage.setImageBitmap(bitmap);
Log.d("tag","themsg after ") ;

                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == 2) {
                String dir = Environment.getExternalStorageDirectory().getAbsolutePath();
                Uri selectedImage = data.getData();
                String[] filePath = { MediaStore.Images.Media.DATA };
                Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
               // Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                Log.w("path of image from gallery......******************.........", picturePath + "");
                viewImage.setImageBitmap(loadImage(picturePath));
              //  LinearLayout rl = (LinearLayout) findViewById(R.id.viewImage);
                //rl.addView(viewImage);
                Log.w("path of image from gallery......******************.........", picturePath + "");
            }
        }
    }

    private Bitmap loadImage(String imgPath) {
        BitmapFactory.Options options;
        try {
            options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bitmap = BitmapFactory.decodeFile(imgPath, options);
            return bitmap;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
*/

    /*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1 && null != data) {
            decodeUri(data.getData());
        }
    }

    */
    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            System.out.println("The count isffffffffffffffffffffff   " + count);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //viewImage.setImageBitmap(imageBitmap);
            process_image(imageBitmap);
            System.out.println("The count is kkkjjkkjkj   " +count);
            if(count==6){

                nextActivity();
                Log.d("TAg", "after next activity");
            }
        }
    }
public void nextActivity() {
    Intent intent = new Intent(Camera_Input.this, Manual.class);
    startActivity(intent);
}

public void process_image(Bitmap imagebitmap){
    count++;
System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    int c1 = imagebitmap.getPixel(imagebitmap.getWidth() / 4, imagebitmap.getHeight() / 4);
    int c2 = imagebitmap.getPixel(imagebitmap.getWidth() / 2, imagebitmap.getHeight() / 4);
    int c3 = imagebitmap.getPixel(3*imagebitmap.getWidth() / 4, imagebitmap.getHeight() / 4);
    int c4 = imagebitmap.getPixel(imagebitmap.getWidth() / 4, imagebitmap.getHeight() / 2);
    int c5 = imagebitmap.getPixel(3*imagebitmap.getWidth() / 4, imagebitmap.getHeight() / 2);
    int c6 = imagebitmap.getPixel(imagebitmap.getWidth() / 4, 3*imagebitmap.getHeight() / 4);
    int c7 = imagebitmap.getPixel(imagebitmap.getWidth() / 2, 3*imagebitmap.getHeight() / 4);
    int c8 = imagebitmap.getPixel(3*imagebitmap.getWidth() / 4, 3*imagebitmap.getHeight() / 4);

    if(c1<-16400000&&c1>-17000000)  c1=1;
    if(c1<-2500000&&c1>-5000000) c1=2;
    if(c1<-14500000&&c1>-16400000) c1=3;
    if(c1<-5800000&&c1>-9000000) c1=4;
    if(c1<-9000000&&c1>-13000000) c1=5;
    if(c1<-5000000&&c1>-5800000) c1=6;

    if(c2<-16400000&&c2>-17000000)  c2=1;
    if(c2<-2500000&&c2>-5000000) c2=2;
    if(c2<-14500000&&c2>-16400000) c2=3;
    if(c2<-5800000&&c2>-9000000) c2=4;
    if(c2<-9000000&&c2>-13000000) c2=5;
    if(c2<-5000000&&c2>-5800000) c2=6;

    if(c3<-16400000&&c3>-17000000)  c3=1;
    if(c3<-2500000&&c3>-5000000) c3=2;
    if(c3<-14500000&&c3>-16400000) c3=3;
    if(c3<-5800000&&c3>-9000000) c3=4;
    if(c3<-9000000&&c3>-13000000) c3=5;
    if(c3<-5000000&&c3>-5800000) c3=6;

    if(c4<-16400000&&c4>-17000000)  c4=1;
    if(c4<-2500000&&c4>-5000000) c4=2;
    if(c4<-14500000&&c4>-16400000) c4=3;
    if(c4<-5800000&&c4>-9000000) c4=4;
    if(c4<-9000000&&c4>-13000000) c4=5;
    if(c4<-5000000&&c4>-5800000) c4=6;

    if(c5<-16400000&&c5>-17000000)  c5=1;
    if(c5<-2500000&&c5>-5000000) c5=2;
    if(c5<-14500000&&c5>-16400000) c5=3;
    if(c5<-5800000&&c5>-9000000) c5=4;
    if(c5<-9000000&&c5>-13000000) c5=5;
    if(c5<-5000000&&c5>-5800000) c5=6;

    if(c6<-16400000&&c6>-17000000)  c6=1;
    if(c6<-2500000&&c6>-5000000) c6=2;
    if(c6<-14500000&&c6>-16400000) c6=3;
    if(c6<-5800000&&c6>-9000000) c6=4;
    if(c6<-9000000&&c6>-13000000) c6=5;
    if(c6<-5000000&&c6>-5800000) c6=6;

    if(c7<-16400000&&c7>-17000000)  c7=1;
    if(c7<-2500000&&c7>-5000000) c7=2;
    if(c7<-14500000&&c7>-16400000) c7=3;
    if(c7<-5800000&&c7>-9000000) c7=4;
    if(c7<-9000000&&c7>-13000000) c7=5;
    if(c7<-5000000&&c7>-5800000) c7=6;

    if(c8<-16400000&&c8>-17000000)  c8=1;
    if(c8<-2500000&&c8>-5000000) c8=2;
    if(c8<-14500000&&c8>-16400000) c8=3;
    if(c8<-5800000&&c8>-9000000) c8=4;
    if(c8<-9000000&&c8>-13000000) c8=5;
    if(c8<-5000000&&c8>-5800000) c8=6;


    System.out.println("COLORrrrrrrrrrrrrr   "+c1+"   "+c2+"  "+c3 +"   "+c4+"   "+c5+"  " +c6 +"   " +c7 + "    " +c8);
    switch(count) {

        case 1 : //Blue centred face
                //Top Left square
                switch (c1) {
                            case 1: //Blue
                                            cc.blue.tl = 1;
                                            break;
                            case 2 : //Red
                                            cc.blue.tl = 2;
                                            break;
                            case 3 : //Green
                                            cc.blue.tl = 3;
                                            break;
                            case 4: //Orange
                                    cc.blue.tl = 4;
                                    break;
                            case 5 : //Yellow
                                    cc.blue.tl = 5;
                                    break;
                            case 6: //White
                                    cc.blue.tl = 6;
                                    break;
                            default : //Black
                                        cc.blue.tl = 0;
                }
                //Top middle square
                switch (c2) {
                            case 1: //Blue
                                            cc.blue.tm = 1;
                                            break;
                            case 2 : //Red
                                            cc.blue.tm = 2;
                                            break;
                            case 3 : //Green
                                            cc.blue.tm = 3;
                                            break;
                            case 4: //Orange
                                        cc.blue.tm = 4;
                                            break;
                                case 5: //Yellow
                                            cc.blue.tm = 5;
                                                break;
                                case 6: //White
                                                    cc.blue.tm = 6;
                                                    break;
                                default : //Black
                                            cc.blue.tm = 0;
                }

                //Top Right Square
                switch (c3) {
                                case 1: //Blue
                                                    cc.blue.tr = 1;
                                                      break;
                                case 2 : //Red
                                                    cc.blue.tr = 2;
                                                        break;
                                case 3 : //Green
                                                    cc.blue.tr = 3;
                                                        break;
                                case 4: //Orange
                                                     cc.blue.tr = 4;
                                                         break;
                                case 5: //Yellow
                                                     cc.blue.tr = 5;
                                                        break;
                                case 6: //White
                                                    cc.blue.tr = 6;
                                                        break;
                                default : //Black
                                                    cc.blue.tr = 0;
                }

                //Middle Left square
                  switch (c4) {
                                case 1: //Blue
                                                    cc.blue.ml = 1;
                                                             break;
                                case 2 : //Red
                                                    cc.blue.ml = 2;
                                                      break;
                                case 3 : //Green
                                                    cc.blue.ml = 3;
                                                         break;
                                case 4: //Orange
                                                    cc.blue.ml = 4;
                                                      break;
                                case 5: //Yellow
                                                    cc.blue.ml = 5;
                                                        break;
                                case 6: //White
                                                    cc.blue.ml = 6;
                                                             break;
                                default : //Black
                                                     cc.blue.ml = 0;
                    }

            //Middle middle square is blue
                    cc.blue.mm = 1;

                //Middle Right square
                    switch (c5) {
                                    case 1: //Blue
                                                    cc.blue.mr = 1;
                                                         break;
                                    case 2 : //Red
                                                    cc.blue.mr = 2;
                                                              break;
                                    case 3 : //Green
                                                    cc.blue.mr = 3;
                                                    break;
                                    case 4: //Orange
                                                    cc.blue.mr = 4;
                                                         break;
                                    case 5: //Yellow
                                                    cc.blue.mr = 5;
                                                     break;
                                    case 6: //White
                                                    cc.blue.mr = 6;
                                                        break;
                                    default : //Black
                                                    cc.blue.mr = 0;
                    }

                    //Bottom left square
                    switch (c6) {
                                    case 1: //Blue
                                                    cc.blue.bl = 1;
                                                    break;
                                    case 2 : //Red
                                                    cc.blue.bl = 2;
                                                    break;
                                    case 3 : //Green
                                                    cc.blue.bl = 3;
                                                            break;
                                    case 4: //Orange
                                                    cc.blue.bl = 4;
                                                    break;
                                    case 5: //Yellow
                                                    cc.blue.bl = 5;
                                                    break;
                                    case 6: //White
                                                        cc.blue.bl = 6;
                                                      break;
                                    default : //Black
                                                    cc.blue.bl = 0;
                     }

                //Bottom middle square
                    switch (c7) {
                                    case 1: //Blue
                                                             cc.blue.bm = 1;
                                                         break;
                                    case 2 : //Red
                                                            cc.blue.bm = 2;
                                                             break;
                                    case 3 : //Green
                                                            cc.blue.bm = 3;
                                                             break;
                                     case 4: //Orange
                                                            cc.blue.bm = 4;
                                                             break;
                                     case 5: //Yellow
                                                        cc.blue.bm = 5;
                                                              break;
                                         case 6: //White
                                                        cc.blue.bm = 6;
                                                             break;
                                        default : //Black
                                                        cc.blue.bm = 0;
                      }

                    //Bottom right square
                    switch (c8) {
                                    case 1: //Blue
                                                        cc.blue.br = 1;
                                                           break;
                                    case 2 : //Red
                                                    cc.blue.br = 2;
                                                        break;
                                     case 3 : //Green
                                                    cc.blue.br = 3;
                                                        break;
                                    case 4: //Orange
                                                        cc.blue.br = 4;
                                                         break;
                                    case 5: //Yellow
                                                    cc.blue.br = 5;
                                                        break;
                                    case 6: //White
                                                    cc.blue.br = 6;
                                                        break;
                                    default : //Black
                                                    cc.blue.br = 0;
            }
            break;
        case 2 : //Red centred face

                    //Top Left square
            switch (c1) {
                case 1: //Blue
                    cc.red.tl = 1;
                    break;
                case 2 : //Red
                    cc.red.tl = 2;
                    break;
                case 3 : //Green
                    cc.red.tl = 3;
                    break;
                case 4: //Orange
                    cc.red.tl = 4;
                    break;
                case 5 : //Yellow
                    cc.red.tl = 5;
                    break;
                case 6: //White
                    cc.red.tl = 6;
                    break;
                default : //Black
                    cc.red.tl = 0;
            }
            //Top middle square
            switch (c2) {
                case 1: //Blue
                    cc.red.tm = 1;
                    break;
                case 2 : //Red
                    cc.red.tm = 2;
                    break;
                case 3 : //Green
                    cc.red.tm = 3;
                    break;
                case 4: //Orange
                    cc.red.tm = 4;
                    break;
                case 5: //Yellow
                    cc.red.tm = 5;
                    break;
                case 6: //White
                    cc.red.tm = 6;
                    break;
                default : //Black
                    cc.red.tm = 0;
            }

            //Top Right Square
            switch (c3) {
                case 1: //Blue
                    cc.red.tr = 1;
                    break;
                case 2 : //Red
                    cc.red.tr = 2;
                    break;
                case 3 : //Green
                    cc.red.tr = 3;
                    break;
                case 4: //Orange
                    cc.red.tr = 4;
                    break;
                case 5: //Yellow
                    cc.red.tr = 5;
                    break;
                case 6: //White
                    cc.red.tr = 6;
                    break;
                default : //Black
                    cc.red.tr = 0;
            }

            //Middle Left square
            switch (c4) {
                case 1: //Blue
                    cc.red.ml = 1;
                    break;
                case 2 : //Red
                    cc.red.ml = 2;
                    break;
                case 3 : //Green
                    cc.red.ml = 3;
                    break;
                case 4: //Orange
                    cc.red.ml = 4;
                    break;
                case 5: //Yellow
                    cc.red.ml =5 ;
                    break;
                case 6: //White
                    cc.red.ml =6 ;
                    break;
                default : //Black
                    cc.red.ml = 0;
            }

            //Middle middle square is red
            cc.red.mm = count;

            //Middle Right square
            switch (c5) {
                case 1: //Blue
                    cc.red.mr = 1;
                    break;
                case 2 : //Red
                    cc.red.mr = 2;
                    break;
                case 3 : //Green
                    cc.red.mr = 3;
                    break;
                case 4: //Orange
                    cc.red.mr = 4;
                    break;
                case 5: //Yellow
                    cc.red.mr = 5;
                    break;
                case 6: //White
                    cc.red.mr = 6;
                    break;
                default : //Black
                    cc.red.mr = 0;
            }

            //Bottom left square
            switch (c6) {
                case 1: //Blue
                    cc.red.bl = 1;
                    break;
                case 2 : //Red
                    cc.red.bl = 2;
                    break;
                case 3 : //Green
                    cc.red.bl = 3;
                    break;
                case 4: //Orange
                    cc.red.bl = 4;
                    break;
                case 5: //Yellow
                    cc.red.bl = 5;
                    break;
                case 6: //White
                    cc.red.bl = 6;
                    break;
                default : //Black
                    cc.red.bl = 0;
            }

            //Bottom middle square
            switch (c7) {
                case 1: //Blue
                    cc.red.bm = 1;
                    break;
                case 2 : //Red
                    cc.red.bm = 2;
                    break;
                case 3 : //Green
                    cc.red.bm = 3;
                    break;
                case 4: //Orange
                    cc.red.bm = 4;
                    break;
                case 5: //Yellow
                    cc.red.bm = 5;
                    break;
                case 6: //White
                    cc.red.bm = 6;
                    break;
                default : //Black
                    cc.red.bm = 0;
            }

            //Bottom right square
            switch (c8) {
                case 1: //Blue
                    cc.red.br = 1;
                    break;
                case 2 : //Red
                    cc.red.br = 2;
                    break;
                case 3 : //Green
                    cc.red.br = 3;
                    break;
                case 4: //Orange
                    cc.red.br = 4;
                    break;
                case 5: //Yellow
                    cc.red.br = 5;
                    break;
                case 6: //White
                    cc.red.br = 6;
                    break;
                default : //Black
                    cc.red.br = 0;
            }
            break;

        case 3 : //Green centred face

            //Top Left square
            switch (c1) {
                case 1: //Blue
                    cc.green.tl = 1;
                    break;
                case 2 : //Red
                    cc.green.tl = 2;
                    break;
                case 3 : //Green
                    cc.green.tl = 3;
                    break;
                case 4: //Orange
                    cc.green.tl = 4;
                    break;
                case 5 : //Yellow
                    cc.green.tl = 5;
                    break;
                case 6: //White
                    cc.green.tl = 6;
                    break;
                default : //Black
                    cc.green.tl = 0;
            }
            //Top middle square
            switch (c2) {
                case 1: //Blue
                    cc.green.tm = 1;
                    break;
                case 2 : //Red
                    cc.green.tm = 2;
                    break;
                case 3 : //Green
                    cc.green.tm = 3;
                    break;
                case 4: //Orange
                    cc.green.tm = 4;
                    break;
                case 5: //Yellow
                    cc.green.tm = 5;
                    break;
                case 6: //White
                    cc.green.tm = 6;
                    break;
                default : //Black
                    cc.green.tm = 0;
            }

            //Top Right Square
            switch (c3) {
                case 1: //Blue
                    cc.green.tr = 1;
                    break;
                case 2 : //Red
                    cc.green.tr = 2;
                    break;
                case 3 : //Green
                    cc.green.tr = 3;
                    break;
                case 4: //Orange
                    cc.green.tr = 4;
                    break;
                case 5: //Yellow
                    cc.green.tr = 5;
                    break;
                case 6: //White
                    cc.green.tr = 6;
                    break;
                default : //Black
                    cc.green.tr = 0;
            }

            //Middle Left square
            switch (c4) {
                case 1: //Blue
                    cc.green.ml = 1;
                    break;
                case 2 : //Red
                    cc.green.ml = 2;
                    break;
                case 3 : //Green
                    cc.green.ml = 3;
                    break;
                case 4: //Orange
                    cc.green.ml = 4;
                    break;
                case 5: //Yellow
                    cc.green.ml =5 ;
                    break;
                case 6: //White
                    cc.green.ml =6 ;
                    break;
                default : //Black
                    cc.green.ml = 0;
            }

            //Middle middle square is Green
            cc.green.mm = count;

            //Middle Right square
            switch (c5) {
                case 1: //Blue
                    cc.green.mr = 1;
                    break;
                case 2 : //Red
                    cc.green.mr = 2;
                    break;
                case 3 : //Green
                    cc.green.mr = 3;
                    break;
                case 4: //Orange
                    cc.green.mr = 4;
                    break;
                case 5: //Yellow
                    cc.green.mr = 5;
                    break;
                case 6: //White
                    cc.green.mr = 6;
                    break;
                default : //Black
                    cc.green.mr = 0;
            }

            //Bottom left square
            switch (c6) {
                case 1: //Blue
                    cc.green.bl = 1;
                    break;
                case 2 : //Red
                    cc.green.bl = 2;
                    break;
                case 3 : //Green
                    cc.green.bl = 3;
                    break;
                case 4: //Orange
                    cc.green.bl = 4;
                    break;
                case 5: //Yellow
                    cc.green.bl = 5;
                    break;
                case 6: //White
                    cc.green.bl = 6;
                    break;
                default : //Black
                    cc.green.bl = 0;
            }

            //Bottom middle square
            switch (c7) {
                case 1: //Blue
                    cc.green.bm = 1;
                    break;
                case 2 : //Red
                    cc.green.bm = 2;
                    break;
                case 3 : //Green
                    cc.green.bm = 3;
                    break;
                case 4: //Orange
                    cc.green.bm = 4;
                    break;
                case 5: //Yellow
                    cc.green.bm = 5;
                    break;
                case 6: //White
                    cc.green.bm = 6;
                    break;
                default : //Black
                    cc.green.bm = 0;
            }

            //Bottom right square
            switch (c8) {
                case 1: //Blue
                    cc.green.br = 1;
                    break;
                case 2 : //Red
                    cc.green.br = 2;
                    break;
                case 3 : //Green
                    cc.green.br = 3;
                    break;
                case 4: //Orange
                    cc.green.br = 4;
                    break;
                case 5: //Yellow
                    cc.green.br = 5;
                    break;
                case 6: //White
                    cc.green.br = 6;
                    break;
                default : //Black
                    cc.green.br = 0;
            }
            break;
        case 4 : //Orange centred face

            //Top Left square
            switch (c1) {
                case 1: //Blue
                    cc.orange.tl = 1;
                    break;
                case 2 : //Red
                    cc.orange.tl = 2;
                    break;
                case 3 : //Green
                    cc.orange.tl = 3;
                    break;
                case 4: //Orange
                    cc.orange.tl = 4;
                    break;
                case 5 : //Yellow
                    cc.orange.tl = 5;
                    break;
                case 6: //White
                    cc.orange.tl = 6;
                    break;
                default : //Black
                    cc.orange.tl = 0;
            }
            //Top middle square
            switch (c2) {
                case 1: //Blue
                    cc.orange.tm = 1;
                    break;
                case 2 : //Red
                    cc.orange.tm = 2;
                    break;
                case 3 : //Green
                    cc.orange.tm = 3;
                    break;
                case 4: //Orange
                    cc.orange.tm = 4;
                    break;
                case 5: //Yellow
                    cc.orange.tm = 5;
                    break;
                case 6: //White
                    cc.orange.tm = 6;
                    break;
                default : //Black
                    cc.orange.tm = 0;
            }

            //Top Right Square
            switch (c3) {
                case 1: //Blue
                    cc.orange.tr = 1;
                    break;
                case 2 : //Red
                    cc.orange.tr = 2;
                    break;
                case 3 : //Green
                    cc.orange.tr = 3;
                    break;
                case 4: //Orange
                    cc.orange.tr = 4;
                    break;
                case 5: //Yellow
                    cc.orange.tr = 5;

                    break;
                case 6: //White
                    cc.orange.tr = 6;
                    break;
                default : //Black
                    cc.orange.tr = 0;
            }

            //Middle Left square
            switch (c4) {
                case 1: //Blue
                    cc.orange.ml = 1;
                    break;
                case 2 : //Red
                    cc.orange.ml = 2;
                    break;
                case 3 : //Green
                    cc.orange.ml = 3;
                    break;
                case 4: //Orange
                    cc.orange.ml = 4;
                    break;
                case 5: //Yellow
                    cc.orange.ml =5 ;
                    break;
                case 6: //White
                    cc.orange.ml =6 ;
                    break;
                default : //Black
                    cc.orange.ml = 0;
            }

            //Middle middle square is orange
            cc.orange.mm = count;

            //Middle Right square
            switch (c5) {
                case 1: //Blue
                    cc.orange.mr = 1;
                    break;
                case 2 : //Red
                    cc.orange.mr = 2;
                    break;
                case 3 : //Green
                    cc.orange.mr = 3;
                    break;
                case 4: //Orange
                    cc.orange.mr = 4;
                    break;
                case 5: //Yellow
                    cc.orange.mr = 5;
                    break;
                case 6: //White
                    cc.orange.mr = 6;
                    break;
                default : //Black
                    cc.orange.mr = 0;
            }

            //Bottom left square
            switch (c6) {
                case 1: //Blue
                    cc.orange.bl = 1;
                    break;
                case 2 : //Red
                    cc.orange.bl = 2;
                    break;
                case 3 : //Green
                    cc.orange.bl = 3;
                    break;
                case 4: //Orange
                    cc.orange.bl = 4;
                    break;
                case 5: //Yellow
                    cc.orange.bl = 5;
                    break;
                case 6: //White
                    cc.orange.bl = 6;
                    break;
                default : //Black
                    cc.orange.bl = 0;
            }

            //Bottom middle square
            switch (c7) {
                case 1: //Blue
                    cc.orange.bm = 1;
                    break;
                case 2 : //Red
                    cc.orange.bm = 2;
                    break;
                case 3 : //Green
                    cc.orange.bm = 3;
                    break;
                case 4: //Orange
                    cc.orange.bm = 4;
                    break;
                case 5: //Yellow
                    cc.orange.bm = 5;
                    break;
                case 6: //White
                    cc.orange.bm = 6;
                    break;
                default : //Black
                    cc.orange.bm = 0;
            }

            //Bottom right square
            switch (c8) {
                case 1: //Blue
                    cc.orange.br = 1;
                    break;
                case 2 : //Red
                    cc.orange.br = 2;
                    break;
                case 3 : //Green
                    cc.orange.br = 3;
                    break;
                case 4: //Orange
                    cc.orange.br = 4;
                    break;
                case 5: //Yellow
                    cc.orange.br = 5;
                    break;
                case 6: //White
                    cc.orange.br = 6;
                    break;
                default : //Black
                    cc.orange.br = 0;
            }
            break;
        case 5 : //Yellow centred face

            //Top Left square
            switch (c1) {
                case 1: //Blue
                    cc.yellow.tl = 1;
                    break;
                case 2 : //Red
                    cc.yellow.tl = 2;
                    break;
                case 3 : //Green
                    cc.yellow.tl = 3;
                    break;
                case 4: //Orange
                    cc.yellow.tl = 4;
                    break;
                case 5 : //Yellow
                    cc.yellow.tl = 5;
                    break;
                case 6: //White
                    cc.yellow.tl = 6;
                    break;
                default : //Black
                    cc.yellow.tl = 0;
            }
            //Top middle square
            switch (c2) {
                case 1: //Blue
                    cc.yellow.tm = 1;
                    break;
                case 2 : //Red
                    cc.yellow.tm = 2;
                    break;
                case 3 : //Green
                    cc.yellow.tm = 3;
                    break;
                case 4: //Orange
                    cc.yellow.tm = 4;
                    break;
                case 5: //Yellow
                    cc.yellow.tm = 5;
                    break;
                case 6: //White
                    cc.yellow.tm = 6;
                    break;
                default : //Black
                    cc.yellow.tm = 0;
            }

            //Top Right Square
            switch (c3) {
                case 1: //Blue
                    cc.yellow.tr = 1;
                    break;
                case 2 : //Red
                    cc.yellow.tr = 2;
                    break;
                case 3 : //Green
                    cc.yellow.tr = 3;
                    break;
                case 4: //Orange
                    cc.yellow.tr = 4;
                    break;
                case 5: //Yellow
                    cc.yellow.tr = 5;
                    break;
                case 6: //White
                    cc.yellow.tr = 6;
                    break;
                default : //Black
                    cc.yellow.tr = 0;
            }

            //Middle Left square
            switch (c4) {
                case 1: //Blue
                    cc.yellow.ml = 1;
                    break;
                case 2 : //Red
                    cc.yellow.ml = 2;
                    break;
                case 3 : //Green
                    cc.yellow.ml = 3;
                    break;
                case 4: //Orange
                    cc.yellow.ml = 4;
                    break;
                case 5: //Yellow
                    cc.yellow.ml =5 ;
                    break;
                case 6: //White
                    cc.yellow.ml =6 ;
                    break;
                default : //Black
                    cc.yellow.ml = 0;
            }

            //Middle middle square is Yellow
            cc.yellow.mm = count;

            //Middle Right square
            switch (c5) {
                case 1: //Blue
                    cc.yellow.mr = 1;
                    break;
                case 2 : //Red
                    cc.yellow.mr = 2;
                    break;
                case 3 : //Green
                    cc.yellow.mr = 3;
                    break;
                case 4: //Orange
                    cc.yellow.mr = 4;
                    break;
                case 5: //Yellow
                    cc.yellow.mr = 5;
                    break;
                case 6: //White
                    cc.yellow.mr = 6;
                    break;
                default : //Black
                    cc.yellow.mr = 0;
            }

            //Bottom left square
            switch (c6) {
                case 1: //Blue
                    cc.yellow.bl = 1;
                    break;
                case 2 : //Red
                    cc.yellow.bl = 2;
                    break;
                case 3 : //Green
                    cc.yellow.bl = 3;
                    break;
                case 4: //Orange
                    cc.yellow.bl = 4;
                    break;
                case 5: //Yellow
                    cc.yellow.bl = 5;
                    break;
                case 6: //White
                    cc.yellow.bl = 6;
                    break;
                default : //Black
                    cc.yellow.bl = 0;

            }

            //Bottom middle square
            switch (c7) {
                case 1: //Blue
                    cc.yellow.bm = 1;
                    break;
                case 2 : //Red
                    cc.yellow.bm = 2;
                    break;
                case 3 : //Green
                    cc.yellow.bm = 3;
                    break;
                case 4: //Orange
                    cc.yellow.bm = 4;
                    break;
                case 5: //Yellow
                    cc.yellow.bm = 5;
                    break;
                case 6: //White
                    cc.yellow.bm = 6;
                    break;
                default : //Black
                    cc.yellow.bm = 0;
            }

            //Bottom right square
            switch (c8) {
                case 1: //Blue
                    cc.yellow.br = 1;
                    break;
                case 2 : //Red
                    cc.yellow.br = 2;
                    break;
                case 3 : //Green
                    cc.yellow.br = 3;
                    break;
                case 4: //Orange
                    cc.yellow.br = 4;
                    break;
                case 5: //Yellow
                    cc.yellow.br = 5;
                    break;
                case 6: //White
                    cc.yellow.br = 6;
                    break;
                default : //Black
                    cc.yellow.br = 0;
            }
                break;
        case 6 : //White centred face

            //Top Left square
            switch (c1) {
                case 1: //Blue
                    cc.white.tl = 1;
                    break;
                case 2 : //Red
                    cc.white.tl = 2;
                    break;
                case 3 : //Green
                    cc.white.tl = 3;
                    break;
                case 4: //Orange
                    cc.white.tl = 4;
                    break;
                case 5 : //Yellow
                    cc.white.tl = 5;
                    break;
                case 6: //White
                    cc.white.tl = 6;
                    break;
                default : //Black
                    cc.white.tl = 0;
            }
            //Top middle square
            switch (c2) {
                case 1: //Blue
                    cc.white.tm = 1;
                    break;
                case 2 : //Red
                    cc.white.tm = 2;
                    break;
                case 3 : //Green
                    cc.white.tm = 3;
                    break;
                case 4: //Orange
                    cc.white.tm = 4;
                    break;
                case 5: //Yellow
                    cc.white.tm = 5;
                    break;
                case 6: //White
                    cc.white.tm = 6;
                    break;
                default : //Black
                    cc.white.tm = 0;
            }

            //Top Right Square
            switch (c3) {
                case 1: //Blue
                    cc.white.tr = 1;
                    break;
                case 2 : //Red
                    cc.white.tr = 2;
                    break;
                case 3 : //Green
                    cc.white.tr = 3;
                    break;
                case 4: //Orange
                    cc.white.tr = 4;
                    break;
                case 5: //Yellow
                    cc.white.tr = 5;
                    break;
                case 6: //White
                    cc.white.tr = 6;
                    break;
                default : //Black
                    cc.white.tr = 0;
            }

            //Middle Left square
            switch (c4) {
                case 1: //Blue
                    cc.white.ml = 1;
                    break;
                case 2 : //Red
                    cc.white.ml = 2;
                    break;
                case 3 : //Green
                    cc.white.ml = 3;
                    break;
                case 4: //Orange
                    cc.white.ml = 4;
                    break;
                case 5: //Yellow
                    cc.white.ml =5 ;
                    break;
                case 6: //White
                    cc.white.ml =6 ;
                    break;
                default : //Black
                    cc.white.ml = 0;
            }

            //Middle middle square is White
            cc.white.mm = count;

            //Middle Right square
            switch (c5) {
                case 1: //Blue
                    cc.white.mr = 1;
                    break;
                case 2 : //Red
                    cc.white.mr = 2;
                    break;
                case 3 : //Green
                    cc.white.mr = 3;
                    break;
                case 4: //Orange
                    cc.white.mr = 4;
                    break;
                case 5: //Yellow
                    cc.white.mr = 5;
                    break;
                case 6: //White
                    cc.white.mr = 6;
                    break;
                default : //Black
                    cc.white.mr = 0;
            }

            //Bottom left square
            switch (c6) {
                case 1: //Blue
                    cc.white.bl = 1;
                    break;
                case 2 : //Red
                    cc.white.bl = 2;
                    break;
                case 3 : //Green
                    cc.white.bl = 3;
                    break;
                case 4: //Orange
                    cc.white.bl = 4;
                    break;
                case 5: //Yellow
                    cc.white.bl = 5;
                    break;
                case 6: //White
                    cc.white.bl = 6;
                    break;
                default : //Black
                    cc.white.bl = 0;
            }

            //Bottom middle square
            switch (c7) {
                case 1: //Blue
                    cc.white.bm = 1;
                    break;
                case 2 : //Red
                    cc.white.bm = 2;
                    break;
                case 3 : //Green
                    cc.white.bm = 3;
                    break;
                case 4: //Orange
                    cc.white.bm = 4;
                    break;
                case 5: //Yellow
                    cc.white.bm = 5;
                    break;
                case 6: //White
                    cc.white.bm = 6;
                    break;
                default : //Black
                    cc.white.bm = 0;
            }

            //Bottom right square
            switch (c8) {
                case 1: //Blue
                    cc.white.br = 1;
                    break;
                case 2 : //Red
                    cc.white.br = 2;
                    break;
                case 3 : //Green
                    cc.white.br = 3;
                    break;
                case 4: //Orange
                    cc.white.br = 4;
                    break;
                case 5: //Yellow
                    cc.white.br = 5;
                    break;
                case 6: //White
                    cc.white.br = 6;
                    break;
                default : //Black
                    cc.white.br = 0;
            }
    }

    //Manual.cube =cc;

    cc.saveCubeState(cc);
}





/*
    public void decodeUri(Uri uri) {
        ParcelFileDescriptor parcelFD = null;
        try {
            parcelFD = getContentResolver().openFileDescriptor(uri, "r");
            FileDescriptor imageSource = parcelFD.getFileDescriptor();

            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(imageSource, null, o);

            // the new size we want to scale to
            final int REQUIRED_SIZE = 1024;

            // Find the correct scale value. It should be the power of 2.
            int width_tmp = o.outWidth, height_tmp = o.outHeight;
            int scale = 1;
            while (true) {
                if (width_tmp < REQUIRED_SIZE && height_tmp < REQUIRED_SIZE) {
                    break;
                }
                width_tmp /= 2;
                height_tmp /= 2;
                scale *= 2;
            }

            // decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            Bitmap bitmap = BitmapFactory.decodeFileDescriptor(imageSource, null, o2);

            viewImage.setImageBitmap(bitmap);

        } catch (FileNotFoundException e) {
            // handle errors
        } finally {
            if (parcelFD != null)
                try {
                    parcelFD.close();
                } catch (IOException e) {
                    // ignored
                }
        }
    }

*/
}