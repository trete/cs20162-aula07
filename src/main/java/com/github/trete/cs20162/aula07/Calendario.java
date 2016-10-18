
package com.github.trete.cs20162.aula07;

/**
 *
 * @author Rafael Borges Calil
 */
public abstract class Calendario {
    private static final int LIMIAR_ACEITACAO = 99999999;
    private static final int DATA_MINIMA = 10000000;
    private static final int QNT_MESES = 12;
    private static final int FEVEREIRO_BISSEXTO = 29;
    private static final int FEVEREIRO_COMUM = 28;
    private static final int MES_DE_TRINTA_DIAS = 30;
    private static final int MES_DE_TRINTA_E_UM_DIAS = 31;
    private static final int VIRA_FEVEREIRO_BISSEXTO = 71;
    private static final int VIRA_FEVEREIRO_COMUM = 72;
    private static final int VIRA_MES_TRINTA_E_UM_DIAS = 69;
    private static final int VIRA_MES_TRINTA_DIAS = 70;
    private static final int VIRA_ANO = 8869;
    private static final int DIGITOS_ANOS = 10000;
    private static final int DIGITOS_DIAS = 100;
    private static final int SEGUNDA = 0;
    private static final int DOMINGO = 6;
    private static final int RESTO_DE_BISSEXTO_POR_QUATRO = 0;
    private static final int CHECA_BISSEXTO = 4;
    private static final int VALIDO = 1;
    private static final int VIRA_MES_DECRESCENTE = 1;
    private static final int ERRO = -1;
    /**
      *método que verifica a validade de uma data
     * @param data data cuja validade do mês será verificada
     * @param bissexto ano que será tomado como base para verificar bissextos
     * @return -1 se a data for inválida e 0 se for válida
     */
    protected static int verificaData(final int data, final int bissexto) {
        int dia = data % DIGITOS_DIAS;
        int mes = (data % DIGITOS_ANOS) / DIGITOS_DIAS;
        int ano = data / DIGITOS_ANOS;
        switch(mes){
            //casos de dia do mês da data desconhecida inválidos
            case 1:
                if(dia > MES_DE_TRINTA_E_UM_DIAS){
                    return ERRO;
                }
            case 2:
                if ((ano - bissexto) % CHECA_BISSEXTO
                        ==RESTO_DE_BISSEXTO_POR_QUATRO) {
                    if (dia > FEVEREIRO_BISSEXTO) {
                        return ERRO;
                    }
                }else{
                    if (dia > FEVEREIRO_COMUM) {
                        return ERRO;
                    }
                }
            case 3:
                if (dia > MES_DE_TRINTA_E_UM_DIAS) {
                    return ERRO;
                }
            case 4:
                if (dia > MES_DE_TRINTA_DIAS) {
                    return ERRO;
                }
            case 5:
                if (dia > MES_DE_TRINTA_E_UM_DIAS) {
                    return ERRO;
                }
            case DOMINGO:
                if (dia > MES_DE_TRINTA_DIAS) {
                    return ERRO;
                }
            case 7:
                if (dia > MES_DE_TRINTA_E_UM_DIAS) {
                    return ERRO;
                }
            case 8:
                if (dia > MES_DE_TRINTA_E_UM_DIAS) {
                    return ERRO;
                }
            case 9:
                if (dia > MES_DE_TRINTA_DIAS) {
                    return ERRO;
                }
            case 10:
                if (dia > MES_DE_TRINTA_E_UM_DIAS) {
                    return ERRO;
                }
            case 11:
                if (dia > MES_DE_TRINTA_DIAS) {
                    return ERRO;
                }
            case 12:
                if (dia > MES_DE_TRINTA_E_UM_DIAS) {
                    return ERRO;
                }
            default:
                return VALIDO;
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
            throws RuntimeException{
        if(data < DATA_MINIMA || data > LIMIAR_ACEITACAO 
                || dataConhecida < DATA_MINIMA
                || dataConhecida > LIMIAR_ACEITACAO) {
            throw new RuntimeException("as datas devem ser inteiros" +
                    " de 8 dígitos");
        }
        if (bissexto < RESTO_DE_BISSEXTO_POR_QUATRO
                || diaConhecido < RESTO_DE_BISSEXTO_POR_QUATRO 
                || diaConhecido > DOMINGO) {
            return ERRO;
        }
        int diaData = data % DIGITOS_DIAS;
        int mesData = (data % DIGITOS_ANOS) / DIGITOS_DIAS;
        if(diaData < VIRA_MES_DECRESCENTE || mesData > QNT_MESES
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
                || mesDataConhecida > QNT_MESES ||
                mesDataConhecida < VIRA_MES_DECRESCENTE) {
            return ERRO;
        }
        if (data < dataConhecida) {
            return diaSemanaDataMenor
                (data, bissexto, dataConhecida, diaConhecido);
        }else{
            return diaSemanaDataMaior
                (data, bissexto, dataConhecida, diaConhecido);
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
     */
    protected static int diaSemanaDataMenor(final int data, final int bissexto,
            final int dataConhecida, final int diaConhecido){
        if (data >= dataConhecida){
            throw new RuntimeException("a data deve ser menor que a"
                    + " dataConhecida");
        }
        int diaDesejado = diaConhecido, contador;
        for(contador = dataConhecida; contador > data; contador--){
                int diaContador = contador % DIGITOS_DIAS;
        
                int mesContador = (contador % DIGITOS_ANOS) /DIGITOS_DIAS;
        
                int anoContador = (contador) / DIGITOS_ANOS;
               
                switch(mesContador){
                    case 1:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_ANO;
                        }
                        break;
                    case 2:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case 3:
                        if ((anoContador - bissexto) % CHECA_BISSEXTO ==
                                RESTO_DE_BISSEXTO_POR_QUATRO) {
                            if(diaContador <= VIRA_MES_DECRESCENTE){
                                contador -= VIRA_FEVEREIRO_BISSEXTO;
                            }
                        }else{
                            if(diaContador <= VIRA_MES_DECRESCENTE){
                                contador -= VIRA_FEVEREIRO_COMUM;
                            }
                        }
                        break;
                    case CHECA_BISSEXTO:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case 5:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                    case 6:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case 7:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                    case 8:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case 9:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case 10:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                    case 11:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case 12:
                        if (diaContador <= VIRA_MES_DECRESCENTE) {
                            contador -= VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                }
                diaDesejado--;
                if(diaDesejado < SEGUNDA){
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
     */
    protected static int diaSemanaDataMaior(final int data, final int bissexto,
            final int dataConhecida, final int diaConhecido){
        int contador, diaDesejado = diaConhecido;
        for(contador = dataConhecida; contador < data; contador++){
                int diaContador = contador % DIGITOS_DIAS;
        
                int mesContador = (contador % DIGITOS_ANOS) / DIGITOS_DIAS;
        
                int anoContador = (contador) / DIGITOS_ANOS;
               
                switch(mesContador){
                    case 1:
                        if (diaContador >= MES_DE_TRINTA_E_UM_DIAS) {
                            contador += VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case 2:
                        if ((anoContador - bissexto) % CHECA_BISSEXTO == 
                                RESTO_DE_BISSEXTO_POR_QUATRO) {
                            if (diaContador >= FEVEREIRO_BISSEXTO) {
                                contador += VIRA_FEVEREIRO_BISSEXTO;
                            }
                        } else if (diaContador >= FEVEREIRO_COMUM) {
                            contador += VIRA_FEVEREIRO_COMUM;
                        }
                        break;
                    case 3:
                        if (diaContador >= MES_DE_TRINTA_E_UM_DIAS) {
                            contador += VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case 4:
                        if (diaContador >= MES_DE_TRINTA_DIAS) {
                            contador += VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                    case 5:
                        if (diaContador >= MES_DE_TRINTA_E_UM_DIAS) {
                            contador += VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case 6:
                        if (diaContador >= MES_DE_TRINTA_DIAS) {
                            contador += VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                    case 7:
                        if (diaContador >= MES_DE_TRINTA_E_UM_DIAS) {
                            contador += VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case 8:
                        if (diaContador >= MES_DE_TRINTA_E_UM_DIAS) {
                            contador += VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case 9:
                        if (diaContador >= MES_DE_TRINTA_DIAS) {
                            contador += VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                    case 10:
                        if (diaContador >= MES_DE_TRINTA_E_UM_DIAS) {
                            contador += VIRA_MES_TRINTA_E_UM_DIAS;
                        }
                        break;
                    case 11:
                        if (diaContador >= MES_DE_TRINTA_DIAS) {
                            contador += VIRA_MES_TRINTA_DIAS;
                        }
                        break;
                    case 12:
                        if (diaContador >= MES_DE_TRINTA_E_UM_DIAS) {
                            contador += VIRA_ANO;
                        }
                        break;
                }
                diaDesejado++;
                if(diaDesejado > DOMINGO){
                    diaDesejado = SEGUNDA;
                }
            }
        return diaDesejado;
    }
}
