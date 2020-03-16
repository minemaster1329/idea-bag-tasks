using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace ChangeReturnProgramCS_WPF
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void CalculateButton_Click(object sender, RoutedEventArgs e)
        {
            if (decimal.TryParse(CostInput.Value, out decimal cost) && decimal.TryParse(PaidInput.Value, out decimal paid))
            {
                if (cost <= 0 || paid <= 0) MessageBox.Show("Item cost and amount paid must be greater than 0.");
                else if (cost > paid) MessageBox.Show("Item cost must be less or equal to amount paid for it.");
                else
                {
                    OutputPanel.Children.Clear();
                    decimal[] nominals = { 500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5m, 0.2m, 0.1m, 0.05m, 0.02m, 0.01m };
                    paid -= cost;
                    for (int i = 0; i < 9; i++)
                    {
                        OutputPanel.Children.Add(new TextBlock() { Text = $"{nominals[i]} zl: {Math.Floor(paid / nominals[i])}" });
                        paid %= nominals[i];
                    }

                    for (int i = 9; i < 15; i++)
                    {
                        OutputPanel.Children.Add(new TextBlock() { Text = $"{(int) (nominals[i] * 100)} gr: {Math.Floor(paid / nominals[i])}" });
                        paid %= nominals[i];
                    }
                }
            }
        }

        private void ClearButton_Click(object sender, RoutedEventArgs e)
        {
            CostInput.Value = "0";
            PaidInput.Value = "0";
            OutputPanel.Children.Clear();
        }
    }
}
