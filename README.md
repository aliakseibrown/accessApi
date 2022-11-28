# reads data of measuring stations

A program that reads data of measuring stations available at: https://powietrze.gios.gov.pl/pjp/content/api

The Program should display a list of measurement stations available on https://api.gios.gov.pl/pjp-api/rest/station/findAll
and allow the user (in the text menu) to select a station and, based on its ID, select the measurement information by sending a query to
https://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex / {stationId}
Measurement results can be saved in PDF, JSON or XML file.

<img width="949" alt="Screenshot 2022-11-28 at 9 27 33 PM" src="https://user-images.githubusercontent.com/67626128/204374301-7836da5c-0e7d-4aa6-8681-7573506625ad.png">
<img width="571" alt="Screenshot 2022-11-28 at 9 28 29 PM" src="https://user-images.githubusercontent.com/67626128/204374501-b0dcfaeb-1642-4263-ba0c-0989038aafd7.png">
json:
<img width="1397" alt="Screenshot 2022-11-28 at 9 29 28 PM" src="https://user-images.githubusercontent.com/67626128/204374646-5f5f2888-2791-41ec-8502-ea6c0e1bbea3.png">
