package com.ppi.service;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.ppi.impl.RecordsIMPL;
import com.ppi.model.Knowledge;

/**
 * Servlet implementation class ChartServlet
 */
@WebServlet("/ChartServlet")
public class ChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int data=0,logic=0,cao=0,dbms=0,os=0,cn=0,app=0;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("image/jpeg");

		OutputStream outputStream = response.getOutputStream();

		JFreeChart chart1 = getChart();	
		int width = 650;
		int height = 500;
		ChartUtilities.writeChartAsPNG(outputStream, chart1, width, height);
	}

	public JFreeChart getChart() {
		
		for(Knowledge k : RecordsIMPL.getKnowledge()){
			data=data+Integer.valueOf(k.getData());
			logic=logic+Integer.valueOf(k.getLogic());
			cao=cao+Integer.valueOf(k.getCao());
			dbms=dbms+Integer.valueOf(k.getDbms());
			os=os+Integer.valueOf(k.getOs());
			cn=cn+Integer.valueOf(k.getCn());
			app=app+Integer.valueOf(k.getApp());
		}
		System.out.println(data+"  "+logic+"  "+dbms+"   "+cao+"   "+os+"   "+cn+"   "+app);
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("DATA STRUCTURE", data);
		dataset.setValue("LOGIC BUILDING", logic);
		dataset.setValue("COMPUTER ARCHITECTURE & ORGANISATION", cao);
		dataset.setValue("DATABASE MANAGEMENT SYSTEM", dbms);
		dataset.setValue("OPERATING SYSTEM", os);
		dataset.setValue("COMPUTER NETWORK", cn);
		dataset.setValue("APPLICATION DEVELOPMENT", app);

		boolean legend = true;
		boolean tooltips = false;
		boolean urls = false;

		JFreeChart chart = ChartFactory.createPieChart("Student Knowledge", dataset, legend, tooltips, urls);

		chart.setBorderPaint(Color.BLUE);
		chart.setBorderStroke(new BasicStroke(5.0f));
		chart.setBorderVisible(true);

		return chart;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
