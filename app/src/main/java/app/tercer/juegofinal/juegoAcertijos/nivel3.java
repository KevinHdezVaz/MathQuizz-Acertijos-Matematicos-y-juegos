package app.tercer.juegofinal.juegoAcertijos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.Animator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.mrntlu.toastie.Toastie;

import app.tercer.juegofinal.AjustesDelJuego.Ajustes;
import app.tercer.juegofinal.MenuJuegos;
import app.tercer.juegofinal.PreferenciaNvl;
import app.tercer.juegofinal.R;
import io.codetail.animation.ViewAnimationUtils;

public class nivel3 extends AppCompatActivity {
    EditText editText;
    String varResultado;
    Button entrarx, btnad1, btnad2;
    ImageButton foco;
    ImageView cerrar;
    Button btnVamo,cerrarVentana;
    Dialog epicDialog, epicDialog2, epicDialog3;
    LottieAnimationView animacion2;
    private InterstitialAd mInterstitialAd,mInterstitialAd2;

    TextView txtResultado,txtRespuesta,msjResuelto;
    MediaPlayer mediaPlayer,mediainco,mediacorrec;
int contador;
    LinearLayout tabla1;
    Button enter;
    Button uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero;
    RelativeLayout relativeLayout, relativofondo;
    SharedPreferences sharedPref;
    Boolean anunciopista,anuncioresultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_nivel3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
         foco = findViewById(R.id.foco);
        entrarx = findViewById(R.id.enter);
        relativeLayout = findViewById(R.id.relativeLayout);
        relativofondo = findViewById(R.id.relativofondo);
         tabla1 = findViewById(R.id.tabla1);
        enter = findViewById(R.id.enter);
        cerrar = findViewById(R.id.cerrar);
        uno = findViewById(R.id.btn_1);
        dos = findViewById(R.id.btn_2);
        tres = findViewById(R.id.btn_3);
        cuatro = findViewById(R.id.btn_4);
        cinco = findViewById(R.id.btn_5);
        seis = findViewById(R.id.btn_6);
        siete = findViewById(R.id.btn_7);
        ocho = findViewById(R.id.btn_8);
        nueve = findViewById(R.id.btn_9);
        cero = findViewById(R.id.btn_0);;

        anunciopista = false;
        anuncioresultado =false;
        editText = findViewById(R.id.editext);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.pista));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        mInterstitialAd2 = new InterstitialAd(this);
        mInterstitialAd2.setAdUnitId(getString(R.string.recompensa));
        mInterstitialAd2.loadAd(new AdRequest.Builder().build());

        mInterstitialAd2.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd2.loadAd(new AdRequest.Builder().build());
            }

        });
        PreferenciaNvl.setLevel(getApplicationContext(), 3 /* Nivel */);
        getSharedPreferences(PreferenciaNvl.Shared_Preferences, Context.MODE_PRIVATE).edit().putInt(PreferenciaNvl.Last_Level, 3).apply();


        //sonido en los botones
        mediaPlayer = MediaPlayer.create(this, R.raw.clic);
        mediacorrec = MediaPlayer.create(this, R.raw.correctos);
        mediainco = MediaPlayer.create(this, R.raw.incorrecto);
       /* if (darkModePref) {

            relativofondo.setBackground(getDrawable(R.drawable.fondonegro2));
            tabla1.setBackground(getDrawable(R.drawable.fondonegro2));
            enter.setBackground(getDrawable(R.drawable.fondonegro2));
            relativeLayout.setBackground(getDrawable(R.drawable.fondonegro));
            toolbar.setBackground(getDrawable(R.drawable.fondonegro2));
            uno.setBackground(getDrawable(R.drawable.fondonegro));
            dos.setBackground(getDrawable(R.drawable.fondonegro));
            tres.setBackground(getDrawable(R.drawable.fondonegro));
            cuatro.setBackground(getDrawable(R.drawable.fondonegro));
            cinco.setBackground(getDrawable(R.drawable.fondonegro));
            seis.setBackground(getDrawable(R.drawable.fondonegro));
            siete.setBackground(getDrawable(R.drawable.fondonegro));
            ocho.setBackground(getDrawable(R.drawable.fondonegro));
            nueve.setBackground(getDrawable(R.drawable.fondonegro));
            cero.setBackground(getDrawable(R.drawable.fondonegro));

            //la barra de hasta arriba cambia de color a negro
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorARRIBA));
        }

        */

        //LOGICA
        entrarx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                if(contador==5){
                    Toastie.warning(nivel3.this,getString(R.string.ayuda1),Toast.LENGTH_SHORT).show();
                }
                if(contador==8){
                    Toastie.warning(nivel3.this,getString(R.string.ayuda2),Toast.LENGTH_SHORT).show();
                }
                varResultado = editText.getText().toString();
                if (varResultado.equals("1")) {

                    PreferenciaNvl.lvlCompleto(nivel3.this,3); //ya lo paso

                    Animation fadeOut = new AlphaAnimation(1, 0);
                    fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
                    fadeOut.setStartOffset(200);
                    fadeOut.setDuration(2200);


                    final View mv = findViewById(R.id.awesome_card);

                    int centerX = (mv.getRight());
                    int centerY = (mv.getBottom());

                    int startRadius = 0;
                    int endRadius = Math.max(mv.getWidth(), mv.getHeight());

                    Animator anim =
                            ViewAnimationUtils.createCircularReveal(mv, centerX, centerY, startRadius, endRadius);


                    AnimationSet animation = new AnimationSet(false); //change to false
                    animation.addAnimation(fadeOut);
                    mv.setAnimation(animation);

                    anim.setDuration(300);
                    anim.start();
                    mediacorrec.start();

                    mostrarInfo();


                }
                else{
                    editText.setText("");
                    mediainco.start();

                }
            }
        });


        foco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mostrarInfo2();

            }
        });

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {

            }

            @Override
            public void onAdFailedToLoad (LoadAdError adError){

            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdClicked() {

                Toastie.success(nivel3.this,getString(R.string.desbloqueado),Toast.LENGTH_SHORT).show();

                epicDialog.dismiss();
                Pista();
                anunciopista=true;
            }

            @Override
            public void onAdLeftApplication() {

            }

            @Override
            public void onAdClosed() {
                if(!anunciopista){//quesi ya lo vio

                    Toastie.info(nivel3.this,getString(R.string.informacionc),Toast.LENGTH_SHORT).show();
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());

                }


            }
        });


        mInterstitialAd2.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {

            }

            @Override
            public void onAdFailedToLoad (LoadAdError adError){

            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdClicked() {

                Toastie.success(nivel3.this,getString(R.string.desbloqueadoRe),Toast.LENGTH_SHORT).show();

                epicDialog.dismiss();
                Respuesta();
                anuncioresultado = true;

            }

            @Override
            public void onAdLeftApplication() {

            }

            @Override
            public void onAdClosed() {
                if(!anuncioresultado){//quesi ya lo vio

                    Toastie.info(nivel3.this,getString(R.string.informacionc),Toast.LENGTH_SHORT).show();
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());

                }


            }
        });


    }

    public void onClick1(View view) {
        editText.setText(editText.getText() + "1");
        mediaPlayer.start();
    }

    public void onClick2(View view) {
        mediaPlayer.start();
        editText.setText(editText.getText() + "2");
    }

    public void onClick3(View view) {
        mediaPlayer.start();
        editText.setText(editText.getText() + "3");
    }

    public void onClick4(View view) {
        mediaPlayer.start();
        editText.setText(editText.getText() + "4");
    }

    public void onClick5(View view) {
        mediaPlayer.start();
        editText.setText(editText.getText() + "5");
    }

    public void onClick6(View view) {
        mediaPlayer.start();
        editText.setText(editText.getText() + "6");
    }

    public void onClick7(View view) {
        mediaPlayer.start();
        editText.setText(editText.getText() + "7");
    }

    public void onClick8(View view) {
        mediaPlayer.start();
        editText.setText(editText.getText() + "8");
    }

    public void onClick9(View view) {
        mediaPlayer.start();
        editText.setText(editText.getText() + "9");
    }

    public void onClick0(View view) {
        mediaPlayer.start();
        editText.setText(editText.getText() + "0");
    }

    public void onClickCerrar(View view) {
        editText.setText("");
    }

    public void mostrarInfo() {
        epicDialog = new Dialog(this);
        epicDialog.setContentView(R.layout.custompopup4);
         btnVamo = epicDialog.findViewById(R.id.botonvamo);
        btnVamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nivel3.this,nivel4.class));
                finish();
            }
        });
        msjResuelto =epicDialog.findViewById(R.id.msjResultado);
        msjResuelto.setText(getString(R.string.nvldos));

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        epicDialog.setCanceledOnTouchOutside(false);
        epicDialog.show();

    }

    public void mostrarInfo2() {
        epicDialog = new Dialog(this);

        epicDialog.setContentView(R.layout.customads);
        cerrar =   epicDialog.findViewById(R.id.cerrarVentana2);
        btnad1 = epicDialog.findViewById(R.id.btnad1);
        btnad2 = epicDialog.findViewById(R.id.btnad2);


        if(anunciopista==true ){
            btnad1.setText(getString(R.string.pist));
        }

        if(anuncioresultado==true ){
            btnad2.setText(getString(R.string.res));
        }


        btnad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(anunciopista ){
                    epicDialog.dismiss();
                    Pista();

                }

                if (!anunciopista) { //osea que si no lo han visto


                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();

                    }

                    else{//SE MUESTRA PORQUE TODAVIA NO ESTA CARGADO
                        Toastie.info(nivel3.this,getString(R.string.ayuda3),Toast.LENGTH_SHORT).show();

                    }
                }
                //falta mostrar el toast


                else
                {
                    epicDialog.show();
                }

            }
        });




        btnad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(anuncioresultado ){
                    epicDialog.dismiss();
                    Respuesta();

                }

                if(anunciopista==false){
                    Toastie.info(nivel3.this,getString(R.string.ayuda4),Toast.LENGTH_SHORT).show();
                }else{

                    if (anuncioresultado == false) { //osea que si no lo han visto

                        if (mInterstitialAd2.isLoaded()) {
                            mInterstitialAd2.show();

                        }

                        else{
                            Toastie.info(nivel3.this,getString(R.string.ayuda3),Toast.LENGTH_SHORT).show();

                        }
                    }
                    else{
                        epicDialog.show();
                    }
                }
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        epicDialog.show();

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicDialog.dismiss();
            }
        });

    }

    //para cargar varios anuncios

    public RewardedAd createAndLoadRewardedAd(String adUnitId) {
        RewardedAd rewardedAd = new RewardedAd(this, adUnitId);
        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
            }

            @Override
            public void onRewardedAdFailedToLoad(LoadAdError adError) {
                // Ad failed to load.
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
        return rewardedAd;


    }
    public void Pista(){

        epicDialog = new Dialog(this);
        epicDialog.setContentView(R.layout.custompista1);
        cerrarVentana =  epicDialog.findViewById(R.id.cerrarVentana);
        txtResultado =epicDialog.findViewById(R.id.txtResultado);
        txtResultado.setText(getString(R.string.princi2));
        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        epicDialog.show();

        cerrarVentana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicDialog.dismiss();
            }
        });


    }

    public void Respuesta(){

        epicDialog = new Dialog(this);
        epicDialog.setContentView(R.layout.customrespuesta);
        cerrarVentana =  epicDialog.findViewById(R.id.cerrarVentana);
        txtRespuesta =epicDialog.findViewById(R.id.txtRespuesta);
        txtRespuesta.setText(getString(R.string.resp)+ " 1");
        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        epicDialog.show();

        cerrarVentana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicDialog.dismiss();
            }
        });


    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(nivel3.this, MenuJuegos.class));
        finish();
    }
}
