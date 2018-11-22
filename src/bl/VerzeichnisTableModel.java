package bl;

import data.Eintrag;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class VerzeichnisTableModel extends AbstractTableModel {
    private ArrayList<Eintrag> list;
    
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
            case ANSCH: return e.getAk()+"".replace(".", ",");
            case DATUM: return e.getDatum()+"".replace(".", ",");
            case NUTZD: return e.getNd()+"".replace(".", ",");
            case NUTZDBISH: return e.getNdbish()+"".replace(".", ",");
            case AFABISH: return e.getAfabish()+"".replace(".", ",");
            case VORAFA: return e.getVorafa()+"".replace(".", ",");
            case AFAJAHR: return e.getAfajahr()+"".replace(".", ",");
            case BARWERT: return e.getBarwert()+"".replace(".", ",");
            default: return "?";
        }
    }
    
    public void load(File f, double year) throws Exception {
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
