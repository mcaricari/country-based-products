# Mostrador de productos por país

## Cómo compilar y ejecutar
- Clonar el repositorio y abrirlo con Android Studio. 
**Importante: la app se desarrolló con la versión de Android Studio: Narwhal Feature Drop | 2025.1.2. Posiblemente no se pueda compilar con versiones anteriores o hayan problemas de compatibilidad**.
- Correr la aplicación en un emulador o en un dispositivo Android

## Login
Al iniciar la aplicación, se pediran credenciales para ingresar. Utilizar las siguientes para un login exitoso:
- Usuario: user123
- Contraseña: pass123

## Apis utilizadas
Se utilizaron las siguientes apis según el país seleccionado:
- País A: Fake Store API (https://fakestoreapi.com/products)
- Pais B: Platzi Fake Store API (https://api.escuelajs.co/api/v1/products)

## Tecnologías y librerías utilizadas
- Kotlin
- Jetpack Compose
- Hilt
- Retofit
- JUnit
- Mockk

## Conceptos para la resolución del problema
Se utilizó Clean Architecture y MVVM para la interacción de la capa de dominio con la interfaz de usuario.
Para resolver el problema de consumir dos APIs con modelos de productos diferentes se creó un repositorio y un DTO particular a cada API, para luego poder mapear al tipo "Product" único para el dominio.
Luego, para elegir la fuente de datos, es decir, qué repositorio utilizar, se implementó un tercero, dedicado exclusivamente a esta tarea. Este decide qué implementación será devuelto a la capa de dominio.
Considero que es una solución escalable si se desean incrementar el número de APIs posibles a utilizar.

## Puntos de Mejora
- Persistir la sesión de usuario
- Posibilidad de elegir qué pais utilizar en el Home
- Implementación de Firebase para el login y creación de usuarios
- Firestore o Realtime DataBase para implementar el historial de compras por usuario.
