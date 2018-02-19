package css.cis3334.heartratetracker;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    HeartRateList heartRateList;        // The list of heart rate objects
    ArrayAdapter<HeartRate> hrAdapter;  // The custom array adapter for displaying the heart rates in the list view
    ListView lvHeartRates;              // List view of random heart rates
    TextView tvSelect;                  // Text view for user selection

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvHeartRates = (ListView) findViewById(R.id.listViewHeartRates);
        tvSelect = (TextView) findViewById(R.id.textViewSelect);

        heartRateList = new HeartRateList();
        heartRateList.InitRandomElderly();

        // display random heart rates
        hrAdapter = new HeartRateAdapter(this, R.layout.heart_rate_row, R.id.textViewPulse, heartRateList);
        hrAdapter.setDropDownViewResource(R.layout.heart_rate_row);
        lvHeartRates.setAdapter(hrAdapter);

        // display user selection
        lvHeartRates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                HeartRate hr = (HeartRate) parent.getItemAtPosition(position);
                tvSelect.setText("You selected: " + hr.toString());

            }
        });
    }
}
