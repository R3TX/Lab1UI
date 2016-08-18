package lab1ui.gr7.compumovil.udea.edu.co.lab1ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    private  AdapterItem aihobies, aipaises ;
    private String sexo;
    private EditText nombre, telefono, email, apellidos, direccion;
    private TextView fNacimiento;
    private CheckBox favorito;
    private RadioGroup radioGroup;
    private TextView  txtName, txtApellidos, txtSexo,txtTelefono, txtDireccion, txtEmail, txtHobbies, txtPaises, txtDateLabel,txtMostrar, dateView;
    private Spinner spinnerPaises, spinnerHobbies;
    private ArrayAdapter<CharSequence> adapter, adapter2;
    private Button mostrar;
    private RadioButton rG, rGM;
    private int orientation;

    private void iniciar(){
        orientation= this.getResources().getConfiguration().orientation;
        //sppiner
        spinnerPaises = (Spinner) findViewById(R.id.sPaises);
        spinnerHobbies = (Spinner) findViewById(R.id.sHobbies);
        //itemlistener spiners
        aihobies = new AdapterItem();
        aipaises = new AdapterItem();
        //adapter spinner
        //adapter de datos del spiner paises
        adapter = ArrayAdapter.createFromResource(this,
                R.array.paises, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter de datos de hobies
        adapter2 = ArrayAdapter.createFromResource(this,
                R.array.hobbies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //agregamos los adapter
        spinnerPaises.setOnItemSelectedListener(aipaises);
        spinnerPaises.setAdapter(adapter);
        spinnerHobbies.setAdapter(adapter2);
        spinnerHobbies.setOnItemSelectedListener( aihobies);

        //encontramos los edit text
        nombre = (EditText) findViewById(R.id.eTNombres);
        apellidos = (EditText) findViewById(R.id.eTapellidos);
        direccion = (EditText) findViewById(R.id.eTDireccion);
        fNacimiento = (TextView) findViewById(R.id.txtDate);
        telefono = (EditText) findViewById(R.id.eTTelefono);
        email = (EditText) findViewById(R.id.eTEmail);

        //iniciamos el checkbox
        favorito= (CheckBox)  findViewById(R.id.cHFavorito);
        //iniciamos el radiogroup
        radioGroup = ( RadioGroup) findViewById(R.id.rGroup);
        //iniciamos el botton
        mostrar= (Button) findViewById(R.id.btnMostrar);

        //inicamos los textview
        txtName =(TextView) findViewById(R.id.txtName);
        txtApellidos=(TextView)findViewById(R.id.txtApellido);
        txtSexo = (TextView)findViewById(R.id.txtSexo);
        txtTelefono=(TextView)findViewById(R.id.txtTelefono);
        txtDireccion=(TextView)findViewById(R.id.txtDireccion);
        txtEmail= (TextView)findViewById(R.id.txtEmail);
        txtHobbies=(TextView)findViewById(R.id.txtHobbies);
        txtPaises =(TextView) findViewById(R.id.txtPaises);
        txtDateLabel=(TextView)findViewById(R.id.txtDateLabel);
        dateView = (TextView) findViewById(R.id.txtDate);
        txtMostrar = (TextView) findViewById(R.id.txtMostrar);
        //radiobuton
        rG=(RadioButton)findViewById(R.id.rFemenino);
        rGM=(RadioButton)findViewById(R.id.rMasculino);
    }
    private void mostrar(){
        if(!validad()){
            AlertDialog.Builder alertDialog= new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle(this.getString(R.string.warningMust));

            alertDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                }
            });
            alertDialog.show();
            return;
        }





        StringBuffer datos = new StringBuffer();

        datos.append(txtName.getText().toString()+" :\n");
        datos.append(nombre.getText().toString()+"\n");
        if(!apellidos.getText().toString().trim().equals("")) {
            datos.append(txtApellidos.getText().toString() + ":\n");
            datos.append(apellidos.getText().toString() + "\n");
        }
        datos.append(txtSexo.getText().toString()+":\n");
        datos.append(sexo+ "\n");
        datos.append(txtDateLabel.getText().toString()+":\n");
        datos.append(dateView.getText().toString()+"\n");
        datos.append(txtPaises.getText().toString()+":\n");
        datos.append(aipaises.getStringSelected().toString()+"\n");
        datos.append(txtTelefono.getText().toString()+":\n");
        datos.append(telefono.getText().toString()+"\n");
        if(!direccion.getText().toString().trim().equals("")) {
            datos.append(txtDireccion.getText().toString() + ":\n");
            datos.append(direccion.getText().toString() + "\n");
        }
        datos.append(txtEmail.getText().toString()+":\n");
        datos.append(email.getText().toString()+"\n");
        datos.append(txtHobbies.getText().toString()+":\n");
        datos.append(aihobies.getStringSelected().toString()+"\n");
        datos.append(favorito.getText().toString()+":\n");
        datos.append(favorito.isChecked());



        txtMostrar.setText(datos.toString());
    }
    private boolean validad(){
        if(!nombre.getText().toString().trim().equals("") && !email.getText().toString().trim().equals("") && !telefono.getText().toString().trim().equals("")){
            return true;
        }
        return false;
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rFemenino:
                if (checked)
                    rG = (RadioButton) findViewById(R.id.rFemenino);
                    sexo = rG.getText().toString();
                    break;
            case R.id.rMasculino:
                if (checked)
                    rG = (RadioButton) findViewById(R.id.rMasculino);
                    sexo = rG.getText().toString();
                    break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar();
        sexo = this.getString(R.string.rF);



        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mostrar();
            }
        });




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


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LinearLayout ly = (LinearLayout) findViewById(R.id.principal);

        if(0x2 == this.getResources().getConfiguration().orientation){//landscape

            ly.setOrientation(LinearLayout.HORIZONTAL);

        }else {
            ly.setOrientation(LinearLayout.VERTICAL);

        }
        nombre.setText(savedInstanceState.getString("name"));
        apellidos.setText(savedInstanceState.getString("apellidos"));
        telefono.setText(savedInstanceState.getString("telefono"));
        email.setText(savedInstanceState.getString("email"));
        direccion.setText(savedInstanceState.getString("direccion"));
        rG.setChecked(savedInstanceState.getBoolean("female"));
        rGM.setChecked(savedInstanceState.getBoolean("male"));
        dateView.setText(savedInstanceState.getString("date"));
        favorito.setChecked(savedInstanceState.getBoolean("favor"));
        txtMostrar.setText(savedInstanceState.getString("mostrar"));
                //nombre, telefono, email, apellidos, direccion, rG, dateView, favorito, txtMostrar, orientacion

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putString("name", nombre.getText().toString());
        outState.putString("apellidos", apellidos.getText().toString());
        outState.putString("telefono", telefono.getText().toString());
        outState.putString("email", email.getText().toString());
        outState.putString("direccion", direccion.getText().toString());
        outState.putBoolean("female", rG.isChecked());
        outState.putBoolean("male", rGM.isChecked());
        outState.putString("date", dateView.getText().toString());
        outState.putBoolean("favor", favorito.isChecked());
        outState.putString("mostrar", txtMostrar.getText().toString());
        outState.putInt("orientacion", orientation);

    }
}
