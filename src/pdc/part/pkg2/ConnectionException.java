/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.part.pkg2;

/**
 *
 * @author elija
 */
public class ConnectionException extends Exception
{
    public ConnectionException()
    {
        super("There was an error that occurred when connecting to the database. Please try again later.");
    }
}
