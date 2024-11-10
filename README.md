# Unidad Didáctica 3: Historial Médico Electrónico Personal
#### Enlace al repositorio: https://github.com/itsedupablo/Historial_Medico_Personal_Android
## Descripción
Este proyecto consiste en el desarrollo de una aplicación mediante la cual los usuarios pueden acceder a su historial médico y medicación.
## Arquitectura del proyecto
El proyecto se compone fundamentalmente de las siguientes clases:
- **SplashActivity:** Muestra la pantalla de carga inicial y redirige a LoginActivity tras un breve retraso.
- **LoginActivity:** Gestiona el inicio de sesión de usuario y, al autenticarse correctamente, redirige a MainActivity.
- **MainActivity:** Contiene la toolbar con opciones para navegar entre los fragmentos (HistorialFragment y MedicacionFragment).
- **HistorialFragment:** Muestra el historial médico del usuario en un RecyclerView, obteniendo datos de Firebase.
- **MedicacionFragment:** Muestra la medicación del usuario en un RecyclerView, también con datos de Firebase.
- **HistorialAdapter:** Adaptador para mostrar los elementos del historial en HistorialFragment.
- **MedicacionAdapter:** Adaptador para mostrar los elementos de medicación en MedicacionFragment.
- **Historial y Medicacion:** Modelos de datos para representar las entradas de historial y medicación, respectivamente.
## Flujo y funcionamiento de la aplicación:
https://github.com/itsedupablo/Historial_Medico_Personal_Android/tree/main/Flujo%20de%20la%20App

