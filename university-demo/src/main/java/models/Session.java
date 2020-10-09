package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long session_id;
	private String sesssion_name;
	private String session_description;
	private Integer session_length;
	
	
	@ManyToMany
	@JoinTable(
			name = "session_faculties",
			joinColumns = @JoinColumn(name = "session_id"),
			inverseJoinColumns = @JoinColumn(name = "faculty_id"))
	private List<Faculty> faculties;
	
	
	public List<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}

	public Session() {
		
	}

	public Long getSession_id() {
		return session_id;
	}

	public void setSession_id(Long session_id) {
		this.session_id = session_id;
	}

	public String getSesssion_name() {
		return sesssion_name;
	}

	public void setSesssion_name(String sesssion_name) {
		this.sesssion_name = sesssion_name;
	}

	public String getSession_description() {
		return session_description;
	}

	public void setSession_description(String session_description) {
		this.session_description = session_description;
	}

	public Integer getSession_length() {
		return session_length;
	}

	public void setSession_length(Integer session_length) {
		this.session_length = session_length;
	}
	
	

}
