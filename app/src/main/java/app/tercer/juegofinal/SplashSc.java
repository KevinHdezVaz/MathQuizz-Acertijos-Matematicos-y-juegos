package app.tercer.juegofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class SplashSc extends AppCompatActivity {
    ImageView imagen;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_sc);
        imagen = findViewById(R.id.chido);
        texto = findViewById(R.id.chacos);


        imagen.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_left_advanced));
        texto.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_right_0));

        new Handler().postDelayed(new Runnable(){
            public void run(){
                // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación
                Intent intent = new Intent(SplashSc.this, MainActivity.class);
                startActivity(intent);
                finish();
            };
        }, 3000);
    }

}