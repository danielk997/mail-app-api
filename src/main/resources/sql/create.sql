IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Campaigns' and xtype='U')
CREATE TABLE Campaigns (
    Name varchar(64) not null
)
    GO