package appejemplo.tta.intel.ehu.eus.appejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class test extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        String cadena[]={"Version de la aplicacion","Listado de componentes de la aplicacion","Opciones del menu de ajustes","Nivel minimo de la API Android requerida","Nombre del paquete java de la aplicacion"};
        RadioGroup group = (RadioGroup)findViewById(R.id.test_choices);
        for(int i=0; i<5; i++){
            RadioButton radio = new RadioButton(this);
            radio.setText(cadena[i]);
            radio.setOnClickListener(this);
            group.addView(radio);
        }
       /* int choice= group.getChildCount();
        for(int i=0; i<choice; i++){
            group.getChildAt(i).setEnabled(false);
        }*/
    }

    @Override
    public void onClick(View v) {
        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);
    }
}
