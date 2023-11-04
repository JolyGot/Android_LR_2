package mai.team1.lab2;


import androidx.fragment.app.Fragment;

public class CrimeActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}