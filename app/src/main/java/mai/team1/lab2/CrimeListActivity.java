package mai.team1.lab2;


import androidx.fragment.app.Fragment;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import mai.team1.lab2.DatePickerFragment;


public class CrimeListActivity extends SingleFragmentActivity
    implements CrimeListFragment.Callbacks, CrimeFragment.Callbacks {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }
    @Override
    public void onCrimeSelected(Crime crime) {
        if (findViewById(R.id.detail_fragment_container) == null) {
            Intent intent = CrimePagerActivity.newIntent(this, crime.getId());
            startActivity(intent);
        } else {
            Fragment newDetail = CrimeFragment.newInstance(crime.getId());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, newDetail)
                    .commit();
        }
    }
    public void onCrimeUpdated(Crime crime) {
        CrimeListFragment listFragment = (CrimeListFragment)
                getSupportFragmentManager()
 .findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }
}