﻿# Challenge-ForoHub

 
¡Hola! Bienvenidos y bienvenidas al desafío de construir nuestra propia API REST utilizando Java y Spring Boot para un foro en línea. En este proyecto, hemos aplicado nuestros conocimientos en desarrollo backend para crear un espacio donde los usuarios pueden interactuar, compartir conocimientos y aprender unos de otros.

## Descripción del Proyecto

En este proyecto hemos desarrollado una API RESTful utilizando Java y Spring Boot para gestionar un foro en línea. Los usuarios pueden realizar operaciones como listar tópicos, crear nuevos tópicos, eliminar tópicos existentes y autenticarse para proteger las operaciones sensibles.

## Tecnologías Utilizadas

- **Java**
- **Spring Boot**
- **Spring Security con JWT**
- **Base de Datos (MySQL)**

## Funcionalidades Implementadas

- **Crear Tópico**: Desarrollamos un endpoint para que los usuarios puedan crear nuevos tópicos en el foro.
- **Mostrar detalles de un Tópico**: Implementamos un endpoint para obtener todos los detalles de un topico existentes en la base de datos.
- **Listar Tópicos**: Implementamos un endpoint para obtener todos los tópicos existentes en la base de datos.
- **Actualizar Tópicos**: Implementamos un endpoint para actualizar los datos de un tópico.
- **Eliminar Tópico**: Implementamos la funcionalidad para eliminar tópicos existentes, protegida con autenticación JWT.
- **Seguridad con JWT**: Implementamos un sistema de autenticación basado en tokens JWT para proteger nuestros endpoints sensibles.

## Documentación

Hemos utilizado Javadoc para documentar el código, asegurando una guía clara sobre el funcionamiento de nuestros métodos y clases principales.
<p align="center">
  <img src="images/Javadocs.PNG" alt="Interfaz de documentación">
</p>

## Instrucciones de Uso

1. **Clonar el Repositorio**
```bash
git clone https://github.com/EdgarCamberos1894/Challenge-ForoHub.git

cd Challenge-ForoHub
```
2. **Configurar la Base de Datos**
- Configura la conexión a tu base de datos MySQL en `src/main/resources/application.properties`.
- Asegúrate de tener creada la estructura de la base de datos necesaria para el proyecto.
3. **Ejecutar la Aplicación**
```bash
   ./mvnw spring-boot
```
4. **Probar los Endpoints**
- Utiliza herramientas como Insomnia para realizar peticiones a los endpoints definidos y verificar su funcionamiento.

5. **Contribuciones**
- Siéntete libre de contribuir al proyecto realizando un fork, implementando nuevas funcionalidades y enviando pull requests.

6. **Contacto**
- Para cualquier pregunta o sugerencia, contáctanos a través de nuestra comunidad en Discord o nuestras redes sociales.

<p align="center">
  <img src="images/Badge-Spring.png" alt="Badge-AluraLatam">
</p>


## Licencia

Este proyecto está licenciado bajo la [Licencia MIT](https://opensource.org/licenses/MIT) - consulta el archivo [LICENSE](LICENSE) para más detalles.
