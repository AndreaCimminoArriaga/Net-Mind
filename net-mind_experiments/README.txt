
En este directorio tenemos diferentes archivos:

	- nn.jar: es el archivo jar del proyecto java que permite crear las redes neuronales, para conocer su funcionamiento ver el archivo nn_namual presente en la carpeta doc de este mismo directorio o teclear en la consola "java -jar nn.jar nn -help".

	- configutarion.txt: este es el archivo de configuracion que utiliza el programa nn.jar si se desea modificar alguna constante de los algoritmos que usa es aqui donde hay que cambiar los valores. En caso de eliminar accidentalmente el archivo nn.jar posee una opcion para crear una predefinido.

	- c3po.jar: es un programa auxiliar creado por mi, nn.jar genera dos tipos de ficheros, la red neuronal y otro que se llama igual pero con un "_statistics" que posee las estadisticas de la fase de entrenamiento y testing. Como hay que lanzar cada fichero proben sobre 10 redes neuronales distintas este programa permite lanzar 10 veces nn.jar para un mismo archivo y despues al llamar a c3po.jar este leera el directorio que se le indique y resumira todos los ficheros "_statistics" en un fichero csv y ademas realizara una evaluacion de los archivos creando un resumen con el rendimiento medio (tal y como se expone en las tablas de PROBEN).

	- doc: contiene los manuales de c3po.jar y nn.jar

	- El resto de carpetas contienen (por el propio nombre) el archivo de PROBEN elegido para el experimento, las 10 redes neuronales escogidas para realizarlo junto con sus estadisticas y el archivo statistics.csv generado por c3po donde se resume toda la informacion experimental obtenida.
	
	
Para reproducir los experimentos recomiento utilizar la opcion java -jar nn.jar nn -ctt [topology] [network_name] [proben_file] ya que de un solo comando permite crear, entrenar y producir los resultados para esa ejecucion en el fichero "[network_name]_statistics.txt". Con lo que lanzando ese comando 10 veces y simplemente cambiando la topologia y el nombre de la red (esto ultimo es para que no se sobreescriban los ficheros) cada vez (y parametros si se desea desde el archivo configuration.txt) y luego lanzar c3po ya se habra reproducido toda la experimentacion.

