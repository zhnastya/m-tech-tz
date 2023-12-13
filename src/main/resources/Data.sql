insert into bodies(type_body)
values ('Hatchback'),
       ('Sedan'),
       ('Sports') ON DUPLICATE KEY update id=id;
insert into wheels(type_wheel)
values ('R15'),
       ('R16'),
       ('R17') ON DUPLICATE KEY update id=id;