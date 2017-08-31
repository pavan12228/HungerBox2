package justjava.android.example.packagecom.hungerbox;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mtxtForgot, mtxtSignup;
    TextInputLayout textInputEmail, textInputPwd;
    EditText EtInputEmail, EtInputpwd;
    Button btnLogin, btnclear;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInputEmail = (TextInputLayout) findViewById(R.id.textInputEmail);
        textInputPwd = (TextInputLayout) findViewById(R.id.textInputPwd);
        EtInputEmail = (EditText) findViewById(R.id.EtInputEmail);
        EtInputpwd = (EditText) findViewById(R.id.EtInputpwd);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sEmail = EtInputEmail.getText().toString().trim();
                String sPwd = EtInputpwd.getText().toString().trim();
                if (sEmail.length() == 0) {
                    textInputEmail.setError("First name is required!");
                    textInputPwd.setErrorEnabled(false);
                    textInputEmail.setErrorTextAppearance(R.style.TextAppearance_AppCompat);
                } else if (sPwd.length() == 0) {
                    textInputPwd.setError("password is required!");
                    textInputEmail.setErrorEnabled(false);
                    textInputPwd.setErrorTextAppearance(R.style.TextAppearance_AppCompat);
                }
            }

        });

        btnclear = (Button) findViewById(R.id.btnClear);
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sEmail = EtInputEmail.getText().toString().trim();
                String sPwd = EtInputpwd.getText().toString().trim();
                EtInputEmail.setText("");
                EtInputpwd.setText("");
            }
        });


        mtxtForgot = (TextView) findViewById(R.id.mtxtForgot);
        if (mtxtForgot != null) {
            mtxtForgot.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        }
        mtxtForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialog_layout, null);
                final TextInputLayout textInputPwd = (TextInputLayout) mView.findViewById(R.id.textInputPwd);
                final EditText sPasssword = (EditText) mView.findViewById(R.id.EtInputpwd);
                final Button btnSubmit = (Button) mView.findViewById(R.id.btnSubmit);
                final Button btnCancel = (Button) mView.findViewById(R.id.btnCancel);

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }



                });

                builder.setView(mView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }


        });
        mtxtSignup = (TextView) findViewById(R.id.mtxtSignup);
        mtxtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                 builder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.activity_signup, null);
                final TextInputLayout text_Input_First_Name = (TextInputLayout) mView.findViewById(R.id.text_Input_First_Name);
                final TextInputLayout text_Input_Email = (TextInputLayout) mView.findViewById(R.id.text_Input_Email);
                final TextInputLayout text_Input_First_Password = (TextInputLayout) mView.findViewById(R.id.text_Input_First_Password);
                final TextInputLayout text_Input_First_confirm_Password = (TextInputLayout) mView.findViewById(R.id.text_Input_First_confirm_Password);
                final EditText et_input_first_Nname = (EditText) mView.findViewById(R.id.et_input_first_Nname);
                final EditText et_input_email = (EditText) mView.findViewById(R.id.et_input_email);
                final EditText EtInputpwd = (EditText) mView.findViewById(R.id.EtInputpwd);
                final EditText et_confirm_pwd = (EditText) mView.findViewById(R.id.et_confirm_pwd);
                final Button btnSubmit = (Button) mView.findViewById(R.id.btnSubmit);
                final Button btnCancel = (Button) mView.findViewById(R.id.btnCancel);


                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                      startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }



                });
                builder.setView(mView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }



        });
    }
}
