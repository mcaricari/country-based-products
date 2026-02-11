# Product display by country

## How to build and run
- Clone the repository and open it with Android Studio. 
**Important: the app was developed with Android Studio version: Narwhal Feature Drop | 2025.1.2. It may not be possible to compile with previous versions or there may be compatibility issues.**
- Run the application on an emulator or an Android device

## Login
Upon starting the application, credentials will be requested to log in. Use the following for a successful login:
- User: user123
- Password: pass123

## Apis used
The following APIs were used according to the selected country:
- Country A: Fake Store API (https://fakestoreapi.com/products)
- Country B: Platzi Fake Store API (https://api.escuelajs.co/api/v1/products)

## Technologies and libraries used
- Kotlin
- Jetpack Compose
- Hilt
- Retrofit
- JUnit
- Mockk

## Concepts for problem solving
Clean Architecture and MVVM were used for the interaction of the domain layer with the user interface.
To solve the problem of consuming two APIs with different product models, a specific repository and DTO were created for each API, to later map to a unique "Product" type for the domain.
Then, to choose the data source, i.e., which repository to use, a third one was implemented, dedicated exclusively to this task. This one decides which implementation will be returned to the domain layer.
I consider it a scalable solution if the number of possible APIs to be used is to be increased.

## Points for Improvement
- Persist the user session
- Ability to choose which country to use in the Home screen
- Firebase implementation for login and user creation
- Firestore or Realtime DataBase to implement the purchase history per user.
