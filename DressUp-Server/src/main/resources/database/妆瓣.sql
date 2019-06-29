/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/6/19 星期三 上午 9:37:15                     */
/*==============================================================*/


drop table if exists admin_role;

drop table if exists admin_user;

drop table if exists comments;

drop table if exists favorites;

drop table if exists image;

drop table if exists likes;

drop table if exists postMessage;

drop table if exists relation;

drop table if exists role;

drop table if exists user;

/*==============================================================*/
/* Table: admin_role                                            */
/*==============================================================*/
create table admin_role
(
   admin_name           varchar(50) not null,
   role_code            varchar(30) not null,
   primary key (admin_name, role_code)
);

/*==============================================================*/
/* Table: admin_user                                            */
/*==============================================================*/
create table admin_user
(
   name                 varchar(50) not null,
   password             varchar(50) not null,
   email                varchar(50),
   last_login_time      datetime,
   primary key (name)
);

/*==============================================================*/
/* Table: comments                                              */
/*==============================================================*/
create table comments
(
   userID               varchar(50) not null,
   postID               varchar(50) not null,
   message              text not null,
   time                 datetime not null,
   primary key (userID, postID)
);

/*==============================================================*/
/* Table: favorites                                             */
/*==============================================================*/
create table favorites
(
   userID               varchar(50) not null,
   postID               varchar(50) not null,
   time                 datetime not null,
   primary key (userID, postID)
);

/*==============================================================*/
/* Table: image                                                 */
/*==============================================================*/
create table image
(
   postID               varchar(50) not null,
   imgID                varchar(255) not null,
   primary key (postID, imgID)
);

/*==============================================================*/
/* Table: likes                                                 */
/*==============================================================*/
create table likes
(
   userID               varchar(50) not null,
   postID               varchar(50) not null,
   time                 datetime not null,
   primary key (userID, postID)
);

/*==============================================================*/
/* Table: postMessage                                           */
/*==============================================================*/
create table postMessage
(
   pid                  varchar(50) not null,
   uid                  varchar(50),
   post_time             datetime not null,
   type                 tinyint not null,
   title                varchar(50),
   messagebody          text not null,
   primary key (pid)
);

/*==============================================================*/
/* Table: relation                                              */
/*==============================================================*/
create table relation
(
   fans                 varchar(50) not null,
   follows              varchar(50) not null,
   primary key (fans, follows)
);

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   role_code            varchar(30) not null,
   role_name            varchar(30) not null,
   primary key (role_code)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   uid                  varchar(50) not null,
   name                 varchar(50) not null,
   password             varchar(50) not null,
   birthday             date,
   sex                  smallint,
   age                  smallint,
   register_date        datetime not null,
   avatarID             varchar(256),
   description          varchar(50),
   mailbox              varchar(50),
   last_login_time      datetime,
   primary key (uid),
   unique key AK_Key_2 (name)
);

alter table admin_role add constraint FK_Reference_13 foreign key (admin_name)
      references admin_user (name) on delete restrict on update restrict;

alter table admin_role add constraint FK_Reference_14 foreign key (role_code)
      references role (role_code) on delete restrict on update restrict;

alter table comments add constraint FK_Reference_7 foreign key (userID)
      references user (uid) on delete restrict on update restrict;

alter table comments add constraint FK_Reference_8 foreign key (postID)
      references postMessage (pid) on delete restrict on update restrict;

alter table favorites add constraint FK_Reference_1 foreign key (userID)
      references user (uid) on delete restrict on update restrict;

alter table favorites add constraint FK_Reference_2 foreign key (postID)
      references postMessage (pid) on delete restrict on update restrict;

alter table image add constraint FK_Reference_9 foreign key (postID)
      references postMessage (pid) on delete restrict on update restrict;

alter table likes add constraint FK_Reference_3 foreign key (userID)
      references user (uid) on delete restrict on update restrict;

alter table likes add constraint FK_Reference_4 foreign key (postID)
      references postMessage (pid) on delete restrict on update restrict;

alter table postMessage add constraint FK_Reference_15 foreign key (uid)
      references user (uid) on delete restrict on update restrict;

alter table relation add constraint FK_Reference_11 foreign key (fans)
      references user (uid) on delete restrict on update restrict;

alter table relation add constraint FK_Reference_12 foreign key (follows)
      references user (uid) on delete restrict on update restrict;

