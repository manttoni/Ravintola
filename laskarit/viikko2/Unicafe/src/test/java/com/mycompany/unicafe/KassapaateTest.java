package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti rikas, koyha;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        rikas = new Maksukortti(1000);
        koyha = new Maksukortti(1);
    }

    @Test
    public void kassassa1000Lounaita0() {
        assertEquals("10000000", "" + kassa.kassassaRahaa() + kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisOstoKassassaRahaaKasvaa() {
        int maksu = 240 + 400 + 1;
        maksu = kassa.syoEdullisesti(maksu);
        maksu = kassa.syoMaukkaasti(maksu);
        assertEquals("1006401", "" + kassa.kassassaRahaa() + maksu);
    }

    @Test
    public void lounaidenMaaraKasvaa() {
        kassa.syoEdullisesti(240);
        kassa.syoMaukkaasti(400);
        assertEquals("11", "" + kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void rahatEiRiita() {
        int maksu = 1;
        maksu = kassa.syoEdullisesti(maksu);
        maksu = kassa.syoMaukkaasti(maksu);
        assertEquals("100000100", "" + kassa.kassassaRahaa() + maksu + kassa.edullisiaLounaitaMyyty() + kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kortillaTarpeeksiRahaa() {
        boolean a = kassa.syoEdullisesti(rikas);
        boolean b = kassa.syoMaukkaasti(rikas);
        assertTrue(rikas.saldo() == 1000 - 240 - 400 && a && b);
    }

    @Test
    public void lounaidenMaaraKasvaaKortillaOstettaessa() {
        kassa.syoEdullisesti(rikas);
        kassa.syoMaukkaasti(rikas);
        assertTrue(kassa.edullisiaLounaitaMyyty() == 1 && kassa.maukkaitaLounaitaMyyty() == 1);
    }

    @Test
    public void kortillaEiTarpeeksiRahaa() {
        boolean a = kassa.syoEdullisesti(koyha);
        boolean b = kassa.syoMaukkaasti(koyha);
        int saldo = koyha.saldo();
        assertTrue(!a && !b && saldo == 1 && kassa.edullisiaLounaitaMyyty() == 0 && kassa.maukkaitaLounaitaMyyty() == 0);

    }

    @Test
    public void kortillaOstettaessaKassassaRahaaEiMuutu() {
        kassa.syoEdullisesti(rikas);
        kassa.syoMaukkaasti(rikas);
        assertTrue(kassa.kassassaRahaa() == 100000);
    }

    @Test
    public void kortinLataus() {
        kassa.lataaRahaaKortille(koyha, 100);
        kassa.lataaRahaaKortille(koyha, -1);
        assertTrue(kassa.kassassaRahaa() == 100100 && koyha.saldo() == 101);
    }

    @Test
    public void rahatEiRiitaMaukkaaseen() {
        assertTrue(!kassa.syoMaukkaasti(koyha));

    }
}
