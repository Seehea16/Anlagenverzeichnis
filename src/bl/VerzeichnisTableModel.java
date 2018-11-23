package bl;

import data.Eintrag;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VerzeichnisTableModel extends AbstractTableModel {
    private List<Eintrag> list;

    public VerzeichnisTableModel() {
        this.list = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return VerzeichnisColumnEnum.values().length;
    }
    
    public Eintrag getEintrag(int rowIndex) {
        return list.get(rowIndex);
    }
    
    @Override
    public String getColumnName(int column) {
        return VerzeichnisColumnEnum.values()[column].getName();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Eintrag e = this.getEintrag(rowIndex);
        
        VerzeichnisColumnEnum enumIndex = VerzeichnisColumnEnum.values()[columnIndex];
        switch(enumIndex) {
            case BEZ: return e.getBez();
            case ANSCH: return e.getAk();
            case DATUM: return String.format("%.1f", e.getDatum()).replace(".", ",");
            case NUTZD: return String.format("%.2f", (e.getNd() <= 0 ? 0 : e.getNd())).replace(".", ",");
            case NUTZDBISH: return String.format("%.1f", (e.getNdbish() <= 0 ? 0 : e.getNdbish())).replace(".", ",");
            case AFABISH: return String.format("%.2f", (e.getAfabish() <= 0 ? 0 : e.getAfabish())).replace(".", ",");
            case VORAFA: return String.format("%.2f", (e.getVorafa() <= 0 ? 0 : e.getVorafa())).replace(".", ",");
            case AFAJAHR: return String.format("%.2f", (e.getAfajahr() <= 0 ? 0 : e.getAfajahr())).replace(".", ",");
            case BARWERT: return String.format("%.2f", (e.getBarwert() <= 0 ? 0 : e.getBarwert())).replace(".", ",");
            default: return "?";
        }
    }
    
    public void load(File f, int year) throws Exception {
        this.clear();
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(fr = new FileReader(f));
            String line = br.readLine();
            while((line = br.readLine()) != null) {
                Eintrag e = new Eintrag(line, year);
                list.add(e);
            }
            this.fireTableDataChanged();
        } catch(FileNotFoundException ex) {
            System.out.println("Datei nicht gefunden!");
            throw ex;
        } catch(IOException ex) {
            System.out.println("Fehler beim Laden der Datei!");
            throw ex;
        } finally {
            if(br != null) {
                br.close();
            }
        }   
    }
    
    public void clear() {
        this.list.clear();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
}
