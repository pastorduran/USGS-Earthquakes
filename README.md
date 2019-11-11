# USGS Earthquakes service
Esta API se encarga de gestionar toda la información referente a los sismos que ocurren cada día a nivel mundial, 
permite realizar consulta por rango de fechas, magnitud de los sismos y país donde ocurren

# Pre-requisitos:

* **Java jdk 1.8**
* **gradle 4.10 o superior**

# Levantar el proyecto

Luego de clonar o descargar el proyecto se debe ubicar en la carpeta raiz del proyecto y ejecutar los siguientes comandos

```
$ ./gradlew bootJar
```
```
$ ./gradlew bootRun
```
por defecto luego de ejecutar el comando bootRun la aplicación iniciara en el puerto 8080, luego de iniciar correctamente, se podra consumir el servicio


## Lista de Servicios

### 1. SISMOS POR FECHA
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

### 2. SISMOS POR MAGNITUDES
Este Servicio busca los sismos ocurridos en un rango magnitudes de sismos

* **Method:**
   `
   GET application/json
   `

* **Url:**
	`
	localhost:8080/sismos/porMagnitud
	`

* **Headers:**  
	 1. **Content-Type:** application/json
 
* **Parámetros:**
	 1. **magnitudMinima** (formato Double)
	 2. **magnitudMaxima** (formato Double)
   
 
* **Ejemplo Request:**

```
	curl -H "Content-Type: application/json" -X GET http://localhost:8080/sismos/porMagnitud?magnitudMinima=6.1&magnitudMaxima=6.9
```

### 3. SISMOS POR RANGO DE FECHAS
Este Servicio busca los sismos ocurridos en dos rangos de fechas

* **Method:**
   `
   GET application/json
   `

* **Url:**
	`
	localhost:8080/sismos/porRangoFechas
	`

* **Headers:**  
	 1. **Content-Type:** application/json
 
* **Parámetros:**
	 1. **fechaInicioR1** (formato yyy-mm-dd)
	 2. **fechaTerminoR1** (formato yyy-mm-dd)
	 3. **fechaInicioR2** (formato yyy-mm-dd)
	 4. **fechaTerminoR2** (formato yyy-mm-dd)	 
   
   Nota: Estos parámetros son recibidos por body unicamente
 
* **Ejemplo Request:**

```
	curl -H "Content-Type: application/json" -d "{"fechaInicioR1" : "2019-10-01", "" : "2019-10-03", "fechaInicioR2" : "2019-10-06", "fechaTerminoR2" : "2019-10-14"}" -X GET http://localhost:8080/sismos/porRangoFechas
```

### 4. SISMOS POR PAÍS
Este Servicio busca los sismos ocurridos en un país

* **Method:**
   `
   GET application/json
   `

* **Url:**
	`
	localhost:8080/sismos/porPais
	`

* **Headers:**  
	 1. **Content-Type:** application/json
 
* **Parámetros:**
	 1. **pais** (formato String)
   
 
* **Ejemplo Request:**

```
	curl -H "Content-Type: application/json" -X GET http://localhost:8080/sismos/porPais?pais=chile
```

### 4. SISMOS POR RANGOS DE FECHAS Y PAISES
Este Servicio busca los sismos ocurridos en un dos paises a partir de dos rangos de fechas

* **Method:**
   `
   GET application/json
   `

* **Url:**
	`
	localhost:8080/sismos/porPais
	`

* **Headers:**  
	 1. **Content-Type:** application/json
 
* **Parámetros:**
	 1. **paisR1** (formato String)
	 2. **paisR2** (formato String)
	 3. **fechaInicioR1** (formato yyy-mm-dd)
	 4. **fechaTerminoR1** (formato yyy-mm-dd)
	 5. **fechaInicioR2** (formato yyy-mm-dd)
	 6. **fechaTerminoR2** (formato yyy-mm-dd)	
 
* **Ejemplo Request:**

```
	curl -H "Content-Type: application/json" -d "{
	"fechaInicioR1" : "2019-10-01",
	"fechaTerminoR1" : "2019-10-03",
	"fechaInicioR2" : "2019-10-06",
	"fechaTerminoR2" : "2019-10-14",
	"paisR1" : "PUERTO RICO",
	"paisR2" : "CHILE"
}" -X GET http://localhost:8080/sismos/porPaisesYFechas
```
