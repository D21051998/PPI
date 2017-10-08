/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ppi.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ppi.database.ConnectionFactory;
import com.ppi.model.LoginCreds;

public class LoginObjs {

    public static void addIP(String id, String ip) {

        Connection connection = null;
        PreparedStatement ps1 = null;
        try {
            connection = ConnectionFactory.getConnection();
            ps1 = connection.prepareStatement("update login  set last_machine_ip=? where id=? ");
            ps1.setString(1, ip);
            ps1.setString(2, id);
            ps1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps1 != null) {
                try {
                    ps1.close();
                    ps1 = null;
                } catch (SQLException ex) {
                    Logger.getLogger(LoginObjs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ConnectionFactory.close(connection);

        }

    }

    public static boolean autherizeRoles(String id, String role) {
        LoginCreds lg = LoginObjs.getLoginByID(id);
        return lg.getRole().equals(role);
    }

    public static LoginCreds getLoginByID(String id) {
        Connection connection = null;
        LoginCreds creds = new LoginCreds();
        PreparedStatement ps1 = null;
        ResultSet r = null;
        try {
            connection = ConnectionFactory.getConnection();
            ps1 = connection.prepareStatement("select id, password, role, base, status from login where id=?");
            ps1.setString(1, id);
            r = ps1.executeQuery();
            if (r.next()) {
                creds.setId(id);
                creds.setPassword(r.getString("password"));
                creds.setRole(r.getString("role"));
                creds.setStatus(r.getString("status"));
                creds.setBase(r.getString("base"));
                ps1.close();
            } else {
                return null;
            }
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            if (ps1 != null) {
                try {
                    ps1.close();
                    ps1 = null;
                } catch (SQLException ex) {
                    Logger.getLogger(LoginObjs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ConnectionFactory.close(connection);
        }
        return creds;
    }

    public static List<LoginCreds> getAllLogins() {
        List<LoginCreds> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps1 = null;
        ResultSet r = null;
        try {
            connection = ConnectionFactory.getConnection();
            ps1 = connection.prepareStatement("select id, role, status from login");
            r = ps1.executeQuery();
            while (r.next()) {
                LoginCreds creds = new LoginCreds();
                creds.setId(r.getString("id"));
                creds.setRole(r.getString("role"));
                creds.setStatus(r.getString("status"));
                if (!creds.getRole().equals("ROLE_ADMIN")) {
                    list.add(creds);
                }

            }
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            if (null != ps1 || r != null) {
                try {
                    ps1.close();
                    r.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ConnectionFactory.close(connection);
        }
        return list;
    }

    public static String getS_id(String id) {

        Connection connection = null;
        String sid = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement p = connection.prepareStatement("select sid from login where id=?");
            p.setString(1, id);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                sid = rs.getString("sid");
            }
        } catch (SQLException s) {
            System.out.println(s);
        } finally {
            ConnectionFactory.close(connection);
        }
        return sid;
    }

    public static String getIdByS_ID(String sid) {
        Connection connection = null;
        String id = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement p = connection.prepareStatement("select id from login where sid=?");
            p.setString(1, sid);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                id = rs.getString("id");
            }
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            ConnectionFactory.close(connection);
        }
        return id;
    }

    public static void setS_ID(String id, String sid) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            System.out.println(id + sid);
            PreparedStatement p = connection.prepareStatement("update login set sid=? where id=?");
            p.setString(1, sid);
            p.setString(2, id);
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(connection);
        }

    }

    public static void deleteS_ID(String id) {
        Connection connection = null;
        PreparedStatement p1 = null;
        try {
            connection = ConnectionFactory.getConnection();
            p1 = connection.prepareStatement("update login set sid=? where sid=?");
            p1.setNull(1, Types.VARCHAR);
            p1.setString(2, id);
            if (p1.executeUpdate() == 1) {
            } else {
                System.out.println("Logout Not Complete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(connection);
        }

    }

    public static void main(String[] args) {
        for (LoginCreds c : getAllLogins()) {
            System.out.println(c);
        }
    }

}
