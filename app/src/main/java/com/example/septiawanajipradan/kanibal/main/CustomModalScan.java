package com.example.septiawanajipradan.kanibal.main;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.septiawanajipradan.kanibal.R;
import com.example.septiawanajipradan.kanibal.entitas.BangunanSensus;
import com.example.septiawanajipradan.kanibal.koneksi.CustomVolleyRequest;

/**
 * Created by Septiawan Aji Pradan on 4/1/2017.
 */

public class CustomModalScan extends Dialog{
    private Activity activity;
    private String bangunanSensus;
    private TextView ketBangunanSesus;
    private NetworkImageView fotoBangunan;
    private ImageLoader imageLoader;
    CustomModalScan(Activity activity,String bangunanSensus){
        super(activity);
        this.activity = activity;
        this.bangunanSensus = bangunanSensus;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modal_scan);
        imageLoader = CustomVolleyRequest.getInstance(activity).getImageLoader();
        ketBangunanSesus = (TextView)findViewById(R.id.ket_bangunan_sensus);
        fotoBangunan = (NetworkImageView)findViewById(R.id.gambar_bangunan_sensus);
        fotoBangunan.setImageUrl("https://blog-cdn.duitpintar.com/wp-content/uploads/2016/04/meningkatkan-harga-rumah-3-1.jpg",imageLoader);
        ketBangunanSesus.setText(bangunanSensus);
    }

}
