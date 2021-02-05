/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangnt.product;

import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author khang
 */
public class TblProductModel extends AbstractTableModel{
    TblProductDAO dao = null;

    public TblProductModel(TblProductDAO dao) {
        this.dao=dao;
    }

    public TblProductDAO getDao() {
        return dao;
    }

    public void setDao(TblProductDAO dao) {
        this.dao = dao;
    }

    @Override
    public int getRowCount(){
        return dao.size();
    }
    
    @Override
    public int getColumnCount(){
        return 6;
    }
    
    @Override
    public Object getValueAt(int row, int column){
        TblProductDTO dto = dao.get(row);
        Object obj = null;
        switch(column){
            case 0:
                obj = dto.getProID();
                break;
            case 1:
                obj = dto.getProName();
                break;
            case 2: 
                obj = dto.getCate().getCategoryID();
                break;
            case 3:
                obj = dto.getUnit();
                break;
            case 4: 
                obj = dto.getPrice();
                break;
            case 5:
                obj = dto.getQuantity();
                break;
        }
        return obj;
    }
}
