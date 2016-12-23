package appejemplo.tta.intel.ehu.eus.appejemplo;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


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



    }

    @Override
    public void onClick(View v) {
        LinearLayout layout = (LinearLayout)findViewById(R.id.test_layout);

        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);

        RadioGroup group = (RadioGroup)findViewById(R.id.test_choices);
        int choice= group.getChildCount();
        for(int i=0; i<choice; i++){
            group.getChildAt(i).setEnabled(false);
        }
        layout.removeView(findViewById(R.id.button_send_test));
        group.getChildAt(2).setBackgroundColor(Color.GREEN);
       /* if(selected!= correct){
            group.getChildAt(selected).setBackgroundColor(Color.RED);
            Toast.makeText(getApplicationContext(), "Has fallado!", Toast.LENGTH_SHORT);
            if(advise != null && !advise.isEmpty()){
                findViewById(R.id.button_vieew_advise);
            }else{
                Toast.makeText(getApplicationContext(),"Correcto!",Toast.LENGTH_SHORT);
            }
            
        }*/

    }

    private void showHtml (String advise){
        if(advise.substring(0,10).contains("://")) {
            Uri uri = Uri.parse(advise);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }else{
            WebView web = new WebView(this);
            web.loadData(advise,"test/html",null);
            web.setBackgroundColor(Color.TRANSPARENT);
            web.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
        }
    }
}

