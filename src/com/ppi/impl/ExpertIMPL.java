package com.ppi.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ppi.database.ConnectionFactory;
import com.ppi.model.Record;
import com.ppi.model.StudExpert;

public class ExpertIMPL {
	
static Connection connection = null;
	
	public List<Record> getStudents(String id,int ppi){
		List<Record> list=new ArrayList<Record>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("Select name,rno from records,assign where assign.expert_id=?"
					+ "and assign.student_id = records.rno "
					+ "and assign.ppi_taken =?");
			ps.setString(1, id);
			ps.setInt(2, ppi);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Record r=new Record();
				r.setName(rs.getString(1));
				r.setRoll(rs.getString(2));
				list.add(r);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	public static StudExpert getDetailsById(String id){

        StudExpert s = new StudExpert();

        ResultSet rs = null;
        try{
        	connection = ConnectionFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement("Select expert_id,student_id,name from assign,records where "
					+ "assign.student_id=records.rno and assign.student_id=?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	s.setExpert(rs.getString(1));
				s.setRoll(rs.getString(2));
				s.setStudent(rs.getString(3));
                connection.close();
                return s;
            }
            else{
                return null;
            }
        }
        catch(SQLException se){
            se.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                rs.close();
                ConnectionFactory.close(connection);
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
		return s;
    }
	

}
