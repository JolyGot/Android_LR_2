package mai.team1.lab2;


import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class CrimeLab {
    public void addCrime(Crime c) {
        mCrimes.add(c);
    }
    public List<Crime> getCrimes() {
        return mCrimes;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
    }
}
