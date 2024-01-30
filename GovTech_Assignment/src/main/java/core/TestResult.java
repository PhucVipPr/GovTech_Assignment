package core;

public class TestResult {
    private String TCID;
    private String result;

    public String getTCID() {
        return TCID;
    }

    public void setTCID(String TCID) {
        this.TCID = TCID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "TCID='" + TCID + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
