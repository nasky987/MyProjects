create table MEMBER (
    member_email varchar2(30) primary key,
    member_password varchar2(16),
    member_name varchar2(30),
    member_birth char(8),
    member_gender char(1),
    member_phone_number varchar2(11)
);