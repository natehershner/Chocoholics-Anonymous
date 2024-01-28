# Chocoholics-Anonymous
Software created for the fictitious Chocoholics Anonymous company for a Computer Science course project.
# WARNING
This software utilizes Microsoft's SQL Server 2022 Express. If you do not have SQL installed, please follow the tutorial before running the project.
# SQL Install
1. Visit https://www.microsoft.com/en-us/sql-server/sql-server-downloads
2. Click "Download Now" on SQL Express
![SQL Express image] (add)
3. At the end of the install, install SSMS as well.
4. Open Sql Server Configuration Manager.
5. Open the drop-down for SQL Server Network Configuration
6. Click Protocols for SQLEXPRESS
7. Ensure Shared Memory and TCP/IP is enabled.
8. Click SQL Server Services
9. Ensure SQL Server Browser and SQL Server are both running.
Note: If your Server Browser Start Mode says disabled, follow these steps:
  Press Win + R

    Open services.msc
  
    Find and right-click SQL Server (SQLEXPRESS) and select properties.
  
    For Startup type, select manual or automatic.
  
    Return to server manager and ensure both server and server browser are running.
  
  
  
  
11. Exit the configuration manager.
12. Open SSMS.
13. Open services.msc
