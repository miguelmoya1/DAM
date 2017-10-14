namespace Moya_Miguel_POO {
    class Telefono {
        protected long id;
        protected string numero;
        protected string propietario;
        protected string tarifa;

        public long Id { get; }
        public string Numero {
            get { return "+34-" + numero; }
            set { numero = value.Length <= 9 ? value : "000000000"; }
        }
        public string Propietario {
            get { return propietario; }
            set { propietario = value.Length < 255 ? value : ""; }
        }
        public enum TIPO { fijo = 9, movil = 6, especial = 8 };
        public string Tarifa {
            get { return tarifa; }
            set { tarifa = value.Length < 255 ? value : ""; }
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

        public override string ToString() => Id + " # " + Numero + " # " + Propietario + " # " + Tarifa;
    }
}
