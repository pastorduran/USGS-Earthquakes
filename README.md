# USGS Earthquakes service
Esta API se encarga de gestionar toda la información referente a los sismos que ocurren cada día a nivel mundial, 
permite realizar consulta por rango de fechas, magnitud de los sismos y país donde ocurren

# Pre-requisitos:

* **Java jdk 1.8**
* **gradle 4.10 o superior**


# 1. SISMOS POR FECHA
Este Servicio busca los sismos ocurridos en un rango de fechas

* **Method:**
   `
   GET application/json
   `

* **Url:**
	`
	localhost:8080/sismos/porFechas
	`

* **Headers:**  
	 1. **Content-Type:** application/json
 
* **Parámetros:**
	 1. **fechaInicio** (formato yyy-mm-dd)
	 2. **fechaFin** (formato yyy-mm-dd)
   
 
* **Ejemplo Request:**

```
	curl -H "Content-Type: application/json" -X GET localhost:8080/sismos/porFechas?fechaInicio=2019-10-13&fechaFin=2019-10-14
```
