package css.cis3334.heartratetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HeartDetailActivity extends AppCompatActivity {

    TextView tvPulse;
    TextView tvRange;
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_detail);

        tvPulse = (TextView) findViewById(R.id.textViewPulseDetail);
        tvRange = (TextView) findViewById(R.id.textViewRangeDetail);
        tvDescription = (TextView) findViewById(R.id.textViewDescription);

        Bundle extras = getIntent().getExtras();
        HeartRate hr = (HeartRate) extras.getSerializable(MainActivity.HEARTRATE_KEY);
        tvPulse.setText(hr.getPulse().toString());
        tvRange.setText(hr.getRangeName());
        tvDescription.setText(hr.getRangeDescription());

    }
}
