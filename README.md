# app
Instructivo de uso para la applicacion App:

DESCARGAR EL CODIGO FUENTE DE LA APPLICACION Desktop y App:

Para esto es necesario tener instalado el entorno de desarollo Eclipse. 
Una vez instalado ir a File -> Import -> Git -> Projects from Git -> Clone Uri -> https://github.com/ams2Proyecto1JAP/Desktop -> Next -> seleccionar solo "pre" -> Next -> seleccionar CloneSubmodule -> Finish.

Es necesario tener instalado AndroidStudio. Abrir AndroidStudio ir a File -> New -> Project from Version Control -> en URL poner : https://github.com/ams2Proyecto1JAP/app

CREAR LA BASE DATOS:

Para esto es necesario tener MySQL Server operativo en el sistema. Entrar en MySQL y crear una base de datos con el comando -> create database nombreBaseDeDatos;

PASOS PREVIOS ANTES DE LANZAR LA APPLICACION:

En el explorador de archivos de eclipse ir a lib -> src/main/java -> duolingo.lib.hibernate.util -> HibernateUtil.java Abrir el archivo y hacer la siguientes modificaciones:

linea 25, enlace base de datos: sustituir con tus datos ip, puerto y nombreBaseDatos en "jdbc:mysql://ip:puerto/nombreBaseDatos?serverTimezone=UTC"

linea 26, usuario: sustituir "user" en settings.put(Environment.USER, "user"); con el nombre de tu usuario de la base datos.

linea 27, password: sustituir "password" en settings.put(Environment.PASS, "password"); con tu password de la base datos.

Abrir AndroidStudio, en el explorador de archivos de Project ir a app -> java -> com.ieti.duolingoproyect -> MainActivity.java -> ClientService (hacer doble click).
En la linea 103: Client client = new Client("ip", 7777, callHandler); cambiar ip por la ip de tu ordenador (dejar las comillas "").


LANZAR LA APPLICACION:

En el explorador de archivos de eclipse ir a Duolingo_Desktop -> src -> main -> Interface.java. Abrir el archvio y ejecutar el programa (Run Interface).
Para usar la aplicaion es app es necesario mantener el programa Interface en funcionamiento. En AndroidStudio ir a app y hacer click en Run 'app' (triangulo verde en la barra de arriba).



 


