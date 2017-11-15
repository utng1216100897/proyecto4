package report;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class StudentReport
 */
@WebServlet("/StudentReport")
public class StudentReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAOImpl dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentReport() {
        super();
        dao = new StudentDAOImpl() {
			
			@Override
			public void updateStudent(Student student) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Student readStudent(Long id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Student> readAllStudents() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void deleteStudent(Long id) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void createStudent(Student student) {
				// TODO Auto-generated method stub
				
			}
		};
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportPath = "C:\\Users\\gerardo\\eclipse-workspace\\Project4\\src\\report\\studentsReport.jrxml";
		try {
			
			JasperReport report = JasperCompileManager.compileReport(reportPath);
			
			Map<String, Object> data = new HashMap<String, Object>();
			// data.put("Image", this.getServletContext().getRealPath("/")+"/images/helloWorld.jpg");
			JasperPrint print = JasperFillManager.fillReport(report, data, dao.getConnetion());
			
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
			
			
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
