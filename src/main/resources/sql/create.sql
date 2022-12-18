DROP TABLE IF EXISTS Views
DROP TABLE IF EXISTS SentCampaigns
DROP TABLE IF EXISTS Campaigns
DROP TABLE IF EXISTS Templates
DROP TABLE IF EXISTS SmtpConfigurations

CREATE TABLE Campaigns
(
    id   uniqueidentifier not null,
    name varchar(65)      not null,
    primary key (id)
)

CREATE TABLE Templates
(
    id      uniqueidentifier not null,
    name    varchar(65)      not null,
    content nvarchar(max) not null,
    primary key (id)
)

CREATE TABLE SentCampaigns
(
    id         uniqueidentifier not null,
    campaignId uniqueidentifier not null,
    templateId uniqueidentifier not null,
    startDate  datetime         not null,
    primary key (id),
    foreign key (campaignId) references Campaigns (id),
    foreign key (templateId) references Templates (id),
)


CREATE TABLE Views
(
    id             uniqueidentifier not null,
    sentCampaignId uniqueidentifier not null,
    viewDate       datetime         not null default getdate(),
    email          nvarchar(255) not null,
    primary key (id),
    foreign key (sentCampaignId) references SentCampaigns (id)
)

CREATE TABLE SmtpConfigurations
(
    id       uniqueidentifier not null,
    host     nvarchar(255) not null,
    userName nvarchar(255) not null,
    password nvarchar(255) not null,
    port     int              not null,
    active   bit default 0,
    primary key (id),
)