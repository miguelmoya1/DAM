using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjerciciosPOO {
    class Complejo {
        protected double entera { get; set; }
        protected double imaginaria { get; set; }

        public Complejo Establecer(double entera, double imaginaria) {
            this.entera = entera;
            this.imaginaria = imaginaria;

            return this;
        }

        public override string ToString() {
            return this.entera + "+" + this.imaginaria + "i";
        }

        public static Complejo operator +(Complejo c1, Complejo c2) {
            return new Complejo().Establecer(c1.entera + c2.entera, c1.imaginaria + c2.imaginaria);
        }

        public static Complejo operator -(Complejo c1, Complejo c2) {
            return new Complejo().Establecer(c1.entera - c2.entera, c1.imaginaria - c2.imaginaria);
        }

        public static Complejo operator *(Complejo c1, Complejo c2) {
            return new Complejo().Establecer(
                (c1.entera * c2.entera) - (c1.imaginaria * c2.imaginaria),
                (c1.entera * c2.imaginaria) + (c1.imaginaria * c2.entera)
            );
        }

        public static Complejo operator *(double x, Complejo c2) {
            return new Complejo().Establecer(x * c2.entera, x * c2.imaginaria);
        }
    }
}
