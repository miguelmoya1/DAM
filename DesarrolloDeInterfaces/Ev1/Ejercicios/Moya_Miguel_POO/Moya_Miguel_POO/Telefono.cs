using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Moya_Miguel_POO {
    class Telefono {
        protected long Id { get; }
        protected string Numero {
            get { return "+34-" + Numero; }
            set { if (value.Length > 9) Numero = value; }
        }
        protected string Propietario {
            get { return Propietario; }
            set { if (value.Length > 255) Propietario = value; }
        }
        protected enum TIPO { fijo = 9, movil = 6, especial = 8 };
        protected string Tarifa {
            get { return Tarifa; }
            set { if (value.Length > 255) Tarifa = value; }
        }

        public Telefono() { }

        public Telefono(long id, string numero, string propietario, string tarifa) {
            Id = id;
            Numero = numero;
            Propietario = propietario;
            Tarifa = tarifa;
        }

        public Telefono(Telefono t) {
            Id = t.Id;
            Numero = t.Numero;
            Propietario = t.Propietario;
            Tarifa = t.Tarifa;
        }

        ~Telefono() { }

        public override string ToString() => Id + "#" + Numero + "#" + Propietario + "#" + Tarifa;
    }
}
