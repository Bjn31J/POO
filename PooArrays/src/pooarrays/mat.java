package pooarrays;
import java.util.LinkedList;
class mat {
    String nameS;
    String clvS;
    int cre;
    LinkedList<alum> lalum=new LinkedList();
    public mat(String nameS, String clvS, int cre) {
        this.nameS = nameS;
        this.clvS = clvS;
        this.cre = cre;
    }
    public String getNameS() {
        return nameS;
    }
    public void setNameS(String nameS) {
        this.nameS = nameS;
    }
    public String getClvS() {
        return clvS;
    }
    public void setClvS(String clvS) {
        this.clvS = clvS;
    }
    public int getCre() {
        return cre;
    }
    public void setCre(int cre) {
        this.cre = cre;
    }
    @Override
    public String toString() {
        return  "nameS=" + nameS + ", clvS=" + clvS + ", cre=" + cre;
    }   }

