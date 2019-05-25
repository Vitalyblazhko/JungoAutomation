package models;

public class FailedEyewear {
    int frame;
    String eyewearSource;
    String eyewearSample;

    public FailedEyewear() {
    }

    public FailedEyewear(int frame, String eyewearSource, String eyewearSample) {
        this.frame = frame;
        this.eyewearSource = eyewearSource;
        this.eyewearSample = eyewearSample;
    }

    public String toScv() {
        return frame+","+eyewearSource+","+eyewearSample;
    }

}