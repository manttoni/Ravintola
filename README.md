Ravintola-ohjelma

Ohjelman tarkoituksena on saada ravintolan osat toimimaan yhdessä. Tarjoilijat keräävät asiakkaiden tilaukset, jotka jaetaan keittiön ja 
baarin kesken. Kummallekkin printataan kuitti tilauksista, esim keittiö saa heti tiedon tilatuista ranskalaisista ja baarin puolella 
tiedetään juomatilaukset. 

Ravintolan johto voi käyttää ohjelmaa päivittämällä sinne ravintolan menun tai tulostamalla listan varastossa 
olevista tuotteista inventaariota varten.

Dokumentointi

- [Viikon 5 release (tein releasen jälkeen vielä paljon päivityksiä)](https://github.com/manttoni/ot-harjoitustyo/releases/tag/viikko5)
- [Vaatimusmäärittely](https://github.com/manttoni/ot-harjoitustyo/blob/master/dokumentointi/Maarittelydokumentti.md)
- [Työtuntikirjanpito](https://github.com/manttoni/ot-harjoitustyo/blob/master/dokumentointi/ty%C3%B6tuntikirjanpito.txt)
- [Arkkitehtuuri](https://github.com/manttoni/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

Ohjelman käyttöohjeet:

- Tunnuksia, joiden salasana on sama kuin tunnus: "manager", "chef", "waiter"
- Komentorivin komennot:
	- Checkstyle: "mvn jxr:jxr checkstyle:checkstyle"
	- Testikattavuusraportti: "mvn test jacoco:report"
	- Ohjelman käynnistys: "mvn compile exec:java -Dexec.mainClass=main.Ravintola"
	- .jar-tiedoston luonti: "mvn package"
	- Checkstylen tulokset ja testikattavuusraportti löytyvät tämän jälkeen target-kansiosta. Myös luotu .jar-tiedosto löytyy sieltä.

5. viikon version toiminnot:

- RavintolaUI-luokasta siirretty koodia WaiterUI ja Waiter-luokkiin. Koodia jaettu sovelluslogiikan ja käyttöliittymän kesken.
- Samoin tehty Managerin kohdalla
- Muokattiin id-logiikkaa
	- Asiakkaan id on nyt yksinkertaisempi
	- Kun asiakkaita tai ordereita poistetaan ja lisätään omilta listoiltaan, niiden id:t alustetaan [1,2,3,...] selkeyden vuoksi.
- Manager voi nyt muokata menua
- Manager voi nyt poistaa tai luoda uusia waiter-käyttäjiä.
- Kaikki käyttäjät voivat nyt vaihtaa salasanaansa. Ravintolan uusi manager tai chef (eli keittiömestari) voivat näin ottaa itselleen käyttöoikeudet. Heidän usernamensa ovat aina "manager" tai "chef".
- Chef voi tulostaa listan varastossa olevasta ruuasta
	- Uusi tiedosto "inventory.txt"
	- Uusi luokka "Item", joka tarkoittaa jotain raaka-ainetta varastossa ja sen lukumäärää
- Tarjoilijan tekemät muutokset näkyvät hyväksymisen jälkeen yhdellä listalla, joka tulostuu keittiön kuittikoneesta.
- Tarjoilija voi myös peruuttaa tehdyt tilaukset ennen hyväksymistä, jolloin pöydän tilanne palaa takaisin edelliseen tilanteeseen. 


4. viikon version toiminnot:

- Maven asennettu
- checkstyle on otettu käyttöön ja se toimii komennolla "mvn jxr:jxr checkstyle:checkstyle"
- testikattavuusraportin voi saada komennolla "mvn test jacoco:report"
- Ohjelman pystyy nyt käynnistämään komennolla "mvn compile exec:java -Dexec.mainClass=main.Ravintola"
- Tarkennus: vain waiter voi vaikuttaa pöytiin eikä waiter voi vaikuttaa mihinkään muuhun
- Paranneltu ulkoasu, "leiska"-luokka
- Pöytien hallinnan koodin rakenteen muokkaus niin, että ne luetaan txt-tiedostosta, kun tarjoilija kirjautuu sisään. 
- Kun tarjoilija kirjautuu ulos, tehdyt muutokset tallennetaan txt-tiedostoon.
- Tarjoilija voi lisätä pöytiin asiakkaita
- Tarjoilija voi lisätä asiakkaille tilauksia.
- Tarjoilija voi pyytää asiakkaalta laskun, jolloin asiakkaan tiedot poistetaan.
- Tarjoilija voi myös pyytää koko pöydän laskun ilman erittelyä, jolloin koko pöydän kaikki tiedot (paitsi ID) poistetaan.
- Ravintolassa on oletuksena 5 pöytää ja 0 asiakasta
- customerlist.txt ja sitä lukeva luokka poistettu
- asiakkaan id muodostetaan kaavalla pöydän id + käyttämätön int perään. 
	- Pöydässä 1 ne ovat [11,12,13,14...], pöydässä 2 [21,22,23...]
- tablelist.txt rakennetta muokattu seuraavanalaiseksi:

	tableID = *pöydän id*

	customerID = *asiakkaan id. näitä voi olla useita, kunhan tämä lopetetaan ensin endCustomer-rivillä*

	orderID = *yksittäisen tilauksen id, jonka muut tiedot luetaan orderlist.txt:stä. Näitä voi olla useita*

	endCustomer, lukijaa varten

	customerID...

	orderID...

	orderID...

	endCustomer

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

tekstitiedostojen formaatit:

	- userlist.txt: username;password;status(eli esim manager)
	- tablelst.txt: id;varattu?;lista asiakkaiden id:stä
	- customerlist.txt: id;lista tilausten id:stä
	- orderlist.txt: id;nimi;hinta

