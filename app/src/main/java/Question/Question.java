package Question;

/**
 * Created by wemerson on 12/04/2018.
 */

public class Question {

    private int mTexteResID;
    private boolean mAnswerTrue;

    public Question(int mTexteResID, boolean mAnswerTrue) {
        this.mTexteResID = mTexteResID;
        this.mAnswerTrue = mAnswerTrue;
    }

    public int getmTexteResID() {
        return mTexteResID;
    }

    public void setmTexteResID(int mTexteResID) {
        this.mTexteResID = mTexteResID;
    }

    public boolean ismAnswerTrue() {
        return mAnswerTrue;
    }

    public void setmAnswerTrue(boolean mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }
}
