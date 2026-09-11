# Patterns Parte 1

## 1. Singleton

He creado la clase Undo, la cual primero crea una unica instancia de Undo, haciendo que no se pueda crear 
directamente desde fuera. Despues, he creado la lista que almacenara los comandos que le lleguen.
Luego he hecho que el constructor sea privado de forma que no se pueda hacer new Undo desde otra clase y un método 
getInstance() para que siempre se obtenga el mismo Undo independientemente de quien lo necesite.
Despues he añadido los métodos que manejaran la lista de comandos que pertenece a Undo: añadir un comando, eliminar y 
retornar el ultimo que se ha añadido y mostrar el historial.

En los Test primero he creado un @BeforeEach para obtener la instancia de Undo antes de cada test y no tener que 
repetir el proceso en cada uno. Aunque se llame antes de cada test, al ser Singleton siempre se recupera la misma 
instancia.
En el primer test he comprobado que al pedir un segundo Undo, este sea exactamente el mismo que el que ya hay creado.
En el segundo test he comprobado que se almacenaban correctamente los comandos en Undo.
En el tercer test he añadido los comandos y he verificado que undo.undoCommand() elimina y devuelve el ultimo.
En el cuarto test me he liado un poco porque no encontraba la forma de verificar que devolvia todo el historial. He 
encontrado ByteArrayOutputStream y he creado la variable output para guardar temporalmente la salida de consola. Luego 
convierto todo lo registrado en un String y se comprueba que contiene el historial que esperaba.

Este ejercicio como tal no me ha ayudado demasiado a entender el uso real de Singleton. La forma que mas me ha ayudado 
a verlo claro ha sido pedirle a la IA que lo relacionara con mi prueba de nivel de robots y aplicar un posible uso de 
este patrón. Asi lo he podido relacionar con un registro de robots, un historial de competición o algo que registre
errores o registros de una competición. En estos casos veo que tiene sentido que todo el programa utilice una unica 
instancia que almacene información.

---

## 2. Abstract Factory

He creado 2 interfaces, la primera de dirección Address y la segunda de teléfono Phone, para que cada tipo concreto las
implemente según necesite.
Despues he creado una clase que dispone de los atributos que podria necesitar una dirección independientemente de si es 
información de España o de USA.
Esta clase se llama AddressData y contiene los datos mediante getters. Luego SpainAddress o UsaAddress son las 
encargadas de decidir cuales necesitan utilizar según el formato de cada país.
Luego cada clase implementa la interfaz Address, que se usa para devolver esa información independientemente de como 
esté estructurada.
Con Phone he hecho algo parecido. Cada implementación concreta se encarga de aplicar el formato y prefijo de su región 
y recibe el número que se quiere utilizar.
La clase ContactFactory define que cualquier Factory concreta tendrá que ser capaz de crear un Address y un Phone, para 
que posteriormente las Factory de España y USA implementen esa estructura.

En SpainContactFactory y UsaFactory he implementado ContactFactory y desde cada override se crea el producto 
correspondiente del país. Si es España se retornara un new SpainAddress utilizando AddressData y un new SpainPhone con 
el número y si es USA se retornara un new UsaAddress y un new UsaPhone.
De esta forma cada Factory concreta crea una familia completa de productos compatibles del mismo país.

En la clase Contact se crea un contacto completo sin importar todavia si es de un país u otro. Primero utilizo Address 
y Phone para poder guardar cualquier tipo de dirección o teléfono independientemente de su clase concreta.
Posteriormente he creado un constructor que me ha liado un poco por el hecho de que no tenia que pasar Phone como algo 
ya creado sino como un dato que la Factory va a utilizar para crear el contacto, por lo que tenia que ser un String.

Luego he visto que realmente pasa algo parecido con AddressData, pero como una dirección necesita varios datos tiene 
sentido tener una clase para agruparlos, mientras que Phone solo necesita un número y con un String es suficiente.
Una vez que lo he entendido, he hecho que el constructor reciba una unica ContactFactory y mediante esta cree la 
dirección y el teléfono.

Dependiendo de si recibe SpainContactFactory o UsaContactFactory se crearan los productos correspondientes sin que 
Contact tenga que conocer directamente SpainAddress, SpainPhone, UsaAddress o UsaPone.
Finalmente he creado los getters que llaman a las interfaces para retornar dirección y teléfono en su formato.

En los Test he creado uno para España y otro para USA. En cada uno he creado los datos de dirección, generado un Contact 
utilizando la Factory correspondiente y comprobado que la dirección y el teléfono tengan el formato esperado para ese 
país.

También he creado una clase Launcher para ejecutar el programa y poder ver por consola el resultado de los contactos de 
España y USA.

---

## 3. Strategy

Primero he creado la interfaz Report, que tiene el método común que tendrá que implementar cualquier clase capaz de 
generar un informe: generateReport(String content, String fileName).

Despues he creado la clase principal ReportService, creando dentro un atributo de tipo Report. De esta forma puede 
recibir cualquier tipo de archivo siempre que su clase implemente Report.
Como la clase ReportService no necesita saber con que trabaja, solo llama al método generateReport() de la clase 
que haya recibido.
Despues he creado una clase para cada tipo de archivo, todas implementan Report y cada una contiene su propia extensión 
correspondiente pero son copias unas de otras.
JSON, HTML, XML y CSV ha sido facil con FileWriter, ya que solo hay crear el archivo y escribir dentro el contenido.
Si ocurre algún problema al crear o escribir el archivo se captura el IOException y se lanza un RuntimeException para 
indicar que la generación del informe ha fallado.

Las ultimas tres estrategias han sido diferentes. Para crear archivos reales de PDF, Excel y Word no ha sido solo
cambiar la extensión del archivo.
Para PDF he utilizado la dependencia pdfbox, mientras que para Excel y Word he utilizado Apache Poi.
Estas clases la he hecho con ayuda de IA porque estaba bastante perdido con el funcionamiento de estas dependencias.

En los Test he creado un test para cada estrategia. En cada uno creo un ReportService pasándole el tipo de Report 
que quiero utilizar, genero el archivo y después utilizo File y assertTrue(file.exists()) para comprobar que realmente 
se ha creado. Finalmente elimino el archivo generado con file.delete() para que los tests no vayan dejando archivos cada 
vez que se ejecutan.
He entendido que ReportService no cambia en ningún momento. Para utilizar otro formato solo se le pasa otra 
implementación de Report.

Esta parte al principio parecia bastante mas complicada de lo que ha sido. Cuando he visto que ReportService trabaja 
siempre contra la interfaz Report, añadir nuevos formatos es básicamente crear otra estrategia sin tener que 
modificar.
