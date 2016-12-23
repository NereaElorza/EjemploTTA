package appejemplo.tta.intel.ehu.eus.appejemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class menu extends AppCompatActivity {

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
        Intent intent = new Intent(this, test.class);
        startActivity(intent);//pasa a la pantalla donde se ha expecificado el intent
    }
    public void ejercicio(View view) {
        Intent intent = new Intent(this, exercise.class);
        startActivity(intent);//pasa a la pantalla donde se ha expecificado el intent
    }
}
