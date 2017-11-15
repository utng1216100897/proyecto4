package model;
import java.io.Serializable;

	public class Student implements Serializable{
		private Long id;
		private String name;
		private String groupStudent;
		private String turn;
		
		public Student (Long id, String name, String groupStudent, String turn) {
			
			super();
			this.id = id;
			this.name = name;
			this.groupStudent = groupStudent;
			this.turn = turn;
		}
		public Student() {
				this(0L, "", "", "");
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGroupStudent() {
			return groupStudent;
		}
		public void setGroupStudent(String groupStudent) {
			this.groupStudent = groupStudent;
		}
		public String getTurn() {
			return turn;
		}
		public void setTurn(String turn) {
			this.turn = turn;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", groupStudent=" + groupStudent + ", turn=" + turn + "]";
		}
		
		
		
	}


