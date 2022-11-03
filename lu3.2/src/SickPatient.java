public class SickPatient extends Patient{

    private String expertise;
    private String status;
    private int startDay;

    public SickPatient(String name, String address, String egn) {
        super(name, address, egn);
    }

    @Override
    public void cure(String cure, double dose) {
        this.expertise += cure + " " + dose + "\n";
    }
}
