using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SQLite;

namespace capa_datos
{
    public class BD
    {
        private SQLiteConnection _bd;

        public BD()
        {
            // Creo la BD si no existia
            _bd = new SQLiteConnection("Cartelera.db");

            _bd.CreateTable<Pelicula>();
        }

        public int añadir(Pelicula p)
        {
            try
            {
                _bd.Insert(p);
            }
            catch (Exception e)
            {
                return 0;
            }
            return 1;
        }

        public List<Pelicula> leer_cartelera()
        {
            int i;
            List<Pelicula> c = new List<Pelicula>(); ;

            // De esta forma leemos toda la tabla
            TableQuery<Pelicula> aux = _bd.Table<Pelicula>();

            // IMPORTANTE. Tambien podemos hecer una select
            //db.Query<Stock>("SELECT * FROM Cartelera");

            for (i=0;i<aux.Count();i++)
            {
                c.Add(aux.ElementAt(i));
            }

            return c;
        }

        public int Eliminar(string t)
        {
            // Borro la pelicula de la base de datos.
            try
            {
                _bd.Execute("Delete from Peliculas where titulo = '" + t + "'");
            }
            catch (Exception e)
            {
                return 0;
            }

            return 1;
        }

        public int Modificar(string t,
                            string titulo, int duracion,
                            string genero, int tresd)
        {
            // Borro la pelicula de la base de datos.
            try
            {
                _bd.Execute("Update Peliculas set titulo = '" + titulo + "'," +
                             " tresd = '" + tresd + "'," +
                             " duracion = '" + duracion + "'," +
                             " genero = '" + genero + "' where titulo = '" +
                             t + "'");
            }
            catch (Exception e)
            {
                return 0;
            }

            return 1;
        }
    }
}
