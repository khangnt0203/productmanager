/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangnt.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import khangnt.utils.DBHelper;

/**
 *
 * @author khang
 */
public class TblCategoryDAO extends Vector<TblCategoryDTO> {

    public TblCategoryDAO() {
        super();
    }

    public int find(String cateID){
        try{
            List<TblCategoryDTO> list = getAllCate();
            for(int i=0; i<list.size();i++){
                if(cateID.equals(list.get(i).getCategoryID())){
                    return i;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return -1;
    }
    public TblCategoryDTO findCate(String cateID){
        try{
            List<TblCategoryDTO> list = getAllCate();
            int i = find(cateID);
            return i<0 ? null : list.get(i);
          
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public static TblCategoryDAO getAllCate()
            throws SQLException, ClassNotFoundException {
        TblCategoryDAO dao = new TblCategoryDAO();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.getConnection();
            String sql = "select categoryID, categoryName, description "
                    + "from TblCategories";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String cateID = rs.getString("categoryID");
                String cateName = rs.getString("categoryName");
                String des = rs.getString("description");

                TblCategoryDTO dto = new TblCategoryDTO(cateID, cateName, des);

                dao.add(dto);
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
        return dao;
    }

    public static int insert(TblCategoryDTO dto)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        int result = 0;
        try {
            con = DBHelper.getConnection();
            String sql = "insert TblCategories "
                    + "values(?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getCategoryID());
            stm.setString(2, dto.getCategoryName());
            stm.setString(3, dto.getDescription());
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

    public static int update(TblCategoryDTO dto)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        int result = 0;
        try {
            con = DBHelper.getConnection();
            String sql = "update TblCategories "
                    + "set categoryName=? ,"
                    + "description=? "
                    + "where categoryID=? ";
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getCategoryName());
            stm.setString(2, dto.getDescription());
            stm.setString(3, dto.getCategoryID());
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

    public static int delete(String cateID)
            throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        int result = 0;
        
        try{
            con=DBHelper.getConnection();
            String sql = "delete from TblCategories "
                    + "where categoryID=?";
            stm=con.prepareStatement(sql);
            stm.setString(1, cateID);
            result = stm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return result;
    }
    
     public boolean checkCate(String cateID)
            throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.getConnection();
            String sql = "select categoryID "
                    + "from TblCategories "
                    + "where categoryID=?";
            stm=con.prepareStatement(sql);
            stm.setString(1, cateID);
            rs=stm.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return false;
    }
}
