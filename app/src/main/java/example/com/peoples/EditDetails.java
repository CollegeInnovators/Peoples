package example.com.peoples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditDetails extends AppCompatActivity {
    private EditText fname,lname,country,pos;
    private PlayerDetails[] playerDetails;
    private Button submit;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);
        Bundle extra = getIntent().getExtras();
        if(extra!=null){
            playerDetails = (PlayerDetails[]) extra.getSerializable("obj");
            position = extra.getInt("position");
        }

        fname = findViewById(R.id.editText);
        lname = findViewById(R.id.editText2);
        country = findViewById(R.id.editText3);
        submit = findViewById(R.id.update);
        pos = findViewById(R.id.editText4);

        fname.setText(playerDetails[position].firstName);
        lname.setText(playerDetails[position].lastName);
        country.setText(playerDetails[position].country);
        pos.setText(playerDetails[position].position);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerDetails[position].firstName = fname.getText().toString();
                playerDetails[position].lastName = lname.getText().toString();
                playerDetails[position].country = country.getText().toString();
                playerDetails[position].country = pos.getText().toString();

                Intent intent = new Intent(EditDetails.this, ProfilesActivity.class);
                intent.putExtra("obj",playerDetails)
                        .putExtra("pos",position);
                startActivity(intent);
                finish();


            }
        });


    }
}
