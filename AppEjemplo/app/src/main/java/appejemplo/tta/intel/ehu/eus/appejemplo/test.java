package appejemplo.tta.intel.ehu.eus.appejemplo;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;


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

        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);
    }


    public void enviar (View v){
        LinearLayout layout = (LinearLayout)findViewById(R.id.test_layout);
        int correct = 3;

        RadioGroup group = (RadioGroup)findViewById(R.id.test_choices);
        int choice= group.getChildCount();
        for(int i=0; i<choice; i++){
            group.getChildAt(i).setEnabled(false);      //deshabilitar todos los botones
        }
        layout.removeView(findViewById(R.id.button_send_test));
        int selected = group.getCheckedRadioButtonId();

        group.getChildAt(correct).setBackgroundColor(Color.GREEN);

        if(selected!= correct) {
            group.getChildAt(selected).setBackgroundColor(Color.RED);
            Toast.makeText(getApplicationContext(), "Has fallado!", Toast.LENGTH_SHORT).show();
            if (selected==1){
                findViewById(R.id.button_vieew_advise).setVisibility(View.VISIBLE);
            }
            if (selected==2){
                findViewById(R.id.button_vieew_advise2).setVisibility(View.VISIBLE);
            }
            if (selected==4){
                findViewById(R.id.button_vieew_advise4).setVisibility(View.VISIBLE);
            }
            if (selected==5){
                findViewById(R.id.button_vieew_advise5).setVisibility(View.VISIBLE);
            }


        }else{
           Toast.makeText(getApplicationContext(),"Correcto!",Toast.LENGTH_SHORT).show();
        }
    }


    //ayuda en texto
    public void ayuda (View v){
        LinearLayout layout = (LinearLayout)findViewById(R.id.test_layout);
        layout.removeView(findViewById(R.id.button_vieew_advise2));
        findViewById(R.id.textodeayuda).setVisibility(View.VISIBLE);
    }


    //ayuda web
    public void showHtml (View view){
        LinearLayout layout = (LinearLayout)findViewById(R.id.test_choices);
        //String advise="<html><body><p>Mensaje de Ayuda</p></body></html>";
        String advise ="https://www.google.es/?gws_rd=ssl";
        if(advise.substring(0,10).contains("://")) {
            Uri uri = Uri.parse(advise);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }else{//NO VA
            WebView web = new WebView(this);
            web.loadData(advise,"test/html",null);
            web.setBackgroundColor(Color.TRANSPARENT);
            web.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
            layout.addView(web);
            layout.removeView(findViewById(R.id.button_vieew_advise));
        }
    }

    //ayuda video
    public void showVideo (View v){
        LinearLayout layout = (LinearLayout)findViewById(R.id.test_layout);

        String advise = "http://u017633.ehu.eus:28080/static/ServidorTta/AndroidManifest.mp4";
        VideoView video = new VideoView(this);
        video.setVideoURI(Uri.parse(advise));

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        video.setLayoutParams(params);

        MediaController controller = new MediaController(this){
            @Override
            public void hide(){

            }
            @Override
            public boolean dispatchKeyEvent (KeyEvent event){
                if(event.getKeyCode() == KeyEvent.KEYCODE_BACK) finish();
                return super.dispatchKeyEvent(event);
            }
        };
        controller.setAnchorView(video);
        video.setMediaController(controller);

        layout.addView(video);
        video.start();

    }

    //ayuda audio
    public void showAudio (View v){
        LinearLayout layout = (LinearLayout)findViewById(R.id.test_layout);

        String advise = "http://u017633.ehu.eus:28080/static/ServidorTta/AndroidManifest.mp4";
        AudioPlayer audio = new AudioPlayer(v);
        MediaPlayer mp = new MediaPlayer();
       //mp.setOnPreparedListener(audio);
        try {
            audio.setAudioUri(Uri.parse(advise));
        } catch (IOException e) {
            e.printStackTrace();
        }
        audio.onPrepared(mp);
        audio.start();

    }
}



