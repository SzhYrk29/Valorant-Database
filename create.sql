create table ability (id bigint not null auto_increment, agent_uuid varchar(255), display_icon varchar(255), display_name varchar(255), slot varchar(255), description longtext, primary key (id)) engine=InnoDB;
create table agent (is_playable_character bit not null, display_icon varchar(255), display_name varchar(255), role_uuid varchar(255), uuid varchar(255) not null, description longtext, primary key (uuid)) engine=InnoDB;
create table callout (id bigint not null auto_increment, map_uuid varchar(255), region_name varchar(255), super_region_name varchar(255), primary key (id)) engine=InnoDB;
create table map (coordinates varchar(255), display_icon varchar(255), display_name varchar(255), splash varchar(255), tactical_description varchar(255), uuid varchar(255) not null, primary key (uuid)) engine=InnoDB;
create table role (display_icon varchar(255), display_name varchar(255), uuid varchar(255) not null, description longtext, primary key (uuid)) engine=InnoDB;
alter table agent add constraint UKhfpi9iyvucnb2ro81xcbma1a3 unique (display_name);
alter table ability add constraint FKbib1sqjy10vnd7440ts6nneg1 foreign key (agent_uuid) references agent (uuid);
alter table agent add constraint FK7txk3lmpvnkj2kowlfsypxuba foreign key (role_uuid) references role (uuid);
alter table callout add constraint FKglqakj9psh4xgxep34xrv7bli foreign key (map_uuid) references map (uuid);
