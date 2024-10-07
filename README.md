# SmallIMDb App

## Objective
The *SmallIMDb App* is a mobile application that allows users to browse a list of movies, TV shows, and artists, as well as view brief information about each. The app fetches data from an API using Retrofit and supports refresh functionality to retrieve the latest data. The project focuses on optimizing data fetching by implementing caching with a local Room database and only making API calls when necessary. Additionally, Dependency Injection is implemented using Hilt, marking my first experience with both Retrofit and Hilt.

### Skills Learned

- **Retrofit** for handling API requests efficiently, marking my first practical experience in handling APIs in Android.
- Implemented **data caching** with Room to store data locally and fetch it only when needed, optimizing performance and reducing network calls.
- Proficient use of **Dependency Injection** with **Hilt**, ensuring loose coupling and better testability of code components.
- Experience with **LiveData** for observing data and updating the UI accordingly.
- Integrated **Room Database** for local data persistence to reduce redundant API calls and offer offline functionality.
- Understanding of MVVM architecture for clean code separation between the UI, business logic, and data layers.
- UI/UX improvements with a **refresh button** for users to manually refresh the movie list and pull the latest data from the API.

### Tools Used

- **Retrofit** for making network requests to retrieve data from the API.
- **Hilt** for Dependency Injection to manage the lifecycle of components and dependencies.
- **Room Database** for storing movie, TV show, and artist data locally.
- **LiveData** for real-time updates to the UI based on data changes.
- **RecyclerView** for displaying lists of movies, TV shows, and artists.
- **Kotlin Coroutines** for asynchronous data fetching to keep the app responsive.

## Features

1. **Browse Lists:** Users can view a list of movies, TV shows, or artists fetched from an external API.
2. **Brief Information:** Users can view basic details of movies, TV shows, and artists directly on the list.
3. **Refresh Button:** A manual refresh button allows users to update the data and get the latest list from the API.
4. **Caching and Offline Mode:** Data is cached locally using Room, so users can access previously fetched lists even when offline. The app fetches new data only when necessary, reducing redundant API calls.
5. **Dependency Injection:** The project utilizes Hilt for Dependency Injection, enhancing modularity and making the app easier to test and maintain.

## Screenshots

- **Ref 2: Refresh Button and trigger API Caching**  
  <img src="https://github.com/Avwaveaf/screenshots/blob/main/Screenshot_1728293483.png" alt="Refresh Screen" width="250"/>  
  *A refresh button is available to manually pull the latest data from the API, with local data caching reducing redundant network requests.*

## Steps

1. Set up **Retrofit** for API requests to fetch movies, TV shows, and artist information from the IMDb API.
2. Implement **Room Database** to cache data locally for offline access and minimize unnecessary API calls.
3. Use **Hilt** for managing Dependency Injection to simplify code modularity and ease of testing.
4. Set up **RecyclerView** for displaying lists of data (movies, TV shows, artists).
5. Implement a **refresh button** to allow users to manually update the displayed data by fetching the latest from the API.

