package smktelkom.mirzauksyh.rekrutmen_arkademy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView txtHeader,txtOutput,txtOut;
    EditText txtInput;
    Button btnSubmit;
    String temp = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initComp();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "By.Mirza Ukasyah Yazdani", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void initComp() {
        txtHeader = findViewById(R.id.txtheader);
        txtOutput = findViewById(R.id.txtOutput1);
        txtOut = findViewById(R.id.txtOut);
        txtInput = findViewById(R.id.txtInput);
        btnSubmit = findViewById(R.id.btnSubmit);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav1) {
            txtHeader.setText("SOAL 1");
            txtOutput.setText("");
            returnJSON();
        } else if (id == R.id.nav2) {
            txtHeader.setText("SOAL 2");
            txtOutput.setText("");
            txtInput.setText("");
            txtInput.setHint("");
            usernameValidation();
        } else if (id == R.id.nav3) {
            txtHeader.setText("SOAL 3");
            txtOutput.setText("");
            txtInput.setText("");
            txtInput.setHint("");
            temp = "";
            segitiga();

        } else if (id == R.id.nav4) {
            txtHeader.setText("SOAL 4");
            txtOutput.setText("");
            txtInput.setText("");
            txtInput.setHint("");
            hitungHandshake();

        } else if (id == R.id.nav5) {
            txtHeader.setText("SOAL 5");
            txtOutput.setText("");
            txtInput.setText("");
            txtInput.setHint("");
            hitungChar();
        }
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void hitungChar() {
        txtInput.setVisibility(View.VISIBLE);
        btnSubmit.setVisibility(View.VISIBLE);
        txtOut.setVisibility(View.VISIBLE);
        txtInput.setHint("String [spasi] char");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] arrInput = txtInput.getText().toString().split(" ");
                String str = arrInput[0];
                char c =  arrInput[1].charAt(0);
                int count = 0;
                for(int i=0; i < str.length(); i++){
                    if(str.charAt(i) == c)
                        count++;
                }
                txtOutput.setText(String.valueOf(count));
            }
        });
    }

    private void hitungHandshake() {
        txtInput.setVisibility(View.VISIBLE);
        btnSubmit.setVisibility(View.VISIBLE);
        txtOut.setVisibility(View.VISIBLE);
        txtInput.setHint("Masukkan Banyak Orang");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(txtInput.getText().toString());
                int jmlh = 0;
                for (int i=1;i<count;i++){
                    jmlh += i;
                }
                txtOutput.setText(jmlh+"");

            }
        });
    }

    private void segitiga() {
        txtInput.setVisibility(View.VISIBLE);
        btnSubmit.setVisibility(View.VISIBLE);
        txtOut.setVisibility(View.VISIBLE);
        txtInput.setHint("Panjang Deret");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int deret = Integer.parseInt(txtInput.getText().toString());
                if(deret <= 10){
                    for(int i = 0;i<=deret;i++){
                        String t = "";
                        for(int x = 1;x<=i;x++){

                            t += x +",";
                        }
                        temp = temp + t + "\n";
                    }
                    txtOutput.setText(temp);

                }else{
                    txtOutput.setText("Panjang Deret tidak boleh lebih dari 10");
                }

            }
        });

    }

    private void usernameValidation() {
        txtInput.setVisibility(View.VISIBLE);
        btnSubmit.setVisibility(View.VISIBLE);
        txtOut.setVisibility(View.VISIBLE);
        txtInput.setHint("Input Username");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = String.valueOf(txtInput.getText());

                String firstfive = username.substring(0, 5);
                String firstsix = username.substring(5, 6);
                String lasttwo = username.substring(6, 8);
                String isLower = firstfive.toLowerCase();
                String isUpper = lasttwo.toUpperCase();
                if(firstfive.equals(isLower) && (firstsix.equals(".") || firstsix.equals("_")) && lasttwo.equals(isUpper)){
                    txtOutput.setText("Username Anda Valid");
                }else{
                    txtOutput.setText("Username Anda Tidak Valid");
                }
            }
        });

    }

    private void returnJSON() {
        txtOut.setVisibility(View.VISIBLE);
        JSONObject mainObject = new JSONObject();
        mainObject.put("itemId","12341822");
        mainObject.put("itemName","Basic T-shirt");
        mainObject.put("price",70000);
        JSONArray availArr = new JSONArray();
        JSONObject obj1 = new JSONObject();
        obj1.put("color","red");
        obj1.put("size","S,M,L");
        JSONObject obj2 = new JSONObject();
        obj2.put("color","solid black");
        obj2.put("size","M,L");
        availArr.add(obj1);
        availArr.add(obj2);
        mainObject.put("availableColorAndSize",availArr);
        mainObject.put("freeShiping",false);
        txtOutput.setText(mainObject.toJSONString());
    }

}
