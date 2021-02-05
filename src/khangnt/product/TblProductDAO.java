/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangnt.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import khangnt.category.TblCategoryDAO;
import khangnt.category.TblCategoryDTO;
import khangnt.utils.DBHelper;

/**
 *
 * @author khang
 */
public class TblProductDAO extends Vector<TblProductDTO> {

    public TblProductDAO() {
        super();
    }

    public int find(String proID) {
        for (int i = 0; i < this.size(); i++) {
            if (proID.equals(this.get(i).getProID())) {
                return i;
            }
        }
        return -1;
    }

    public static TblProductDAO getAll()
            throws SQLException, ClassNotFoundException {
        TblProductDAO pro = new TblProductDAO();
        TblCategoryDAO cate = new TblCategoryDAO();

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.getConnection();
            String sql = "select productID, productName, "
                    + " categoryID, unit, price, quantity "
                    + "from TblProducts";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String proID = rs.getString(1);
                String proName = rs.getString(2);
                String cateID = rs.getString(3);
                TblCategoryDTO cateDTO = cate.findCate(cateID);
                String unit = rs.getString(4);
                float price = rs.getFloat(5);
                int quantity = rs.getInt(6);

                TblProductDTO proDTO = new TblProductDTO(proID, proName, unit, price, quantity, cateDTO);
                pro.add(proDTO);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return pro;
    }

    public static int insert(TblProductDTO dto)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        int result = 0;
        try {
            con = DBHelper.getConnection();
            String sql = "insert TblProducts "
                    + "values(?,?,?,?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getProID());
            stm.setString(2, dto.getProName());
            stm.setString(3, dto.getUnit());
            stm.setFloat(4, dto.getPrice());
            stm.setInt(5, dto.getQuantity());
            stm.setString(6, dto.getCate().getCategoryID());
            result = stm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public static int update(TblProductDTO dto)
            throws SQLException, ClassNotFoundException{
        Connection con =null;
        PreparedStatement stm = null;
        int result=0;
        try{
            con=DBHelper.getConnection();
            String sql = "update TblProducts "
                    + "set productName=? ,"
                    + "unit=? ,"
                    + "price=? ,"
                    + "quantity=? ,"
                    + "categoryID=? "
                    + "where productID=? ";
            stm=con.prepareStatement(sql);
            stm.setString(1, dto.getProName());
            stm.setString(2, dto.getUnit());
            stm.setFloat(3, dto.getPrice());
            stm.setInt(4, dto.getQuantity());
            stm.setString(5, dto.getCate().getCategoryID());
            stm.setString(6, dto.getProID());
            result=stm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return result;
    }
    
    public static int delete(String proID)
            throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        int result = 0;
        try{
            con=DBHelper.getConnection();
            String sql = "delete from TblProducts where productID=?";
            stm=con.prepareStatement(sql);
            stm.setString(1, proID);
            result=stm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return result;
    }
    public boolean checkPro(String proID)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.getConnection();
            String sql = "select productID "
                    + "from TblProducts "
                    + "where productID=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, proID);
            rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean checkCateID(String cateID)
            throws SQLException, ClassNotFoundException{
          Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.getConnection();
            String sql = "select productID "
                    + "from TblProducts "
                    + "where categoryID=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, cateID);
            rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
