package teste.unidade.dominio.modelo;

import conta.sistema.dominio.modelo.Conta;
import conta.sistema.dominio.modelo.NegocioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

@DisplayName("Regra de Crédito de Conta")
public class TesteCreditoConta {

    // armazena o saldo para teste ficar dinamico
    BigDecimal cem = new BigDecimal(100);
    Conta contaValida;

    @BeforeEach
    void preparar() {
        contaValida = new Conta(1, cem, "Rebeca");
    }


    //negativos
    @Test
    @DisplayName("valor de credito nulo como obrigatório")
    void teste1() {
        try {
            contaValida.creditar(null);
            fail("valor crédito obrigatório");
        }catch (NegocioException e) {
            assertEquals(e.getMessage(), "Valor crédito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("valor de credito negativo como obrigatório")
    void teste2() {
        try {
            contaValida.creditar(new BigDecimal(-10));
            fail("valor crédito obrigatório");
        }catch (NegocioException e) {
            assertEquals(e.getMessage(), "Valor crédito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("valor de credito zero como obrigatório")
    void teste3() {
        try {
            contaValida.creditar(BigDecimal.ZERO);
            fail("valor crédito obrigatório");
        }catch (NegocioException e) {
            assertEquals(e.getMessage(), "Valor crédito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }

    //positivos
    @Test
    @DisplayName("valor de credito acima de zero")
    void teste4() {
        try {
            contaValida.creditar(BigDecimal.ONE);
            var saldoFinal = cem.add(BigDecimal.ONE);
            assertEquals(contaValida.getSaldo(), saldoFinal, "Saldo deve bater");
        }catch (NegocioException e) {
            fail("Deve creditar com sucesso - " + e.getMessage());
        }
    }
}
