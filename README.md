
# app
Instructivo de uso para la applicacion App:

----------------------------
****REQUISITOS PREVIOS****:
----------------------------

Para poder utilizar la conexión RMI con el servidor donde se descargan los cursos, es necesario tener mínimo la versión "v3.0" del programa: https://github.com/ams2Proyecto1JAP/Desktop instalada en el sistema y ejecutada (Con las dependencias del Desktop también añadidas).



-----------------------------------------------------
****DESCARGAR EL CODIGO FUENTE DE LA APLICACION****:
-----------------------------------------------------

Descargar el .zip que ofrece GitHub para la release v3.0 y desde Android Studio ir a "File --> Open" --> Seleccionar la carpeta "app-3.0"  donde la hayas descomprimido en tu sistema



-----------------------------------------------------
****PASOS PREVIOS ANTES DE LANZAR LA APPLICACION****:
-----------------------------------------------------

En el explorador de proyecto de Android Studio ir a: (Carpeta) Java --> (Paquete) com.ieti.duolingoproyect --> (Fichero) MainActivity.java --> (Clase) ClientService

Y en la linea 173 sustituir la ip "0.0.0.0" con la IP donde se esté ejecutando el programa Desktop<br>
**(Si se ejecuta desde un dispositivo móvil o un emulador en otro PC, puede ser necesario desactivar el Firewall donde esté el Desktop para que la conexión por RMI no sea rechazada).



------------------------------
****LANZAR LA APPLICACION****:
------------------------------

(Carpeta) Java --> (Paquete) com.ieti.duolingoproyect --> Lanzar: MainActivity.java




 


