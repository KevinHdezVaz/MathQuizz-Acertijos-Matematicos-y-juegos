package app.tercer.juegofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.wave.MultiWaveHeader;

import app.tercer.juegofinal.AjustesDelJuego.Ajustes;


public class SplashSc extends AppCompatActivity {
    ImageView imagen;
    TextView texto,chacos;
    MediaPlayer mediaPlayer;
    SharedPreferences sharedPref;

    RelativeLayout fondorelativo;
    MultiWaveHeader wave_header,wave_header2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_sc);
        imagen = findViewById(R.id.chido);
        texto = findViewById(R.id.chacos);

        //sonido en los botones
        mediaPlayer = MediaPlayer.create(this, R.raw.intro);
        mediaPlayer.start();
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        chacos = findViewById(R.id.chacos);
         Boolean darkModePref = sharedPref.getBoolean(Ajustes.KEY_DARK_MODE_SWITCH, false);
        wave_header = findViewById(R.id.wave_header);
        wave_header2 = findViewById(R.id.wave_header2);
        fondorelativo = findViewById(R.id.fondorelativo);
        if(darkModePref){
            //activado el modo oscuro, cambiamos de color algunos aspectos
             wave_header.setStartColor(R.color.colorOlass);
             wave_header2.setStartColor(R.color.colorOlass);
            fondorelativo.setBackground(getDrawable(R.drawable.fondonegro));
            chacos.setTextColor(getResources().getColor(R.color.white));

            //la barra de hasta arriba cambia de color a negro
            getWindow().setStatusBarColor(getResources().getColor(R.color.qboard_black));
        }

        imagen.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_arriba));
        texto.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_arriba));

        new Handler().postDelayed(new Runnable(){
            public void run(){
                // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación
                Intent intent = new Intent(SplashSc.this, MainActivity.class);
                startActivity(intent);
                finish();
            };
        }, 3000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mediaPlayer.stop();
        mediaPlayer.release();

    }
}