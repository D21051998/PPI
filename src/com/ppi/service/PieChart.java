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
import com.ppi.model.Skills;

/**
 * Servlet implementation class PieChart
 */
@WebServlet("/PieChart")
public class PieChart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int team=0,enth=0,conf=0,clean=0,oral=0,lang=0,prob=0,skill=0,total=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PieChart() {
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
		
		for(Skills s : RecordsIMPL.getSkills()){
			team=team+Integer.valueOf(s.getTeam());
			enth=enth+Integer.valueOf(s.getEnth());
			conf=conf+Integer.valueOf(s.getConf());
			clean=clean+Integer.valueOf(s.getClean());
			oral=oral+Integer.valueOf(s.getOral());
			lang=lang+Integer.valueOf(s.getLang());
			prob=prob+Integer.valueOf(s.getProb());
			skill=skill+Integer.valueOf(s.getSkill());
			
		}
		
		total=team+enth+conf+clean+oral+lang+prob+skill;
		
		float a = ((float)team/total*100);
		float b = ((float)enth/total*100);
		float c = ((float)conf/total*100);
		float d = ((float)clean/total*100);
		float e = ((float)oral/total*100);
		float f = ((float)lang/total*100);
		float g = ((float)prob/total*100);
		float h = ((float)skill/total*100);
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("TEAM SPIRIT ("+a+" %)", team);
		dataset.setValue("ENTHUSIASM ("+b+" %)", enth);
		dataset.setValue("SELF CONFIDENCE ("+c+" %)", conf);
		dataset.setValue("CLEANLINESS ("+d+" %)", clean);
		dataset.setValue("ORAL COMMUNICATION ("+e+" %)", oral);
		dataset.setValue("BODY LANGUAGE ("+f+" %)", lang);
		dataset.setValue("PROBLEM SOLVING ("+g+" %)", prob);
		dataset.setValue("ANALYTICAL SKILL ("+h+" %)", skill);

		boolean legend = true;
		boolean tooltips = false;
		boolean urls = false;

		JFreeChart chart = ChartFactory.createPieChart("Student Skills", dataset, legend, tooltips, urls);

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
