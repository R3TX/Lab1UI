package lab1ui.gr7.compumovil.udea.edu.co.lab1ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    AdapterItem aihobies ;
    AdapterItem aipaises;
    String pais;
    String hobie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerPaises = (Spinner) findViewById(R.id.sPaises);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.paises, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

         aihobies = new AdapterItem();
        aipaises = new AdapterItem();

        spinnerPaises.setOnItemSelectedListener(aipaises);
        spinnerPaises.setAdapter(adapter);
        Spinner spinnerHobbies = (Spinner) findViewById(R.id.sHobbies);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.hobbies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHobbies.setAdapter(adapter2);
        spinnerHobbies.setOnItemSelectedListener( aihobies);



        EditText nombre, telefono, email, apellidos, direccion;
        TextView fNacimiento;
        CheckBox favorito= (CheckBox)  findViewById(R.id.cHFavorito);
        RadioGroup radioGroup = ( RadioGroup) findViewById(R.id.rGroup);

        nombre = (EditText) findViewById(R.id.eTNombres);
        apellidos = (EditText) findViewById(R.id.eTapellidos);
        direccion = (EditText) findViewById(R.id.eTDireccion);
        fNacimiento = (TextView) findViewById(R.id.txtDate);
        telefono = (EditText) findViewById(R.id.eTTelefono);
        email = (EditText) findViewById(R.id.eTEmail);
        Button mostrar= (Button) findViewById(R.id.btnMostrar);

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pais=aipaises.getStringSelected();
                hobie=aihobies.getStringSelected();

                Toast.makeText(MainActivity.this, pais,Toast.LENGTH_SHORT).show();
            }
        });

      //  mostrar.setOnClickListener();



        dateView = (TextView) findViewById(R.id.txtDate);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
    }
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                .show();
    }


    public void mostrar(){
        pais=aipaises.getStringSelected();
        hobie=aihobies.getStringSelected();

        Toast.makeText(this, pais,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
}
