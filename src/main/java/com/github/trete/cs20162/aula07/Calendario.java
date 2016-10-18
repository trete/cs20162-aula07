
package com.github.trete.cs20162.aula07;

public class Calendario {

    /**
      *Método que retorna o dia da semana de uma data baseado nos dados
      *inseridos a respeito de outra data
     *
     * @param data inteiro de 8 digitos que representa a data da qual se quer
     * descobrir o dia da semana, no formato aaaammdd
     * 
     * @param bissexto numero que o programa toma como ano bissexto conhecido.
     * 
     * @param dataConhecida inteiro de 8 digitos que representa uma data da qual
     * se sabe o dia da semana, no formato aaaammdd
     * 
     * @param diaConhecido dia da semana da data conhecida, 0 vale segunda 
     * feira, 1 vale terça feira, e assim por diante até domingo(6)
     * 
     * @return o valor inteiro correspondente ao dia da semana da data 
     * representada pelo parâmetro "data" (0 significa segunda feira, 1
     * significa terça feira, e assim por diante até domingo, que é representado
     * por 6. -1 é retornado em caso de erro).
     * 
     * @throws RuntimeException se data ou dataConhecida forem menores que
     * 10000000 ou maiores que 99999999.
     */
    public static int diaSemana(int data, int bissexto, int dataConhecida, 
            int diaConhecido)throws RuntimeException{
        
        if(data < 10000000 || data > 99999999 ||
                dataConhecida < 10000000 || dataConhecida > 99999999 ){
            throw new RuntimeException("as datas devem ser inteiros" +
                    " de 8 dígitos");
        }
        
        if(bissexto < 0 || diaConhecido < 0 || diaConhecido > 6){
            return -1;
        }
        
        int diaData = data % 100;
        
        int mesData = (data % 10000) / 100;
        
        int anoData = data / 10000;
        
        if(diaData < 1 || mesData > 12 || mesData < 1){
            return -1;
        }
        
        switch(mesData){
            //casos de dia do mês da data desconhecida inválidos
            case 1:
                if(diaData > 31){
                    return -1;
                }
            case 2:
                if((anoData - bissexto) % 4 ==0){
                    if(diaData > 29){
                        return -1;
                    }
                }else{
                    if(diaData > 28){
                        return -1;
                    }
                }
            case 3:
                if(diaData > 31){
                    return -1;
                }
            case 4:
                if(diaData > 30){
                    return -1;
                }
            case 5:
                if(diaData > 31){
                    return -1;
                }
            case 6:
                if(diaData > 30){
                    return -1;
                }
            case 7:
                if(diaData > 31){
                    return -1;
                }
            case 8:
                if(diaData > 31){
                    return -1;
                }
            case 9:
                if(diaData > 30){
                    return -1;
                }
            case 10:
                if(diaData > 31){
                    return -1;
                }
            case 11:
                if(diaData > 30){
                    return -1;
                }
            case 12:
                if(diaData > 31){
                    return -1;
                }
        }
        
        int diaDataConhecida = dataConhecida % 100;
        
        int mesDataConhecida = (dataConhecida % 10000) / 100;
        
        int anoDataConhecida = dataConhecida / 10000;
        
        if(diaDataConhecida < 1 || mesDataConhecida > 12 ||
                mesDataConhecida < 1){
            return -1;
        }
        switch(mesDataConhecida){
            //casos de dia do mês da data conhecida inválidos
            case 1:
                if(diaDataConhecida >= 31){
                    return -1;
                }
                break;
            case 2:
                if((anoDataConhecida - bissexto) % 4 ==0){
                    if(diaDataConhecida >= 29){
                        return -1;
                    }
                }else{
                    if(diaDataConhecida >= 28){
                        return -1;
                    }
                }
                break;
            case 3:
                if(diaDataConhecida >= 31){
                    return -1;
                }
                break;
            case 4:
                if(diaDataConhecida >= 30){
                    return -1;
                }
                break;
            case 5:
                if(diaDataConhecida >= 31){
                    return -1;
                }
                break;
            case 6:
                if(diaDataConhecida >= 30){
                    return -1;
                }
                break;
            case 7:
                if(diaDataConhecida >= 31){
                    return -1;
                }
                break;
            case 8:
                if(diaDataConhecida >= 31){
                    return -1;
                }
                break;
            case 9:
                if(diaDataConhecida >= 30){
                    return -1;
                }
                break;
            case 10:
                if(diaDataConhecida >= 31){
                    return -1;
                }
                break;
            case 11:
                if(diaDataConhecida >= 30){
                    return -1;
                }
                break;
            case 12:
                if(diaDataConhecida >= 31){
                    return -1;
                }
                break;
        }
        
        int diaDesejado = diaConhecido;
        
        int contador;
        
        if(data < dataConhecida){
            for(contador = dataConhecida; contador > data; contador--){
                int diaContador = contador % 100;
        
                int mesContador = (contador % 10000) /100;
        
                int anoContador = (contador) / 10000;
               
                switch(mesContador){
                    case 1:
                        if (diaContador <= 1) {
                            contador -= 8869;
                        }
                        break;
                    case 2:
                        if (diaContador <= 1) {
                            contador -= 69;
                        }
                        break;
                    case 3:
                        if ((anoContador - bissexto) % 4 == 0) {
                            if(diaContador <= 1){
                                contador -= 71;
                            }
                        }else{
                            if(diaContador <= 1){
                                contador -= 72;
                            }
                        }
                        break;
                    case 4:
                        if (diaContador <= 1) {
                            contador -= 69;
                        }
                        break;
                    case 5:
                        if (diaContador <= 1) {
                            contador -= 70;
                        }
                        break;
                    case 6:
                        if (diaContador <= 1) {
                            contador -= 69;
                        }
                        break;
                    case 7:
                        if (diaContador <= 1) {
                            contador -= 70;
                        }
                        break;
                    case 8:
                        if (diaContador <= 1) {
                            contador -= 69;
                        }
                        break;
                    case 9:
                        if (diaContador <= 1) {
                            contador -= 69;
                        }
                        break;
                    case 10:
                        if (diaContador <= 1) {
                            contador -= 70;
                        }
                        break;
                    case 11:
                        if (diaContador <= 1) {
                            contador -= 69;
                        }
                        break;
                    case 12:
                        if (diaContador <= 1) {
                            contador -= 70;
                        }
                        break;
                }
                diaDesejado--;
                if(diaDesejado < 0){
                    diaDesejado = 6;
                }
            }
            return diaDesejado;
        }else{
            for(contador = dataConhecida; contador < data; contador++){
                int diaContador = contador % 100;
        
                int mesContador = (contador % 10000) / 100;
        
                int anoContador = (contador) / 10000;
               
                switch(mesContador){
                    case 1:
                        if (diaContador >= 31) {
                            contador += 69;
                        }
                        break;
                    case 2:
                        if ((anoContador - bissexto) % 4 == 0) {
                            if (diaContador >= 29) {
                                contador += 71;
                            }
                        } else if (diaContador >= 28) {
                            contador += 72;
                        }
                        break;
                    case 3:
                        if (diaContador >= 31) {
                            contador += 69;
                        }
                        break;
                    case 4:
                        if (diaContador >= 30) {
                            contador += 70;
                        }
                        break;
                    case 5:
                        if (diaContador >= 31) {
                            contador += 69;
                        }
                        break;
                    case 6:
                        if (diaContador >= 30) {
                            contador += 70;
                        }
                        break;
                    case 7:
                        if (diaContador >= 31) {
                            contador += 69;
                        }
                        break;
                    case 8:
                        if (diaContador >= 31) {
                            contador += 69;
                        }
                        break;
                    case 9:
                        if (diaContador >= 30) {
                            contador += 70;
                        }
                        break;
                    case 10:
                        if (diaContador >= 31) {
                            contador += 69;
                        }
                        break;
                    case 11:
                        if (diaContador >= 30) {
                            contador += 70;
                        }
                        break;
                    case 12:
                        if (diaContador >= 31) {
                            contador += 8869;
                        }
                        break;
                }
                diaDesejado++;
                if(diaDesejado > 6){
                    diaDesejado = 0;
                }
            }
            return diaDesejado;
        }
    }
}
