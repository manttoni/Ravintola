[Alustava vaatimusmäärittely](https://github.com/manttoni/ot-harjoitustyo/blob/master/dokumentointi/Maarittelydokumentti.md)
[Työtuntikirjanpito](https://github.com/manttoni/ot-harjoitustyo/blob/master/ty%C3%B6tuntikirjanpito.txt)

Ohjelman suoritus tapahtuu netbeansin vihreällä napilla, ja testit mustalla silmällä.

Tämänhetkiset toiminnot:

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

tekstitiedostojen formaatit:

	- userlist.txt: username;password;status(eli esim manager)
	- tablelst.txt: id;varattu?;lista asiakkaiden id:stä
	- customerlist.txt: id;lista tilausten id:stä
	- orderlist.txt: id;nimi;hinta

Seuraavaksi tulevat toiminnot:

- Kolmas käyttäjäoikeustyyppi keittiömestari. 
- Keittiömestari voi tulostaa listan varastossa olevista raaka-aineista

- Tarjoilija voi lisätä asiakkaita pöytiin
- Tarjoilija voi lisätä tilauksia asiakkaille
- Tarjoilija voi merkitä tilauksen maksetuksi
- Tarjoilija voi vaihtaa pöydän varatusta vapaaksi

- Manageri voi tulostaa yhteenvedon asiakkaiden tilauksista
- Manageri voi muokata menua
- Manageri voi luoda tai poistaa käyttäjätunnuksia (paitsi manager-tunnuksia)

- Parempi UI ulkoasu (silti tekstipohjainen)
- Mavenin asennus windowsille
- Varmuuskopio tekstitiedostojen sisällölle, jotta niitä voi muokata ohjelman sisällä testiksi ja palata takaisin 
alkuperäiseen
