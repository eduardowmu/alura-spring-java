package med.voll.api.validacoes;

import med.voll.api.consulta.DadosAgendamentoConsulta;

@FunctionalInterface
public interface Validador {
    void validar(DadosAgendamentoConsulta dados);
}