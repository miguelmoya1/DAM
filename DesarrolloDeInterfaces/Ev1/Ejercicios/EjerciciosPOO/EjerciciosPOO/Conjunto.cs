using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjerciciosPOO {
    class Conjunto {
        protected List<int> c;

        public Conjunto() {
            c = new List<int>();
        }

        public Conjunto Vaciar() {
            this.c = new List<int>();
            return this;
        }
        public Conjunto Agregar(int x) {
            if (!this.c.Contains(x)) this.c.Add(x);
            return this;
        }

        public Conjunto Eliminar(int x) {
            this.c.Remove(x);
            return this;
        }

        public Conjunto Copia(List<int> c) {
            c = this.c.ToList();
            return this;
        }

        public bool EsMiembro(int x) {
            return this.c.Contains(x);
        }

        public bool EsIgual(Conjunto c) {
            return this.c.Equals(c);
        }

        public override string ToString() {
            string toReturn = "";
            this.c.ForEach(elem => toReturn += elem + " ");
            return toReturn.Trim();
        }

        public bool EsVacio() {
            return this.c.Count == 0;
        }

        public int Cardinal() {
            return this.c.Count;
        }

        public Conjunto Union(Conjunto c) {
            this.c.Concat(c.c);
            return this;
        }

        public Conjunto Interseccion(Conjunto c) {
            Conjunto cToReturn = new Conjunto();
            this.c.ForEach(elem => {
                if (c.c.Contains(elem)) cToReturn.Agregar(elem);
            });
            return cToReturn;
        }

        public Conjunto Diferencia(Conjunto c) {
            Conjunto cToReturn = new Conjunto();
            this.c.ForEach(elem => {
                if (!c.c.Contains(elem)) cToReturn.Agregar(elem);
            });
            return cToReturn;
        }
    }
}
