module conta.desktop {
    //==> BUILD 2
    // usar conta sistema
    requires conta.sistema;
    // usar spring
    requires javax.inject;
    requires spring.tx;
    requires spring.core;
    requires spring.beans;
    requires spring.context;
    requires java.sql;

    // usar javafx
    requires javafx.controls;

    // abre telas e builds
    opens conta.tela;
    opens conta.dsv;
    opens conta.hml;
    opens conta.prd;

    //==> BUILD 3 e 4
    // usa conta serviços
    requires conta.servicos;
    requires spring.jdbc;
    requires hsqldb;

}