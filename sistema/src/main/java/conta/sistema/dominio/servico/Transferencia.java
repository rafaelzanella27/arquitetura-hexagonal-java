package conta.sistema.dominio.servico;

import conta.sistema.dominio.modelo.Conta;

import javax.inject.Named;
import java.math.BigDecimal;

import static java.util.Objects.isNull;
import static conta.sistema.dominio.modelo.Erro.obrigatorio;

// Responsável por representar a entidade transferência e suas regras.
// Será gerenciado pelo IoC
@Named
public class Transferencia {
    public void processar (BigDecimal valor, Conta debito, Conta credito){
        if (isNull(valor)) {
            obrigatorio("Valor da transferência");
        }
        if (isNull(debito)) {
            obrigatorio("Conta débito");
        }
        if (isNull(credito)) {
            obrigatorio("Conta crédito");
        }
        debito.debitar(valor);
        credito.creditar(valor);
    }
}
