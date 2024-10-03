package teste.unidade.dominio.servico;

import conta.sistema.dominio.modelo.Conta;
import conta.sistema.dominio.modelo.NegocioException;
import conta.sistema.dominio.servico.Transferencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

@DisplayName("Regra de Transferência")
public class TesteTransferencia {

    BigDecimal cem = new BigDecimal(100);
    BigDecimal vinte = new BigDecimal(20);
    Transferencia transferencia;
    Conta contaDebito;
    Conta contaCredito;

    @BeforeEach
    void prepara() {
        contaDebito = new Conta(1, cem, "Fernando");
        contaCredito = new Conta(2, cem, "Rebeca");
        transferencia = new Transferencia();
    }

    //negativos
    @Test
    @DisplayName("valor nulo como obrigatório")
    void teste1() {
        try {
            transferencia.processar(null, contaDebito, contaCredito);
            fail("valor transferência obrigatório");
        }catch (NegocioException e) {
            assertEquals(e.getMessage(), "Valor da transferência é obrigatório.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("conta de débito como obrigatório")
    void teste2() {
        try {
            transferencia.processar(vinte, null, contaCredito);
            fail("conta débito obrigatório");
        }catch (NegocioException e) {
            assertEquals(e.getMessage(), "Conta débito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("conta de crédito como obrigatório")
    void teste3() {
        try {
            transferencia.processar(vinte, contaDebito, null);
            fail("conta crédito obrigatório");
        }catch (NegocioException e) {
            assertEquals(e.getMessage(), "Conta crédito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }

    //positivos
    @Test
    @DisplayName("transferir 20 reais")
    void teste4() {
        try {
            transferencia.processar(vinte, contaDebito, contaCredito);
            assertEquals(contaDebito.getSaldo(), cem.subtract(vinte), "Saldo da conta débito deve bater");
            assertEquals(contaCredito.getSaldo(), cem.add(vinte), "Saldo da conta crédito deve bater");
        }catch (NegocioException e) {
            fail("Deve transferir com sucesso");
            System.out.println(e.getMessage());
        }
    }

}
