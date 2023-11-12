package mai.team1.lab2;

import android.content.ContentValues;

import java.io.File;
import java.util.UUID;

public class CrimeLab {
    private File mPhotoFile;
    private static ContentValues getContentValues(Crime crime) {
        values.put(CrimeTable.Cols.SUSPECT, crime.getSuspect());
    }

    public Crime getCrime(UUID id) {
    }

    public File getPhotoFile(Crime crime) {
        File filesDir = mContext.getFilesDir();
        return new File(filesDir, crime.getPhotoFilename());
        if (externalFilesDir == null) {
        }
        public void updateCrime (Crime crime){
        }
    }
}
