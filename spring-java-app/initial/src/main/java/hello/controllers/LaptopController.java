package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;//addd
import java.util.List;
import java.util.ArrayList;


@RestController
public class LaptopController {
  private List<Laptop> laptopuri = new ArrayList<Laptop>();

  LaptopController() {
    Laptop l1 = new Laptop(1, "Toshiba");
    Laptop l2 = new Laptop(2, "Acer");
    Laptop l3 = new Laptop(3, "ASUS");

    laptopuri.add(l1);
    laptopuri.add(l2);
    laptopuri.add(l3);
  }

  @RequestMapping(value="/laptop", method = RequestMethod.GET)
  public List<Laptop> index() {
    return this.laptopuri;
  }

  @RequestMapping(value="/laptop/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id) {
    for(Laptop l : this.laptopuri) {
      if(l.getId() == id) {
    	  l.Editaremarca( "Dell");
    	  
        return new ResponseEntity<Laptop>(l, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/laptop/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Laptop l : this.laptopuri) {
      if(l.getId() == id) {
        return new ResponseEntity<Laptop>(l, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

@RequestMapping(value="/laptop", method = RequestMethod.POST)
 
 public ResponseEntity create(@RequestBody Laptop l) {
   
 this.laptopuri.add(l);
	
return new ResponseEntity<List<Laptop>>(this.laptopuri, new HttpHeaders(), HttpStatus.OK);
 
 }



  @RequestMapping(value="/laptop/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Laptop l : this.laptopuri) {
      if(l.getId() == id) {
        this.laptopuri.remove(l);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}