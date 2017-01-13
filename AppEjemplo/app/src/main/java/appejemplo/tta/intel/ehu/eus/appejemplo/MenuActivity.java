package appejemplo.tta.intel.ehu.eus.appejemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    public final static String EXTRA_LOGIN = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent= getIntent();
        //TextView textLogin = (TextView)findViewById(R.id.menu_login);
        //textLogin.setText(intent.getStringExtra(EXTRA_LOGIN));
    }

    public void test(View view) {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);//pasa a la pantalla donde se ha expecificado el intent
    }
    public void ejercicio(View view) {
        Intent intent = new Intent(this, ExerciseActivity.class);
        startActivity(intent);//pasa a la pantalla donde se ha expecificado el intent
    }
}
