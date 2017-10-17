/// <author> Miguel Moya Ortega</author>

using System;
using System.Collections.Generic;

namespace Moya_Miguel_POO {
    class Program {
        static void Main(string[] args) {
            List<Movil> list = new List<Movil>();

            list.Add(new Movil(0, "646644664", "Miguel", "Normal", 10));
            list.Add(new Movil(1, "666755756", "Carla", "Premium", 11));
            list.Add(new Movil(2, "654321234", "Sergio", "Barata", 0));
            list.Add(new Movil(3, "988998889", "Carlos", "Premium", 45));
            list.Add(new Movil(4, "655677849", "Alejandro", "Normal", 100));
            list.Add(new Movil(5, "955567765", "Lorena", "Barata", 76));

            bool finish = false;
            byte option;

            while (!finish) {
                WriteText();
                option = Convert.ToByte(Console.ReadLine());
                Console.Clear();

                switch (option) {
                    case 0:
                        finish = !finish;
                        break;

                    case 1:
                        Console.WriteLine("Introduce el nombre del propietario: ");
                        string name = Console.ReadLine();
                        Console.Clear();

                        list.FindAll(m => m.Propietario.ToLower().Contains(name.ToLower())).ForEach(m => Console.WriteLine(m));
                        break;

                    case 2:
                        Console.WriteLine("Introduce el numero del propietario: ");
                        string number = Console.ReadLine();

                        list.FindAll(m => m.Numero.Contains(number)).ForEach(m => Console.WriteLine(m));
                        break;

                    case 3:
                        list.ForEach(m => Console.WriteLine(m));
                        break;

                    default:
                        Console.WriteLine("Opción desconocida");
                        break;
                }
            }


        }

        private static void WriteText() {
            Console.WriteLine("Introduce la opción: ");
            Console.WriteLine("    1) Buscar móviles por propietario: ");
            Console.WriteLine("    2) Buscar móviles por número: ");
            Console.WriteLine("    3) Ver todos los móviles: ");
            Console.WriteLine("    0) Salir: ");
        }
    }
}
