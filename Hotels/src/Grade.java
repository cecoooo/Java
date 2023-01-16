public class Grade {
    private int offeretId;
    private boolean evaluation = false;

    public Grade(){}

    public int getOfferetId() {
        return offeretId;
    }

    public void setOfferetId(int offeretId) {
        this.offeretId = offeretId;
    }

    public boolean isEvaluation() {
        return evaluation;
    }

    public void setEvaluation(boolean evaluation) {
        this.evaluation = evaluation;
    }
}
