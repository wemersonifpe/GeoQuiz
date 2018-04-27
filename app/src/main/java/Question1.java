
public class Question1 {
    private int mTextResID;
    private boolean mAnswerTrue;

    public Question1(int mTextResID, boolean mAnswerTrue) {
        this.mTextResID = mTextResID;
        this.mAnswerTrue = mAnswerTrue;
    }

    public int getmTextResID() {
        return mTextResID;
    }

    public void setmTextResID(int mTextResID) {
        this.mTextResID = mTextResID;
    }

    public boolean ismAnswerTrue() {
        return mAnswerTrue;
    }

    public void setmAnswerTrue(boolean mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }
}
