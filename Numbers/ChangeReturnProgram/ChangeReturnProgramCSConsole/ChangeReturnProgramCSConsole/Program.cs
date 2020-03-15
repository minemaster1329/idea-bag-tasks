using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChangeReturnProgramCSConsole
{
    class Program
    {
        static void Main(string[] args)
        {
            string cost_str, paid_str;
            Console.Write("Enter item cost: ");
            cost_str = Console.ReadLine();
            Console.Write("Enter amount paid for item: ");
            paid_str = Console.ReadLine();

            if (decimal.TryParse(cost_str, out decimal cost) && decimal.TryParse(paid_str, out decimal paid))
            {
                if (cost > paid) Console.WriteLine("Item cost must be lower or equal to amount paid for item.");
                else
                {
                    decimal[] nominals = { 500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5m, 0.2m, 0.1m, 0.05m, 0.02m, 0.01m };
                    int nomCount;
                    paid -= cost;
                    for (int i = 0; i < 9; i++)
                    {
                        nomCount = (int)Math.Floor(paid / nominals[i]);
                        Console.WriteLine($"{nominals[i]} zl: {nomCount}");
                        if (nomCount > 0) paid -= nomCount * nominals[i];
                    }

                    for (int i = 9; i < 15; i++)
                    {
                        nomCount = (int)Math.Floor(paid / nominals[i]);
                        Console.WriteLine($"{(int)(nominals[i] * 100)} gr: {nomCount}");
                        if (nomCount > 0) paid -= nomCount * nominals[i];
                    }
                }   
            }

            else Console.WriteLine("Invalid input.");
            Console.ReadKey();
        }
    }
}
