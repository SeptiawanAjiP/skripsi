package com.example.septiawanajipradan.kanibal;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.septiawanajipradan.kanibal.database.DatabaseHandler;
import com.example.septiawanajipradan.kanibal.formisian.PetaIsian;
import com.example.septiawanajipradan.kanibal.formisian.BangunanSensusOnMaps;
import com.example.septiawanajipradan.kanibal.main.ARPortraitActivity;

public class MainActivity extends Activity implements View.OnClickListener {
    private final static int REQUEST_CAMERA_PERMISSIONS_CODE = 11;
    public static final int REQUEST_LOCATION_PERMISSIONS_CODE = 0;
    private Button scanTempat,inputData,lihatPeta;
    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scanTempat = (Button)findViewById(R.id.scan_tempat);
        inputData = (Button)findViewById(R.id.input_data);
        lihatPeta = (Button)findViewById(R.id.lihat_peta);
        databaseHandler = new DatabaseHandler(getApplicationContext());
        scanTempat.setOnClickListener(this);
        inputData.setOnClickListener(this);
        lihatPeta.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        if (view==scanTempat){
            intent = new Intent(this, ARPortraitActivity.class);
            startActivity(intent);
        }else if(view==inputData){
            intent = new Intent(this, PetaIsian.class);
            startActivity(intent);
        }else if (view==lihatPeta){
            if(databaseHandler.getAll().isEmpty()){
                Toast.makeText(this, "Belum Ada Data", Toast.LENGTH_SHORT).show();
            }else{
                intent = new Intent(this, BangunanSensusOnMaps.class);
                startActivity(intent);
            }
        }
    }

    public void startARPortrait(View view) {
        Intent intent = new Intent(this, ARPortraitActivity.class);
        startActivity(intent);
    }
//    public void startARLandscape(View view) {
//        Intent intent = new Intent(this, ARLandscapeActivity.class);
//        startActivity(intent);
//    }
//public void startARAutoOrienting(View view) {
//    Intent intent = new Intent(this, ARAutoOrientingActivity.class);
//    startActivity(intent);
//}
    public void startInputData(View view) {
        Intent intent = new Intent(this, PetaIsian.class);
        startActivity(intent);
    }
    public void startLihatPeta(View view) {
        Intent intent = new Intent(this, BangunanSensusOnMaps.class);
        startActivity(intent);
    }


    public void requestCameraPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                this.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            this.requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSIONS_CODE);
        } else {

        }
    }

    public void requestLocationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                this.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            this.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSIONS_CODE);
        } else {

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestLocationPermission();
        requestCameraPermission();
    }

}
