/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangnt.category;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author khang
 */
public class TblCategoryModel extends AbstractTableModel{
    TblCategoryDAO dao = null;
    
    public TblCategoryModel (TblCategoryDAO dao){
        this.dao=dao;
    }

    public TblCategoryDAO getDao() {
        return dao;
    }

    public void setDao(TblCategoryDAO dao) {
        this.dao = dao;
    }
    
    public int getRowCount(){
        return dao.size();
    }
    
    public int getColumnCount(){
        return 3;
    }
    
    @Override
    public String getColumnName (int column){
        String columnName="";
        switch(column){
            case 0: 
                columnName="Category ID";
                break;
            case 1:
                columnName="Category Name";
                break;
            case 2:
                columnName="Description";
                break;
        }
        return columnName;
    }
    
    public Object getValueAt(int row, int column){
        TblCategoryDTO dto = dao.get(row);
        Object obj = null;
        switch(column){
            case 0:
                obj=dto.getCategoryID();
                break;
            case 1:
                obj=dto.getCategoryName();
                break;
            case 2:
                obj=dto.getDescription();
                break;
        }
        return obj;
    }
}
