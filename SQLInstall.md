# SQL Install
1. Visit https://www.microsoft.com/en-us/sql-server/sql-server-downloads
2. Click "Download Now" on SQL Express
3. At the end of the install, install SSMS as well.
4. Open Sql Server Configuration Manager.
5. Open the dropdown for SQL Server Network Configuration
6. Click Protocols for SQLEXPRESS
7. Ensure Shared Memory and TCP/IP is enabled.
8. Click SQL Server Services
9. Ensure SQL Server Browser and SQL Server are both running.
Note: If your Server Browser Start Mode says disabled, follow these steps:

        Press Win + R

        Open services.msc
  
        Find and right-click SQL Server Browser and select properties.
  
        For Startup type, select manual or automatic.
  
        Return to server manager and ensure both server and server browser are running.
  
  
  
  
12. Open SSMS.
13. Connect to your server via Windows Authentication
14. Right-click your server in the Object Explorer and select properties.
15. In the security tab, change your Server authentication to SQL Server and Windows Authentication mode.
16. Open the Security dropdown.
17. Right-click Logins and select new login.
18. Click SQL Server authentication and enter a login name and password, disable "Enforce password policy" if you would like to remove the requirements on your password.
19. Click OK to save the new user
20. Select "New Query"
21. Run the command

        USE master;

        GRANT CREATE ANY DATABASE TO yourUser;
  
22. Return to the server manager.
23. Select SQL Server Services.
24. Right-click your server and select "restart" or "start" if it is already stopped.
You will now be able to finish the setup for the project.
