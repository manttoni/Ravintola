- [Alustava vaatimusmäärittely](https://github.com/manttoni/ot-harjoitustyo/blob/master/dokumentointi/Maarittelydokumentti.md)
- [Työtuntikirjanpito](https://github.com/manttoni/ot-harjoitustyo/blob/master/ty%C3%B6tuntikirjanpito.txt)

Ohjelman käyttöohjeet:

- Ravintolassa on tällä hetkellä vain yksi tarjoilija, jonka Username on "waiter" ja Password on myös "waiter"
- Samoin on myös vain yksi manager (myös valmiissa ohjelmassa vain 1) jonka username on "manager" ja password on myös "manager"

4. viikon version toiminnot:

- Maven asennettu
- Ohjelman pystyy nyt käynnistämään komennolla "mvn compile exec:java -Dexec.mainClass=RavintolaMaven.Ravintola" kun olet "RavintolaMaven"-kansiossa
- Tarkennus: vain waiter voi vaikuttaa pöytiin eikä waiter voi vaikuttaa mihinkään muuhun
- Paranneltu ulkoasu, "leiska"-luokka
- Pöytien hallinnan koodin rakenteen muokkaus niin, että ne luetaan txt-tiedostosta, kun tarjoilija kirjautuu sisään. Kun tarjoilija kirjautuu ulos, tehdyt muutokset tallennetaan txt-tiedostoon.
- Tarjoilija voi lisätä pöytiin asiakkaita
- Tarjoilija voi lisätä asiakkaille tilauksia.
- Tarjoilija voi pyytää asiakkaalta laskun, jolloin asiakkaan tiedot poistetaan.
- Tarjoilija voi myös pyytää koko pöydän laskun ilman erittelyä, jolloin koko pöydän kaikki tiedot (paitsi ID) poistetaan.
- Asiakkaat voivat jatkaa tilailua, koska pöytä on vielä merkitty varatuksi.
- Kun asiakkaat poistuvat ravintolasta, pöytä voidaan taas merkitä vapaaksi. 
- Ravintolassa on oletuksena 5 pöytää
- customerlist.txt ja sitä lukeva luokka poistettu
- asiakkaan id muodostetaan kaavalla pöydän id + käyttämätön int perään. 
- tablelist.txt rakennetta muokattu seuraavanalaiseksi:

	tableID = *pöydän id*
	customerID = *asiakkaan id*
	orderID = *yksittäisen tilauksen id, jonka muut tiedot luetaan orderlist.txt:stä*
	endCustomer, lukijaa varten
	endTable, lukijaa varten
	endFile, lukijaa varten

3. viikon version toiminnot:

- Yksi testi, jossa testataan, voiko luoda asiakkaan ja lisätä tilauksia onnistuneesti

- Käyttäjät voivat kirjautua sisään

- Kahdenlaisia käyttäjäoikeuksia
	- Tarjoilija voi kirjautua sisään waiter waiter tunnuksilla
	- Tarjoilija voi nähdä listan pöydistä, jossa lukee id, onko pöytä varattu ja jos on, kuinka monta asiakasta 
siellä on
	- Tarjoilija voi tulostaa "kuitin" kustakin pöydästä ja nähdä loppusumman eriteltynä

	- Manageri voi kirjautua sisään manager manager tunnuksilla
	- Manageri voi tulostaa menun

- Kun ohjelma pyörii, tiedot pöydistä, niiden asiakkaista ja niiden tilauksista luetaan Ravintola\ hakemistossa 
olevista tekstitiedostoista. Myös käyttäjät löytyvät tekstitiedostosta.

tekstitiedostojen formaatit: EI ENÄÄ NÄIN

	- userlist.txt: username;password;status(eli esim manager)
	- tablelst.txt: id;varattu?;lista asiakkaiden id:stä
	- customerlist.txt: id;lista tilausten id:stä
	- orderlist.txt: id;nimi;hinta

Seuraavaksi tulevat toiminnot:

- Kolmas käyttäjäoikeustyyppi keittiömestari. 
- Keittiömestari voi tulostaa listan varastossa olevista raaka-aineista

- Tarjoilija voi lisätä tilauksia asiakkaille

- Manageri voi tulostaa yhteenvedon asiakkaiden tilauksista
- Manageri voi muokata menua
- Manageri voi luoda tai poistaa käyttäjätunnuksia (paitsi manager-tunnuksia)
