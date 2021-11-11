# EnviarEmail
Implementar una aplicación Java utilizando el framework **JavaFX,** cumpliendo el patrón de diseño **MVC**, y que permita enviar mensajes de correo electrónico.

Se deberá crear un **proyecto Maven** en Eclipse (recuerda marcar "Create a simple project" al crear el proyecto).

La aplicación utilizará la librería [Apache Commons Email](https://commons.apache.org/proper/commons-email/index.html) para enviar los correos, por lo que añadiremos la siguiente dependencia al fichero "pom.xml":

```
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-email</artifactId>
    <version>1.5</version>
</dependency>
```

La interfaz de la aplicación debe ser como la siguiente y deberá implementarse en **FXML**:

![img](https://www3.gobiernodecanarias.org/medusa/evagd/laguna/pluginfile.php/141781/mod_assign/intro/enviar-email-01.png)

Intentar en la medida de lo posible que se parezca lo máximo posible y que al redimensionarse se adepte a la ventana (Stage) de forma adecuada y decorosa ;-D. 

El icono de la aplicación se puede descargar al final del enunciado.

Dispones del ejemplo "[A simple text email](https://commons.apache.org/proper/commons-email/userguide.html)" desde el que se muestra como enviar un email sencillo sin adjuntos y en texto plano con la librería Commons Email. Nos basaremos en este ejemplo para enviar los email. Como puede observarse en la imagen anterior, desde la interfaz gráfica se recogerán todos los datos necesarios.

En cuanto a la funcionalidad de los botones:

- **Enviar**: enviará un email empleando los parámetros introducidos. 

En caso de error se mostrará un aviso como el siguiente (se deberá mostrar el mensaje de la excepción como contenido del aviso):

![img](https://www3.gobiernodecanarias.org/medusa/evagd/laguna/pluginfile.php/141781/mod_assign/intro/enviar-email-02.png)

Si el mensaje se envía correctamente, se mostrará un mensaje como el siguiente y sólo se vaciarán los campos "Destinatario", "Asunto" y "Mensaje".

![img](https://www3.gobiernodecanarias.org/medusa/evagd/laguna/pluginfile.php/141781/mod_assign/intro/enviar-email-03.png)

- **Vaciar:** limpiará el contenido de todos los campos.
- **Cerrar**: cerrará la ventana y terminará el programa

Existe una cuenta de correo de prueba en GMail creada exclusivamente para el módulo DAD. Puedes utilizarla para hacer las pruebas:

```
Servidor SMTP: smtp.gmail.com:465
SSL: Sí
Email/Usuario: dad.iesdpm@gmail.com
Contraseña: Minikit0$
```
