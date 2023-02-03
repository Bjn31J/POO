package pooarrays;
class alum {
    String name;
    String nrocrl;
    int sem;
    public alum(String name, String nrocrl, int sem) {
        this.name = name;
        this.nrocrl = nrocrl;
        this.sem = sem;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNrocrl() {
        return nrocrl;
    }
    public void setNrocrl(String nrocrl) {
        this.nrocrl = nrocrl;
    }
    public int getSem() {
        return sem;
    }
    public void setSem(int sem) {
        this.sem = sem;
    }
    @Override
    public String toString() {
        return"name=" + name + ", nrocrl=" + nrocrl + ", sem=" + sem;
    }   
}
