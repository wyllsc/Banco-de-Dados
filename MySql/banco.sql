  alter table PROCESSO 
        drop 
        foreign key FKF2BC9FE0E3AB9D0C

    alter table USUARIO 
        drop 
        foreign key FK22E07F0E848B6EFB

    alter table USUARIO 
        drop 
        foreign key FK22E07F0EEB46C149

    drop table if exists ANDAMENTO_PROCESSO

    drop table if exists PESSOA

    drop table if exists PROCESSO

    drop table if exists USUARIO

    create table ANDAMENTO_PROCESSO (
        ID_ANDAMENTO_PROCESSO bigint not null auto_increment,
        DESCRICAO varchar(200),
        TIPO char(1),
        primary key (ID_ANDAMENTO_PROCESSO)
    )

    create table PESSOA (
        ID_PESSOA bigint not null auto_increment,
        ENDERECO varchar(200),
        NOME varchar(200),
        TELEFONE bigint,
        primary key (ID_PESSOA)
    )

    create table PROCESSO (
        ID_PROCESSO bigint not null auto_increment,
        ADVOGADO varchar(255),
        DATA_FIM datetime,
        DATA_INICIO datetime,
        DESCRICAO varchar(255),
        DESEMBARGADOR varchar(255),
        NUM_PROCESSO bigint,
        OBSERVACAO varchar(255),
        REQUERENTE varchar(255),
        REQUERIDO varchar(255),
        ID_ANDAMENTO_PROCESSO bigint,
        primary key (ID_PROCESSO)
    )

    create table USUARIO (
        ID_USUARIO bigint not null auto_increment,
        LOGIN bigint,
        SENHA bigint,
        TIPO char(1),
        ID_PESSOA bigint,
        ID_PROCESSO bigint,
        primary key (ID_USUARIO)
    )

    alter table PROCESSO 
        add index FKF2BC9FE0E3AB9D0C (ID_ANDAMENTO_PROCESSO), 
        add constraint FKF2BC9FE0E3AB9D0C 
        foreign key (ID_ANDAMENTO_PROCESSO) 
        references ANDAMENTO_PROCESSO (ID_ANDAMENTO_PROCESSO)

    alter table USUARIO 
        add index FK22E07F0E848B6EFB (ID_PROCESSO), 
        add constraint FK22E07F0E848B6EFB 
        foreign key (ID_PROCESSO) 
        references PROCESSO (ID_PROCESSO)

    alter table USUARIO 
        add index FK22E07F0EEB46C149 (ID_PESSOA), 
        add constraint FK22E07F0EEB46C149 
        foreign key (ID_PESSOA) 
        references PESSOA (ID_PESSOA)