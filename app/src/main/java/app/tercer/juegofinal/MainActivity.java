package app.tercer.juegofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;

import com.scwang.wave.MultiWaveHeader;

import app.tercer.juegofinal.AjustesDelJuego.Ajustes;


public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    TextView titulo,introtext,slogan,introText;
    private MediaPlayer mediaPlayer;
    public static Boolean sonido = true;
    SharedPreferences sharedPref;
    private Boolean mute;
    Button entrar,botonachi,leaderborads;
    MultiWaveHeader waveHeader,waveHeader2;
     int  length;
    ImageButton muteButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titulo = findViewById(R.id.logo);
        entrar = findViewById(R.id.entrar);
        introText = findViewById(R.id.introText);
        waveHeader = findViewById(R.id.wave_header);
        waveHeader2 = findViewById(R.id.wave_header2);
        entrar.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_right_0));
         titulo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.advanced_inicio));
         introText.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_left_advanced));

        PreferenceManager.setDefaultValues(this,R.xml.preference,false);
         sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPref.registerOnSharedPreferenceChangeListener(this);
         introtext = findViewById(R.id.introText);
        slogan = findViewById(R.id.slogan);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        mute = sharedPref.getBoolean(Ajustes.KEY_MUTE_MUSIC,true);
        Boolean darkModePref = sharedPref.getBoolean(Ajustes.KEY_DARK_MODE_SWITCH, false);

        muteButton = findViewById(R.id.muteButton);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MenuJuegos.class));
                finish();
            }
        });



        MobileAds.initialize(this);





        mediaPlayer = MediaPlayer.create(this,R.raw.littleide);
        mediaPlayer.setLooping(true);

        if(!mute) {
            mediaPlayer.start();
            muteButton.setImageResource(R.drawable.ic_volume_up_black_24dp);
        }else{
            muteButton.setImageResource(R.drawable.ic_volume_off_black_24dp);
        }
        if(darkModePref){
            //activado el modo oscuro, cambiamos de color algunos aspectos
            RelativeLayout relativelayout = (findViewById(R.id.mainMenu));
            relativelayout.setBackground(getDrawable(R.drawable.fondonegro));

             waveHeader.setStartColor(R.color.colorOlass);
            waveHeader2.setStartColor(R.color.colorOlass);
            entrar.setBackground(getDrawable(R.drawable.main_menu_button_rd_dk));

             slogan.setTextColor(getResources().getColor(R.color.white));
            introtext.setTextColor(getResources().getColor(R.color.white));

            //la barra de hasta arriba cambia de color a negro
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorARRIBA));
        }
    }


    public void openSettings(View view){
        startActivity(new Intent(this, Ajustes.class));
    }

    //cambiar el icono y las prefenrencias sobre el ajuste del sonido
    public void muteTemp(View view){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            sonido = true;
            sharedPref.edit().putBoolean(Ajustes.KEY_MUTE_MUSIC,true).apply();
            muteButton.setImageResource(R.drawable.ic_volume_off_black_24dp);
        }else{
            mediaPlayer.start();
            sonido = false;
            sharedPref.edit().putBoolean(Ajustes.KEY_MUTE_MUSIC,false).apply();
            muteButton.setImageResource(R.drawable.ic_volume_up_black_24dp);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        if(mediaPlayer.isPlaying() && !mute){
            mediaPlayer.pause();
            length = mediaPlayer.getCurrentPosition();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(!mediaPlayer.isPlaying() && !mute) {
            mediaPlayer.seekTo(length);
            mediaPlayer.pause();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    //reiniciar la aplicacion para implementar el modo oscuro y guardar la preferencia
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals(Ajustes.KEY_DARK_MODE_SWITCH)){
            recreate();
        }
    }





}
