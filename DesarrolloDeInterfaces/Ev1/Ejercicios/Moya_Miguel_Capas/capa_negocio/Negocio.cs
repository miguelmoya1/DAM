using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using capa_datos;

namespace capa_negocio {
    public class Negocio {
        // atributos
        private BD _bd;
        private List<Pelicula> _cartelera;


        // propiedades
        public List<Pelicula> cartelera {
            get {
                return _cartelera;
            }
        }

        public Negocio() {
            // Creo la Base de datos si no existia
            _bd = new BD();

            // Actualizo el objeto cartelera con los valores de la base de datos
            // El acceso a la BD se realizará desde el objeto _bd de la
            // capa de datos
            _cartelera = _bd.leer_cartelera();
        }

        // Guarda una nueva pelicula en la BD
        public int Añadir(string titulo, int edad, int duracion, string descripcion) {
            int filas_almacenadas;

            // Aquí procesaria los datos en según las necesidades de la empresa
            if (!cartelera.Exists(film => film.Titulo.Equals(titulo))) {
                // Añado la película a la cartelera
                Pelicula p = new Pelicula(titulo, descripcion, duracion, edad);
                filas_almacenadas = _bd.añadir(p);

                // Actualizo el objeto cartelera con los valores de la base de datos
                // El acceso a la BD se realizará desde el objeto _bd de la
                // capa de datos
                _cartelera = _bd.leer_cartelera();

                return filas_almacenadas;
            } else return 0;
        }

        public int Borrar(Pelicula p) {
            return _bd.borrar(p);
        }
    }
}
