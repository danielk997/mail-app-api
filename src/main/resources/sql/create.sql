DROP TABLE IF EXISTS Views
DROP TABLE IF EXISTS SentCampaigns
DROP TABLE IF EXISTS Campaigns
DROP TABLE IF EXISTS Templates
DROP TABLE IF EXISTS ReceiverGroupLink
DROP TABLE IF EXISTS Receivers
DROP TABLE IF EXISTS ReceiverGroup
DROP TABLE IF EXISTS SmtpConfigurations

CREATE TABLE Campaigns
(
    id   BIGINT identity not null,
    name varchar(65)     not null,
    primary key (id)
)

CREATE TABLE Receivers
(
    id    BIGINT identity    not null,
    name  nvarchar(65)       not null,
    email varchar(65) unique not null,
    primary key (id)
)

CREATE TABLE ReceiverGroup
(
    id   BIGINT identity not null,
    name nvarchar(65)    not null,
    primary key (id)
)

CREATE TABLE ReceiverGroupLink
(
    receiverId BIGINT not null,
    groupId    BIGINT not null,
)

CREATE TABLE Templates
(
    id      BIGINT identity not null,
    name    varchar(65)     not null,
    content nvarchar(max)   not null,
    primary key (id)
)

CREATE TABLE SentCampaigns
(
    id               UNIQUEIDENTIFIER not null,
    campaignId       BIGINT           not null,
    templateId       BIGINT           not null,
    receiversGroupId BIGINT           not null,
    startDate        datetime         not null,
    status           varchar(64)      not null default 'SCHEDULED',
    primary key (id),
    foreign key (campaignId) references Campaigns (id),
    foreign key (templateId) references Templates (id),
    foreign key (receiversGroupId) references ReceiverGroup (id),
)


CREATE TABLE Views
(
    id             BIGINT identity  not null,
    sentCampaignId UNIQUEIDENTIFIER not null,
    viewDate       datetime         not null default getdate(),
    email          nvarchar(255)    not null,
    primary key (id),
    foreign key (sentCampaignId) references SentCampaigns (id)
)

CREATE TABLE SmtpConfigurations
(
    id       BIGINT identity not null,
    host     nvarchar(255)   not null,
    userName nvarchar(255)   not null,
    password nvarchar(255)   not null,
    port     int             not null,
    active   bit default 0,
    primary key (id),
)