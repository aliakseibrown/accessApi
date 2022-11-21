# accessApi

A program that reads data about measuring stations available at: https://powietrze.gios.gov.pl/pjp/content/api

The Program should display a list of measurement stations available on https://api.gios.gov.pl/pjp-api/rest/station/findAll
and allow the user (in the text menu) to select a station and, based on its ID, select the measurement information by sending a query to
https://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex / {stationId}
Measurement results can be saved in PDF, JSON or XML file.
