# PDC-Project-Part-2
Me and Sangy's work

12/6/20 - Added a Login and Registration form before being able to book a train seat.
        - Added database to store login information such as the username, password etc.
        - Improved GUI
        - Fixed bug where an account with no username could be created.
        
13/6/20 - Improved GUI
        - Database connection now closes upon the window closing.
        - Added a log out button
        - User is now able to choose a train line
        - Fixed bug where text fields will still hold past entries
        
        
13/6/20 - Modified Seat and SeatGrid allows for JToggleButton Implementation.
        - TestWindow tests the above SeatGrid class. Note: SeatGrid extends JPanel.
        - SeatGrid still needs to be implemented to the main code!

14/6/20 - Added window where user can select and their chosen seats (still needs polishing)
        - Added an arraylist under TrainDataModel that holds user's chosen seats.
        - TODO: Add a jpanel under MainFrame which shows the details of user's selected seats as well as the total price.
        - TODO: create the .txt file to hold user's selected seats, and read and write them.
        - TODO: Polished GUI.
