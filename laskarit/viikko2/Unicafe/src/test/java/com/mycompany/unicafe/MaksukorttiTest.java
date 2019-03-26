package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
//    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());
    }
//    
    
    @Test
    public void saldoVaheneeOikeinJosRahaaTarpeeksi() {
         kortti.otaRahaa(10);
         assertEquals("saldo: 0.0", kortti.toString());
         
    }
    
    @Test
    public void saldoEiMuutuRahaaEiTarpeeksi() {
        kortti.otaRahaa(20);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void metodiPalauttaaOikeanArvon() {
        if(kortti.otaRahaa(20)==false) {// jos kortilta ei voi ottaa liikaa
            assertTrue(kortti.otaRahaa(10));      //niin testi onnistuu jos kortilta voi ottaa sallitun määrän
        } else 
            assertTrue(1==0);
    }
}
