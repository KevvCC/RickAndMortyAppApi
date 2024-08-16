<body>
    <h1>Rick and Morty App Api</h1>
   <p>Una aplicación Android que consume la API hecha por <a href="https://github.com/afuh" target="_blank">Axel Fuhrmann</a> de la famosa serie producida por Adult Swim, Rick and Morty, para mostrar una lista de personajes de la serie.</p>
    <ul>
        <li><strong>Visualización de Personajes</strong>: Muestra una lista de personajes de la serie Rick and Morty con su imagen, nombre y estado.</li>
        <li><strong>Paginación</strong>: Implementa la paginación para cargar datos de manera eficiente a medida que el usuario se desplaza por la lista.</li>
        <li><strong>Búsqueda</strong>: Permite a los usuarios buscar personajes por nombre usando un <code>SearchView</code>.</li>
        <li><strong>Diseño Adaptable</strong>: Utiliza un diseño basado en <code>StaggeredGridLayoutManager</code> para una presentación visual atractiva de los personajes.</li>


<h1>Tecnologías Utilizadas:</h1>
    
  <ul>
        <li><strong>Kotlin</strong>: Lenguaje de programación principal.</li>
        <li><strong>AndroidX</strong>: Librerías de soporte para componentes de la UI y arquitectura.</li>
        <li><strong>Paging3</strong>: Biblioteca para la paginación eficiente de listas grandes.</li>
        <li><strong>Retrofit</strong>: Biblioteca para realizar solicitudes HTTP y manejar respuestas de API.</li>
        <li><strong>Coroutines</strong>: Para manejar operaciones asíncronas y concurrentes.</li>
        <li><strong>Dagger-Hilt</strong>: Para la inyección de dependencias y gestión del ciclo de vida de los componentes.</li>
        <li><strong>View Binding</strong>: Para una vinculación segura y fácil de las vistas en las actividades.</li>
    </ul>

<h1> Estructura del Proyecto: <strong> Arquitectura MVVM </strong> </h1>
    <ul>
        <li><strong>Model</strong>: <code>RickMortyRepository</code> gestiona la obtención de datos desde la API y proporciona una capa de abstracción sobre la fuente de datos.</li>
        <li><strong>ViewModel</strong>: <code>RickViewModel</code> prepara y proporciona datos a la vista, maneja la lógica de negocios y coordina la paginación de datos.</li>
        <li><strong>View</strong>: <code>CharactersListActivity</code> es la vista que muestra la lista de personajes y maneja la entrada del usuario, como la búsqueda.</li>
    </ul>

  <h1>Paginación</h1>
    <ul>
        <li><code>RickMortyPagingSource</code> maneja la carga de datos paginados desde la API.</li>
        <li><code>Pager</code> en <code>RickViewModel</code> configura la paginación y proporciona los datos a la vista.</li>
    </ul>

  <h3>Inyección de Dependencias</h3>
    <ul>
        <li> La libreria <code>Dagger-Hilt</code> se utiliza para la inyección de dependencias en la aplicación, facilitando la gestión de componentes y servicios.</li>
    </ul>

  <h3>Manejo de Asíncronía</h3>
    <ul>
        <li>La libreria de coroutines se utilizan para realizar operaciones en segundo plano sin bloquear la interfaz de usuario.</li>
    </ul>

<h2>Imagenes</h2>
<img src = https://github.com/user-attachments/assets/e204c614-cf04-4cbf-a2fa-cb8a30c5bd44 width = "200" height="400" align="left">
<img src = https://github.com/user-attachments/assets/0b381336-1fc1-4c30-b502-52338c22e68e width = "200" height="400" align="left">
<img src = https://github.com/user-attachments/assets/3b369070-150c-40a8-ac18-b8694b45ea35 width = "200" height="400" align="left">

