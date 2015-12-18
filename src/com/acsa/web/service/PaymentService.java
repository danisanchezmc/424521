package com.acsa.web.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.acsa.dao.DAOManager;
import com.acsa.dao.Table;
import com.acsa.dao.impl.PaymentDAO;
import com.acsa.web.model.Payment;

@Path("/payments")
public class PaymentService
{
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
    public List<Payment> getPayments() throws SQLException
    {
		
		DAOManager dao = DAOManager.getInstance();
		
		PaymentDAO uoDao;
		
		uoDao = (PaymentDAO) dao.getDAO(Table.PAYMENT);
		
         return uoDao.getAll();
    }
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Payment PaymentsById(@PathParam("id") String id) throws SQLException{
	
		DAOManager dao = DAOManager.getInstance();
		
		PaymentDAO uoDao= (PaymentDAO) dao.getDAO(Table.PAYMENT);
		
		return uoDao.getById(Integer.parseInt(id));
	}	
	
	@Path("{location}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Payment getByLocation(@PathParam("location") String location) throws SQLException{
	
		DAOManager dao = DAOManager.getInstance();
		
		PaymentDAO uoDao= (PaymentDAO) dao.getDAO(Table.PAYMENT);
		
		return uoDao.getByLocation(location);
	}	
	
}
