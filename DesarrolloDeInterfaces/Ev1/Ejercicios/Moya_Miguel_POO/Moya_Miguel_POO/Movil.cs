using System;

namespace Moya_Miguel_POO {
    class Movil : Telefono, IComparable {
        protected long segundosConsumidos;
        public long SegundosConsumidos {
            get { return segundosConsumidos; }
            set { segundosConsumidos = value; }
        }

        public Movil() : base() { }

        public Movil(long id, string numero, string propietario, string tarifa, long segundosConsumidos) : base(id, numero, propietario, tarifa) {
            SegundosConsumidos = segundosConsumidos;
        }

        public Movil(Movil m) : base(m) {
            SegundosConsumidos = m.SegundosConsumidos;
        }

        ~Movil() { }
        public int CompareTo(object m) {
            if (m == null) {
                throw new ArgumentNullException(nameof(m));
            }
            return ((Movil)m).Propietario.CompareTo(Propietario);
        }

        public override string ToString() => base.ToString() + " # " + SegundosConsumidos;
    }
}
