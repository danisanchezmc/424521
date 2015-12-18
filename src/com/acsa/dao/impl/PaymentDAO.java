package com.acsa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.acsa.dao.GenericDAO;
import com.acsa.web.model.Payment;

public class PaymentDAO extends GenericDAO<Payment> {

	public PaymentDAO(Connection con) {
		super(con, TABLENAME);
	}

	@Override
	public int count() throws SQLException {
		String query = "SELECT COUNT(*) AS count FROM " + this.tableName;
		PreparedStatement counter;
		try {
			counter = this.con.prepareStatement(query);
			ResultSet res = counter.executeQuery();
			res.next();
			return res.getInt("count");
		} catch (SQLException e) {
			throw e;
		}
	}

	public List<Payment> getAll() throws SQLException {

		String query = "SELECT * " + "FROM " + this.tableName + " pr " + "WHERE pr.completed=1"
				+ " " + "ORDER BY pr.restaurantLocation ASC";

		PreparedStatement listProvincia;
		try {

			List<Payment> prvList = new ArrayList<Payment>();

			listProvincia = this.con.prepareStatement(query);
			ResultSet res = listProvincia.executeQuery();

			while (res.next()) {

				Payment prv = new Payment();

				prv.setCode(res.getString("code"));
				prv.setTxt_amount(res.getString("amount"));
				prv.setTxt_tipGratuity(res.getString("tipGratuity"));
				prv.setTxt_tableNumber(res.getString("tableNumber"));
				prv.setTxt_restaurantLocation(res.getString("restaurantLocation"));
				prv.setTxt_paymentReference(res.getString("paymentReference"));
				prv.setTxt_cardType(res.getString("cardType"));
				
				prvList.add(prv);

			}
			
			this.con.close();
			
			return prvList;
		} catch (SQLException e) {
			throw e;
		}
	}

	public Payment getById(int id) throws SQLException {

		String query = "SELECT * FROM " + this.tableName + " WHERE code=" + id;

		PreparedStatement prvRs;

		try {
			prvRs = this.con.prepareStatement(query);
			ResultSet res = prvRs.executeQuery();
			res.next();

			Payment prv = new Payment();

			prv.setCode(res.getString("code"));
			prv.setTxt_amount(res.getString("amount"));
			prv.setTxt_tipGratuity(res.getString("tipGratuity"));
			prv.setTxt_tableNumber(res.getString("tableNumber"));
			prv.setTxt_restaurantLocation(res.getString("restaurantLocation"));
			prv.setTxt_paymentReference(res.getString("paymentReference"));
			prv.setTxt_cardType(res.getString("cardType"));

			this.con.close();
			
			return prv;
		} catch (SQLException e) {
			throw e;
		}

	}
	
	public Payment getByLocation(String location) throws SQLException {

		String query = "SELECT * FROM " + this.tableName + " WHERE restaurantLocation=" + location;

		PreparedStatement prvRs;

		try {
			prvRs = this.con.prepareStatement(query);
			ResultSet res = prvRs.executeQuery();
			res.next();

			Payment prv = new Payment();

			prv.setCode(res.getString("code"));
			prv.setTxt_amount(res.getString("amount"));
			prv.setTxt_tipGratuity(res.getString("tipGratuity"));
			prv.setTxt_tableNumber(res.getString("tableNumber"));
			prv.setTxt_restaurantLocation(res.getString("restaurantLocation"));
			prv.setTxt_paymentReference(res.getString("paymentReference"));
			prv.setTxt_cardType(res.getString("cardType"));

			this.con.close();
			
			return prv;
		} catch (SQLException e) {
			throw e;
		}

	}

	// Private
	private final static String TABLENAME = "PAYMENT";

}