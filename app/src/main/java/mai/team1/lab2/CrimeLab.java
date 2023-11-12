package mai.team1.lab2;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import mai.team1.lab2.database.CrimeBaseHelper;
import mai.team1.lab2.database.CrimeCursorWrapper;
import mai.team1.lab2.database.CrimeDbSchema;
public class CrimeLab {
    private static ContentValues getContentValues(Crime crime) {
        values.put(CrimeTable.Cols.SUSPECT, crime.getSuspect());
    }
}

