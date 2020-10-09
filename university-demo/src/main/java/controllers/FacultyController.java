package controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import models.Faculty;
import repositories.FacultyRepository;


@RestController
@RequestMapping("/api/v1/faculties")
public class FacultyController {

	@Autowired
	private FacultyRepository facultyRepository;
	
	@GetMapping
	public List<Faculty> list(){
		return facultyRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Faculty get(@PathVariable Long id) {
		return facultyRepository.getOne(id);	
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Faculty create (@RequestBody final Faculty faculty) {
		return facultyRepository.saveAndFlush(faculty);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		facultyRepository.deleteById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Faculty update(@PathVariable Long id, @RequestBody Faculty faculty) {
		
		Faculty existingFaculty = facultyRepository.getOne(id);
		BeanUtils.copyProperties(faculty, existingFaculty, "faculty_id");
		return facultyRepository.saveAndFlush(existingFaculty);
	}
}
