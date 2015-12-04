package hello;

import java.util.List;
import java.util.ArrayList;

public class Laptop {
  private String marca;
  private int id;

  public Laptop() {}

  public Laptop(int id, String marca) {
      this.marca = marca;
      this.id = id;
  }

  public String getMarca() {
      return this.marca;
  }

  public int getId() {
    return this.id;
  }
  
  public Laptop Editaremarca( String marca )
  {
	  this.marca = marca;
	  return this;
  }
}