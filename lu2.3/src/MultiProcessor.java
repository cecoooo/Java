public class MultiProcessor {
    private int cpus;
    private int cores;
    private double clock;

    public int getCpus(){
        return this.cpus;
    }
    public int getCores(){
        return this.cores;
    }
    public double getClock(){
        return this.clock;
    }
    public void setCpus(int n){
        if(n >= 1) {
            this.cpus = n;
        }
        else this.cpus = 1;
    }
    public void setCores(int n){
        if(n >= 1) {
            this.cores = n;
        }
        else this.cores = 1;
    }
    public void setClock(double n){
        this.clock = n;
    }

    public MultiProcessor(){
        this.cpus = 0;
        this.cores = 0;
        this.clock = 0.0;
    }
    public MultiProcessor(int cp, int co, double cl){
        this.cpus = cp;
        this.cores = co;
        this.clock = cl;
    }

    public double MultiClock(){
        return (0.7*this.cores)*(0.8*cpus)*clock;
    }
    public double Time(double t){
        return t*this.clock/this.MultiClock();
    }
    public String toString(){
        return "CPUS: " + this.cpus + "\n" +
                "Cores: " + this.cores + "\n" +
                "Clock: " + this.clock;
    }
}
