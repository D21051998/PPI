package com.ppi.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
//import java.util.concurrent.ThreadLocalRandom;

public class AssignService {
	
	static void shuffleArray(String[] ar)
	  {
	    
	    Random rnd = new Random();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	     
	      String a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }
	
	public static void main(String[] args) 
    {
		Connection con=null;
        try
        {        	
                   Class.forName("com.mysql.jdbc.Driver");
                   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppi","root","root");
                   con.setAutoCommit(false);
                   PreparedStatement pstm = null;
                   int a = 0,b = 0,c,d;
                   String x = null,y = null;
                   
                   String sql6 = "DELETE FROM ASSIGN";
                   pstm = con.prepareStatement(sql6);
                   pstm.execute();

                  
                   String sql = "Select count(*) from records";
                   pstm=con.prepareStatement(sql);
                   ResultSet rs= pstm.executeQuery();
                   
                   while(rs.next()){
                	   a=rs.getInt(1);
                   }
                   
                   String sql2 = "Select count(*) from expert_login";
                   pstm=con.prepareStatement(sql2);
                   ResultSet rs2= pstm.executeQuery();
                   
                   while(rs2.next()){
                	   b=rs2.getInt(1);
                   }
                   
                   c=a/b;
                   d=a%b;
                   
                   System.out.println("a : "+a);
                   System.out.println("b : "+b);
                   System.out.println("c : "+c);
                   System.out.println("d : "+d);
                   
                   
                   
                   String sql4 = "Select id from expert_login";
        		   String sql5 = "Select rno from records";
        		   pstm=con.prepareStatement(sql4);
                   ResultSet rs3= pstm.executeQuery();
                   pstm=con.prepareStatement(sql5);
                   ResultSet rs4= pstm.executeQuery();
                   
                   String arr[]=new String[a];
                   int i=0;
                   while(rs4.next()){
                	   arr[i]=rs4.getString(1);
                	   i++;
                   }
                   
                   shuffleArray(arr);
                   
                   for (i = 0; i < arr.length; i++)
                   {
                     System.out.print(arr[i] + " ");
                   }
                   System.out.println();
 

                   int k=0;
                  
                   
                	   for(i=0;i<b;i++){
                    	   for(int j=0;j<c;j++){  
                       //for(int k=0;k<a;k++){ 
                               
                               if(k!=a){
                            	   System.out.println("k : "+(k+1));  
                            	   if(rs3.absolute(i+1)){
                            	   x=rs3.getString(1);
                            	   System.out.println("x : "+x);
                            	   }
                               //if(rs4.absolute(k+1)){
                            	   y=arr[k];
                            	   System.out.println("y : "+y);
                               //}
                               }
                    		   k++;
                    		   String sql3 = "insert into assign values(?,?)";
                    		   pstm=con.prepareStatement(sql3);
                    		   pstm.setString(1,x);
                               pstm.setString(2,y);
                               System.out.println(pstm.executeUpdate());
                    	 }  

                   }
                	   
                	   if(d!=0){
int j;
                	   
                	   for(i=0,j=k;i<d && j<k+d;i++,j++){
                		   
                		   sql4 = "Select id from expert_login";
//                		   sql5 = "select rno from records order by rno desc limit ?;";
                		   pstm=con.prepareStatement(sql4);
                           rs3= pstm.executeQuery();
//                           pstm=con.prepareStatement(sql5);
//                           pstm.setInt(1, d);
//                           rs4= pstm.executeQuery();
                           
                           System.out.println("k : "+(k+1));  
                           if(rs3.absolute(i+1)){               	   
                        	   x=rs3.getString(1);
                        	   System.out.println("x : "+x);
                           }
                           if(rs4.absolute(i+1)){
                        	   y=arr[j];
                        	   System.out.println("y : "+y);
                           }
                           
                		  
                		   String sql3 = "insert into assign values(?,?)";
                		   pstm=con.prepareStatement(sql3);
                		   pstm.setString(1,x);
                           pstm.setString(2,y);
                           System.out.println(pstm.executeUpdate());
                		   
                	   }
                	   
            		   
           	   }
                   
                   con.commit();
                   pstm.close();
                   } 
                   catch (Exception e) 
                   {
                       e.printStackTrace();
                   }
            
	
    }

}
