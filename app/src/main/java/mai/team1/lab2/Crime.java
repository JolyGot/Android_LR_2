package mai.team1.lab2;


import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private Date mTime;
    private boolean mSolved;
    private String mSuspect;
    public Crime() {
        this(UUID.randomUUID());
    }
    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
    }
    public UUID getId() {

        return mId;
    }
    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String title) {

        mTitle = title;
    }

    public Date getDate() {

        return mDate;
    }
    public void setDate(Date date) {

        mDate = date;
    }
    public void setTime(Date time) {

        mTime = time;
    }
    public boolean isSolved() {

        return mSolved;
    }
    public void setSolved(boolean solved) {

        mSolved = solved;
    }
    public String getSuspect() {
        return mSuspect;
    }
    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }
    public String getPhotoFilename() {
        return "IMG_" + getId().toString() + ".jpg";
    }
    private String mPhone;
    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }
}



