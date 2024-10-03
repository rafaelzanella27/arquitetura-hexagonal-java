package conta.dsv;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// Responsável por configurar os serviços do spring
@Configuration
@ComponentScan({
        // adaptadores de front-end javafx
        "conta.dsv",
        "conta.tela",
        // objetos de sistema
        "conta.sistema",
        // adaptadores falsos
        "conta.adaptador"
})
public class Build2 {
    // Build 1: Adaptador JavaFX -> Sistema <- Adptadores Mocks
}
