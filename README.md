# Juego de la Ruleta
Proyecto backend realizado en Spring Boot que usa Redis como persistencia.

## Ejecución en repositorio local

Requerimientos:
- Docker

Instalación:
```shell
#1. Obtener el repositorio con git clone
git clone https://github.com/anndresfelipe29/ruleta.git

#2. Moverse a la carpeta del repositorio
cd ruleta

# 3. Ejecutar docker-compose
docker-compose up
```
## Uso
Puede usar este aplicativo accediento a:
- Endpoint base http://localhost:8080  y agregar las rutas de acceso a cada controlador.
- Url de la aplicación swagger que facilita el uso del microservicio http://localhost:8080/swagger-ui.html#

## Funcionalidades

Las rutas disponibles son:
- /user/save [post] Crea 5 usuarios por defecto con una cantidad de 15000 en dinero.
- /user [get] muestra a todos los usuarios y su dinero.
- /user/{id} [get] muestra la informción de de un usuario específico a partir de su id.
- /ruleta [get] Muestra todas las ruletas y sus estados.
- /ruleta [post] Crea una nueva ruleta y retorna su Id.
- /ruleta/{id} [get] Muestra una ruleta en especifico, {id} es un id de ruleta.
- /ruleta/betOnRuletaForNumber/{rouletteId}/{numberWin}/{cash} [patch] Crea una apuesta por número, donde:
    - {rouletteId} es un id de ruleta.
    - {numberWin} es el número al cual se va a apostar.
    - {cash} es la cantidad de dinero a apostar.
    - Además recibe un header llamado UserId con un id de usuario.
- /ruleta/betOnRuletaForColor/{rouletteId}/{numberWin}/{cash} [patch] Crea una apuesta por color, donde:
    - {rouletteId} es un id de ruleta.
    - {blackIsWin} es un booleano, en el cual si ingresa true elige el negro y si ingresa false elige rojo.
    - {cash} es la cantidad de dinero a apostar.
    - Además recibe un header llamado UserId con un id de usuario.
- /ruleta/open/{id} [patch] abre una ruleta solo si existe y nunca hasido abierta.
- /ruleta/close/{id} [patch] cierra una ruleta solo si actualmente está abierta, además genera el numero y color ganador y retorna las ganancias a quienes ganan.

    
    
