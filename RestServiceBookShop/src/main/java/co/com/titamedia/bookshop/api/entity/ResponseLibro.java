package co.com.titamedia.bookshop.api.entity;

public class ResponseLibro {
	
	private String message;
	private Libro libro;
	
	public ResponseLibro(){
		
	}
	
	public ResponseLibro(String message ,Libro libro){
		
		this.message = message;
		this.libro = libro;
		
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	

}
