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

            // De esta forma leeos toda la tabla
            TableQuery<Pelicula> aux = _bd.Table<Pelicula>();

            // IMPORTANTE. Tambien podemos hecer una select
            //db.Query<Stock>("SELECT * FROM Cartelera");

            for (i=0;i<aux.Count();i++)
            {
                c.Add(aux.ElementAt(i));
            }

            return c;
        }
    }
}
