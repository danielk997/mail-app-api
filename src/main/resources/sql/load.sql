INSERT INTO Campaigns
VALUES ('Test Campaign 1');
INSERT INTO Campaigns
VALUES ('Test Campaign 2');
INSERT INTO Campaigns
VALUES ('Test Campaign 3');

INSERT INTO Templates
VALUES ('Test Template 1', '<h1 style="color: red;">Template works</h1>')

DECLARE @Campaign1Id BIGINT;
DECLARE @Template1Id BIGINT;
SET @Campaign1Id = (select id
                    from Campaigns
                    where name like 'Test Campaign 1');

SET @Template1Id = (select id
                    from Templates
                    where name like 'Test Template 1');

insert into Receivers
values ('name1', 'danielkociolek@vp.pl');
insert into Receivers
values ('name2', 'mail2@vp.pl');
insert into Receivers
values ('name3', 'mail3@vp.pl');
insert into Receivers
values ('name4', 'mail4@vp.pl');
insert into Receivers
values ('name5', 'mail5@vp.pl');
insert into Receivers
values ('name6', 'mail6@vp.pl');

insert into ReceiverGroup
values ('test_group');

insert into ReceiverGroupLink
values (1, 1);

insert into SentCampaigns (id, campaignId, templateId, receiversGroupId, startDate, status)
values (NEWID(), @Campaign1Id, @Template1Id, 1, GETDATE(), 'FINISHED');

DECLARE @SentCampaignId UNIQUEIDENTIFIER;
SET @SentCampaignId = (select top 1 id
                       from SentCampaigns);

insert into Views
values (@SentCampaignId, GETDATE(), 'mail1@vp.pl');
insert into Views
values (@SentCampaignId, GETDATE(), 'mail2@vp.pl');
insert into Views
values (@SentCampaignId, GETDATE(), 'mail3@vp.pl');
insert into Views
values (@SentCampaignId, GETDATE(), 'mail4@vp.pl');
insert into Views
values (@SentCampaignId, GETDATE(), 'mail5@vp.pl');
insert into Views
values (@SentCampaignId, GETDATE(), 'mail6@vp.pl');
insert into Views
values (@SentCampaignId, GETDATE(), 'mail7@vp.pl');
insert into Views
values (@SentCampaignId, GETDATE(), 'mail8@vp.pl');

insert into SmtpConfigurations
values ('smtp.mailgun.org',
        'postmaster@sandbox3eab8b11f70c4d949b53995817d7e3ec.mailgun.org',
        'a0c8c5508ca627c2e6eab5b10d2ff336-2de3d545-59e55d55',
        587,
        1)

