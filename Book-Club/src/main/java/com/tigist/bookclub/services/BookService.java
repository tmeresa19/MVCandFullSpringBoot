package com.tigist.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tigist.bookclub.models.Book;
import com.tigist.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
		//	//import repository
		//	private final BookRepository bookRepo;
		//	
		//	//constructor
		//	public BookService( BookRepository bookRepo) {
		//		this.bookRepo = bookRepo;
		//	}
	
	        //Alternative way to import repository than using the above 3 lines of code
	@Autowired
	private BookRepository bookRepo;
	
	
	//====================BUILDING ALL BACKEND LOGIC WITH CRUD===================================//
	
	
	  //==================FIND ALL=======================================================//
	
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	  //==================CREATE===========================================================//
	
		public Book createBook(Book newBook) {
				// meaning, go to the bookRepo and save the newBook. 
				//Even if we didn't include the save method inside the Repository,we can still use it. 
				//That's why, we were able to get all the books and save the create or post books in the controller 
			return bookRepo.save(newBook);
	}
	
		//=================FIND ONE BY ID===================================================//
		
				//The return type of find by id is an Interface/class called Optional. So, it retrieves an entity by it's id
				//it's called Optional data type because it gives us whether something is present or not. If not present, no error will be displayed.
		public Book findOne(Long id) {
				//return bookRepo.findById(id); since it's optional, we can't return like this but like below:
			Optional<Book> optionalBook = bookRepo.findById(id);
				//created optionalBook object or variable with the datatype of Optional Book
			if(optionalBook.isPresent())//one of the method of Optional type is isPresent().
				return optionalBook.get();//get() allows us to get the data type inside the <> which is of type Book
			else {
				return null; //because Book could be null. And null is accepted for Book datatype
			}
		}
		
		//====================EDIT OR UPDATE============================================//
			
		public Book updateBook(Book oneBook) { //create and update implementations in the service side is the same as long as we provided the id
//				System.out.println(oneBook.getId());
				return bookRepo.save(oneBook);		//edit or update implementation is a combination of create and find by id methods
				
			}
		
		//====================DELETE======================================================//
		
		public void removeBook(Long id) {
			bookRepo.deleteById(id);
		}
}
