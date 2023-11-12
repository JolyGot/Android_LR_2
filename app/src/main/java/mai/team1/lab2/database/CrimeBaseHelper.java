package mai.team1.lab2.database;
import android.database.sqlite.SQLiteDatabase;

import mai.team1.lab2.database.CrimeDbSchema.CrimeTable;
public class CrimeBaseHelper {
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CrimeTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                CrimeTable.Cols.SOLVED + ", " +
                CrimeTable.Cols.SUSPECT +
                ")"
        );
    }
}
