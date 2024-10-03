package teste;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({
        // teste regras
        "teste.unidade.dominio.modelo",
        //  teste serviços
        "teste.unidade.dominio.servico",
        // teste porta entrada (driver)
        "teste.casouso",
})
public class SuiteCore {
}
