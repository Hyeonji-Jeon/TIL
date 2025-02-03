CREATE DATABASE webdb;

CREATE USER 'webdbuser'@'localhost' IDENTIFIED BY 'webdbuser';
CREATE USER 'webdbuser'@'%' IDENTIFIED BY 'webdbuser';

GRANT ALL PRIVILEGES ON webdb.* TO 'webdbuser'@'localhost';

GRANT ALL PRIVILEGES ON webdb.* TO 'webdbuser'@'%';
webdb


CREATE DATABASE hyeondb;
 
CREATE USER 'hyeon' @'localhost' IDENTIFIED BY 'hyeon';
CREATE USER 'hyeon' @'%' IDENTIFIED BY 'hyeon';

GRANT ALL PRIVILEGES ON hyeondb.* TO 'hyeon' @'localhost';

GRANT ALL PRIVILEGES ON hyeondb.* TO 'hyeon' @'%' ;
hyeondb
