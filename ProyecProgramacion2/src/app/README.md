DESCRIPCION DEL PROYECTO 
1. Descripción del proyecto 
El programa está compuesto por tres clases que trabajan juntas para cargar y graficar señales ECG desde un archivo CSV almacenado en Google Drive. La clase ArchivoDatos se encarga de leer el archivo, reconocer su estructura de columnas (tiempo, ritmo normal, taquicardia y bradicardia), separar los valores y almacenarlos en listas independientes que luego pueden ser consultadas según el tipo de arritmia. La clase Graficador utiliza estos datos para dibujar la señal correspondiente sobre una ventana gráfica, escalando los valores y trazando la curva en función del tiempo con ejes y etiquetas adecuadas. Finalmente, la clase Main coordina la ejecución del programa: carga los datos desde el enlace de Drive, muestra un menú interactivo para que el usuario seleccione qué ritmo cardíaco desea visualizar, y envía la solicitud a la clase graficadora para mostrar la señal elegida. En conjunto, el sistema permite visualizar de manera clara y diferenciada los tres patrones de frecuencia cardíaca basados en los datos del archivo.

2. instrucciones de ejecución 



3. TECNOLOGIAS USADAS

En este proyecto se implementaron varias tecnologías y herramientas fundamentales del ecosistema Java. En primer lugar, se utilizó Java SE como lenguaje principal para la construcción de las clases encargadas del procesamiento de datos y la visualización. Para la parte visual se implementó Swing, que permite crear interfaces gráficas y, en este caso, mostrar la ventana donde se dibuja la gráfica mediante componentes como JFrame y JPanel. También se emplearon clases de I/O (Input/Output) de Java como BufferedReader, FileReader y InputStreamReader para la lectura de archivos tanto locales como desde URL. Además, se utilizaron estructuras de datos de la biblioteca estándar, específicamente ArrayList, para almacenar y manejar las diferentes columnas del archivo. Finalmente, se organizó el proyecto utilizando Programación Orientada a Objetos (POO), lo que permitió separar la lógica de lectura, graficación y ejecución en clases independientes

5. ROLES DE CADA INTEGRANTE

Dos de las tres integrantes del equipo asumieron roles compartidos, ya que, a medida que se iba desarrollando el código y surgían correcciones o mejoras, trabajaban de manera colaborativa para arreglarlo. De esta manera, el desarrollo fue completamente colaborativo y cada parte del proyecto se construyó mediante
el aporte conjunto de las integrantes. Por otro lado, hay una compañera que no mostro interes por el trabajo a realizar.
