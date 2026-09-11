1. Singleton
He creado la clase Undo la cual primero crea una unica instancia de Undo, haciendo que no se permita acceder a ella
directamente desde fuera.
Despues, he creado la lista que almacenara los comandos que le lleguen.
Luego he hecho que el constructor sea privado de forma que no se pueda hacer new Undo desde otra clase y un getter de
la instancia para que siempre se llame al mismo Undo independientemente de quien lo necesite.
Despues he añadido los metodos que manejaran la lista de commandos que pertenece a Undo: añadir un comando, eliminar
y retornar el ultimo que se ha añadido y mostrar el historial.

En los Test primero he creado Un @BeforeEach para llamar a Undo en cada test para no tener que repetir el proceso en
cada uno.
En el primer test he comprobado que al llamar un segundo Undo, este sea el mismo que el que ya hay creado.
En el segundo test, he comprobado que se almacenaban correctamente los comandos en Undo.
En el tercer test, he añadido los comandos y he verificado que undo.undoCommand elimina y devuelve el ultimo.
En el cuarto test me he liado un poco y encontrba la forma de verificar que devolvia todo el historial y he encontrado
el ByteArrayOutputStream y creando la variable output para crear un espacio temporal donde gurda la salida por consola
luego convierte todo lo registrado en un string y compuebo que contiene lo que espraba.

Este ejercicio como tal no me ha ayudado a entender el uso de Singleton, la forma que he me ha ayudado a verlo todo mas
claro ha sido que le he pedido a la IA que me lo contara pasandole mi Prueba de Nivel y aplicarle un pposible uso de
este patron y lo he podido relacionar bien a un registro de robots, y un historial de competicion o incluso podria
usarse para gestionar una competicion y errores o registros deribados de estas.

2. Abstract Factory
He creado 2 interfaces la primera de direccion y la segunda de telefono para que cada uno se implemente pero tal como
necesite cada clase.

Despues he creado una clase que dispone de los atributos que necesitaria cualquier pais dando igual si es informacion
de España o de USA ya que estas tendran su propia clase pero cada clase usara unicamente los datos que necesite.
Esta clase se llama AddressData y contiene todos los datos disponibles mediante getters, pero luego SpainAddress o
USAAddress seran las encargadas de decidir cuales necesitan utilizar segun el formato de cada pais. De esta forma en un
futuro se podrian añadir o quitar atributos si fuera necesario.

Luego cada clase usa la interface Address que se usara para devolver esa informacion, independientemente de como este
estructurada pero recuperandola desde la misma en cualquier clase que la implemente.

Posteriormente con Phone, he obligando a cada una a tener el prefijo predefinido para cada region y posteriormente un
atributo numero para introducir el numero. De esta forma las clases Factory quedaran mucho mas limpias porque solo se
llamara a AddressData y no a los atributos en si.

La clase ContactFactory define que cualquier Factory concreta tendra que ser capaz de crear un Address y un Phone para
que posteriormente las Factory de contacto finales de España y USA implementen esa estructura.

En SpainContactFactory, implementamos ContactFactory y desde cada override se crea el producto correspondiente del pais.
En el caso de España se retornara un new SpainAddress con AddressData y un new SpainPhone con el numero. En USA se hara
lo mismo pero creando USAAddress y USAPhone. De esta forma cada Factory concreta crea una familia completa de productos
del mismo pais.

En la clase Contact se crea un contacto completo sin importar todavia si es de un pais u otro. Primero llamo a Address
y Phone para poder guardar cualquier tipo de direccion o telefono independientemente de su clase concreta.

Posteriormente he creado un constructor que me ha liado un poco por el hecho de que no tenia que pasar Phone como algo
creado sino como dato que se va a usar para crear el contacto y he tenido que ponerlo en el constructor como String y
no como atributo Phone. Luego he visto que realmente pasa algo parecido con AddressData, pero como una direccion
necesita varios datos tiene sentido tener una clase para agruparlos, mientras que Phone solo necesita un numero y por
eso basta con pasar un String.

Una vez entendido, he hecho que el constructor reciba una unica ContactFactory y mediante esta cree tanto la direccion
como el telefono. Dependiendo de si recibe SpainContactFactory o USAContactFactory se crearan los productos
correspondientes sin que Contact tenga que conocer directamente SpainAddress, USAAddress, SpainPhone o USAPhone.

Finalmente he creado los getters que llaman a las interfaces para retornar direccion y telefono en su formato
correspondiente.

En los Test he creado uno para España y otro para USA. En cada uno creo los datos de dirección, genero un Contact
utilizando la Factory correspondiente y compruebo con assertEquals que tanto la dirección como el teléfono tengan el
formato esperado para ese país.

También he creado una clase Launcher para ejecutar el programa y poder ver por consola el resultado de los contactos de
España y USA, comprobando que cada Factory genera el formato correspondiente.
