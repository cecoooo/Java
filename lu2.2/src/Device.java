public class Device {
    private int uV;
    private String processor;
    private Boolean switched;

    public int getuV(){
        return this.uV;
    }
    public String getProcessor(){
        return this.processor;
    }
    public void setuV(int uv){
        this.uV = uv;
    }
    public void setProcessor(String pr){
        this.processor = pr;
    }

    public Device(){
        this.uV = 0;
        this.processor = "";
    }
    public Device(int uv, String pr) {
        this.uV = uv;
        this.processor = pr;
    }

    public void On(){
        this.switched = true;
    }
    public void Off(){
        this.switched = false;
    }
}
