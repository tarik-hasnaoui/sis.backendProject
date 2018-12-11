
package nl.hva.sisspringboot.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

 @ResponseStatus(value=HttpStatus.NOT_FOUND)
public class DataNotFoundExcpetion extends RuntimeException{
    
     public DataNotFoundExcpetion(String message){
         super(message);
     }
     
     public DataNotFoundExcpetion(){
         super();
     }
}
