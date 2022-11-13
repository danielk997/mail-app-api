DROP TABLE IF EXISTS Views
DROP TABLE IF EXISTS SentCampaigns
DROP TABLE IF EXISTS Campaigns

CREATE TABLE Campaigns
(
    id   uniqueidentifier not null,
    name varchar(65)      not null,
    primary key (id)
)


CREATE TABLE SentCampaigns
(
    id uniqueidentifier not null,
    campaignId uniqueidentifier not null,
    startDate date not null,
    primary key (id),
    foreign key (campaignId) references Campaigns(id)
)


CREATE TABLE Views
(
    id uniqueidentifier not null,
    sentCampaignId uniqueidentifier not null,
    viewDate date not null,
    email nvarchar(255) not null,
    primary key (id),
    foreign key (sentCampaignId) references SentCampaigns(id)
)