package mai.team1.lab2.database;

import mai.team1.lab2.Crime;
public class CrimeCursorWrapper {
    public Crime getCrime() {
        String suspect = getString(getColumnIndex(CrimeTable.Cols.SUSPECT));
        crime.setSuspect(suspect);
    }
}
