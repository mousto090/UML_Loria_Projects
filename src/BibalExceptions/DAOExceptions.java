/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibalExceptions;

/**
 *
 * @author Jalloh
 */
public class DAOExceptions extends RuntimeException{

    public DAOExceptions(String message) {
        super(message);
    }
    
    public DAOExceptions(Throwable cause) {
        super(cause);
    }
    
    public DAOExceptions(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
