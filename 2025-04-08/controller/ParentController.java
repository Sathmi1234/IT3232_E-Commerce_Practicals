package lk.ac.vau.fas.ict.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appParent")
public class ParentController<K,T> {
	
	private Map<K,T> objects = new HashMap<K,T>();
	
	
	@GetMapping("/")
	public Map<K,T> getAll(){
		return objects;
	}
	
	@GetMapping("{id}")
	public T getbyId(@PathVariable("id") K id) {
		return objects.get(id);
    }

	@PostMapping("/add/{id}")
	public String addStudentMap(@RequestBody T object, @PathVariable("id") K id){
		objects.put(id, object);
		return "New Object Created Successfully!";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleStudentMap(@PathVariable("id") K id){
		if(objects.get(id) != null) {
			objects.remove(id);
			return "Object Removed Successfully!";
		}
		
		return "Coudn't find Object!";
	}
	
	//Update Student
	@PutMapping("/update/{id}")
	public String updateStudentMap(@PathVariable("id") K id,@RequestBody T student){
		if(objects.get(id) != null) {
			objects.put(id, student);
			return "Object Updated Successfully!";			
		}
		return "Coudn't find Object!";
    }
}
