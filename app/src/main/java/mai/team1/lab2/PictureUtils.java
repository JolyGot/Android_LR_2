package mai.team1.lab2;
import android.graphics.Bitmap;
import android.app.Activity;
import android.graphics.Point;

public class PictureUtils {
    public static Bitmap getScaledBitmap(String path, Activity activity, int destWidth, int destHeight) {
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay()
                .getSize(size);
        return getScaledBitmap(path, activity, size.x, size.y);
    }
}
