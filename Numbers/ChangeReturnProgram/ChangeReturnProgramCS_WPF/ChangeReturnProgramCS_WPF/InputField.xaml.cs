using System;
using System.Collections.Generic;
using System.Text;
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
    /// Interaction logic for InputField.xaml
    /// </summary>
    public partial class InputField : UserControl
    {
        public static readonly DependencyProperty headProperty = DependencyProperty.Register("Head", typeof(string), typeof(InputField), new FrameworkPropertyMetadata("Title"));
        public static readonly DependencyProperty controlFontSizeProperty = DependencyProperty.Register("ControlFontSize", typeof(int), typeof(InputField), new FrameworkPropertyMetadata(16));
        
        public string Head
        {
            get => (string)GetValue(headProperty);
            set => SetValue(headProperty, value);
        }

        public int ControlFontSize
        {
            get => (int) GetValue(controlFontSizeProperty);
            set => SetValue(controlFontSizeProperty, value);
        }

        public string Value
        {
            get => Input.Text;
            set => Input.Text = value;
        }

        public InputField()
        {
            InitializeComponent();
        }
    }
}
