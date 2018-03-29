package example.com.peoples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    PeopleAdapter peopleAdapter;

    PlayerDetails[] details = {
            new PlayerDetails("David", "Ospina","Goalkeeper","Colombia","david_ospina", "david_large"),
            new PlayerDetails("Petr","Cech","Goalkeeper" ,"Czech Republic","peter_cech", "petr_large"),
            new PlayerDetails("Per","Mertesacker","Defender","Germany","per_mertesacker", "per_large"),
            new PlayerDetails("Laurent","Koscienly","Defender","France","laurent_koscienlny", "laurent_koscienlny"),
            new PlayerDetails("ROB","Holding","Defender","England","rob_holding", "rob_holding"), new PlayerDetails("Shkodran","Mustafi","Defender","Germany","shkodran_mustafi", "shkodran_mustafi"),
            new PlayerDetails("Calum","Chambers","Defender","Engaland","calum_chambers", "calum_chambers"),
            new PlayerDetails("Hector","Bellerin","Defender","Spain","hector_bellern", "hector_bellern"),
            new PlayerDetails("Sead","Kolasinac","Defender","Greece","sead_kolasinac", "sead_kolasinac"),
            new PlayerDetails("Henrikh","Mkhitaryan","Midfielder","AArmenia","henrik_mkhitaryan", "henrik_mkhitaryan"),
            new PlayerDetails("Aaron","Ramsey","Midfielder","Wales","aaron_ramsey", "aaron_ramsey"),
            new PlayerDetails("Jack","Wilshere","Midfielder","England","jack_wilshere", "jack_wilshere"),
            new PlayerDetails("Mesut","Ozil","Midfielder","Germany","mesut_ozil", "mesut_ozil"),
            new PlayerDetails("Santi","Cazorla","Midfielder","Spain","santi_cazorla", "santi_cazorla"),
            new PlayerDetails("Granit","Xhaka","Midfielder","Switzerland","granit_xhaka", "granit_xhaka"),
            new PlayerDetails("Ainsley","Maitland","Midfielder","England","ainsley_maitland", "ainsley_maitland"),
            new PlayerDetails("Mohamed","Elneny","Midfielder","Egypt","mohamed_elneny", "mohamed_elneny"),
            new PlayerDetails("Alexandre","Lacazette","Forward","France","alexander_lacazette", "alexander_lacazette"),
            new PlayerDetails("Pierre-Emerick","Aubameyang","Forward","Gabon","aubameyang", "aubameyang"),
            new PlayerDetails("Alex","Iwobi","Forward","Nigeria","alex_iwobi", "alex_iwobi"),
            new PlayerDetails("Danny","Welbeck","Forward","Engaland","danny_welbeck", "danny_welbeck")


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extra = getIntent().getExtras();
        if(extra!=null){
            details =(PlayerDetails[]) extra.getSerializable("obj");
        }

        recyclerView = findViewById(R.id.rv_people);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        peopleAdapter = new PeopleAdapter(details);
        recyclerView.setAdapter(peopleAdapter);
    }
}
