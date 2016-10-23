package com.example.viknox.smtest.pricecart;



        import android.app.Activity;
        import android.app.Dialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class LoginActivity extends Activity
{
    Button btnSignIn;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // create a instance of SQLite Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        // Get The Refference Of Buttons
        btnSignIn=(Button)findViewById(R.id.buttonSignIn);
        // btnSignUp=(Button)findViewById(R.id.buttonSignUP);

        // Set OnClick Listener on SignUp button
        //btnSignUp.setOnClickListener(new View.OnClickListener()

    }
    // Methos to handleClick Event of Sign In - id/buttonSignIn
    public void signIn_Click(View V)
    {
//			final Dialog dialog = new Dialog(LoginActivity.this); //Focus 2nd Dialog
//			dialog.setContentView(R.layout.activity_login); //
//		    dialog.setTitle("Login"); //
//
//		    // get the Refferences of views
        //final  EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
        //final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);
        EditText editTextUserName=(EditText)findViewById(R.id.editTextUserNameToLogin);
        EditText editTextPassword=(EditText)findViewById(R.id.editTextPasswordToLogin);
        //Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);

        // Set On ClickListener
        //btnSignIn.setOnClickListener(new View.OnClickListener()
        {

            //public void onClick(View v)
            {
                // get The User name and Password
                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();

                // fetch the Password form database for respective user name
                String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);

                // check if the Stored password matches with  Password entered by user
                if(password.equals(storedPassword))
                {
                    Toast.makeText(LoginActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    //dialog.dismiss();
                    Intent intent = new Intent(LoginActivity.this, SearchEngine.class); //TO BE CHANGED to Searchng.class If login ok, goes to Search!
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        }//);

        //dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }


    public void RegisterBTNclick(View v) //calling Register activity
    {

        Intent intent = new Intent(LoginActivity.this, RegisterC.class);
        startActivity(intent);
    }

    // For faster testing of Search, click without Sign in or Register
    public void testSearch(View v) //calling Register activity
    {

        Intent intent = new Intent(LoginActivity.this, SearchEngine.class);
        startActivity(intent);
    }
}
