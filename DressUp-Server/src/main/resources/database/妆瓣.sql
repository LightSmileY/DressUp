/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/5/15 星期三 下午 21:32:32                    */
/*==============================================================*/


drop table if exists admin_user;

drop table if exists comments;

drop table if exists favorites;

drop table if exists image;

drop table if exists likes;

drop table if exists post;

drop table if exists postMessage;

drop table if exists relation;

drop table if exists user;

/*==============================================================*/
/* Table: admin_user                                            */
/*==============================================================*/
create table admin_user
(
   id                   int not null,
   name                 varchar(20) not null,
   password             varchar(32) not null,
   email                varchar(32),
   last_login_time      datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: comments                                              */
/*==============================================================*/
create table comments
(
   userID               int not null,
   postID               int not null,
   message              text not null,
   time                 datetime not null,
   primary key (userID, postID)
);

/*==============================================================*/
/* Table: favorites                                             */
/*==============================================================*/
create table favorites
(
   userID               int not null,
   postID               int not null,
   time                 datetime not null,
   primary key (userID, postID)
);

/*==============================================================*/
/* Table: image                                                 */
/*==============================================================*/
create table image
(
   postID               int not null,
   imgID                varchar(255) not null,
   primary key (postID, imgID)
);

/*==============================================================*/
/* Table: likes                                                 */
/*==============================================================*/
create table likes
(
   userID               int not null,
   postID               int not null,
   time                 datetime not null,
   primary key (userID, postID)
);

/*==============================================================*/
/* Table: post                                                  */
/*==============================================================*/
create table post
(
   userID               int not null,
   postID               int not null,
   time                 datetime not null,
   primary key (userID, postID)
);

/*==============================================================*/
/* Table: postMessage                                           */
/*==============================================================*/
create table postMessage
(
   pid                  int not null auto_increment,
   postTime             date not null,
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
   fans                 int not null,
   follows              int not null,
   primary key (fans, follows)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   uid                  int not null auto_increment,
   name                 varchar(50) not null,
   password             varchar(50) not null,
   birthday             date,
   sex                  smallint,
   age                  smallint,
   register_date        datetime not null,
   avatarID             varchar(50),
   description          varchar(50),
   mailbox              varchar(50),
   last_login_time      datetime,
   primary key (uid),
   unique key AK_Key_2 (name)
);

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

alter table post add constraint FK_Reference_5 foreign key (userID)
      references user (uid) on delete restrict on update restrict;

alter table post add constraint FK_Reference_6 foreign key (postID)
      references postMessage (pid) on delete restrict on update restrict;

alter table relation add constraint FK_Reference_11 foreign key (fans)
      references user (uid) on delete restrict on update restrict;

alter table relation add constraint FK_Reference_12 foreign key (follows)
      references user (uid) on delete restrict on update restrict;

