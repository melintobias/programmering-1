# Programmering 1 - Algoritmer - Teoriuppgifter

## 1. Vad är en algoritm?

En algoritm är en ändlig, väldefinierad sekvens av elementära instruktioner som, givet indata, producerar utdata inom ändlig tid.

## 2. Varför använder man ofta pseudokod för att beskriva en algoritm?

Användningen av pseudokod gör det möjligt att beskriva algoritmer på ett sätt som är lätt att förstå och obundet till ett specifikt programmeringsspråk. På så vis blir det lättare att fokusera på algoritmens logik och struktur snarare än syntaxen tillhörande ett visst språk.

## 3. När används linjär respektive binär sökning?

Linjär sökning används när data är osorterad eller tillräckligt liten. Binär sökning kräver sorterad data, men är i regel mycket snabbare än linjär sökning, eftersom den halverar sökområdet vid varje steg vilket ger en tidskomplexitet på $\mathcal{O}(\log n)$ jämfört med linjär sökning som har en tidskomplexitet på $\mathcal{O}(n)$.

## 4. Beskriv kortfattat den binära sökningen med egna ord

Binär sökning används för att finna platsen för ett givet värde i en sorterad lista. Algoritmen delar upprepade gånger listan i två delar och jämför det sökta värdet med det mittersta elementet, tills antingen det sökta värdet hittas eller att sökområdet är tomt. Om det sökta värdet är mindre än det mittersta elementet fortsätter sökningen i den del av listan där elementen är mindre enligt den givna ordningen, annars i den del där elementen är större.

## 5. Vilken sorteringsmetod, bubbel- eller urvalssortering, bör man välja om materialet inte är i allt för stor oordning?

Bubbelsortering kan vara mer effektiv om listan redan är delvis sorterad; annars är skillnaden liten eftersom båda algoritmer har kvadratisk tidskomplexitet.

## 6. Beskriv kortfattat hur urvalssortering fungerar med egna ord

Urvalssortering fungerar genom att upprepat utföra en linjär sökning i den osorterade delen av listan (som initialt omfattar hela listan) för att identifiera det element som enligt en vald jämförelsefunktion eller sorteringsnyckel är föredraget, det vill säga det element som rangordnas först vid parvisa jämförelser enligt den definierade ordningen (t. ex. numerisk storlek, alfabetisk ordning, identitet eller någon annan jämförelseregel).

Detta element byter därefter plats med det första elementet i den osorterade delen och överförs därmed till den sorterade delen av listan. Processen upprepas sedan för den återstående osorterade delen tills hela listan är ordnad enligt den valda jämförelseregeln.

## 7. Vad innebär tidskomplexitet?

Tidskomplexitet är ett mått på hur antalet operationer som krävs för att exekvera en algoritm växer i förhållande till storleken på indatan. Tidskomplexitet uttrycks vanligtvis med ordonotation (även kallat big O-, stora O- eller O-notation), där exempelvis $\mathcal{O}(1)$ representerar konstant tid, $\mathcal{O}(n)$ linjär tid och $\mathcal{O}(n^2)$ kvadratisk tid.

## 8. Vilka konsekvenser kan en dåligt vald algoritm få?

En dåligt vald algoritm kan leda till ineffektivitet, vilket kan resultera i längre exekveringstider och högre resursförbrukning. I praktiken kan detta innebära att ett program inte kan hantera stora datamängder eller försämrad användarupplevelsen.

## Jämför tidskomplexiteten mellan urvalssortering och bubbelsortering

Både urvalssortering och bubbelsortering har en tidskomplexitet på $\mathcal{O}(n^2)$ i det genomsnittliga och värsta fallet, vilket innebär att antalet operationer växer kvadratiskt med storleken på indatan.

<!-- TODO: Lägg till matten -->
