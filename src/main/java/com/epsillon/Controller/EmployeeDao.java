package com.epsillon.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.epsillon.Model.Employee;

@WebServlet("/Emp")
public class EmployeeDao extends HttpServlet implements CRUD<Employee> {
	private static final long serialVersionUID = 1L;
	Connection conn = DbConnection.getConnection();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("ID"));
		String fullName = request.getParameter("fullName");
		String date = request.getParameter("birthDate");
		int salary = Integer.parseInt(request.getParameter("Salary"));
		Employee emp = new Employee(id, fullName, date, salary);

		if (request.getParameter("add") != null) {
			int affected = add(emp);
			if (affected > 0) {
				out.println("<h1>Data inserted !!</h1>");
			} else {
				out.println("<h1>Error inserting data !!</h1>");
			}
		} else if (request.getParameter("update") != null) {
			int affected = update(emp);
			if (affected > 0) {
				out.println("<h1>Data updated !!</h1>");
			} else {
				out.println("<h1>Error updating data !!</h1>");
			}
		} else if (request.getParameter("delete") != null) {
			int affected = delete(id);
			if (affected > 0) {
				out.println("<h1>Row deleted !!</h1>");
			} else {
				out.println("<h1>Error deleting row !!</h1>");
			}
		}
	}

	@Override
	public int add(Employee t) {
		PreparedStatement ps = null;
		int rowAffected = 0;
		try {
			ps = conn.prepareStatement("INSERT INTO EMPLOYEES (ID, fullName, BIRTHDATE, SALARY) VALUES(?, ?, ?, ?);");
			ps.setInt(1, t.getId());
			ps.setString(2, t.getFullName());
			ps.setString(3, t.getDate());
			ps.setInt(4, t.getSalary());
			rowAffected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowAffected;
	}

	@Override
	public int delete(int id) {
		PreparedStatement ps = null;
		int rowAffected = 0;
		try {
			ps = conn.prepareStatement("DELETE FROM EMPLOYEES WHERE ID = ?;");
			ps.setInt(1, id);
			rowAffected = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowAffected;
	}

	@Override
	public int update(Employee t) {
		PreparedStatement ps = null;
		int rowAffected = 0;
		try {
			ps = conn.prepareStatement("UPDATE EMPLOYEES SET fullName = ?, BIRTHDATE = ?, SALARY = ? WHERE ID = ?;");
			ps.setString(1, t.getFullName());
			ps.setString(2, t.getDate());
			ps.setInt(3, t.getSalary());
			ps.setInt(4, t.getId());
			rowAffected = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowAffected;
	}
}
