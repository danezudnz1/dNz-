package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class StudentController {
  private List<Student> studenti = new ArrayList<Student>();

  StudentController() {
    Student s1 = new Student(1, "John");
    Student s2 = new Student(2, "Paul");
    Student s3 = new Student(3, "Paul");

    studenti.add(s1);
    studenti.add(s2);
    studenti.add(s3);
  }

  @RequestMapping(value="/Student", method = RequestMethod.GET)
  public List<Student> index() {
    return this.studenti;
  }
  
  @RequestMapping(value="/Student", method = RequestMethod.POST)
  public ResponseEntity create() {
	  Student s4 = new Student(4, "Armand");
	  return new ResponseEntity<Student>(s4, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/Student/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id) {
    for(Student s : this.studenti) {
      if(s.getId() == id) {
    	  s.Editarenume( "Dan");
    	  
        return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/Student/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Student s : this.studenti) {
      if(s.getId() == id) {
        return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Student/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Student s : this.studenti) {
      if(s.getId() == id) {
        this.studenti.remove(s);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}