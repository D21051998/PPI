package com.ppi.service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
//import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.ppi.impl.ExpertIMPL;
import com.ppi.impl.RecordsIMPL;
import com.ppi.model.Knowledge;
import com.ppi.model.Remarks;
import com.ppi.model.Skills;
import com.ppi.model.StudExpert;

/**
 * Servlet implementation class PDFGenerator
 */
@WebServlet("/PDFGenerator")
public class PDFGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PDFGenerator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//String id=request.getParameter("id");
		
		String id="15csu065";
		
		StudExpert se = new StudExpert();
		
		se = ExpertIMPL.getDetailsById(id);
		
		Knowledge k = new Knowledge();
		
		k = RecordsIMPL.getRecordById(id);
		
		Skills s = new Skills();
		
		s = RecordsIMPL.getSkillsById(id);
		
		Remarks r = new Remarks();
		
		r = RecordsIMPL.getRemarksById(id);
		
		Document document = new Document();
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
	      try
	      {
	         //PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("PPI.pdf"));
	    	 PdfWriter.getInstance(document, bs);
	         document.open();
//	         Rectangle rect = new Rectangle(15, 15, 580, 820);
//	         Rectangle rect2 = new Rectangle(17, 17, 578, 818);
//	         rect.setBorder(Rectangle.BOX);
//	         rect.setBorderWidth(0.5f);
//	         rect2.setBorder(Rectangle.BOX);
//	         rect2.setBorderWidth(0.5f);
//	         document.add(rect);
//	         document.add(rect2);

	         
	         Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);         
	         PdfPTable th = new PdfPTable(1);
	         PdfPCell in1= new PdfPCell();
	         Phrase firstLine = new Phrase("The NorthCap University\nPPI EVALUATION RESULT", boldFont );     
	         in1.addElement(firstLine );
	         in1.setBorder(2);
	         in1.setBackgroundColor(BaseColor.BLUE);
	         in1.setBorderColor(BaseColor.BLUE);
	         in1.setPadding(7);
		     in1.setHorizontalAlignment(Element.ALIGN_CENTER);
			 in1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			 
			 
			 th.addCell(in1);

	         document.add(th);
	         
	         document.add( Chunk.NEWLINE );

	         document.add(new Paragraph("     Student & Expert Details :"));
	         document.add(new Paragraph());

	         document.add( Chunk.NEWLINE );
	         
	         
//	         PdfPTable table = new PdfPTable(6);
//	         table.setWidths(new int[]{ 4, 3, 3, 3, 3, 3});
//	         PdfPCell cell;
//	         cell = new PdfPCell(new Phrase("Knowledge Parameters"));
//	         table.addCell(cell);
//	         cell = new PdfPCell(new Phrase("Poor"));
//	         cell.setColspan(1);
//	         table.addCell(cell);
//	         cell = new PdfPCell(new Phrase("Satisfactory"));
//
//	         cell.setColspan(1);
//	         table.addCell(cell);
//	         cell = new PdfPCell(new Phrase("Good"));
//
//	         cell.setColspan(1);
//	         table.addCell(cell);
//	         cell = new PdfPCell(new Phrase("Very Good"));
//
//	         cell.setColspan(1);
//	         table.addCell(cell);
//	         cell = new PdfPCell(new Phrase("Excellent"));
//
//	         cell.setColspan(1);
//	         table.addCell(cell);
//	         table.addCell("1");
//	         table.addCell("2");
//	         table.addCell("3");
//	         table.addCell("4");
//	         table.addCell("5");
//
//	         document.add(table);
	         
	        
	         PdfPTable table = new PdfPTable(6);
	         table.setWidths(new int[]{ 4, 3, 3, 3, 3, 3});
	         PdfPCell cell;
	         cell = new PdfPCell(new Phrase("Knowledge Parameters"));
	         cell.setRowspan(2);
	         table.addCell(cell);
	         cell = new PdfPCell(new Phrase("Poor"));
	         cell.setColspan(1);
	         table.addCell(cell);
	         cell = new PdfPCell(new Phrase("Satisfactory"));
	         cell.setColspan(1);
	         table.addCell(cell);
	         cell = new PdfPCell(new Phrase("Good"));
	         cell.setColspan(1);
	         table.addCell(cell);
	         cell = new PdfPCell(new Phrase("Very Good"));
	         cell.setColspan(1);
	         table.addCell(cell);
	         cell = new PdfPCell(new Phrase("Excellent"));
	         cell.setColspan(1);
	         table.addCell(cell);
	         table.addCell("1");
	         table.addCell("2");
	         table.addCell("3");
	         table.addCell("4");
	         table.addCell("5");
	         document.add(table);
	         
	         document.add( Chunk.NEWLINE );
	         
	  
	         
//	         PdfPTable table8 = new PdfPTable(6);
//	         PdfPCell cell90 = new PdfPCell(new Paragraph("Knowledge Parameters"));
//	         table8.addCell(cell90);
//	         PdfPCell cell91 = new PdfPCell(new Paragraph("Poor"));
//	         table8.addCell("1");
//	         cell91.setRowspan(2);
//	         table8.addCell(cell91);
//	         PdfPCell cell92 = new PdfPCell(new Paragraph("Satisfactory"));
//	         PdfPCell cell93 = new PdfPCell(new Paragraph("Good"));
//	         PdfPCell cell94 = new PdfPCell(new Paragraph("Very Good"));
//	         PdfPCell cell95 = new PdfPCell(new Paragraph("Excellent"));
//	         table8.addCell(cell92);
//	         table8.addCell(cell93);
//	         table8.addCell(cell94);
//	         table8.addCell(cell95);
//	         document.add(table8);
	         
	         
	         PdfPTable table1 = new PdfPTable(2); 
	            PdfPCell cell1 = new PdfPCell(new Paragraph("Name Of Expert"));
				cell1.setBorderColor(BaseColor.BLUE);
	            cell1.setPadding(7);
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell2 = new PdfPCell(new Paragraph(se.getExpert().toUpperCase()));
				cell2.setBorderColor(BaseColor.BLUE);
	            cell2.setPadding(7);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell3 = new PdfPCell(new Paragraph("Name Of Student"));
				cell3.setBorderColor(BaseColor.BLUE);
	            cell3.setPadding(7);
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell4 = new PdfPCell(new Paragraph(se.getStudent().toUpperCase()));
				cell4.setBorderColor(BaseColor.BLUE);
	            cell4.setPadding(7);
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell5 = new PdfPCell(new Paragraph("Roll No"));
				cell5.setBorderColor(BaseColor.BLUE);
	            cell5.setPadding(7);
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell6 = new PdfPCell(new Paragraph(se.getRoll().toUpperCase()));
				cell6.setBorderColor(BaseColor.BLUE);
	            cell6.setPadding(7);
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
				
				cell1.setUseBorderPadding(true);
				cell2.setUseBorderPadding(true);
				cell3.setUseBorderPadding(true);
				cell4.setUseBorderPadding(true);
				cell5.setUseBorderPadding(true);
				cell6.setUseBorderPadding(true);
				
	         table1.addCell(cell1);
	         table1.addCell(cell2);
	         table1.addCell(cell3);
	         table1.addCell(cell4);
	         table1.addCell(cell5);
	         table1.addCell(cell6);
	         document.add(table1);

	         document.add( Chunk.NEWLINE );

	         document.add(new Paragraph("A.\t Feedback about Student Knowledge :"));
	         document.add( Chunk.NEWLINE );
	        
	            PdfPTable table2 = new PdfPTable(2); 
	            PdfPCell cell7 = new PdfPCell(new Paragraph("Data Structures"));
				cell7.setBorderColor(BaseColor.BLUE);
	            cell7.setPadding(7);
				cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell15 = new PdfPCell(new Paragraph(k.getData()));
				cell15.setBorderColor(BaseColor.BLUE);
	            cell15.setPadding(7);
				cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell15.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell8 = new PdfPCell(new Paragraph("Logic Building"));
				cell8.setBorderColor(BaseColor.BLUE);
	            cell8.setPadding(7);
				cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell16 = new PdfPCell(new Paragraph(k.getLogic()));
				cell16.setBorderColor(BaseColor.BLUE);
	            cell16.setPadding(7);
				cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell16.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell9 = new PdfPCell(new Paragraph("Computer Architecture & Organisation"));
				cell9.setBorderColor(BaseColor.BLUE);
	            cell9.setPadding(7);
				cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell17 = new PdfPCell(new Paragraph(k.getCao()));
				cell17.setBorderColor(BaseColor.BLUE);
	            cell17.setPadding(7);
				cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell17.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell10= new PdfPCell(new Paragraph("Database Management Systems"));
				cell10.setBorderColor(BaseColor.BLUE);
	            cell10.setPadding(7);
				cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell18 = new PdfPCell(new Paragraph(k.getDbms()));
				cell18.setBorderColor(BaseColor.BLUE);
	            cell18.setPadding(7);
				cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell18.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell11 = new PdfPCell(new Paragraph("Operating Systems"));
				cell11.setBorderColor(BaseColor.BLUE);
	            cell11.setPadding(7);
				cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell19 = new PdfPCell(new Paragraph(k.getOs()));
				cell19.setBorderColor(BaseColor.BLUE);
	            cell19.setPadding(7);
				cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell19.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell12 = new PdfPCell(new Paragraph("Computer Networks"));
				cell12.setBorderColor(BaseColor.BLUE);
	            cell12.setPadding(7);
				cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell20 = new PdfPCell(new Paragraph(k.getCn()));
				cell20.setBorderColor(BaseColor.BLUE);
	            cell20.setPadding(7);
				cell20.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell20.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell13 = new PdfPCell(new Paragraph("Application development using C/C++/PHP/Java"));
				cell13.setBorderColor(BaseColor.BLUE);
	            cell13.setPadding(7);
				cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell13.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell21 = new PdfPCell(new Paragraph(k.getApp()));
				cell21.setBorderColor(BaseColor.BLUE);
	            cell21.setPadding(7);
				cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell21.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell14 = new PdfPCell(new Paragraph("Total Score"));
				cell14.setBorderColor(BaseColor.BLUE);
	            cell14.setPadding(7);
				cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell14.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell22 = new PdfPCell(new Paragraph(k.getTotal()));
				cell22.setBorderColor(BaseColor.BLUE);
	            cell22.setPadding(7);
				cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell22.setVerticalAlignment(Element.ALIGN_MIDDLE);
				
				cell7.setUseBorderPadding(true);
				cell8.setUseBorderPadding(true);
				cell9.setUseBorderPadding(true);
				cell10.setUseBorderPadding(true);
				cell11.setUseBorderPadding(true);
				cell12.setUseBorderPadding(true);
				cell13.setUseBorderPadding(true);
				cell14.setUseBorderPadding(true);
				cell15.setUseBorderPadding(true);
				cell16.setUseBorderPadding(true);
				cell17.setUseBorderPadding(true);
				cell18.setUseBorderPadding(true);
				cell19.setUseBorderPadding(true);
				cell20.setUseBorderPadding(true);
				cell21.setUseBorderPadding(true);
				cell22.setUseBorderPadding(true);

	      table2.addCell(cell7);
	      table2.addCell(cell15);
	      table2.addCell(cell8);
	      table2.addCell(cell16);
	      table2.addCell(cell9);
	      table2.addCell(cell17);
	      table2.addCell(cell10);
	      table2.addCell(cell18);
	      table2.addCell(cell11);
	      table2.addCell(cell19);
	      table2.addCell(cell12);
	      table2.addCell(cell20);
	      table2.addCell(cell13);
	      table2.addCell(cell21);
	      table2.addCell(cell14);
	      table2.addCell(cell22);
	 
	      document.add(table2);
	         
	         document.add( Chunk.NEWLINE );
	         
	         document.add(new Paragraph("B.\t Feedback about Student Skills :"));
	         document.add( Chunk.NEWLINE );
	         
	         PdfPTable table4 = new PdfPTable(2); 
	         PdfPCell cell23 = new PdfPCell(new Paragraph("Team Spirit"));
				cell23.setBorderColor(BaseColor.BLUE);
	         cell23.setPadding(7);
				cell23.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell23.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell24 = new PdfPCell(new Paragraph(s.getTeam()));
				cell24.setBorderColor(BaseColor.BLUE);
	         cell24.setPadding(7);
				cell24.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell24.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell25 = new PdfPCell(new Paragraph("Enthusiasm"));
				cell25.setBorderColor(BaseColor.BLUE);
	         cell25.setPadding(7);
				cell25.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell25.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell26 = new PdfPCell(new Paragraph(s.getEnth()));
				cell26.setBorderColor(BaseColor.BLUE);
	         cell26.setPadding(7);
				cell26.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell26.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell27 = new PdfPCell(new Paragraph("Self Confidence"));
				cell27.setBorderColor(BaseColor.BLUE);
	         cell27.setPadding(7);
				cell27.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell27.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell28 = new PdfPCell(new Paragraph(s.getConf()));
				cell28.setBorderColor(BaseColor.BLUE);
	         cell28.setPadding(7);
				cell28.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell28.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell29= new PdfPCell(new Paragraph("Cleanliness"));
				cell29.setBorderColor(BaseColor.BLUE);
	         cell29.setPadding(7);
				cell29.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell29.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell30 = new PdfPCell(new Paragraph(s.getClean()));
				cell30.setBorderColor(BaseColor.BLUE);
	         cell30.setPadding(7);
				cell30.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell30.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell31 = new PdfPCell(new Paragraph("Oral Communication"));
				cell31.setBorderColor(BaseColor.BLUE);
	         cell31.setPadding(7);
				cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell31.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell32 = new PdfPCell(new Paragraph(s.getOral()));
				cell32.setBorderColor(BaseColor.BLUE);
	         cell32.setPadding(7);
				cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell32.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell33 = new PdfPCell(new Paragraph("Body Language"));
				cell33.setBorderColor(BaseColor.BLUE);
	         cell33.setPadding(7);
				cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell33.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell34 = new PdfPCell(new Paragraph(s.getLang()));
				cell34.setBorderColor(BaseColor.BLUE);
	         cell34.setPadding(7);
				cell34.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell34.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell35 = new PdfPCell(new Paragraph("Problem Solving"));
				cell35.setBorderColor(BaseColor.BLUE);
	         cell35.setPadding(7);
				cell35.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell35.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell36 = new PdfPCell(new Paragraph(s.getProb()));
				cell36.setBorderColor(BaseColor.BLUE);
	         cell36.setPadding(7);
				cell36.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell36.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell37 = new PdfPCell(new Paragraph("Analytical Skills"));
				cell37.setBorderColor(BaseColor.BLUE);
	         cell37.setPadding(7);
				cell37.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell37.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell38 = new PdfPCell(new Paragraph(s.getSkill()));
				cell38.setBorderColor(BaseColor.BLUE);
	         cell38.setPadding(7);
				cell38.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell38.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell39 = new PdfPCell(new Paragraph("Total Score"));
				cell39.setBorderColor(BaseColor.BLUE);
	         cell39.setPadding(7);
				cell39.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell39.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell cell40 = new PdfPCell(new Paragraph(s.getTotal()));
				cell40.setBorderColor(BaseColor.BLUE);
	         cell40.setPadding(7);
				cell40.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell40.setVerticalAlignment(Element.ALIGN_MIDDLE);
				
				cell23.setUseBorderPadding(true);
				cell24.setUseBorderPadding(true);
				cell25.setUseBorderPadding(true);
				cell26.setUseBorderPadding(true);
				cell27.setUseBorderPadding(true);
				cell28.setUseBorderPadding(true);
				cell29.setUseBorderPadding(true);
				cell30.setUseBorderPadding(true);
				cell31.setUseBorderPadding(true);
				cell32.setUseBorderPadding(true);
				cell33.setUseBorderPadding(true);
				cell34.setUseBorderPadding(true);
				cell35.setUseBorderPadding(true);
				cell36.setUseBorderPadding(true);
				cell37.setUseBorderPadding(true);
				cell38.setUseBorderPadding(true);
				cell39.setUseBorderPadding(true);
				cell40.setUseBorderPadding(true);

	   table4.addCell(cell23);
	   table4.addCell(cell24);
	   table4.addCell(cell25);
	   table4.addCell(cell26);
	   table4.addCell(cell27);
	   table4.addCell(cell28);
	   table4.addCell(cell29);
	   table4.addCell(cell30);
	   table4.addCell(cell31);
	   table4.addCell(cell32);
	   table4.addCell(cell33);
	   table4.addCell(cell34);
	   table4.addCell(cell35);
	   table4.addCell(cell36);
	   table4.addCell(cell37);
	   table4.addCell(cell38);
	   table4.addCell(cell39);
	   table4.addCell(cell40);

	   document.add(table4);

	         
	         document.add( Chunk.NEWLINE );
	 

	         DateFormat df = new SimpleDateFormat("dd/MM/yy");
	         Date dateobj = new Date();
	         
	         document.add(new Paragraph("C.\t Student Remarks :"));
	         document.add( Chunk.NEWLINE );
	         
	        PdfPTable itable4 = new PdfPTable(1);  
	     	PdfPCell cell41 = new PdfPCell(new Paragraph(r.getRemarks()));
			cell41.setBorderColor(BaseColor.BLUE);
	        cell41.setPadding(7);
			cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell41.setVerticalAlignment(Element.ALIGN_MIDDLE);
			itable4.addCell(cell41);
			document.add(itable4);

	         document.add(Chunk.NEWLINE);
	         document.add(new Paragraph("\n\t\t\tDate : " + df.format(dateobj)));


	         document.close();
	         response.setHeader("Expires", "0");
             response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
             response.setHeader("Pragma", "public");
             response.setContentType("application/pdf");
             response.setContentLengthLong(bs.size());

             javax.servlet.ServletOutputStream sos = response.getOutputStream();
             bs.writeTo(sos);
             sos.flush();
	         //writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
