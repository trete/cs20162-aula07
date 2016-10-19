
package com.github.trete.cs20162.aula07;

import javax.management.RuntimeErrorException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalendarioTest {
    @Test (expected = RuntimeException.class)
    public void dataMenorQue10000000Invalida(){
        Calendario.diaSemana(999, 0, 20000602, 0);
    }
    
    @Test (expected = RuntimeException.class)
    public void dataMaiorQue9999999Invalida(){
        Calendario.diaSemana(100000000, 0, 20000602, 0);
    }
    
    @Test
    public void valoresDeTesteBonsUm(){
        assertEquals(4, Calendario.diaSemana(20161017, 2016, 20161019, 6));
    }
    
    @Test
    public void valoresDeTesteBonsDois(){
        assertEquals(1, Calendario.diaSemana(20161017, 2016, 20161015, 6));
    }
    
    @Test
    public void valoresDeTesteBonsTres(){
        assertEquals(5, Calendario.diaSemana(20161017, 2016, 20171017, 6));
    }
    
    @Test
    public void valoresDeTesteBonsQuatro(){
        assertEquals(1, Calendario.diaSemana(20161017, 2016, 20151017, 6));
    }
    
    @Test
    public void valoresDeTesteBonsCinco(){
        assertEquals(5, Calendario.diaSemana(20161017, 2016, 20151117, 6));
    }
    
    @Test
    public void valoresDeTesteBonsSeis(){
        assertEquals(3, Calendario.diaSemana(20161017, 2016, 20151217, 6));
    }
    
    @Test
    public void valoresDeTesteBonsSete(){
        assertEquals(3, Calendario.diaSemana(20161017, 2016, 20150917, 6));
    }
    
    @Test
    public void valoresDeTesteBonsOito(){
        assertEquals(6, Calendario.diaSemana(20161017, 2016, 20150817, 6));
    }
    
    @Test
    public void valoresDeTesteBonsNove(){
        assertEquals(2, Calendario.diaSemana(20161017, 2016, 20150717, 6));
    }
    
    @Test
    public void valoresDeTesteBonsDez(){
        assertEquals(4, Calendario.diaSemana(20161017, 2016, 20150617, 6));
    }
    
    @Test
    public void valoresDeTesteBonsOnze(){
        assertEquals(0, Calendario.diaSemana(20161017, 2016, 20150517, 6));
    }
    
    @Test
    public void valoresDeTesteBonsDoze(){
        assertEquals(2, Calendario.diaSemana(20161017, 2016, 20150417, 6));
    }
    
    @Test
    public void valoresDeTesteBonsTreze(){
        assertEquals(5, Calendario.diaSemana(20161017, 2016, 20150317, 6));
    }
    
    @Test
    public void valoresDeTesteBonsCatorze(){
        assertEquals(5, Calendario.diaSemana(20161017, 2016, 20150217, 6));
    }
    
    @Test
    public void valoresDeTesteBonsQuinze(){
        assertEquals(1, Calendario.diaSemana(20161017, 2016, 20150117, 6));
    }
    
    @Test
    public void valoresDeTesteBons16(){
        assertEquals(4, Calendario.diaSemana(20161117, 2016, 20150117, 6));
    }
        
    @Test
    public void valoresDeTesteBons17(){
        assertEquals(6, Calendario.diaSemana(20161217, 2016, 20150117, 6));
    }
    
    @Test
    public void valoresDeTesteBons18(){
        assertEquals(0, Calendario.diaSemana(20160117, 2016, 20150117, 6));
    }
    
    @Test
    public void valoresDeTesteBons19(){
        assertEquals(3, Calendario.diaSemana(20160217, 2016, 20150117, 6));
    }
    
    @Test
    public void valoresDeTesteBons20(){
        assertEquals(4, Calendario.diaSemana(20160317, 2016, 20150117, 6));
    }
    
    @Test
    public void valoresDeTesteBons21(){
        assertEquals(0, Calendario.diaSemana(20160417, 2016, 20150117, 6));
    }
    
    @Test
    public void valoresDeTesteBons22(){
        assertEquals(2, Calendario.diaSemana(20160517, 2016, 20150117, 6));
    }
    
    @Test
    public void valoresDeTesteBons23(){
        assertEquals(5, Calendario.diaSemana(20160617, 2016, 20150117, 6));
    }
    
    @Test
    public void valoresDeTesteBons24(){
        assertEquals(0, Calendario.diaSemana(20160717, 2016, 20150117, 6));
    }
    
    @Test
    public void valoresDeTesteBons25(){
        assertEquals(3, Calendario.diaSemana(20160817, 2016, 20150117, 6));
    }
    
    @Test
    public void valoresDeTesteBons26(){
        assertEquals(6, Calendario.diaSemana(20160917, 2016, 20150117, 6));
    }
    
    @Test
    public void valoresDeTesteBons27(){
        assertEquals(4, Calendario.diaSemana(20160117, 2016, 20170117, 6));
    }
    
    @Test
    public void valoresDeTesteRuinsUm(){
        assertEquals(-1, Calendario.diaSemana(20161317, 2016, 20161018, 6));
    }
    
    @Test
    public void valoresDeTesteRuinsDois(){
        assertEquals(-1, Calendario.diaSemana(20161032, 2016, 20161018, 6));
    }
    
    @Test
    public void valoresDeTesteRuinsTres(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20161032, 6));
    }
    
    @Test
    public void valoresDeTesteRuinsQuatro(){
        assertEquals(-1, Calendario.diaSemana(20161017, -1, 20161019, 6));
    }
    
    @Test
    public void valoresDeTesteRuinsCinco(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20161019, -1));
    }
    
    @Test
    public void valoresDeTesteRuinsSeis(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20161019, 7));
    }
    
    @Test
    public void valoresDeTesteRuinsSete(){
        assertEquals(-1, Calendario.diaSemana(20161000, 2016, 20161019, 6));
    }
    
    @Test
    public void valoresDeTesteRuinsOito(){
        assertEquals(-1, Calendario.diaSemana(20160017, 2016, 20161019, 6));
    }
    
    @Test
    public void valoresDeTesteRuinsNove(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20161000, 6));
    }
    
    @Test
    public void valoresDeTesteRuinsDez(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160019, 6));
    }
    
    @Test
    public void valoresDeTesteRuins11(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160019, 6));
    }
    
    @Test
    public void valoresDeTesteRuin12(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160100, 6));
    }
    
    @Test
    public void valoresDeTesteRuins13(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160200, 6));
    }
    
    @Test
    public void valoresDeTesteRuins14(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160300, 6));
    }
    
    @Test
    public void valoresDeTesteRuins15(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160400, 6));
    }
    
    @Test
    public void valoresDeTesteRuins16(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160500, 6));
    }
    
    @Test
    public void valoresDeTesteRuins17(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160600, 6));
    }
    
    @Test
    public void valoresDeTesteRuins18(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160700, 6));
    }
    
    @Test
    public void valoresDeTesteRuins19(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160800, 6));
    }
    
    @Test
    public void valoresDeTesteRuins20(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160900, 6));
    }
    
    @Test
    public void valoresDeTesteRuins21(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20161000, 6));
    }
    
    @Test
    public void valoresDeTesteRuins22(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20161100, 6));
    }
    
    @Test
    public void valoresDeTesteRuins23(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20161200, 6));
    }
    
    @Test
    public void valoresDeTesteRuins24(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160140, 6));
    }
    
    @Test
    public void valoresDeTesteRuins25(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160240, 6));
    }
    
    @Test
    public void valoresDeTesteRuins26(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160340, 6));
    }
    
    @Test
    public void valoresDeTesteRuins27(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160440, 6));
    }
    
    @Test
    public void valoresDeTesteRuins28(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160540, 6));
    }
    
    @Test
    public void valoresDeTesteRuins29(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160640, 6));
    }
    
    @Test
    public void valoresDeTesteRuins30(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160740, 6));
    }
    
    @Test
    public void valoresDeTesteRuins31(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160840, 6));
    }
    
    @Test
    public void valoresDeTesteRuins32(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20160940, 6));
    }
    
    @Test
    public void valoresDeTesteRuins34(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20161040, 6));
    }
    
    @Test
    public void valoresDeTesteRuins35(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20161140, 6));
    }
    
    @Test
    public void valoresDeTesteRuins36(){
        assertEquals(-1, Calendario.diaSemana(20161017, 2016, 20161240, 6));
    }
    
    @Test
    public void valoresDeTesteRuins37(){
        assertEquals(-1, Calendario.diaSemana(20160100, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins38(){
        assertEquals(-1, Calendario.diaSemana(20160200, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins39(){
        assertEquals(-1, Calendario.diaSemana(20160300, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins40(){
        assertEquals(-1, Calendario.diaSemana(20160400, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins41(){
        assertEquals(-1, Calendario.diaSemana(20160500, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins42(){
        assertEquals(-1, Calendario.diaSemana(20160600, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins43(){
        assertEquals(-1, Calendario.diaSemana(20160700, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins44(){
        assertEquals(-1, Calendario.diaSemana(20160800, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins45(){
        assertEquals(-1, Calendario.diaSemana(20160900, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins46(){
        assertEquals(-1, Calendario.diaSemana(20161000, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins47(){
        assertEquals(-1, Calendario.diaSemana(20161100, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins48(){
        assertEquals(-1, Calendario.diaSemana(20161200, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins49(){
        assertEquals(-1, Calendario.diaSemana(20160140, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins50(){
        assertEquals(-1, Calendario.diaSemana(20160240, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins51(){
        assertEquals(-1, Calendario.diaSemana(20160340, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins52(){
        assertEquals(-1, Calendario.diaSemana(20160440, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins53(){
        assertEquals(-1, Calendario.diaSemana(20160540, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins54(){
        assertEquals(-1, Calendario.diaSemana(20160640, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins55(){
        assertEquals(-1, Calendario.diaSemana(20160740, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins56(){
        assertEquals(-1, Calendario.diaSemana(20160840, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins57(){
        assertEquals(-1, Calendario.diaSemana(20160940, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins58(){
        assertEquals(-1, Calendario.diaSemana(20161040, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins59(){
        assertEquals(-1, Calendario.diaSemana(20161140, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins60(){
        assertEquals(-1, Calendario.diaSemana(20161240, 2016, 20160119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins61(){
        assertEquals(-1, Calendario.diaSemana(20160240, 2015, 20150119, 6));
    }
    
    @Test
    public void valoresDeTesteRuins62(){
        assertEquals(-1, Calendario.diaSemana(20161220, 2015, 20160240, 6));
    }
    
    @Test (expected = RuntimeException.class)
    public void testeLocaldate1(){
        Calendario.diaSemanaLocalDate(201601018, 0, 0, 0);
    }
    
    @Test (expected = RuntimeException.class)
    public void testeLocaldate2(){
        Calendario.diaSemanaLocalDate(2011018, 0, 0, 0);
    }
    
    @Test
    public void testeLocaldate3(){
        Calendario.diaSemanaLocalDate(20161018, 0, 0, 0);
    }
}