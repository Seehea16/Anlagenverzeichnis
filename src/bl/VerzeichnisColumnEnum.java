package bl;

public enum VerzeichnisColumnEnum {
    BEZ("Bezeichnung"), ANSCH("AK"), DATUM("Inbetriebnahme"), 
    NUTZD("ND"), NUTZDBISH("bisherige ND"), AFABISH("Afa bisher"), 
    VORAFA("Wert vor Afa"), AFAJAHR("Afa dieses Jahres"), BARWERT("BW 31.12.");
    
    private String name;

    private VerzeichnisColumnEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
