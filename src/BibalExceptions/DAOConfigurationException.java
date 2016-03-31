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
public class DAOConfigurationException extends RuntimeException{

    public DAOConfigurationException(String message) {
        super(message);
    }

    public DAOConfigurationException(Throwable cause) {
        super(cause);
    }
    
    
    public DAOConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
    
}
