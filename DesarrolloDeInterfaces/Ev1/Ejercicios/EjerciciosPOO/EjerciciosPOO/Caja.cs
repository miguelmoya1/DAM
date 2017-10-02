using System;

namespace EjerciciosPOO {
    class Caja : IComparable<Caja> {
        protected double alto { get; set; }
        protected double largo { get; set; }
        protected double ancho { get; set; }

        public Caja() { }

        public Caja(double alto, double largo, double ancho) {
            this.alto = alto;
            this.largo = largo;
            this.ancho = ancho;
        }

        public override string ToString() {
            return alto + " x " + largo + " x " + ancho;
        }

        public static Caja operator +(Caja c1, Caja c2) {
            return new Caja(
                c1.alto + c2.alto,
                c1.largo + c2.largo,
                c1.ancho + c2.ancho
            );
        }

        public static Caja operator -(Caja c1, Caja c2) {
            return new Caja(
                c1.alto - c2.alto,
                c1.largo - c2.largo,
                c1.ancho - c2.ancho
            );
        }

        public int CompareTo(Caja c) {
            return Convert.ToInt32((this.alto + this.largo + this.ancho) - (c.alto + c.largo + c.ancho));
        }

    }
}
