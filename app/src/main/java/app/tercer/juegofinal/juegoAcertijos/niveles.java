package app.tercer.juegofinal.juegoAcertijos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mrntlu.toastie.Toastie;

import java.util.ArrayList;
import java.util.List;

import app.tercer.juegofinal.Adaptadores.CustomAdapter;
import app.tercer.juegofinal.Adaptadores.Spacecraft;
import app.tercer.juegofinal.AjustesDelJuego.Ajustes;
import app.tercer.juegofinal.MenuJuegos;
import app.tercer.juegofinal.PreferenciaNvl;
import app.tercer.juegofinal.R;
import app.tercer.juegofinal.juego3.JuegoTiempo;
import app.tercer.juegofinal.juego4.correcto_incorrecto;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class niveles extends AppCompatActivity {
    private CustomAdapter adaptador;
    Dialog epicDialog;
    ImageView cerrar;
    SharedPreferences sharedPref;
    Button botonvam,btnvam2;
    private GridView grid;
    nivel1 nvl = new nivel1();
    nivel2 nvl2 = new nivel2();
Boolean  level2;
RelativeLayout
        colorFondo;

     ArrayList<Spacecraft> listItems;
 TextView nvlactual;
CardView sisepode;
GridView item;
    SharedPreferences preferences;
    int Last_Level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);

      listItems = new ArrayList<>();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(niveles.this, MenuJuegos.class));
                finish();


            }
        });

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean darkModePref = sharedPref.getBoolean(Ajustes.KEY_DARK_MODE_SWITCH, false);

        colorFondo = findViewById(R.id.colorFondo);
        epicDialog = new Dialog(this);

        nvlactual = findViewById(R.id.nvlactual);
         level2 = nvl2.pasarnvl;
        grid = (GridView)  findViewById(R.id.item);
        item = findViewById(R.id.item);



            listItems.add(new Spacecraft((R.drawable.uno) ));
            listItems.add(new Spacecraft((R.drawable.dos) ));
            listItems.add(new Spacecraft((R.drawable.tres)));

            listItems.add(new Spacecraft((R.drawable.cuatro)));
            listItems.add(new Spacecraft((R.drawable.cinco)));
            listItems.add(new Spacecraft((R.drawable.seis)));

            listItems.add(new Spacecraft((R.drawable.siete)));
            listItems.add(new Spacecraft((R.drawable.ocho)));
            listItems.add(new Spacecraft((R.drawable.nueve)));
            listItems.add(new Spacecraft((R.drawable.diez)));

            listItems.add(new Spacecraft((R.drawable.once)));





        switch (PreferenciaNvl.getLevel(getApplicationContext())){

            case 0:
                //No realiza nada
                break;
            case 1:

                startActivity(new Intent(niveles.this, nivel1.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 1");

                break;
            case 2:
                startActivity(new Intent(niveles.this, nivel2.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 2");

                 break;
            case 3:
                startActivity(new Intent(niveles.this, nivel3.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 3");
                break;
            case 4:
                startActivity(new Intent(niveles.this, nivel4.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 4");

                break;
            case 5:
                startActivity(new Intent(niveles.this, nivel5.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 5");  break;
            case 6:
                startActivity(new Intent(niveles.this, nivel6.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 6"); break;
            case 7:
                startActivity(new Intent(niveles.this, nivel7.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 7"); break;
            case 8:
                startActivity(new Intent(niveles.this, nivel8.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 8");  break;

            case 9:
                startActivity(new Intent(niveles.this, nivel9.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 9"); break;

            case 10:
                startActivity(new Intent(niveles.this, nivel10.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 10");    break;
            case 11:
                startActivity(new Intent(niveles.this, nivel11.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 11"); break;


            default:
                nvlactual.setText(getString(R.string.nvlactu)+" 1");

        }
        adaptador = new CustomAdapter(this, listItems);
        grid.setAdapter(adaptador);





        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {


                if (position == 0) {

                    Intent intent = new Intent(niveles.this, nivel1.class);
                    startActivity(intent);

                }


                if (position == 1) {


                    if (Clickable(2))
                    {
                         Intent intent = new Intent(niveles.this, nivel2.class);
                        intent.putExtra(PreferenciaNvl.Intent_Row,2);

                        startActivity(intent);
                    }


                }

                if (position == 2) {
                    if (Clickable(3))
                    {

                        Intent intent = new Intent(niveles.this, nivel3.class);
                        intent.putExtra(PreferenciaNvl.Intent_Row,3);
                        startActivity(intent);
                    }

                }

                if (position == 3) {
                    if (Clickable(4))
                    {

                        Intent intent = new Intent(niveles.this, nivel4.class);
                        startActivity(intent);
                    }
                }

                if (position == 4) {
                    if (Clickable(5))
                    {

                        Intent intent = new Intent(niveles.this, nivel5.class);
                        startActivity(intent);

                    }
            //       isEnabled(4);

                }

                if (position == 5) {
                //     if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==6)
                    if (Clickable(6))
                    {

                        Intent intent = new Intent(niveles.this, nivel6.class);
                        startActivity(intent);

                    }
                 //   isEnabled(5);

                }

                if (position == 6) {
                    //  if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==7)
                    if (Clickable(7))  {

                        Intent intent = new Intent(niveles.this, nivel7.class);
                        startActivity(intent);

                    }
                    //  isEnabled(6);

                }

                if (position == 7) {
                    //   if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==8)
                    if (Clickable(8))
                    {

                        Intent intent = new Intent(niveles.this, nivel8.class);
                        startActivity(intent);

                    }
                    //    isEnabled(7);

                }

                if (position == 8) {
                    //      if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==9)
                    if (Clickable(9))  {

                        Intent intent = new Intent(niveles.this, nivel9.class);
                        startActivity(intent);

                    }
                    //    isEnabled(8);

                }

                if (position == 9) {
                    //   if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==10)
                    if (Clickable(10))  {

                        Intent intent = new Intent(niveles.this, nivel10.class);
                        startActivity(intent);

                    }
                    //      isEnabled(9);

                }
                if (position == 10) {
                    //   if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==11)
                    if (Clickable(11))    {

                        Intent intent = new Intent(niveles.this, nivel11.class);
                        startActivity(intent);

                    }
                    //     isEnabled(10);

                }



            }
        });

        //el metodo ya esta, solamente es
        //1- Encontrar algo que recargue las preferencias
        //2- Identificar otro tipo de valor para la variable "default value", algo que sea identico al getlevel();
        Last_Level=getSharedPreferences(PreferenciaNvl.Shared_Preferences,MODE_PRIVATE).getInt(PreferenciaNvl.Last_Level,PreferenciaNvl.getLevel(this));

}
    boolean Clickable (int lvl)
    {
        if (lvl<=Last_Level)
            return true;
        return false;
    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(niveles.this,MenuJuegos.class));
        finish();
    }



}


