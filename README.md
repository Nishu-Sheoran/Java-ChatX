# Java-ChatX
A beginner-friendly Java chat project showcasing socket programming and multi-client handling.

Java-ChatX is a multithreaded, network-based chat application built using Java, Socket Programming, Swing GUI, and SQL Database. It allows multiple clients on different machines to communicate in real-time through a central server, with full support for user authentication, data security, and a friendly graphical interface.

Features
User Registration & Login:

New clients can register and create an account with a username and password.

Existing users can log in using their credentials.

Users can also change their password for security purposes.

Real-Time Chat Between Multiple Users:

Supports messaging between clients on different machines.

Uses Socket Programming and Multithreading to handle multiple clients simultaneously.

Messages are broadcasted to all connected clients in real-time.

Networking & Server Architecture:

Single Server Socket manages multiple clients.

Each client connects via its own Client Socket using an IP address and port number.

Ensures seamless communication between server and clients.

Database Integration & Security:

Stores user information securely using an SQL database.

User data is encrypted to maintain privacy and security.

Graphical User Interface (GUI):

Implemented using Swing.

Includes visually appealing login/register screens and chat screens.

Uses event listeners to perform various actions (e.g., sending messages, updating password).

Exception Handling:

All critical operations are wrapped in exception handling to prevent crashes and handle errors gracefully.


Technologies Used
Java – Core language for the application logic

Swing – For building GUI interfaces

Socket Programming – For network communication between server and clients

Multithreading – To handle multiple clients concurrently

SQL Database – To store user credentials and chat information securely

Encryption Techniques – For secure storage of user data

How It Works
Server Setup:

Start the server socket on a chosen IP and port.

The server listens for incoming client connections.

Client Connection:

Clients connect to the server using the IP and port.

New users register, while existing users log in using stored credentials.

Messaging:

Once connected, clients can send messages that are broadcasted to all users.

Multithreading ensures each client can send and receive messages independently.

Database Interaction:

User credentials are securely stored and retrieved from the SQL database.

Passwords can be updated for security.

Project Highlights
Multi-threaded network programming

Real-time chat across multiple machines

Secure user authentication with SQL database

User-friendly GUI using Swing

Exception handling for robust code

Future Enhancements
Add file sharing between clients

Add group/private chat rooms

Implement notification system for new messages

Use advanced encryption algorithms for even stronger security


