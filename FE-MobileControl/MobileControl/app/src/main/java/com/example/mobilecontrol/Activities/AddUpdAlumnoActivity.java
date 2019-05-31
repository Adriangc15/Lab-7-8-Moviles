package com.example.mobilecontrol.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobilecontrol.R;
import com.example.mobilecontrol.LogicaNegocio.Alumno;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddUpdAlumnoActivity extends AppCompatActivity {
    private FloatingActionButton fBtn;
    private boolean editable = true;
    private EditText nomFld;
    private EditText cedFld;
    private EditText emailFld;
    private EditText telFld;
    private EditText fechaFld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_upd_alumno);
        editable = true;

        // button check
        fBtn = findViewById(R.id.addUpdAlumoBtn);

        //cleaning stuff
        nomFld = findViewById(R.id.nombreAddUpdAlumno);
        cedFld = findViewById(R.id.cedulaAddUpdAlumno);
        emailFld = findViewById(R.id.emailAddUpdAlumno);
        telFld=findViewById(R.id.telefonoAddUpdAlumno);
        fechaFld=findViewById(R.id.fechaNacAddUpdAlumno);
        nomFld.setText("");
        cedFld.setText("");
        emailFld.setText("");
        telFld.setText("");
        fechaFld.setText("");

        //receiving data from admAlumnoActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            editable = extras.getBoolean("editable");
            if (editable) {   // is editing some row
                Alumno aux = (Alumno) getIntent().getSerializableExtra("alumno");
                cedFld.setText(aux.getCedula());
                cedFld.setEnabled(false);
                nomFld.setText(aux.getNombre());
                emailFld.setText(aux.getEmail());
                telFld.setText(Integer.toString(aux.getTelefono()));
                fechaFld.setText(aux.getFechaNacimiento());

                //edit action
                fBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editAlumno();
                    }
                });
            } else {         // is adding new Carrera object
                //add new action
                fBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addAlumno();
                    }
                });
            }
        }
    }

    public void addAlumno() {
        if (validateForm()) {
            //do something

            Alumno alumno = new Alumno(cedFld.getText().toString(), nomFld.getText().toString(),
                    Integer.parseInt(telFld.getText().toString()),
                    emailFld.getText().toString(),
                    fechaFld.getText().toString());
            Intent intent = new Intent(getBaseContext(), AdmAlumnoActivity.class);
            //sending Alumno data
            intent.putExtra("addAlumno", alumno);
            startActivity(intent);
            finish(); //prevent go back
        }
    }

    private Date ConvertToDate(String dateString){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return convertedDate;
    }
    public void editAlumno() {
        if (validateForm()) {
            Alumno alumno = new Alumno(cedFld.getText().toString(), nomFld.getText().toString(),
                    Integer.parseInt(telFld.getText().toString()),
                    emailFld.getText().toString(),
                    fechaFld.getText().toString());
            Intent intent = new Intent(getBaseContext(), AdmAlumnoActivity.class);
            //sending Alumno data
            intent.putExtra("editAlumno", alumno);
            startActivity(intent);
            finish(); //prevent go back
        }
    }

    public boolean validateForm() {
        int error = 0;
        if (TextUtils.isEmpty(this.nomFld.getText())) {
            nomFld.setError("Nombre requerido");
            error++;
        }
        if (TextUtils.isEmpty(this.cedFld.getText())) {
            cedFld.setError("Cedula requerida");
            error++;
        }
        if (TextUtils.isEmpty(this.emailFld.getText())) {
            emailFld.setError("Email requerido");
            error++;
        }
        if (TextUtils.isEmpty(this.telFld.getText())) {
            telFld.setError("Telefono requerido");
            error++;
        }
        if (TextUtils.isEmpty(this.fechaFld.getText())) {
            fechaFld.setError("Fecha requerido");
            error++;
        }
        if (error > 0) {
            Toast.makeText(getApplicationContext(), "Algunos errores", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
