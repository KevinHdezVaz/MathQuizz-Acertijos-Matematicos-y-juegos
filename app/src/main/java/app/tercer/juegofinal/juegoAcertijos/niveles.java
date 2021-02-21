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
Boolean itemsLocked,level2;
RelativeLayout
        colorFondo;
    Toolbar toolbar;
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
            listItems.add(new Spacecraft((R.drawable.doce)));
            listItems.add(new Spacecraft((R.drawable.trece)));
            listItems.add(new Spacecraft((R.drawable.catorce)));
            listItems.add(new Spacecraft((R.drawable.quice)));
            listItems.add(new Spacecraft((R.drawable.diesiseis)));
            listItems.add(new Spacecraft((R.drawable.diesisiete)));
            listItems.add(new Spacecraft((R.drawable.diesiocho)));
            listItems.add(new Spacecraft((R.drawable.diesnueve)));
            listItems.add(new Spacecraft((R.drawable.veinte)));
            listItems.add(new Spacecraft((R.drawable.veintiuno)));
            listItems.add(new Spacecraft((R.drawable.veintidos)));
            listItems.add(new Spacecraft((R.drawable.veintitres)));
            listItems.add(new Spacecraft((R.drawable.veinticuatro)));
            listItems.add(new Spacecraft((R.drawable.veinticinco)));
            listItems.add(new Spacecraft((R.drawable.veintiseis)));
            listItems.add(new Spacecraft((R.drawable.veintisiete)));
            listItems.add(new Spacecraft((R.drawable.veintiocho)));
            listItems.add(new Spacecraft((R.drawable.veintinueve)));
            listItems.add(new Spacecraft((R.drawable.treinta)));





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
            case 12:
                startActivity(new Intent(niveles.this, nivel12.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 12");  break;
            case 13:
                startActivity(new Intent(niveles.this, nivel13.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 13");  break;
            case 14:
                startActivity(new Intent(niveles.this, nivel14.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 14"); break;

            case 15:
                startActivity(new Intent(niveles.this, nivel15.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 15"); break;
            case 16:
                startActivity(new Intent(niveles.this, nivel16.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 16");  break;
            case 17:
                startActivity(new Intent(niveles.this, nivel17.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 17"); break;
            case 18:
                startActivity(new Intent(niveles.this, nivel18.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 18"); break;
            case 19:
                startActivity(new Intent(niveles.this, nivel19.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 19"); break;
            case 20:
                startActivity(new Intent(niveles.this, nivel20.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 20"); break;
            case 21:
                startActivity(new Intent(niveles.this, nivel21.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 21");  break;
            case 22:
                startActivity(new Intent(niveles.this, nivel22.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 22"); break;
            case 23:
                startActivity(new Intent(niveles.this, nivel23.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 23");   break;

            case 24:
                startActivity(new Intent(niveles.this, nivel24.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 24");  break;
            case 25:
                startActivity(new Intent(niveles.this, nivel25.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 25");  break;
            case 26:
                startActivity(new Intent(niveles.this, nivel26.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 26");  break;
            case 27:
                startActivity(new Intent(niveles.this, nivel27.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 27"); break;
            case 28:
                startActivity(new Intent(niveles.this, nivel28.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 28");  break;
            case 29:
                startActivity(new Intent(niveles.this, nivel29.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 29");  break;
            case 30:
                startActivity(new Intent(niveles.this, nivel30.class));
                nvlactual.setText(getString(R.string.nvlactu)+" 30"); break;

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
                if (position == 11) {
                    // if (PreferenciaNvl.getlvlCompleto(getApplicationContext()) == 12)
                    if (Clickable(12))  {


                    Intent intent = new Intent(niveles.this, nivel12.class);
                    startActivity(intent);

                }
                // isEnabled(11);

            }
                if(position==12) {
                 //   if (PreferenciaNvl.getlvlCompleto(getApplicationContext()) == 13)
                    if (Clickable(13))   {


                        Intent intent = new Intent(niveles.this, nivel13.class);
                        startActivity(intent);

                    }
                  //  isEnabled(12);
                }
                if(position==13) {
                    if (Clickable(14))  {

                        Intent intent = new Intent(niveles.this, nivel14.class);
                        startActivity(intent);

                    }

                }
                if(position==14) {
                    if (Clickable(15))  {

                        Intent intent = new Intent(niveles.this, nivel15.class);
                        startActivity(intent);

                    }

                }
                if(position==15) {
                    if (Clickable(16))  {

                        Intent intent = new Intent(niveles.this, nivel16.class);
                        startActivity(intent);

                    }

                }
                if(position==16) {
                    if (Clickable(17))  {

                        Intent intent = new Intent(niveles.this, nivel17.class);
                        startActivity(intent);

                    }

                }
                if(position==17) {
                    if (Clickable(18))  {
                        Intent intent = new Intent(niveles.this, nivel18.class);
                        startActivity(intent);
                    }

                // isEnabled(17);

                }      if(position==18) {
                  //  if (PreferenciaNvl.getlvlCompleto(getApplicationContext()) == 19)
                    if (Clickable(19))  {

                        Intent intent = new Intent(niveles.this, nivel19.class);
                    startActivity(intent);
                }

                //    isEnabled(18);

                }      if(position==19) {
                 //   if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==20)
                    if (Clickable(20))  {

                        Intent intent = new Intent(niveles.this, nivel20.class);
                        startActivity(intent);

                    }

              //      isEnabled(19);

                }
                if(position==20) {

                  //  if (Clickable(21))  {

                        Intent intent = new Intent(niveles.this, nivel21.class);
                        startActivity(intent);

                   // }

                  //  isEnabled(20);

                }
                if(position==21) {
                  //  if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==22)
                    if (Clickable(22))  {
                        Intent intent = new Intent(niveles.this, nivel22.class);
                        startActivity(intent);
                    }

                  //  isEnabled(21);

                }
                if(position==22) {
                 //   if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==23)
                    if (Clickable(23))  {
                        Intent intent = new Intent(niveles.this, nivel23.class);
                        startActivity(intent);

                    }

                //    isEnabled(22);

                }   if(position==23) {
                  //  if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==24)
                    if (Clickable(24))  {
                        Intent intent = new Intent(niveles.this, nivel24.class);
                        startActivity(intent);
                    }

                   // isEnabled(23);

                }
                if(position==24)
                {
                    //    if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==25)
                    if (Clickable(25))  {
                       Intent intent = new Intent(niveles.this, nivel25.class);
                       startActivity(intent);
                   }

                  //  isEnabled(24);

                }
                if(position==25) {
             //       if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==26)
                    if (Clickable(26))  {

                        Intent intent = new Intent(niveles.this, nivel26.class);
                        startActivity(intent);
                    }

                 //   isEnabled(25);

                }
                if(position==26) {
                  //  if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==27)
                    if (Clickable(27))  {
                        Intent intent = new Intent(niveles.this, nivel27.class);
                        startActivity(intent);
                    }

                  // isEnabled(26);

                }
                if(position==27) {
                  //   if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==28)
                    if (Clickable(28))  {
                         Intent intent = new Intent(niveles.this, nivel28.class);
                         startActivity(intent);
                     }

                  //   isEnabled(27);

                }
                if(position==28) {
                    if (Clickable(29))  {
                       Intent intent = new Intent(niveles.this, nivel29.class);
                       startActivity(intent);
                   }

                //   isEnabled(28);

                }
                if(position==29) {
                 //   if(PreferenciaNvl.getlvlCompleto(getApplicationContext() ) ==30)
                    if (Clickable(30))  {
                        Intent intent = new Intent(niveles.this, nivel30.class);
                        startActivity(intent);
                    }

                   // isEnabled(29);

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


