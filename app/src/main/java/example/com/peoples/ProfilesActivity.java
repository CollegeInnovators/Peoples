package example.com.peoples;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProfilesActivity extends AppCompatActivity {
    PlayerDetails[] playerDetails, playerDetails2;
    int position;
    private TextView fname,sname, pos, country;
    ImageView profileimage;
    Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);
        Bundle extra = getIntent().getExtras();

        if (extra != null) {
            playerDetails = (PlayerDetails[])extra.getSerializable("obj");
            position = extra.getInt("pos");
        }

        fname = findViewById(R.id.tv_real_name);
        sname = findViewById(R.id.textView);
        pos = findViewById(R.id.tv_real_position);
        country = findViewById(R.id.tv_real_country);
        profileimage = findViewById(R.id.iv_profile);
        goBack = findViewById(R.id.button);
        fname.setText(playerDetails[position].firstName);
        sname.setText(playerDetails[position].lastName);
        pos.setText(playerDetails[position].position);
        country.setText(playerDetails[position].country);
        int resID = getResources().getIdentifier(playerDetails[position].imageName , "mipmap", getPackageName());
        profileimage.setImageBitmap(BitmapFactory.decodeResource(getResources(), resID));


        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilesActivity.this, MainActivity.class);
                intent.putExtra("obj", playerDetails);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_details,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_edit){
            Intent intent = new Intent(ProfilesActivity.this, EditDetails.class);
            intent.putExtra("obj",playerDetails)
                    .putExtra("position", position);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
