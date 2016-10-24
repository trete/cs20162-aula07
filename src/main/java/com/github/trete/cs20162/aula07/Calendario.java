/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.trete.cs20162.aula07;

import java.time.LocalDate;

/**
 *Implementação de cálculo do dia da semana.
 */
public abstract class Calendario {
    /**
     * valor que representa o mês de janeiro.
     */
    public static final int JANEIRO = 1;
    /**
     * valor que representa o mês de fevereiro.
     */
    public static final int FEVEREIRO = 2;
    /**
     * valor que representa o mês de março.
     */
    public static final int MARCO = 3;
    /**
     * valor que representa o mês de abril.
     */
    public static final int ABRIL = 4;
    /**
     * valor que representa o mês de maio.
     */
    public static final int MAIO = 5;
    /**
     * valor que representa o mês de junho.
     */
    public static final int JUNHO = 6;
    /**
     * valor que representa o mês de julho.
     */
    public static final int JULHO = 7;
    /**
     * valor que representa o mês de agosto.
     */
    public static final int AGOSTO = 8;
    /**
     * valor que representa o mês de setembro.
     */
    public static final int SETEMBRO = 9;
    /**
     * valor que representa o mês de outubro.
     */
    public static final int OUTUBRO = 10;
    /**
     * valor que representa o mês de novembro.
     */
    public static final int NOVEMBRO = 11;
    /**
     * valor que representa o mês de dezembro.
     */
    public static final int DEZEMBRO = 12;

    /**
     * valor de data mais alto que não resulta em exceção.
     */
    private static final int LIMIAR_ACEITACAO = 99999999;
    /**
     * valor de data mais baixo que não resulta em exceção.
     */
    private static final int DATA_MINIMA = 10000000;
    /**
     * quantidade de meses no ano.
     */
    private static final int QNT_MESES = 12;
    /**
     * numero de dias num fevereiro de ano bissexto.
     */
    private static final int FEVEREIRO_BISSEXTO = 29;
    /**
     * numero de dias num fevereiro de um ano não-bissexto.
     */
    private static final int FEVEREIRO_COMUM = 28;
    /**
     * numero de dias num mês que vai até o dia 30.
     */
    private static final int MES_DE_TRINTA_DIAS = 30;
    /**
     * numero de dias num mes que vai até o dia 31.
     */
    private static final int MES_DE_TRINTA_E_UM_DIAS = 31;
    /**
     * numero somado a um inteiro de 8 digitos que representa o dia final de um
     * mês de fevereiro de um ano bissexto no formato aaaammdd de modo a
     * incrementar o mês em uma unidade.
     */
    private static final int VIRA_FEVEREIRO_BISSEXTO = 71;
    /**
     * numero somado a um inteiro de 8 digitos que representa o dia final de um
     * mês de fevereiro de um ano não-bissexto no formato aaaammdd de modo a
     * incrementar o mês em uma unidade.
     */
    private static final int VIRA_FEVEREIRO_COMUM = 72;
    /**
     * numero somado a um inteiro de 8 digitos que representa o dia final de um
     * mês de 31 dias no formato aaaammdd de modo a incrementar o valor do mês
     * em uma unidade.
     */
    private static final int VIRA_MES_TRINTA_E_UM_DIAS = 69;
    /**
     * numero somado a um inteiro de 8 digitos que representa o dia final de um
     * mês de 30 dias no formato aaaammdd de modo a incrementar o valor do mês
     * em uma unidade.
     */
    private static final int VIRA_MES_TRINTA_DIAS = 70;
    /**
     *
     * numero somado a um inteiro de 8 digitos que representa o dia final de um
     * ano no formato aaaammdd de modo a incrementar o valor do ano em uma
     * unidade.
     */
    private static final int VIRA_ANO = 8869;
    /**
     * número pelo qual um inteiro de 8 dígitos que representa uma data no
     * formato aaaammdd deve ser dividido para se obter o valor do ano da data.
     */
    private static final int DIGITOS_ANOS = 10000;
    /**
     * número pelo qual um inteiro de 8 dígitos que representa uma data no
     * formato aaaammdd deve ser dividido para se obter o valor do dia da data.
     */
    private static final int DIGITOS_DIAS = 100;
    /**
     * valor que representa a segunda feira nos métodos da classe.
     */
    private static final int SEGUNDA = 0;
    /**
     * valor que representa a segunda feira nos métodos da classe.
     */
    private static final int DOMINGO = 6;
    /**
     * resultado do resto por CHECA_BISSEXTO que caracteriza um ano bissexto.
     */
    private static final int RESTO_DE_BISSEXTO_POR_QUATRO = 0;
    /**
     * numero usado para extrair o resto da divisão inteira pela subtração entre
     * o valor do ano e o valor do inteiro tomado como ano bissexto pelos
     * métodos da classe.
     */
    private static final int CHECA_BISSEXTO = 4;
    /**
     * valor retornado pelo método verificaData quando a data é válida.
     */
    private static final int DATA_VALIDA = 1;
    /**
     * valor ao qual o dia do mês deve se igualar para que o valor do mês seja
 reduzido em 1 no método diaSemanaAuxDataMenor.
     */
    private static final int VIRA_MES_DECRESCENTE = 1;
    /**
     * valor retornado em caso de inserção de parâmetros que representam datas
     * inválidas nos métodos da classe.
     */
    private static final int ERRO = -1;
    /**
      *método que verifica a validade de uma data.
     * @param data data cuja validade do mês será verificada.
     * @param bissexto ano que será tomado como base para verificar bissextos.
     * @return -1 se a data for inválida e 0 se for válida.
     */
    protected static int verificaData(final int data, final int bissexto) {
        int dia = data % DIGITOS_DIAS;
        int mes = (data % DIGITOS_ANOS) / DIGITOS_DIAS;
        int ano = data / DIGITOS_ANOS;
        switch (mes) {
            //casos de dia do mês da data desconhecida inválidos
            case JANEIRO:
                if (dia > MES_DE_TRINTA_E_UM_DIAS) {
                    return ERRO;
                }
            case FEVEREIRO:
                if ((ano - bissexto) % CHECA_BISSEXTO
                        == RESTO_DE_BISSEXTO_POR_QUATRO) {
                    if (dia > FEVEREIRO_BISSEXTO) {
                        return ERRO;
                    }
                } else {
                    if (dia > FEVEREIRO_COMUM) {
                        return ERRO;
                    }
                }
            case MARCO:
                if (dia > MES_DE_TRINTA_E_UM_DIAS) {
                    return ERRO;
                }
            case ABRIL:
                if (dia > MES_DE_TRINTA_DIAS) {
                    return ERRO;
                }
            case MAIO:
                if (dia > MES_DE_TRINTA_E_UM_DIAS) {
                    return ERRO;
                }
            case JUNHO:
                if (dia > MES_DE_TRINTA_DIAS) {
                    return ERRO;
                }
            case JULHO:
                if (dia > MES_DE_TRINTA_E_UM_DIAS) {
                    return ERRO;
                }
            case AGOSTO:
                if (dia > MES_DE_TRINTA_E_UM_DIAS) {
                    return ERRO;
                }
            case SETEMBRO:
                if (dia > MES_DE_TRINTA_DIAS) {
                    return ERRO;
                }
            case OUTUBRO:
                if (dia > MES_DE_TRINTA_E_UM_DIAS) {
                    return ERRO;
                }
            case NOVEMBRO:
                if (dia > MES_DE_TRINTA_DIAS) {
                    return ERRO;
                }
            case DEZEMBRO:
                if (dia > MES_DE_TRINTA_E_UM_DIAS) {
                    return ERRO;
                }
            default:
                return DATA_VALIDA;
        }
    }
    /**
      *Método que retorna o dia da semana de uma data baseado nos dados
      *inseridos a respeito de outra data.
     * @param data inteiro de 8 digitos que representa a data da qual se quer
     * descobrir o dia da semana, no formato aaaammdd.
     * @param bissexto numero que o programa toma como ano bissexto conhecido.
     * @param dataConhecida inteiro de 8 digitos que representa uma data da qual
     * se sabe o dia da semana, no formato aaaammdd.
     * @param diaConhecido dia da semana da data conhecida, 0 vale segunda
     * feira, 1 vale terça feira, e assim por diante até domingo(6).
     * @return o valor inteiro correspondente ao dia da semana da data
     * representada pelo parâmetro "data" (0 significa segunda feira, 1
     * significa terça feira, e assim por diante até domingo, que é representado
     * por 6. -1 é retornado em caso de erro).
     * @throws RuntimeException se data ou dataConhecida forem menores que
     * 10000000 ou maiores que 99999999.
     */
    public static int diaSemana(final int data, final int bissexto,
            final int dataConhecida, final int diaConhecido)
            throws RuntimeException {
        if (data < DATA_MINIMA || data > LIMIAR_ACEITACAO
                || dataConhecida < DATA_MINIMA
                || dataConhecida > LIMIAR_ACEITACAO) {
            throw new RuntimeException("as datas devem ser inteiros"
                    + " de 8 dígitos");
        }
        if (bissexto < RESTO_DE_BISSEXTO_POR_QUATRO
                || diaConhecido < SEGUNDA
                || diaConhecido > DOMINGO) {
            return ERRO;
        }
        int diaData = data % DIGITOS_DIAS;
        int mesData = (data % DIGITOS_ANOS) / DIGITOS_DIAS;
        if (diaData < VIRA_MES_DECRESCENTE || mesData > QNT_MESES
                || mesData < VIRA_MES_DECRESCENTE) {
            return ERRO;
        }
        int diaDataConhecida = dataConhecida % DIGITOS_DIAS;
        int mesDataConhecida = (dataConhecida % DIGITOS_ANOS) / DIGITOS_DIAS;
        if (verificaData(data, bissexto) == ERRO) {
            return ERRO;
        }
        if (verificaData(dataConhecida, bissexto) == ERRO) {
            return ERRO;
        }
        if (diaDataConhecida < VIRA_MES_DECRESCENTE
                || mesDataConhecida > QNT_MESES
                || mesDataConhecida < VIRA_MES_DECRESCENTE) {
            return ERRO;
        }
        if (data < dataConhecida) {
            return diaSemanaAuxDataMenor(
                data, bissexto, dataConhecida, diaConhecido);
        } else {
            return diaSemanaAuxDataMaior(
                data, bissexto, dataConhecida, diaConhecido);
        }
    }

     /**
      *Método que retorna o dia da semana de uma data baseado nos dados
      *inseridos a respeito de outra data.
     * @param data inteiro de 8 digitos que representa a data da qual se quer
     * descobrir o dia da semana, no formato aaaammdd.
     * @param bissexto numero que o programa toma como ano bissexto conhecido.
     * @param dataConhecida inteiro de 8 digitos que representa uma data da qual
     * se sabe o dia da semana, no formato aaaammdd.
     * @param diaConhecido dia da semana da data conhecida, 0 vale segunda
     * feira, 1 vale terça feira, e assim por diante até domingo(6).
     * @return o valor inteiro correspondente ao dia da semana da data
     * representada pelo parâmetro "data" (0 significa segunda feira, 1
     * significa terça feira, e assim por diante até domingo, que é representado
     * por 6).
     * @throws RuntimeException se a data for maior ou igual à dataConhecida.
     */
    protected static int diaSemanaAuxDataMenor(final int data,
            final int bissexto, final int dataConhecida,
            final int diaConhecido)
            throws RuntimeException {
        if (data >= dataConhecida) {
            throw new RuntimeException("a data deve ser menor que a"
                    + " dataConhecida");
        }
        int diaDesejado = diaConhecido, contador;
        for (contador = dataConhecida; contador > data; contador--) {
                int diaContador = contador % DIGITOS_DIAS;
                int mesContador = (contador % DIGITOS_ANOS) / DIGITOS_DIAS;
                int anoContador = (contador) / DIGITOS_ANOS;
                switch (mesContador) {
                    case JANEIRO:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_ANO;
                        }
                        break;
                    case FEVEREIRO:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case MARCO:
                        if ((anoContador - bissexto) % CHECA_BISSEXTO
                                == RESTO_DE_BISSEXTO_POR_QUATRO) {
                            if (diaContador <= VIRA_MES_DECRESCENTE) {
                                contador -= VIRA_FEVEREIRO_BISSEXTO;
                            }
                        } else {
                            if (diaContador <= VIRA_MES_DECRESCENTE) {
                                contador -= VIRA_FEVEREIRO_COMUM;
                            }
                        }
                        break;
                    case ABRIL:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case MAIO:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                    case JUNHO:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case JULHO:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                    case AGOSTO:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case SETEMBRO:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case OUTUBRO:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                    case NOVEMBRO:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case DEZEMBRO:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                    default:
                        break;
                }
                diaDesejado--;
                if (diaDesejado < SEGUNDA) {
                    diaDesejado = DOMINGO;
                }
            }
            return diaDesejado;
    }
    /**
      *Método que retorna o dia da semana de uma data baseado nos dados
      *inseridos a respeito de outra data.
     * @param data inteiro de 8 digitos que representa a data da qual se quer
     * descobrir o dia da semana, no formato aaaammdd.
     * @param bissexto numero que o programa toma como ano bissexto conhecido.
     * @param dataConhecida inteiro de 8 digitos que representa uma data da qual
     * se sabe o dia da semana, no formato aaaammdd.
     * @param diaConhecido dia da semana da data conhecida, 0 vale segunda
     * feira, 1 vale terça feira, e assim por diante até domingo(6).
     * @return o valor inteiro correspondente ao dia da semana da data
     * representada pelo parâmetro "data" (0 significa segunda feira, 1
     * significa terça feira, e assim por diante até domingo, que é representado
     * por 6).
     * @throws RuntimeException se a data for menor que a dataConhecida
     */
    protected static int diaSemanaAuxDataMaior(final int data,
            final int bissexto, final int dataConhecida, final int diaConhecido)
            throws RuntimeException {
        if (data < dataConhecida) {
            throw new RuntimeException("a data deve ser maior ou igual a"
                    + " dataConhecida");
        }
        int contador, diaDesejado = diaConhecido;
        for (contador = dataConhecida; contador < data; contador++) {
                int diaContador = contador % DIGITOS_DIAS;
                int mesContador = (contador % DIGITOS_ANOS) / DIGITOS_DIAS;
                int anoContador = (contador) / DIGITOS_ANOS;
                switch (mesContador) {
                    case JANEIRO:
                        if (diaContador >= MES_DE_TRINTA_E_UM_DIAS) {
                            contador += VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case FEVEREIRO:
                        if ((anoContador - bissexto) % CHECA_BISSEXTO
                                == RESTO_DE_BISSEXTO_POR_QUATRO) {
                            if (diaContador >= FEVEREIRO_BISSEXTO) {
                                contador += VIRA_FEVEREIRO_BISSEXTO;
                            }
                        } else if (diaContador >= FEVEREIRO_COMUM) {
                            contador += VIRA_FEVEREIRO_COMUM;
                        }
                        break;
                    case MARCO:
                        if (diaContador >= MES_DE_TRINTA_E_UM_DIAS) {
                            contador += VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case ABRIL:
                        if (diaContador >= MES_DE_TRINTA_DIAS) {
                            contador += VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                    case MAIO:
                        if (diaContador >= MES_DE_TRINTA_E_UM_DIAS) {
                            contador += VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case JUNHO:
                        if (diaContador >= MES_DE_TRINTA_DIAS) {
                            contador += VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                    case JULHO:
                        if (diaContador >= MES_DE_TRINTA_E_UM_DIAS) {
                            contador += VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case AGOSTO:
                        if (diaContador >= MES_DE_TRINTA_E_UM_DIAS) {
                            contador += VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case SETEMBRO:
                        if (diaContador >= MES_DE_TRINTA_DIAS) {
                            contador += VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                    case OUTUBRO:
                        if (diaContador >= MES_DE_TRINTA_E_UM_DIAS) {
                            contador += VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case NOVEMBRO:
                        if (diaContador >= MES_DE_TRINTA_DIAS) {
                            contador += VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                    case DEZEMBRO:
                        if (diaContador >= MES_DE_TRINTA_E_UM_DIAS) {
                            contador += VIRA_ANO;
                        }
                        break;
                    default:
                        break;
                }
                diaDesejado++;
                if (diaDesejado > DOMINGO) {
                    diaDesejado = SEGUNDA;
                }
            }
        return diaDesejado;
    }
    /**
      *Método que retorna o dia da semana de uma data baseado na biblioteca
      * java.time.LocalDate.
     * @param data inteiro de 8 digitos que representa a data da qual se quer
     * descobrir o dia da semana, no formato aaaammdd.
     * @param bissexto numero que o programa toma como ano bissexto conhecido.
     * Não tem uma função real nesse método, é um parâmetro apenas  por
     * exigencia do exercicio.
     * @param dataConhecida inteiro de 8 digitos que representa uma data da qual
     * se sabe o dia da semana, no formato aaaammdd.Não tem uma função real
     * nesse método, é um parâmetro apenas  por exigencia do exercicio.
     * @param diaConhecido dia da semana da data conhecida, 0 vale segunda
     * feira, 1 vale terça feira, e assim por diante até domingo(6).Não tem uma
     * função real nesse método, é um parâmetro apenas  por exigencia do
     * exercicio.
     * @return o valor inteiro correspondente ao dia da semana da data
     * representada pelo parâmetro "data" (0 significa segunda feira, 1
     * significa terça feira, e assim por diante até domingo, que é representado
     * por 6. -1 é retornado em caso de erro).
     * @throws RuntimeException se data for menor que 10000000 ou maior
     * que 99999999.
     */
    public static int diaSemanaLocalDate(final int data, final int bissexto,
            final int dataConhecida, final int diaConhecido)
            throws RuntimeException {
        if (data < DATA_MINIMA || data > LIMIAR_ACEITACAO) {
            throw new RuntimeException("as datas devem ser inteiros"
                    + " de 8 dígitos");
        }
        int diaData = data % DIGITOS_DIAS;
        int mesData = (data % DIGITOS_ANOS) / DIGITOS_DIAS;
        int anoData = data / DIGITOS_ANOS;
        LocalDate dataLocalDate = LocalDate.of(anoData, mesData,
                diaData);
        return dataLocalDate.getDayOfWeek().ordinal();
    }
}
