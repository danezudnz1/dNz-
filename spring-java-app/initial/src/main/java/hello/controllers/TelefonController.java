package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; //de pus
import java.util.List;
import java.util.ArrayList;


@RestController
public class TelefonController {
  private List<Telefon> telefoane = new ArrayList<Telefon>();

  TelefonController() {
    Telefon t1 = new Telefon(1, "Samsung");
    Telefon t2 = new Telefon(2, "Apple");
    Telefon t3 = new Telefon(3, "Sony");

    telefoane.add(t1);
    telefoane.add(t2);
    telefoane.add(t3);
  }

  @RequestMapping(value="/telefon", method = RequestMethod.GET)
  public List<Telefon> index() {
    return this.telefoane;
  }
  
  @RequestMapping(value="/telefon", method = RequestMethod.POST)
  public ResponseEntity create() {
	  Telefon t4 = new Telefon(4, "Asus");
	  return new ResponseEntity<Telefon>(t4, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/telefon/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id) {
    for(Telefon t : this.telefoane) {
      if(t.getId() == id) {
    	  t.Editaremarca( "Samsung");
    	  
        return new ResponseEntity<Telefon>(t, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/telefon/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Telefon t : this.telefoane) {
      if(t.getId() == id) {
        return new ResponseEntity<Telefon>(t, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


  @RequestMapping(value="/telefon/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Telefon t : this.telefoane) {
      if(t.getId() == id) {
        this.telefoane.remove(t);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}