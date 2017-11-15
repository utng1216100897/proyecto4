package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;



/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Student student;
	private List<Student> students;
	private StudentDAOImpl studentDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        student = new Student();
        students = new ArrayList<Student>();
        studentDAO = new StudentDAOImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("btn_save")!= null) {
			
			student.setName(request.getParameter("name"));
			student.setGroupStudent(request.getParameter("groupStudent"));
			student.setTurn(request.getParameter("turn"));
				
				
			if(student.getId()==0L) {
				studentDAO.createStudent(student);
				}else {
				studentDAO.updateStudent(student);
			}
			
			students = studentDAO.readAllStudents();
			request.setAttribute("students", students);
			request.getRequestDispatcher("student_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			student = new Student();
			request.getRequestDispatcher("student_form.jsp").forward(request, response);
			
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				student = studentDAO.readStudent(id);
				
			}catch (Exception e) {
				
				student = new Student();
			}
			request.setAttribute("student", student);
			
			request.getRequestDispatcher("student_form.jsp").forward(request, response);
			
			
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			Long id = Long.parseLong(request.getParameter("id"));
			studentDAO.deleteStudent(id);
			students = studentDAO.readAllStudents();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("students", students);
			request.getRequestDispatcher("student_list.jsp").forward(request, response);
		}else {
			students = studentDAO.readAllStudents();
			request.setAttribute("students", students);
			request.getRequestDispatcher("student_list.jsp").forward(request, response);
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
