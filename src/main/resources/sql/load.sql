INSERT INTO Campaigns
VALUES (NEWID(), 'Test Campaign 1');
INSERT INTO Campaigns
VALUES (NEWID(), 'Test Campaign 2');
INSERT INTO Campaigns
VALUES (NEWID(), 'Test Campaign 3');

DECLARE @Test1Id UNIQUEIDENTIFIER;
SET @Test1Id = (select id
                from Campaigns
                where name like 'Test Campaign 1');

insert into SentCampaigns
values (NEWID(), @Test1Id, GETDATE());
insert into SentCampaigns
values (NEWID(), @Test1Id, GETDATE());

DECLARE @SentCampaignId UNIQUEIDENTIFIER;
SET @SentCampaignId = (select top 1 id
                       from SentCampaigns);

insert into Views
values (NEWID(), @SentCampaignId, GETDATE(), 'mail1@vp.pl');
insert into Views
values (NEWID(), @SentCampaignId, GETDATE(), 'mail2@vp.pl');
insert into Views
values (NEWID(), @SentCampaignId, GETDATE(), 'mail3@vp.pl');
insert into Views
values (NEWID(), @SentCampaignId, GETDATE(), 'mail4@vp.pl');
insert into Views
values (NEWID(), @SentCampaignId, GETDATE(), 'mail5@vp.pl');
insert into Views
values (NEWID(), @SentCampaignId, GETDATE(), 'mail6@vp.pl');
insert into Views
values (NEWID(), @SentCampaignId, GETDATE(), 'mail7@vp.pl');
insert into Views
values (NEWID(), @SentCampaignId, GETDATE(), 'mail8@vp.pl');

insert into SmtpConfigurations
values (NEWID(),
        'smtp.mailgun.org',
        'postmaster@sandbox3eab8b11f70c4d949b53995817d7e3ec.mailgun.org',
        'a0c8c5508ca627c2e6eab5b10d2ff336-2de3d545-59e55d55',
        587,
        1)

