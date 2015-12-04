package hello;

import java.util.List;
import java.util.ArrayList;

public class Telefon {
  private String marca;
  private int id;

  public Telefon() {}

  public Telefon(int id, String brand) {
      this.marca = brand;
      this.id = id;
  }

  public String getMarca() {
      return this.marca;
  }

  public int getId() {
    return this.id;
  }
  
  public Telefon Editaremarca( String brand )
  {
	  this.marca = brand;
	  return this;
  }
}