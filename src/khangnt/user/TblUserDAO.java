/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangnt.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import khangnt.utils.DBHelper;

/**
 *
 * @author khang
 */
public class TblUserDAO {
    public static TblUserDTO getUser(String userID, String password)
            throws SQLException, ClassNotFoundException{
        TblUserDTO user = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try{
            con=DBHelper.getConnection();
            String sql = "Select userID, password "
                    + "from TblUsers "
                    + "where userID=? and password=?";
            stm=con.prepareStatement(sql);
            stm.setString(1, userID);
            stm.setString(2, password);
            rs=stm.executeQuery();
            if(rs.next()){
                user = new TblUserDTO(rs.getString("userID"), rs.getString("password"));
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
        return user;
    }
}
