package Controleur;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;

import com.example.eatit.R;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AjouterRepasActivity extends AppCompatActivity {

    private String currentPhotoPath;
    private ConstraintLayout mLayout;
    private Button mButtonTakePhoto;
    private Button mButtonEnregister;
    private String typeRepas;
    private ImageView petitDej, dejeuner, collation, diner, autre;
    private EditText mDate, mHeure, mDuree, mCommentaire;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_repas);

        mButtonTakePhoto = (Button) findViewById(R.id.button_take_photo);
        mButtonEnregister = (Button) findViewById(R.id.button_enregister_ajout_repas);
        petitDej = (ImageView) findViewById(R.id.imageView5);
        dejeuner = (ImageView) findViewById(R.id.imageView7);
        collation = (ImageView) findViewById(R.id.imageView6);
        diner = (ImageView) findViewById(R.id.imageView8);
        autre = (ImageView) findViewById(R.id.imageView3);
        mDate = (EditText) findViewById(R.id.editTextDate);
        mHeure = (EditText) findViewById(R.id.editTextHeure);
        mDuree = (EditText) findViewById(R.id.editTextDuree);
        mCommentaire = (EditText) findViewById(R.id.editTextComm);

        mButtonTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("test image boutton");
            }
        });

        mButtonEnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("repas enregister");
            }
        });
    }

    public void addPhoto(){
        System.out.println("it works !");
    }

    //fonction pour appeller un intent pour prendre une photo
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;

    private void dispatchTakePictureIntent(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Ensure that there is a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null){
            //Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch(IOException ex){
                //Error occurred while creating the file
            }
            //Continue only if the File was successfully created
            if(photoFile != null){
                Uri photoURI = FileProvider.getUriForFile(this, "com.example.android.fileprovider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    //Récupérer l'image en icone/miniature
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data"); //Good pour un icone, peut être que nous devrioons modifier tout cela si nos photos nécessitents d'être plus grandes
//            ImageView.setImageBitmap(imageBitmap);
//        }
//    }

    //Creation du fichier de sauvegarde pour enregistrer l'image en full size
    private File createImageFile() throws IOException{
        //Create an image file name using date
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,      //Prefix
                ".jpeg",     //sufffix
                storageDir         //directory
        );

        //save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    //Method to add photo to a gallery
    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(currentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    //Decode a scaled image --> pour sauvegarder des images davec un format moins lourd
    // Error: static method/non static ccntext. imageview doit être le containers de l'image a afficher ?
//    private void setPic() {
//        // Get the dimensions of the View
//        int targetW = imageView.getWidth();
//        int targetH = imageView.getHeight();
//
//        // Get the dimensions of the bitmap
//        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//        bmOptions.inJustDecodeBounds = true;
//
//        int photoW = bmOptions.outWidth;
//        int photoH = bmOptions.outHeight;
//
//        // Determine how much to scale down the image
//        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);
//
//        // Decode the image file into a Bitmap sized to fill the View
//        bmOptions.inJustDecodeBounds = false;
//        bmOptions.inSampleSize = scaleFactor;
//        bmOptions.inPurgeable = true;
//
//        Bitmap bitmap = BitmapFactory.decodeFile(currentPhotoPath, bmOptions);
//        imageView.setImageBitmap(bitmap);
//    }



}


//méthode pour vérifier si un appareil photo est fonctionnel
//hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)

