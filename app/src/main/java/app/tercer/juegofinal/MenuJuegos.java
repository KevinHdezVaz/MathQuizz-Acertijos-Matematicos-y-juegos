package app.tercer.juegofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

import app.tercer.juegofinal.AjustesDelJuego.Ajustes;
import app.tercer.juegofinal.juego1.suma_resta_mul;
import app.tercer.juegofinal.juego2.adivina_numero;
import app.tercer.juegofinal.juego3.JuegoTiempo;
import app.tercer.juegofinal.juego4.correcto_incorrecto;
import app.tercer.juegofinal.juego5.operaciones;
import app.tercer.juegofinal.juegoAcertijos.nivel1;
import app.tercer.juegofinal.juegoAcertijos.niveles;

public class MenuJuegos extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    CardView card1,card2,card3,card4,card5,card6,card7;
    private MediaPlayer mediaPlayer;
     SharedPreferences sharedPref;
    TextView t1,t2,t3,t4,t5,t6,t7;
    int length;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    TextView textView;


    Boolean mute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_juegos);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        card7 = findViewById(R.id.card7);

        t1 = findViewById(R.id.xd);
        t2 = findViewById(R.id.xd2);
        t3 = findViewById(R.id.xd3);
        t4 = findViewById(R.id.xd4);
        t5 = findViewById(R.id.xd5);
        t6 = findViewById(R.id.xd6);
        t7 = findViewById(R.id.xd7);

        final ImageButton addButton = (ImageButton) findViewById(R.id.add);
        final ImageButton subButton = (ImageButton) findViewById(R.id.sub);
        final ImageButton mulButton = (ImageButton) findViewById(R.id.mul);
        final ImageButton adivinaNumer = (ImageButton) findViewById(R.id.adivinaNumero);
        final ImageButton adivinaNumer2 = (ImageButton) findViewById(R.id.pregunta);
        final ImageButton adivinaNumer3 = (ImageButton) findViewById(R.id.ultimoGame);

        card1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_right_0));
        card2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_left_quick_math));
        card3.startAnimation(AnimationUtils.loadAnimation(this,R.anim.advanced_init));
        card4.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_left_time_trials));
        card5.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_left_advanced));
        card6.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_left_time_trials));
        card7.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_left_advanced));

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        mute = sharedPref.getBoolean(Ajustes.KEY_MUTE_MUSIC,false);
        mediaPlayer = MediaPlayer.create(this,R.raw.littleide);
        mediaPlayer.setLooping(true);
        Boolean darkModePref = sharedPref.getBoolean(Ajustes.KEY_DARK_MODE_SWITCH, false);
        toolbar=findViewById(R.id.toolbar);


        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new
        ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);











        if(!mute) {
            mediaPlayer.start();
        }else{
        }
        if(darkModePref){
            RelativeLayout relativelayout = (findViewById(R.id.menumain));
            relativelayout.setBackground(getDrawable(R.drawable.main_menu_button_rd_dk));

            card1.setBackground(getDrawable(R.drawable.main_menu_button_og_dk_2));
            card2.setBackground(getDrawable(R.drawable.main_menu_button_og_dk_2));
            card3.setBackground(getDrawable(R.drawable.main_menu_button_og_dk_2));
            card4.setBackground(getDrawable(R.drawable.main_menu_button_og_dk_2));
            card5.setBackground(getDrawable(R.drawable.main_menu_button_og_dk_2));
            card6.setBackground(getDrawable(R.drawable.main_menu_button_og_dk_2));
            card7.setBackground(getDrawable(R.drawable.main_menu_button_og_dk_2));
            t1.setTextColor(getResources().getColor(R.color.white));
            t2.setTextColor(getResources().getColor(R.color.white));
            t3.setTextColor(getResources().getColor(R.color.white));
            t4.setTextColor(getResources().getColor(R.color.white));
            t5.setTextColor(getResources().getColor(R.color.white));
            t6.setTextColor(getResources().getColor(R.color.white));
            t7.setTextColor(getResources().getColor(R.color.white));




            getWindow().setStatusBarColor(getResources().getColor(R.color.qboard_black));
        }


      }

    public void acertijos(View view )
    {
        Intent intent = new Intent(MenuJuegos.this, niveles.class);
         startActivity(intent);
        finish();

    }
    public void Suma(View view )
    {
        Intent intent = new Intent(MenuJuegos.this, suma_resta_mul.class);
        intent.putExtra("operation", "add");
        startActivity(intent);
        finish();

     }

    public void Resta(View view )
    {
        Intent intent = new Intent(MenuJuegos.this, suma_resta_mul.class);
        intent.putExtra("operation", "sub");
        startActivity(intent);
        finish();

     }

    public void Multiplicacion(View view )
    {
        Intent intent = new Intent(MenuJuegos.this, suma_resta_mul.class);
        intent.putExtra("operation", "mul");
        startActivity(intent);
        finish();

    }

    public void Adivina(View view ){
        startActivity(new Intent(MenuJuegos.this, adivina_numero.class));
        finish();
        }
    public void Operaciones(View view){
        startActivity(new Intent(MenuJuegos.this, operaciones.class));

        finish();

    }
    public void correctoInco(View view){
        startActivity(new Intent(MenuJuegos.this, correcto_incorrecto.class));

        finish(); }
    public void Tiempo(View view){
        startActivity(new Intent(MenuJuegos.this, JuegoTiempo.class));

        finish();
    }    @Override
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
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
             
            case R.id.nav_acerca:
              //  startActivity();
          //un DetailModal
                break;
            case R.id.nav_calificar:
                String url = "https://play.google.com/store/apps/details?id=app.tercer.juegofinal";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                 break;
            case R.id.nav_share:
                String url2 = "https://play.google.com/store/apps/details?id=app.wena.formulasaprende";
                Intent i2 = new Intent(Intent.ACTION_VIEW);
                i2.setData(Uri.parse(url2));
                startActivity(i2);

                break;
            case R.id.nav_login:
                String facebookId = "fb://page/2182902815353778";
                String urlPage = "http://www.facebook.com/iFormulas";

                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookId )));
                } catch (Exception e) {
                    Toast.makeText(MenuJuegos.this, "Aplicacion FACEBOOK No instalada", Toast.LENGTH_SHORT).show();
                    //Abre url de pagina.
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlPage)));
                }

                break;

            case R.id.nav_profile:
                Intent compartir = new Intent(android.content.Intent.ACTION_SEND);
                compartir.setType("text/plain");
                String mensaje = "MathQuizz - Aprende mientras juegas. \nEntrena tu cerebro con diversos juegos que te haran volar la cabeza y al mismo tiempo aprender.\n Descarga aqui: https://play.google.com/store/apps/details?id=app.tercer.juegofinal ";
                compartir.putExtra(android.content.Intent.EXTRA_SUBJECT, "Aplicación Todo en uno");
                compartir.putExtra(android.content.Intent.EXTRA_TEXT, mensaje);
                startActivity(Intent.createChooser(compartir, "Compartir Via"));
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START); return true;
    }
}



