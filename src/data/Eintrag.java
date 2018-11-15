package data;

public class Eintrag {
    private String bez;
    private double ak, datum, nd, ndbish, afabish, vorafa,
            afajahr,barwert;

    
    public Eintrag(String line, double year) {
         
        String[] token = line.split(";");
        this.bez = token[0];
        this.ak = Double.parseDouble(token[1]);
        this.datum = Double.parseDouble(token[2].replace(",", "."));
        this.nd = Double.parseDouble(token[3]);
    
        this.ndbish = year-this.datum;
        this.afajahr = this.ak / this.nd;
        this.afabish = this.ndbish * this.afajahr;
        this.vorafa = this.ak - this.afabish; 
        this.barwert=   this.vorafa - this.afajahr;
    }
    
    
    public Eintrag(String bez, double ak, double datum, double nd, double year) {
        this.bez = bez;
        this.ak = ak;
        this.datum = datum;
        this.nd = nd;
        
        this.ndbish = year-datum;
        this.afajahr = this.ak / this.nd;
        this.afabish = this.ndbish * this.afajahr;
        this.vorafa = this.ak - this.afabish; 
        this.barwert=  this.vorafa - this.afajahr;
    }

    public String getBez() {
        return bez;
    }

    public double getAk() {
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
