package data;

public class Eintrag {
    private String bez;
    private int ak;
    private double datum, nd, ndbish, afabish, vorafa,
            afajahr,barwert;

    
    public Eintrag(String line, int year) {
        String[] token = line.split(";");
        this.bez = token[0];
        this.ak = Integer.parseInt(token[1].replace(".", ""));
        this.datum = Double.parseDouble(token[2].replace(",", "."));
        this.nd = Double.parseDouble(token[3].replace(",", "."));
    
        this.ndbish = (double) (year)-this.datum;
        this.afajahr = this.ak / this.nd;
        this.afabish = this.ndbish * this.afajahr;
        this.vorafa = this.ak - this.afabish; 
        this.barwert=   this.vorafa - this.afajahr;
    }
    
    
    public Eintrag(String bez, int ak, double datum, double nd, double year) {
        this.bez = bez;
        this.ak = ak;
        this.datum = datum;
        this.nd = nd;
        
        this.ndbish = (double) year-datum;
        this.afajahr = this.ak / this.nd;
        this.afabish = this.ndbish * this.afajahr;
        this.vorafa = this.ak - this.afabish; 
        this.barwert=  this.vorafa - this.afajahr;
    }

    public String getBez() {
        return bez;
    }

    public int getAk() {
        return ak;
    }

    public double getDatum() {
        return datum;
    }

    public double getNd() {
        return nd;
    }

    public double getNdbish() {
        return ndbish;
    }

    public double getAfabish() {
        return afabish;
    }

    public double getVorafa() {
        return vorafa;
    }

    public double getAfajahr() {
        return afajahr;
    }

    public double getBarwert() {
        return barwert;
    }

    
    
    
}
