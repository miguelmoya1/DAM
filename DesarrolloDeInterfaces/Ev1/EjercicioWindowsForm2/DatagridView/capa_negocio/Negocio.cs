using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using capa_datos;

namespace capa_negocio
{
    public class Negocio
    {
        // atributos
        private BD _bd;
        private List<Pelicula> _cartelera;
        

        // propiedades
        public List<Pelicula> cartelera
        {
            get
            {
                return _cartelera;
            }
        }

        public Negocio()
        {
            // Creo la Base de datos si no existia
            _bd = new BD();

            // Actualizo el objeto cartelera con los valores de la base de datos
            // El acceso a la BD se realizará desde el objeto _bd de la
            // capa de datos
            _cartelera=_bd.leer_cartelera();
        }

        // Guarda una nueva pelicula en la BD
        public int Añadir(string titulo,int duracion,string descripcion,
                          string genero,int tresd)
        {
            int filas_almacenadas,i;

            // Aquí procesaria los datos en según las necesidades de la empresa
            for (i = 0; i < cartelera.Count; i++)
            {
                if (titulo == cartelera[i].Titulo)
                    return -500;
            }

            // Añado la película a la cartelera
            Pelicula p = new Pelicula(titulo,descripcion,duracion,genero,tresd);
            filas_almacenadas=_bd.añadir(p);

            // Actualizo el objeto cartelera con los valores de la base de datos
            // El acceso a la BD se realizará desde el objeto _bd de la
            // capa de datos
            _cartelera = _bd.leer_cartelera();

            return filas_almacenadas;
        }

        // Elimina una pelicula de la BD
        public int Eliminar(string t)
        {
            int res;

            res = _bd.Eliminar(t);

            if (res > 0)
            {
                // Actualizo el objeto cartelera con los valores de la base de datos
                // El acceso a la BD se realizará desde el objeto _bd de la
                // capa de datos
                _cartelera = _bd.leer_cartelera();
            }

            return res;
        }

        // Modifica una pelicula de la BD
        public int Modificar(string t,
                            string titulo, int duracion, 
                            string genero, int tresd)
        {
            int res;

            res = _bd.Modificar(t,titulo,duracion,genero,tresd);

            if (res > 0)
            {
                // Actualizo el objeto cartelera con los valores de la base de datos
                // El acceso a la BD se realizará desde el objeto _bd de la
                // capa de datos
                _cartelera = _bd.leer_cartelera();
            }

            return res;
        }
    }
}
