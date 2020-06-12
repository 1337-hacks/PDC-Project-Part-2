/*
 * --- DESCRIPTION ---
 *
 * Custom exception, this is used to detect if the seats are full
 * the user is unable to book anymore for this particular trainline.
 */

package pdc.part.pkg2;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */

public class SeatsAreFullException extends Exception
{
    public SeatsAreFullException()
    {
        super("All seats in this selection are full. We are sorry for the inconvenience.");
    }
}
