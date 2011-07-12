
delete from ticketChange
delete from ticketOwner
delete from ticket
delete from user

insert into user (name, password, role) values('joseph', 'password', 'ticket-user')
insert into user (name, password, role) values('admin', 'password', 'ticket-admin')
insert into user (name, password, role) values('worker', 'password', 'ticket-worker')
