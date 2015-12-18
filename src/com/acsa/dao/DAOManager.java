package com.acsa.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.acsa.dao.impl.PaymentDAO;

public class DAOManager {
	
	    public static DAOManager getInstance() {
        return DAOManagerSingleton.INSTANCE.get();
    }  

    public void open() throws SQLException {
        try
        {
            if(this.con==null || this.con.isClosed())
                this.con = src.getConnection();
        }
        catch(SQLException e) { throw e; }
    }

    public void close() throws SQLException {
        try
        {
            if(this.con!=null && !this.con.isClosed())
                this.con.close();
        }
        catch(SQLException e) { throw e; }
    }

    
    @SuppressWarnings("rawtypes")
	public GenericDAO getDAO(Table t) throws SQLException 
    {

        try
        {
            if(this.con == null || this.con.isClosed()) //Let's ensure our connection is open   
                this.open();
        }
        catch(SQLException e){ throw e; }

        switch(t)
        {
        case PAYMENT:
            return new PaymentDAO(this.con);
        default:
            throw new SQLException("Trying to link to an unexistant table.");
        }

    }
    
    //Private
    private DataSource src;
    private Connection con;

    private DAOManager() throws Exception {
        try
        {
            InitialContext ctx = new InitialContext();
            this.src = (DataSource)ctx.lookup("java:/comp/env/jdbc/Flypay");
        }
        catch(Exception e) { throw e; }
    }

    private static class DAOManagerSingleton {

        public static final ThreadLocal<DAOManager> INSTANCE;
        static
        {
            ThreadLocal<DAOManager> dm;
            try
            {
                dm = new ThreadLocal<DAOManager>(){
                    @Override
                    protected DAOManager initialValue() {
                        try
                        {
                            return new DAOManager();
                        }
                        catch(Exception e)
                        {
                            return null;
                        }
                    }
                };
            }
            catch(Exception e){
                dm = null;
            }
            INSTANCE = dm;
        }        

    }

}
